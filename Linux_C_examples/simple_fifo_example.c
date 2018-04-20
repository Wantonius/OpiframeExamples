#include <string.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>

#define LOGFILE "/tmp/logfile"
#define FIFOFILE "/tmp/fifo"

void daemonize(void) {
	pid_t pid;
	
	pid = fork();
	if (pid < 0) {
		printf("Cannot create child,%s\n",strerror(errno));
		exit(1);
	}
	if (pid > 0) {
		printf("Success in creating child. Exiting\n");
		exit(0);
	}
	if (setsid() < 0) {
		printf("Cannot create a new session. %s",strerror(errno));
		exit(1);
	}
	if(chdir("/") < 0) {
		printf("Cannot change working directory. %s",strerror(errno));
		exit(1);
	}
	umask(0);
	close(STDIN_FILENO);
	close(STDOUT_FILENO);
	close(STDERR_FILENO);
}
int main(int argc,char **argv) {
	int fifofd,n;
	int logfile;
	char buffer[255];
	
	daemonize();
	logfile = open(LOGFILE,O_WRONLY|O_APPEND|O_CREAT,0777);
	n = mkfifo(FIFOFILE, 0777);
	while(1) {
		fifofd=open(FIFOFILE,O_RDONLY);
		do {
			memset(buffer,0,255);
			n = read(fifofd,buffer,255);
			if (n>0) {
				write(logfile,buffer,strlen(buffer));
			}		
		} while(n > 0);
		close(fifofd);
	}
	return 0;
}	
