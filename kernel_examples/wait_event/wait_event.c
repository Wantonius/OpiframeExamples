#include <linux/init.h>
#include <linux/module.h>
#include <linux/moduleparam.h>
#include <linux/cdev.h>
#include <linux/slab.h>
#include <linux/fs.h>
#include <linux/types.h>
#include <asm/uaccess.h>
#include <linux/device.h>
#include <linux/errno.h>
#include <linux/wait.h>
#include <linux/mutex.h>
#include <linux/sched.h>

#define DEVICE_NAME "my_char_dev"

int sizeparam = 1024;
module_param(sizeparam,int,S_IRUGO);


MODULE_LICENSE("GPL");
int my_open(struct inode *inode, struct file *fp);
int my_close(struct inode *inode, struct file *fp);
ssize_t my_read(struct file *fp, char __user *from, size_t count, loff_t *position);
ssize_t my_write(struct file *fp, const char __user *to, size_t count, loff_t *position);

struct file_operations fops = {
	.owner = THIS_MODULE,
	.open = &my_open,
	.release = &my_close,
	.read = &my_read,
	.write = &my_write
};

struct my_dev {
	struct cdev cdev;
	int connections;
	char *data_buffer;
	char name[8];
	int max_size;
	int written;
	wait_queue_head_t readers,writers, openread,openwrite;
	struct mutex mutex;
	int reader;
	int writer;
};

dev_t my_dev_nro;
struct my_dev *device;
struct class *my_dev_class;

int __init my_init(void) {

	printk(KERN_DEBUG "Initializing my_dev\n");
	if (alloc_chrdev_region(&my_dev_nro, 0, 1, DEVICE_NAME) < 0) {
		printk(KERN_ALERT "Can't register my_dev\n");
		return -1;
	}

	device = (struct my_dev *)kmalloc(sizeof(struct my_dev), GFP_KERNEL);
	if (device == NULL) {
		printk(KERN_ALERT "Can't reserve memory for my_dev\n");
		return -1;
	}
	my_dev_class = class_create(THIS_MODULE,DEVICE_NAME);
	sprintf(device->name, "my_dev");
	device->connections = 0;
	device->written = 0;
	device->writer = 0;
	device->reader = 0;
	device->max_size = sizeparam;
	cdev_init(&device->cdev, &fops);
	device->cdev.owner = THIS_MODULE;
	mutex_init(&device->mutex);
	init_waitqueue_head(&device->readers);
	init_waitqueue_head(&device->writers);
	init_waitqueue_head(&device->openread);
	init_waitqueue_head(&device->openwrite);
	if (cdev_add(&device->cdev, my_dev_nro,1) < 0) {
		printk(KERN_ALERT "Failed to cdev_add\n");
		return -1;
	} 
	device_create(my_dev_class, NULL, my_dev_nro, NULL, "my_dev");
	printk("Initialization of my_dev successful\n");
	return 0;
}

