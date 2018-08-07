#include <linux/init.h>
#include <linux/module.h>
#include <linux/workqueue.h>
#include <linux/sched.h>
#include <linux/slab.h>
#include <linux/kernel.h>


static struct workqueue_struct *my_wq;

struct my_work {
	struct work_struct work;
	int data;
};

struct my_delayed_work {
	struct delayed_work delayed_work;
	int data;
};

struct my_work *work;
struct my_delayed_work *delayed_work;

void workqueue_work_function(struct work_struct *work) {
	struct my_work *my_work = (struct my_work *)work;
	printk(KERN_DEBUG "Working work: data: %d\n",my_work->data);
	printk(KERN_DEBUG "Jiffies: %ld\n",jiffies);

}

void workqueue_delayed_work_function(struct work_struct *work) {
	struct my_delayed_work *my_work = (struct my_delayed_work *)work;
	printk(KERN_DEBUG "Delayed work: data: %d\n",my_work->data);
	printk(KERN_DEBUG "Jiffies: %ld\n",jiffies);
}

static int __init init_workqueue_module(void) {
	int ret;

	
	printk(KERN_DEBUG "Init workqueue_module\n");
	my_wq = alloc_workqueue("my_queue",0,4);
	if(my_wq) {
		work = (struct my_work *)kzalloc(sizeof(struct my_work),GFP_KERNEL);
		if(work) {
			INIT_WORK((struct work_struct *)work,&workqueue_work_function);
			work->data = 100;
			ret = queue_work(my_wq, (struct work_struct *)work);
			printk(KERN_DEBUG "Submitted work at %ld jiffies\n",jiffies);	
		}
		delayed_work = (struct my_delayed_work *)kzalloc(sizeof(struct my_delayed_work),GFP_KERNEL);
		if(delayed_work) {
			INIT_DELAYED_WORK((struct delayed_work *)delayed_work, &workqueue_delayed_work_function);
			delayed_work->data=200;
			ret = queue_delayed_work(my_wq, (struct delayed_work *)delayed_work,321);
			printk(KERN_DEBUG "Submitted delayed work at %ld jiffies\n",jiffies);
		}
	}
	return 0;
}

void my_cleanup_module(void) {
	flush_workqueue(my_wq);
	destroy_workqueue(my_wq);
	kfree(work);
	kfree(delayed_work);
}
MODULE_LICENSE("GPL");
module_init(init_workqueue_module);
module_exit(my_cleanup_module);
