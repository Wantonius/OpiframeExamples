#include <signal.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {
	sigset_t signalset;
	sigset_t originalset;


	sigemptyset(&signalset);
	
	sigaddset(&signalset,SIGINT);

	if(sigprocmask(SIG_BLOCK,&signalset,&originalset)==-1) {
		printf("Cannot block SIGINT \n");
		return 1;
	}
	printf("SIGINT is now blocked. Try Ctrl+C\n");
	sleep(10);
	if(sigprocmask(SIG_UNBLOCK,&signalset,&originalset)==-1) {
		printf("Cannot unblock SIGINT\n");
		return 1;
	}
	printf("SIGINT unblocked. Exiting\n");
	return 0;
}
