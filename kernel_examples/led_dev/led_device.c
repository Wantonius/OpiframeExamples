#include <linux/init.h>
#include <linux/module.h>
#include <linux/gpio.h>
#include <linux/kernel.h>
#include <linux/fs.h>
#include <linux/cdev.h>
#include <asm/uaccess.h>
#include <linux/device.h>
#include <linux/sysfs.h>
#include <linux/slab.h>

#define DEVICE_NAME "leddev01"
#define CLASS_NAME "ledclass"

struct led_dev {
	struct cdev cdev;
	int led_on;
};

static dev_t led_devt;
struct device *led_device;
struct class *led_class;
struct led_dev *my_dev;
int led_on = 0;
// Function prototypes

static int led_open(struct inode *inode, struct file *file);
static int led_release(struct inode *inode, struct file *file);
static ssize_t led_write(struct file *fp, const char *buf,size_t len, loff_t *off);
int __init init_ledmodule(void);
void cleanup_ledmodule(void);
static ssize_t led_store(struct device *dev, struct device_attribute *attr, const char *buf, size_t count);
static ssize_t led_show(struct device *dev,struct device_attribute *attr, char *buf);

static struct file_operations fops = {
	.owner = THIS_MODULE,
	.open = &led_open,
	.release = &led_release,
	.write = &led_write,
};

static DEVICE_ATTR(led_attr, S_IRUSR | S_IWUSR, led_show, led_store);

int __init init_ledmodule(void) {
	
	printk(KERN_ALERT "led device: init\n");
	
	my_dev = kmalloc(sizeof(struct led_dev), GFP_KERNEL);
	if (my_dev == NULL) {
		printk(KERN_DEBUG "No mem for my dev\n");
		return -ENODEV;
	}
	
	if (alloc_chrdev_region(&led_devt, 0, 1, DEVICE_NAME) < 0) {
		printk(KERN_DEBUG "Can't reserve device\n");
		kfree(my_dev);
		return -ENODEV;
	}
	led_class = class_create(THIS_MODULE,CLASS_NAME);
	led_device = device_create(led_class,NULL,led_devt,NULL,DEVICE_NAME);
	if (device_create_file(led_device,&dev_attr_led_attr) < 0) {
		printk(KERN_DEBUG "Can't create attribute file\n");
		kfree(my_dev);
		unregister_chrdev_region(led_devt,1);
		device_destroy(led_class,led_devt);
		class_destroy(led_class);		
		return -ENODEV;
	}
	
	cdev_init(&my_dev->cdev,&fops);
	if (cdev_add(&my_dev->cdev,led_devt,1) < 0) {
		printk(KERN_DEBUG "Can't add device\n");
		kfree(my_dev);
		device_destroy(led_class,led_devt);
		class_destroy(led_class);
		unregister_chrdev_region(led_devt,1);
		return -ENODEV;
	}

	if(!gpio_is_valid(22)) {
		printk(KERN_DEBUG "Can't access gpio");
		kfree(my_dev);
		device_destroy(led_class,led_devt);
		class_destroy(led_class);
		unregister_chrdev_region(led_devt,1);
		return -ENODEV;		
	}
	gpio_request(22,"leddev");
	gpio_direction_output(22,led_on);
	return 0;
	
}

void cleanup_ledmodule(void) {
		cdev_del(&my_dev->cdev);
		kfree(my_dev);
		device_destroy(led_class,led_devt);
		class_destroy(led_class);
		unregister_chrdev_region(led_devt,1);
		gpio_set_value(22,0);
		gpio_free(22);
}

static int led_open(struct inode *inode, struct file *file) {
	printk(KERN_DEBUG "Open called\n");
	return 0;
}
static int led_release(struct inode *inode, struct file *file) {
	printk(KERN_DEBUG "Close called\n");
	return 0;
}
static ssize_t led_write(struct file *fp, const char *buf,size_t len, loff_t *off) {
	printk(KERN_DEBUG "Write called\n");
	return 1;
}
static ssize_t led_store(struct device *dev, struct device_attribute *attr, const char *buf, size_t count) {
	printk(KERN_DEBUG "led store called\n");
	if (led_on == 0) {
		led_on = 1;
	} else {
		led_on = 0;
	}
	gpio_set_value(22,led_on);
	return 1;
}
static ssize_t led_show(struct device *dev,struct device_attribute *attr, char *buf) {
	printk(KERN_DEBUG "led show called\n");
	return 1;
}

module_init(init_ledmodule);
module_exit(cleanup_ledmodule);
MODULE_LICENSE("GPL");
MODULE_AUTHOR("Erno Hentonen");
