#include <sys/types.h>
#include <sys/msg.h>
#include <sys/ipc.h>
#include <string.h>
#include <stdio.h>
struct msg{
	long type;
	char text[100];
};

int main (void) {

        key_t ipckey;
        int mq_id;
        struct msg mymsg;
        int received;

        ipckey = ftok("/tmp/foo", 42); // get the same key as in send
        printf("My key is %d\n", ipckey);

        mq_id = msgget(ipckey, 0); // no need to create the instance since it has been created in the send
        printf("Message identifier is %d\n", mq_id);
	memset(mymsg.text, 0, 100); // nuke the buffer
	mymsg.type = 1;
        received = msgrcv(mq_id, &mymsg, sizeof(mymsg.text), 0, 0); // get the message from the queue, fourth parameter (0) tells which messages to get, 0 means first in the queue. Again no flags.

        printf("%s (%d)\n", mymsg.text, received);
	return 0;
}


