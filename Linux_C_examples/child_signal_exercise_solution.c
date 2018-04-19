#include <signal.h>
#include <stdio.h>	// perror, printf
#include <sys/types.h>	// pid_t
#include <unistd.h>	// sleep
#include <stdlib.h>
#include <time.h>
#include <errno.h>
#include <string.h>
#include <sys/wait.h>

static int children = 0;

void myHandler(int signum) {
	children--;
}

int childact(int nro) {
	int sleeping;	
	srand(time(NULL));
	sleeping = rand() % 10 +10;
	printf("I am child %d and I'll sleep for %d\n",nro,sleeping);
	sleep(sleeping);
	return 0;
}	

int main(int argc, char** argv) {
	struct sigaction sa;
	int i,j, temp, status, childpid;

	printf("pid = %d\n", getpid());

	sa.sa_handler = &myHandler;

	sigfillset(&sa.sa_mask);

	sa.sa_flags = 0;

	if (sigaction(SIGCHLD, &sa, NULL) == -1) {
		perror("Problem installing SIGCHLD-handler");
		return 1;
	}
	for (i=0;i<10;i++) {
		sleep(1);		
		j = fork();
		if (j <0) {
			printf("Error: %s",strerror(errno));
			exit(1);
		}
		if (j == 0) {
			printf("Child number %d\n",i);			
			childact(i);
			return 0;
		}
		children++;
	}
	printf("Children done, %d \n", children);
	temp = children;
	while (children != 0) {
		if (temp != children) {
			printf("A child has died!!! \n");
			childpid = wait(&status);
			printf("Child had pid %d and status %d\n",childpid,status);
			temp = children;
		}		
		usleep(20000);
	}
	printf("All children dead. Leaving \n");	
	return 0;
}

