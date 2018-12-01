#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<time.h>

pthread_mutex_t mutex=PTHREAD_MUTEX_INITIALIZER;
int n=100;
void*somma()
{
	int ciclo=0;
	while(ciclo<=1000)
	{
		usleep(100000);
		pthread_mutex_lock(&mutex);
		if(n>=151)
		{
			pthread_mutex_unlock(&mutex);
			printf("tI terminato!\n");
			pthread_exit(NULL);
		}
		else
		{
			n+=rand()%10;
			printf("tI -> %d\n",n);
		}
		pthread_mutex_unlock(&mutex);
		ciclo=ciclo+1;
	}
}

void*sottr()
{
	int ciclo=0;
	while(ciclo<=1000)
	{
		usleep(300000);
		pthread_mutex_lock(&mutex);
		if(n<=79)
		{
			pthread_mutex_unlock(&mutex);
			printf("\t\t\t\ttD terminato!\n");
			pthread_exit(NULL);
		}
		else
		{
			n-=rand()%10;
			printf("\t\t\t\ttD -> %d\n",n);
		}
		pthread_mutex_unlock(&mutex);
		ciclo=ciclo+1;
	}
}

int main(int argc, char**argv)
{
	pthread_t tI;
	pthread_t tD;
	srand(time(NULL));
	pthread_create(&tI,NULL,(void*)&somma,NULL);
	pthread_create(&tD,NULL,(void*)&sottr,NULL);
	pthread_join(tI,NULL);
	pthread_join(tD,NULL);
}
