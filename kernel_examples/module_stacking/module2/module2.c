#include <linux/init.h>
#include <linux/module.h>

MODULE_LICENSE("GPL");

char *get_name(void);

int my_init(void) {
	printk(KERN_DEBUG "Installing second module\n");
	printk(KERN_DEBUG "Hello %s\n",get_name());
	return 0;
}

void my_exit(void) {
	printk(KERN_DEBUG "Removing second module\n");
}

module_init(my_init);
module_exit(my_exit);
