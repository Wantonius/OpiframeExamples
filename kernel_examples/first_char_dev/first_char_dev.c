#include <linux/init.h>
#include <linux/module.h>
#include <linux/cdev.h>
#include <linux/slab.h>
#include <linux/fs.h>
#include <linux/types.h>
#include <asm/uaccess.h>
#include <linux/device.h>
#include <linux/errno.h>

#define DEVICE_NAME "my_dev"

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
	cdev_init(&device->cdev, &fops);
	device->cdev.owner = THIS_MODULE;
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
	return 0;
}

int my_close(struct inode *inode, struct file *fp) {
	return 0;
}

ssize_t my_read(struct file *fp, char __user *from, size_t count, loff_t *position) {
	return 0;
}

ssize_t my_write(struct file *fp, const char __user *to, size_t count, loff_t *position) {
	return 0;
}

module_init(my_init);
module_exit(my_exit);
