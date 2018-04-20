#include <string.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int child_action(int pipedev) {
	int m;
	char buffer[256];
	memset(buffer,0,256);
	printf("Send a message to the parent\n");
	fgets(buffer,255,stdin);
	m = write(pipedev,buffer,256);
	printf("Child wrote %d characters\n",m);
	return 0;		
}

int main(int argc, char **argv) {
	int pipefd[2],pid;
	int m;
	char readbuffer[256];
	m = pipe(pipefd);
	if (m < 0) {
		printf("Error creating pipe: %s",strerror(errno));
		return 1;
	}
	pid = fork();
	if (pid == 0) {
		child_action(pipefd[1]);	
		return 0;	
	}
	if (pid < 0) {
		printf("Problem forking a child. Exiting\n");
		return 1;
	}
	printf("Waiting for a message from the child\n");
	memset(readbuffer,0,256);	
	m = read(pipefd[0],readbuffer,256);
	if (m > 0) {
		printf("Message says: %s",readbuffer);
	}
	return 0;
}
