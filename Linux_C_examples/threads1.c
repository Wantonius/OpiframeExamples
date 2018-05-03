#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

int global= 0;

void *thread_function(void *arg) {
	int i,j;
	for (i=0; i<20;i++) {
		j = global;
		j++;
		printf("In thread, global value: %d sleeping\n", global);
		sleep(1);
		global = j;
		printf("In thread, global value: %d")
	}
	return NULL;

}

int main(int argc, char **argv) {
	pthread_t mythread;
	int i;
	if (pthread_create(&mythread, NULL, thread_function, NULL)) {
		printf("Error creating thread\n");
		return 1;
	}
	for (i=0; i<20; i++) {
		global++;
		printf("Main thread, global %d, sleeping\n",global);
		sleep(1);
		printf("Main thread, global %d, after sleep\n",global);
	}
	if(pthread_join(mythread,NULL)) {
		printf("Error joining thread\n");
		return 1;
	}
	printf("Main exiting, global equals %d\n",global);
	return 0;
}	