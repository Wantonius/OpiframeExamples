#include <sys/types.h>
#include <sys/sem.h>
#include <sys/ipc.h>
#include <string.h> 
#include <errno.h> 
#include <unistd.h> 
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char **argv) {

        key_t ipckey;
        int semid, pid;
        struct sembuf sem[2]; /* sembuf defined in sys/sem.h */

        /* Generate the ipc key */
        ipckey = ftok("/tmp/foo", 42);

        /* Set up the semaphore set. 4 == READ, 2 == ALTER */
        semid = semget(ipckey, 1, 0666 | IPC_CREAT);
        if (semid < 0) {
                printf("Error - %s\n", strerror(errno));
                _exit(1);
        }

        /* These never change so leave them outside the loop */
        sem[0].sem_num = 0;
        sem[1].sem_num = 0;
        sem[0].sem_flg = SEM_UNDO; /* Release semaphore on exit */
        sem[1].sem_flg = SEM_UNDO; /* Release semaphore on exit */
		  pid = fork(); 	
		  if (pid < 0)
		  {
			exit(1);
		  }
	if (pid == 0) { 
	while(1) { /* loop forever */
                printf("[Child] Waiting for the semaphore to be released\n");
                /* Set up two semaphore operations */
                sem[0].sem_op = 0; /* Wait for zero */
                sem[1].sem_op = 1; /* Add 1 to lock it*/
                semop(semid, sem, 2);
                printf("[Child] I have the semaphore\n");

                sleep(rand() % 3); /* Critical section, sleep for 0-2 seconds */

                sem[0].sem_op = -1; /* Decrement to unlock */
                semop(semid, sem, 1);
                printf("[Child] Released semaphore\n");

                sleep(rand() % 3); /* Sleep 0-2 seconds */
        }
	}
	else {
	while(1) { /* loop forever */
                printf("[Parent] Waiting for the semaphore to be released\n");
                /* Set up two semaphore operations */
                sem[0].sem_op = 0; /* Wait for zero */
                sem[1].sem_op = 1; /* Add 1 to lock it*/
                semop(semid, sem, 2);
                printf("[Parent] I have the semaphore\n");

                sleep(rand() % 3); /* Critical section, sleep for 0-2 seconds */

                sem[0].sem_op = -1; /* Decrement to unlock */
                semop(semid, sem, 1);
                printf("[Parent] Released semaphore\n");

                sleep(rand() % 3); /* Sleep 0-2 seconds */
        }	
	}
}

