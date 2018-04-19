#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

int main(int argc, char **argv) {

	pid_t child;
	int i;
	int status;
	int sleeping;

	printf("Forking 10 children\n");
	for(i=0;i<10;i++) {
		child = fork();
		if(child == 0) {
			srand(time(NULL));			
			sleeping = rand() % 10 + 10;	
			printf("%d sleeping for %d\n",getpid(),sleeping);
			sleep(sleeping);
			printf("%d woke up, dying\n",getpid());
			if (i % 2 == 0) {
				exit(EXIT_SUCCESS);
			} else {
				exit(EXIT_FAILURE);
			}
		} else if(child == -1) {
			exit(1);
		} else {
			printf("Created child %d\n",child);
			sleep(1);
		}				
	}
	for(i=0;i<10;i++) {
		printf("Waiting for a child\n");
		child = wait(&status);
		printf("%d child died with status %d\n",child,status);
	}
	printf("Main exiting\n");
	return 0;
}

