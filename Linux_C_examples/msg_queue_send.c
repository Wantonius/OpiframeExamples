#include <sys/msg.h>
#include <sys/ipc.h>
#include <string.h>
#include <stdio.h>
struct msg {
	long type;
	char text[100];
};

int main (void) {

        key_t ipckey;
        int mq_id;
       	struct msg mymsg;


        ipckey = ftok("/tmp/foo", 42); // get the key
        printf("My key is %d\n", ipckey);


        mq_id = msgget(ipckey, IPC_CREAT | 0666); // use the key to create a new instance
        printf("Message identifier is %d\n", mq_id);


        memset(mymsg.text, 0, 100);  // empty the buffer
        strcpy(mymsg.text, "Hello, world!"); // copy the message to the buffer
        mymsg.type = 1;
        msgsnd(mq_id, &mymsg, sizeof(mymsg.text), 0); // send the message (&mymsg) to the queue (mq_id). You need to tell the payload size (sizeof()) and optionally provide flags (no flags in this
	return 0;

}


