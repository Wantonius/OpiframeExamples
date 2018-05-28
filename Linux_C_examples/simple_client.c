#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>


int main(int argc, char **argv) {
	struct addrinfo hints, *res;
	int n,sock,err;
	char buffer[255];
	if (argc < 3) {
		printf("Please provide an address\n");
		printf("For example: ./server localhost 5000\n");
		return 1;
	}
	memset(&hints,0,sizeof(hints));
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_family = AF_INET;
	err = getaddrinfo(argv[1],argv[2],&hints,&res)
	if (err!=0) {
		printf("Error getting address: %s",gai_strerror(errno));
		return 1;
	}

	sock = socket(res->ai_family,res->ai_socktype,res->ai_protocol);
	if (connect(sock,res->ai_addr, res->ai_addrlen) != 0) {
		printf("Error in connecting: %s",strerror(errno));
		return 1;
	}
	do {
		memset(buffer,0,255);
		printf("Write for the server:\n");
		fgets(buffer,255,stdin);
		n = write(sock,buffer,strlen(buffer));
	} while(n>0);
	return 0;
}
