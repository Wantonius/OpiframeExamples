#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

pthread_mutex_t worker_mutex;
pthread_mutex_t control_mutex;
pthread_cond_t control_cond;

int global = 0;

void *worker_thread(void *arg) {
	printf("Worker thread: %d, before mutex, global int: %d\n",*((int *)arg),global);
	pthread_mutex_lock(&worker_mutex);
	sleep(2);
	global++;
	printf("Worker thread: %d, in mutex, global int: %d\n",*((int*)arg),global);
	pthread_mutex_unlock(&worker_mutex);
	printf("Worker thread: %d, after mutex, global int: %d\n",*((int*)arg),global);
	if (global == 2) {
		printf("Worker thread: %d, condition good, waking control\n", *((int)arg));
		pthread_cond_broadcast(&control_cond);
		
	}
	pthread_exit(NULL);
}

void *control_thread(void *arg) {
	printf("Control thread: %d, before wait_cond: global: %d\n",*((int*)arg),global);
	pthread_mutex_lock(&control_mutex);
	pthread_cond_wait(&control_cond, &control_mutex);
	printf("Control thread: %d, after wait_cond, global: %d\n"*((int*)arg),global);
	global++;
	sleep(5);
	pthread_mutex_unlock(&control_mutex);
	printf("Control thread: %d, after mutex unlock, global: %d\n"*((int*)arg),global);	
	pthread_exit(NULL);
}

int main(int argc, char **argv) {
	pthread_t worker1, worker2, control;
	int worker1_id=100,worker2_id=200,control_id=300;
	pthread_mutex_init(&worker_mutex, NULL);
	pthread_mutex_init(&control_mutex,NULL);
	pthread_cond_init(&control_cond,NULL);
	if(pthread_create(&control, NULL, &control_thread, &control_id)) {
		printf("Failed to create control thread\n");
		return 1;		
	}
	if(pthread_create(&worker1, NULL, &worker_thread, &worker1_id)) {
		printf("Failed to create control thread\n");
		return 1;		
	}
	if(pthread_create(&worker2, NULL, &worker_thread, &worker2_id)) {
		printf("Failed to create control thread\n");
		return 1;		
	}	
	printf("Main thread, after thread creation, before wait cond, global:%d\n", global);
	pthread_mutex_lock(&control_mutex);
	pthread_cond_wait(&control_cond, &control_mutex);
	printf("Main thread, after condition wait , global:%d\n", global);
	sleep(5);
	global++;
	pthread_mutex_unlock(&control_mutex);
	printf("Main thread, after control mutex, global:%d\n", global);
	pthread_join(control, NULL);
	printf("Threads done. Exiting\n");
	return 0;
	
}