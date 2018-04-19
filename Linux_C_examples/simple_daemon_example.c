#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <syslog.h>


#define DAEMON_NAME "My_Test_Daemon"
#define LOG_FACILITY LOG_DAEMON
#define LOG_LEVEL LOG_ERR

void daemonize(void) {
	pid_t pid;

	pid = fork();
	if (pid>0) {
		printf("Exiting parent, success\n");
		exit(EXIT_SUCCESS);
	}
	if (pid<0) {
		printf("Exiting parent, failure\n");
		exit(EXIT_FAILURE);
	}

	if(setsid()<0) {
		printf("Cannot create a new session. Exiting.\n");
		exit(EXIT_FAILURE);
	}

	if(chdir("/")<0) {
		printf("Cannot change working directory. Exiting.\n");
		exit(EXIT_FAILURE);
	}
 	umask(0);
	close(STDIN_FILENO);
	close(STDOUT_FILENO);
	close(STDERR_FILENO);
}

int main(int argc, char **argv) {
	pid_t pid,ppid;

	int i =0;

	pid = getpid();
	ppid = getppid();

	openlog(DAEMON_NAME,LOG_PID,LOG_FACILITY);
	syslog(LOG_LEVEL, "Starting daemonization pid=%d, parent pid=%d",pid,ppid);
	
	daemonize();
	ppid = getppid();
	for (i = 0;i<10;i++) {
		syslog(LOG_LEVEL, "Logging round %d, pid=%d, parent pid=%d",i,pid,ppid);
		sleep(1);
	}
	syslog(LOG_LEVEL, "Log done, exiting pid=%d, ppid=%d",pid,ppid);
	return 0;
}
