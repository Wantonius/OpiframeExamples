#include <linux/module.h>
#include <linux/gpio.h>
#include <linux/interrupt.h>
//#include <error.h>

#define MY_GPIO 4
irqreturn_t my_irq_handler( int irq, void *dev) {
        printk(KERN_DEBUG "irq handler" );
        gpio_set_value(MY_GPIO, 1);
        return IRQ_HANDLED;

}
int my_irq;
int init_my_gpio_module(void) {
        int ret ;
        if( !gpio_is_valid(MY_GPIO) ) {
                printk(KERN_INFO "GPIO not valid\n");
                return -EBUSY;
        }
        ret = gpio_request_one(MY_GPIO, GPIOF_IN, "interrupt test");
        if (ret <0 ){
                printk(KERN_INFO "GPIO reuquest failed\n");
                return -EBUSY;
        }
        my_irq = gpio_to_irq(MY_GPIO);
                if (my_irq <0 ){
                printk(KERN_INFO "GPIO to irq  failed");
                return -EBUSY;
        }
        printk(KERN_DEBUG "my irq id: %d\n", my_irq);
        ret = request_any_context_irq(my_irq,  my_irq_handler, IRQF_TRIGGER_FALLING, "interrupt test", &my_irq_handler);
       
        if (ret <0 ){
                printk(KERN_INFO "Request  irq context  failed\n");
                return -EBUSY;
        }

        gpio_set_value(MY_GPIO,0);
        printk(KERN_DEBUG "Initialization done value: %d\n", gpio_get_value(MY_GPIO));
        return 0;
}
void my_module_exit(void) {
        free_irq(my_irq, NULL);
        gpio_free(MY_GPIO);
        printk(KERN_DEBUG "Modlue exit\n");

}

module_init(init_my_gpio_module);
module_exit(my_module_exit);


MODULE_LICENSE("GPL");