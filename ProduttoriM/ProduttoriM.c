#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<time.h>

int m;

pthread_mutex_t mutex=PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t m1_5=PTHREAD_COND_INITIALIZER;
pthread_cond_t m6_10=PTHREAD_COND_INITIALIZER;

void*P1(void*dummy)
{
	while(1)
	{
		pthread_mutex_lock(&mutex);
		usleep(1000000);
		if((m>=1) && (m<=5))
		{
			pthread_cond_signal(&m1_5);
			m=rand()%10+1;
			printf("P1 -> %d\n",m);
		}
		else
		{
			pthread_cond_wait(&m6_10,&mutex);
		}
		pthread_mutex_unlock(&mutex);
	}
}

void*P2(void*dummy)
{
	while(1)
	{
		pthread_mutex_lock(&mutex);
		usleep(1000000);
		if((m>=6) && (m<=10))
		{
			pthread_cond_signal(&m6_10);
			m=rand()%10+1;
			printf("P2 -> %d\n",m);
		}
		else
		{
			pthread_cond_wait(&m1_5,&mutex);
		}
		pthread_mutex_unlock(&mutex);
	}
}

int main(int argc, char**argv)
{
	pthread_t th1, th2;
	srand(time(NULL));
	m=rand()%10+1;
	pthread_create(&th1,NULL,P1,NULL);
	pthread_create(&th2,NULL,P2,NULL);
	pthread_detach(th1);
	pthread_detach(th2);
	pthread_exit(NULL);
}