void my_exit(void) {
	cdev_del(&device->cdev);
	unregister_chrdev_region(my_dev_nro, 1);
	device_destroy(my_dev_class, my_dev_nro);
	class_destroy(my_dev_class);
	kfree(device);
	printk(KERN_DEBUG "Device my_dev removed from system\n");

} 
int my_open(struct inode *inode, struct file *fp) {
	struct my_dev *device;
	printk(KERN_DEBUG "Opening device my_dev.\n");
	if((fp->f_flags & O_ACCMODE) == O_RDWR) {
		printk(KERN_DEBUG "Read/Write not allowed\n");
		return -EPERM;
	}
	device = container_of(inode->i_cdev, struct my_dev, cdev);	
	fp->private_data = device;
	mutex_lock(&device->mutex);
	if(device->connections == 0 && device->written == 0) {
		printk(KERN_DEBUG "Opening for the first time. Reserving buffer\n");
		device->data_buffer= (char *)kzalloc(device->max_size,GFP_KERNEL);
	}
	if((fp->f_flags & O_ACCMODE) == O_RDONLY) {
		printk(KERN_DEBUG "Read only mode writers:%d\n",device->writer);	
		if(device->writer == 0) {
			printk(KERN_DEBUG "No writers. Waiting in queue\n");
			if(fp->f_flags & O_NONBLOCK) {
				printk(KERN_DEBUG "Non-block mode and no writers. Returning with -EAGAIN.\n");
				return -EAGAIN;
			}
			device->reader = 1;
			mutex_unlock(&device->mutex);
			if(wait_event_interruptible(device->openread, device->writer > 0 || device->written > 0)) {
				device->reader = 0;	
				return -EINTR;
			}
		} else {
			printk(KERN_DEBUG "Writer found. Kicking writer wait queue\n");
			device->reader = 1;
			mutex_unlock(&device->mutex);
			wake_up_interruptible(&device->openwrite);
		}
	}
	if((fp->f_flags & O_ACCMODE) == O_WRONLY) {
		printk(KERN_DEBUG "Write only mode. Readers:%d\n",device->reader);	
		if(device->reader == 0) {
			printk(KERN_DEBUG "No readers. Waiting in wait queue\n");
			if(fp->f_flags & O_NONBLOCK) {
				printk(KERN_DEBUG "Non-block mode and no readers. Returning with -EAGAIN.\n");
				return -EAGAIN;
			}
			device->writer = 1;
			mutex_unlock(&device->mutex);
			if(wait_event_interruptible(device->openwrite, device->reader > 0)) {
				device->writer = 0;	
				return -EINTR;
			}
		} else {
			printk(KERN_DEBUG "Reader found. Kicking reader wait queue\n");
			device->writer = 1;
			mutex_unlock(&device->mutex);
			wake_up_interruptible(&device->openread);
		}
	}
	device->connections++;
	return 0;
}

int my_close(struct inode *inode, struct file *fp) {
	struct my_dev *device;
	printk(KERN_DEBUG "Closing device my_dev.\n");	
	device = fp->private_data;
	if((fp->f_flags & O_ACCMODE) == O_WRONLY) {	
		device->writer--;
		if(device->writer == 0) {
			wake_up_interruptible(&device->readers);
		}
	}
	if((fp->f_flags & O_ACCMODE) == O_RDONLY) {	
		device->reader--;
	}	
	device->connections--;
	if(device->connections == 0 && device->written == 0) {	
		printk(KERN_DEBUG "Closing for the last time. Freeing memory\n");
		kfree(device->data_buffer);
	}
	
	return 0;
}

ssize_t my_read(struct file *fp, char __user *from, size_t count, loff_t *position) {
	struct my_dev *device;
	int n;
	printk(KERN_DEBUG "Trying to read %d bytes\n",(int)count);		
	device = fp->private_data;
	if(count > device->written) {
		count=device->written;
	}
	printk(KERN_DEBUG "Currently unread stuff %d\n", device->written);
	if(count == 0)  {
		printk(KERN_DEBUG "Nothing to read. \n");
		if(fp->f_flags & O_NONBLOCK) {
			printk(KERN_DEBUG "Non-block mode. Returning with -EAGAIN.\n");
			return -EAGAIN;
		}
		printk(KERN_DEBUG "Sleeping in the read queue. \n");
		if(wait_event_interruptible(device->readers, device->written >0)) {
			printk(KERN_DEBUG "Signal interruption\n");
			return -ERESTARTSYS;
		}

	}
	count=device->written;	
	n = copy_to_user(from, device->data_buffer, count);
	printk(KERN_DEBUG "Failed to read %d bytes\n", n);
	printk(KERN_DEBUG "Actually read %d bytes\n",(int)count);
	device->written = 0;
	return count-n;
}

ssize_t my_write(struct file *fp, const char __user *to, size_t count, loff_t *position) {
	struct my_dev *device;
	int n;
	printk(KERN_DEBUG "Writing for %d bytes\n",(int)count);		
	device = fp->private_data;
	if(count > device->max_size) {
		count=device->max_size;
	}	
	n = copy_from_user(device->data_buffer, to, count);
	device->written = count;
	printk(KERN_DEBUG "Failed to write %d bytes\n", n);
	printk(KERN_DEBUG "Currently written %d\n", device->written);
	wake_up_interruptible(&device->readers);
	return count-n;
}

module_init(my_init);
module_exit(my_exit);
