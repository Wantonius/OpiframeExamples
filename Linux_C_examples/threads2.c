#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

pthread_mutex_t mutex;
int global = 0;

void *increment_thread(void *arg) {
	int i;
	for(i=0;i < 10; i++) {
		printf("Before mutex lock: Thread: Global: %d\n",global);
		pthread_mutex_lock(&mutex);
		global++;
		printf("In mutex lock: Thread: Global:%d\n", global);
		sleep(2);
		pthread_mutex_unlock(&mutex);
		printf("After mutex lock: Thread: Global:%d\n", global);
		sleep(1);
	}
	pthread_exit(NULL);
}

int main(int argc, char **argv) {
	pthread_t thread;
	int i;
	
	pthread_mutex_init(&mutex, NULL);
	
	if(pthread_create(&thread, NULL, &increment_thread, NULL)) {
		printf("Error in creating thread \n");
		return 1;
	}
	for(i = 0; i < 10; i++) {
		printf("Before mutex lock: Main: Global:%d\n",global);
		pthread_mutex_lock(&mutex);
		global++;
		printf("In mutex lock: Main: Global:%d\n",global);
		sleep(1);
		pthread_mutex_unlock(&mutex);
		printf("After mutex lock: Main: Global:%d\n",global);
		sleep(2);
	}
	pthread_exit(NULL);
}