#include <linux/kernel.h> 
#include <linux/module.h>
#include <linux/workqueue.h>
#include <linux/sched.h>
#include <linux/slab.h>

static struct workqueue_struct *my_wq;

struct my_work {
	struct work_struct work;
	int data;
};

struct my_delayed_work {
	struct delayed_work delayed_work;
	int data;
};

void workqueue_work_function(struct work_struct *work) {
	struct my_work *my_work = (struct my_work *)work; 
	printk(KERN_DEBUG "My work data:%d\n",my_work->data);	
	printk(KERN_DEBUG "Ticks:%ld\n",jiffies);
	kfree(work);
}

void workqueue_delayed_work_function(struct delayed_work *delayed_work) {
	struct my_delayed_work *my_delayed_work = (struct my_delayed_work *)delayed_work;
	printk(KERN_DEBUG "My delayed work data:%d\n",my_delayed_work->data);
	printk(KERN_DEBUG "Ticks:%ld\n",jiffies);
	kfree(delayed_work);
}

int init_my_workqueue_module(void) {
	int ret;
	struct my_work *work;
	struct my_delayed_work *delayed_work;
	my_wq = alloc_workqueue("my_queue",0,16);
	if(my_wq) {
		work = (struct my_work *)kmalloc(sizeof(struct my_work),GFP_KERNEL);
		if (work) {
			INIT_WORK((struct work_struct *)work, workqueue_work_function);
			work->data = 100;
			ret = queue_work(my_wq, (struct work_struct *)work);
			printk(KERN_DEBUG "Initialized work at %ld\n",jiffies);
		}
		delayed_work = (struct my_delayed_work *)kmalloc(sizeof(struct my_delayed_work),GFP_KERNEL);
		if(delayed_work) {
			INIT_DELAYED_WORK((struct delayed_work *)delayed_work, workqueue_delayed_work_function);
			delayed_work->data = 200;
			ret = queue_delayed_work(my_wq,(struct delayed_work *)delayed_work,321);
			printk(KERN_DEBUG "Initialized delayed work at %ld\n",jiffies);
		}
	}
	return 0;
}

void clean_module(void) {
	flush_workqueue(my_wq);
	destroy_workqueue(my_wq);
}

module_init(init_my_workqueue_module);
module_exit(clean_module);
MODULE_LICENSE("GPL");
