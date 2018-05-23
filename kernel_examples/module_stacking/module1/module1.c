#include <linux/init.h>
#include <linux/module.h>
#include <linux/moduleparam.h>

MODULE_LICENSE("GPL");

char *myParam = "World";

module_param(myParam,charp,S_IRUGO);

int my_init(void) {
	printk(KERN_DEBUG "Installing first module\n");
	return 0;
}
void my_exit(void) {
	printk(KERN_DEBUG "Removing first module\n");
}

char *get_name(void) {
	return myParam;
}

EXPORT_SYMBOL_GPL(get_name);
module_init(my_init);
module_exit(my_exit);

