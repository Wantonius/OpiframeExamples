#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void *thread_func(void *);
void hello();

pthread_key_t my_key;

int main(int argc, char **argv) {
	pthread_t thread;
	int *thread_id;
	int i;
	
	pthread_key_create(&my_key,NULL);
	
	for(i=1;i<11; i++) {
		thread_id = (int *)malloc(sizeof(int));
		*thread_id = i;
		pthread_create(&thread, NULL, thread_func, (void *)(thread_id));
		
	}
	pthread_exit(NULL);		
}

void *thread_func(void *thread_id) {
	pthread_setspecific(my_key, thread_id);
	hello();
}

void hello() {
	printf("Thread [%d] says:Hello\n",*((int*)pthread_getspecific(my_key)));
	
}