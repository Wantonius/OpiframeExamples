#include <linux/init.h>
#include <linux/module.h>
#include <linux/device.h>
#include <linux/slab.h>
#include <linux/fs.h>
#include <linux/sysfs.h>
#include <linux/cdev.h>
#include <linux/kernel.h>
#include <linux/gpio.h>
#include <linux/interrupt.h>

#define DEVICE_NAME "led01"
#define CLASS_NAME "ledclass"
#define LED_GPIO 22
#define IRQ_GPIO 4

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

// interrupt handling
int my_irq;
irqreturn_t my_irq_handler( int irq, void *dev) {
        printk(KERN_DEBUG "irq handler\n" );

        if(led_on == 0){
          led_on = 1;
          printk(KERN_DEBUG "Led device : led on\n");
        }else{
          led_on = 0;

          printk(KERN_DEBUG "Led device : led off\n");
        }
	gpio_set_value(LED_GPIO, led_on);
        return IRQ_HANDLED;

}

static int init_led_module(void) {

  int ret ;
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

	if(!gpio_is_valid(LED_GPIO)) {
		printk(KERN_ALERT "Chosen gpio:%d not valid\n",LED_GPIO);
		cdev_del(&my_dev->cdev);
		goto attr;
	}
	gpio_request(LED_GPIO, DEVICE_NAME);
	gpio_direction_output(LED_GPIO, led_on);

  // interrrupt gpio handling

  if( !gpio_is_valid(IRQ_GPIO) ) {
          printk(KERN_INFO "GPIO not valid\n");
          //return -EBUSY;
          goto attr;
  }
  ret = gpio_request_one(IRQ_GPIO, GPIOF_IN, "interrupt test");
  if (ret <0 ){
          printk(KERN_INFO "GPIO reuquest failed\n");
          //return -EBUSY;
          goto attr;
  }
  my_irq = gpio_to_irq(IRQ_GPIO);
          if (my_irq <0 ){
          printk(KERN_INFO "GPIO to irq  failed");
          //return -EBUSY;
          goto attr;
  }
  printk(KERN_DEBUG "my irq id: %d\n", my_irq);
  ret = request_any_context_irq(my_irq,  my_irq_handler, IRQF_TRIGGER_FALLING, "interrupt test", &my_irq_handler);

  if (ret <0 ){
          printk(KERN_INFO "Request  irq context  failed\n");
          //return -EBUSY;
          goto attr;
  }


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

  free_irq(my_irq, &my_irq_handler);
  gpio_free(IRQ_GPIO);

	gpio_set_value(LED_GPIO,0);
	gpio_free(LED_GPIO);

}
static ssize_t led_store(struct device *dev, struct device_attribute *attr, const char *buf, size_t count) {
  printk(KERN_DEBUG "LED store function called: buffer %s\n", buf);
  if(led_on == 0){
    led_on = 1;
    printk(KERN_DEBUG "Led device : led on\n");
  }else{
    led_on = 0;
    printk(KERN_DEBUG "Led device : led off\n");
  }
  /*gpio_set_value(LED_GPIO, led_on)*/
  return count;
}

static ssize_t led_show(struct device *dev, struct device_attribute *attr, char *buf) {
  printk(KERN_DEBUG "Led show called \n");
  return 1;
}

MODULE_LICENSE("GPL");
module_init(init_led_module);
module_exit(remove_led_module);
