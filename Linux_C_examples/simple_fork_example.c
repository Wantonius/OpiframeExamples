#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

static int globalData = 0;


void service(int processCount) {
	pid_t myPid;
	pid_t parentPid;

	myPid = getpid();
	parentPid = getppid();

	globalData++;

	printf("(%d)My pid is:%d\n",processCount,myPid);
	printf("(%d)Parent pid is:%d\n",processCount,parentPid);
	printf("(%d)Globaldata is currently:%d\n",processCount,globalData);

	sleep(8);
	
	myPid = getpid();
	parentPid = getppid();
	printf("(%d)After sleep my pid is:%d\n",processCount,myPid);
	printf("(%d)After sleep parent pid is:%d\n",processCount,parentPid);
	printf("(%d)After sleep globaldata is currently:%d\n",processCount,globalData);
}

int main(int argc, char **argv) {
	pid_t child;
	int i;
	for(i=0;i<10;i++) {
		printf("main, globalData:%d\n",globalData);
		child = fork();
		printf("%d process, child value %d\n",getpid(),child);
		if (child == 0) {
			service(i);
			exit(0);
		} else if (child == -1) {
			printf("Failed to fork child\n");
			exit(1);				
		} else {
			printf("Started process %d. Sleeping for 1 second\n",i);
			sleep(1);				
		}
	}
	printf("Main ending here\n");
}
