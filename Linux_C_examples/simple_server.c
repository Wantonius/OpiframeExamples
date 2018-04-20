#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <string.h>
#include <errno.h>

int main(int argc,char **argv) {
	int sock, newsocket, portno, clilength;
	char buffer[256];
	struct sockaddr_in server_socket,client_socket;
	int no_of_bytes;

	if (argc < 2) {
		printf("Please provide a port of binding\n");
		printf("For example: ./server 5000\n");
		return 1;
	}
	portno = atoi(argv[1]);
	sock = socket(AF_INET,SOCK_STREAM,0);
	memset((char *)&server_socket,0,sizeof(server_socket));
	server_socket.sin_family = AF_INET;
	server_socket.sin_addr.s_addr = INADDR_ANY;
	server_socket.sin_port = htons(portno);

	if (bind(sock, (struct sockaddr *)&server_socket, sizeof(server_socket)) < 0) {
		printf("Error binding socket: %s",strerror(errno));
		return 1;
	}
	listen(sock,5);
	clilength = sizeof(client_socket);
	printf("Now accepting connections in port %d\n",portno);
	newsocket = accept(sock, (struct sockaddr *)&client_socket,&clilength);
	if (newsocket < 0) {
		printf("Error in accepting connections: %s",strerror(errno));
		return 1;
	}
	do {
		memset(buffer,0,255);
		no_of_bytes = read(newsocket,buffer,255);		
		if(no_of_bytes > 0) {
			printf("Client messages: %s\n",buffer);
		}	
	} while(no_of_bytes > 0);
	close(newsocket);
	close(sock);	
	return 0;
}
