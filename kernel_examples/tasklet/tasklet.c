#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/interrupt.h>
#include <linux/sched.h>

MODULE_LICENSE("GPL");

char tasklet_data[] = "Hello from tasklet";

void tasklet_function(unsigned long data) {
	printk(KERN_DEBUG "Ticks: %ld\n",jiffies);
	printk(KERN_DEBUG "Data: %s\n",(char *)data);
}

DECLARE_TASKLET(my_tasklet,tasklet_function,(unsigned long)&tasklet_data);

int init_mymodule(void) {
	printk(KERN_DEBUG "Initializing tasklet. Ticks:%ld\n",jiffies);
	tasklet_schedule(&my_tasklet);
	return 0;
}

void exit_mymodule(void) {
	tasklet_kill(&my_tasklet);	
}

module_init(init_mymodule);
module_exit(exit_mymodule);
