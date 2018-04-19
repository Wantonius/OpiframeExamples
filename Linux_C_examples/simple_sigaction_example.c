#include <signal.h>
#include <stdio.h>
#include <unistd.h>

int count = 0;

void my_sig_handler(int sig) {
	count++;
}

int main(int argc, char **argv) {
	struct sigaction sa;
	
	sa.sa_handler = &my_sig_handler;
	sa.sa_flags = 0;
	sigfillset(&sa.sa_mask);

	if(sigaction(SIGINT,&sa,NULL) == -1) {
		printf("Error installing sighandler. Exiting\n");
		return 1;
	}
	while(count < 10) {
		printf("Waiting for SIGINT. Count:%d\n",count);
		sleep(10);
	}
	printf("Enough SIGINTs. Exiting\n");
	return 0;
}
