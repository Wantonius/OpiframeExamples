#include <linux/init.h>
#include <linux/module.h>
#include <linux/device.h>
#include <linux/slab.h>
#include <linux/fs.h>
#include <linux/sysfs.h>
#include <linux/cdev.h>
#include <linux/kernel.h>
#include <linux/gpio.h>

#define DEVICE_NAME "led01"
#define CLASS_NAME "ledclass"
#define LED_GPIO 22

struct led_dev {
	struct cdev cdev;	
};

int led_on = 0;

static int init_led_module(void);
static void remove_led_module(void);
static ssize_t led_store(struct device *dev, struct device_attribute *attr, const char *buf, size_t count);
static ssize_t led_show(struct device *dev, struct device_attribute *attr, char *buf);

struct file_operations fops = {
	.owner = THIS_MODULE
};



static dev_t led_dev_number;
struct device *led_device;
struct class *led_class;
struct led_dev *my_dev;

static DEVICE_ATTR(led_attr, S_IRUSR | S_IWUSR, led_show, led_store);

static int init_led_module(void) {
	printk(KERN_DEBUG "Init led module\n");
	my_dev = (struct led_dev *)kmalloc(sizeof(struct led_dev),GFP_KERNEL);
	if (my_dev == NULL) {
		printk(KERN_ALERT "No memory for led dev\n");
		return -ENODEV;
	}
	if(alloc_chrdev_region(&led_dev_number,0,1,DEVICE_NAME)<0) {
		printk(KERN_ALERT "No chrdev region\n");
		goto mem;
	}
	led_class = class_create(THIS_MODULE,CLASS_NAME);
	led_device = device_create(led_class, NULL, led_dev_number, NULL, DEVICE_NAME);
	if(device_create_file(led_device, &dev_attr_led_attr) < 0) {
		printk(KERN_ALERT "Can't create device attribute\n");
		goto attr;
	}
	cdev_init(&my_dev->cdev, &fops);
	if(cdev_add(&my_dev->cdev, led_dev_number,1) <0) {
		printk(KERN_ALERT "Can't add cdev\n");
		goto attr;
	}
	/*
	if(!gpio_is_valid(LED_GPIO)<0) {
		printk(KERN_ALERT "Chosen gpio:%d not valid\n",LED_GPIO);
		cdev_del(&my_dev->cdev);
		goto attr;
	}
	gpio_request(LED_GPIO, DEVICE_NAME);
	gpio_direction_output(LED_GPIO, led_on);	
	*/
	return 0;
attr:
	device_destroy(led_class, led_dev_number);
	class_destroy(led_class);
	unregister_chrdev_region(led_dev_number,1);	

mem:
	kfree(my_dev);
	return -ENOMEM;
}

static void remove_led_module(void) {
	cdev_del(&my_dev->cdev);
	device_destroy(led_class, led_dev_number);
	class_destroy(led_class);
	unregister_chrdev_region(led_dev_number,1);
	kfree(my_dev);
	/*
	gpio_set_value(LED_GPIO,0);
	gpio_free(LED_GPIO);
	*/
}
static ssize_t led_store(struct device *dev, struct device_attribute *attr, const char *buf, size_t count) {
	return 0;
}

static ssize_t led_show(struct device *dev, struct device_attribute *attr, char *buf) {
	return 0;
}

MODULE_LICENSE("GPL");
module_init(init_led_module);
module_exit(remove_led_module);
