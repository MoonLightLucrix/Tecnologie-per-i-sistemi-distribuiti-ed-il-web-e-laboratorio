#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<errno.h>
#include<unistd.h>
#include<pthread.h>
#define N 1024
#define backlog 9999

int local_sock, remote_sock, n;
struct sockaddr_in local_addr, remote_addr;
socklen_t length;

void*connection(void*dummy)
{
    //close(local_sock);
    int remote_sock1=remote_sock;
    struct sockaddr_in remote_addr1=remote_addr;
    socklen_t length1=length;
    char buffer[N], msg[N];
    printf("Client from: %s:%d connected, it's address is %d bytes long\n",inet_ntoa(remote_addr1.sin_addr),ntohs(remote_addr1.sin_port),length1);
    while(1)
    {
        if((n=read(remote_sock1,buffer,N))>=1)
        {
            
            buffer[n-1]='\0';
            printf("Client asks: %s\n",buffer);
            buffer[n-1]='\n';
        }
        sprintf(msg,"Hi from Server: sending back %d bytes\n",n-2);
        write(remote_sock1,msg,strlen(msg));
    }
}

int main(int argc,char**argv)
{
	if(argc<=1)
	{
		perror("usage: abbiaci a potta");
		exit(1);
	}
	if((local_sock=socket(AF_INET,SOCK_STREAM,0))==-1)
	{
		perror("error: impossibile aprire lo socket");
		exit(1);
	}
	memset((char*)&local_addr,0,sizeof(local_addr));
	local_addr.sin_family=AF_INET;
	local_addr.sin_addr.s_addr=inet_addr("0.0.0.0");
	local_addr.sin_port=htons(atoi(argv[1]));
    printf(">Wait for connection on port %d…\n",atoi(argv[1]));
	if(bind(local_sock,(struct sockaddr *)&local_addr,sizeof(local_addr))==-1)
	{
		perror("error: trying to bind");
		exit(1);
	}
    
    listen(local_sock,backlog);
    while(1)
    {
        pthread_t connect;
        length=sizeof(remote_addr);
        remote_sock=accept(local_sock,(struct sockaddr*)&remote_addr,&length);
        /*while((remote_sock=accept(local_sock,(struct sockaddr *)&remote_addr,&length))!=-1)
         {
            printf("Client from: %s/%d connected, it's address is %d bytes long\n",inet_ntoa(remote_addr.sin_addr),ntohs(remote_addr.sin_port),length);
            if((n=read(remote_sock,buffer,N))>=1)
            {
                buffer[n-1]='\0';
                printf("Client asks: <%s>\n",buffer);
                buffer[n-1]='\n';
            }
            sprintf(msg,"Hi from Server: sending back %d bytes\n",n*10);
            write(remote_sock,msg,strlen(msg));
            close(remote_sock);
            printf("Server: Connection closed");
         }*/
        pthread_create(&connect,NULL,(void*)&connection,NULL);
        //pthread_join(connect,NULL); //Blocca il thread corrente fino alla fine del thread chiamante
        //pthread_detach(connect);
        //close(remote_sock);
    }
    close(local_sock);
	exit(0);
}
