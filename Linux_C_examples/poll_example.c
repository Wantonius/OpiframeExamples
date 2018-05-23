#include <stdio.h>
#include <poll.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

int child_action();

int main(int argc, char **argv) {
	int pid;
	int flags;
	int n,m;
	char buffer[50];
	struct pollfd fifos[2];
	
	mkfifo("/tmp/fifo1",0666);
	mkfifo("/tmp/fifo2",0666);
	
	pid = fork();
	if (pid < 0) {
		printf("Error forking a child\n");
		return 1;
	}
	if (pid == 0) {
		child_action();
		return 0;
	}
	
	printf("Parent: before open \n");
	fifos[0].fd = open("/tmp/fifo1",O_RDONLY,0);
	fifos[0].events = POLLIN;
	fifos[1].fd = open("/tmp/fifo2",O_RDONLY,0);
	fifos[1].events = POLLIN;
	printf("Parent: after open: fifos %d %d\n", fifos[0].fd, fifos[1].fd);
	for (n=0;n<2; n++) {
		flags = fcntl(fifos[n].fd,F_GETFL);
		flags = flags + O_NONBLOCK;
		fcntl(fifos[n].fd,F_SETFL,flags);
	}
	while(1) {
		n = poll(fifos,2,-1);
		if (n > -1) {
			for (m=0;m<2;m++) {
				if(fifos[m].revents & POLLIN) {
					memset(buffer,0,50);
					n = read(fifos[m].fd,buffer,50);
					if (strncmp(buffer, "quit",4)==0) {
						printf("Quitting from fifo %d\n",fifos[m].fd);
						exit(0);
					}
					fifos[m].revents = 0;
					printf("%s from fifo %d\n",buffer,fifos[m].fd);
				}
			}
		} else {
			printf("No input\n");
		}		
	}
}

int child_action() {
	int n, fifo[2];
	fifo[0] = open("/tmp/fifo1",O_WRONLY,0);
	fifo[1] = open("/tmp/fifo2",O_WRONLY,0);
	printf("Child: after open fifos %d %d\n", fifo[0],fifo[1]);
	sleep(2);
	n = write(fifo[0],"Terve\n",6);
	n = write(fifo[1],"Terve taas\n",11);
	sleep(2);
	n = write(fifo[0],"Back again\n", 11);
	n = write(fifo[1],"Are you bored yet?\n",19);
	sleep(2);
	n = write(fifo[0],"quit\n",5)
	sleep(1);
	return 0;
}