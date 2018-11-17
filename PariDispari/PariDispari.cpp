#include<iostream>
#include<cstdlib>
#include<thread>
#include<mutex>
#include<unistd.h>
#include<ctime>
using namespace std;

mutex mtx;
int x=0;
void A()
{
    srand(time(NULL));
    while(true)
    {
        //usleep(rand()%300000+10000);
        if(x>=100)
        {
            return;
        }
        mtx.lock(); //inizio zona di mutua esclusione
        if(x%2==0)
        {
            cout<<"A -> "<<x<<endl;
            x++;
        }
        mtx.unlock(); //fine zona di mutua esclusione
    }
}

void B()
{
    while(true)
    {
        //usleep(rand()%300000+10000);
        if(x>=100)
        {
            return;
        }
        mtx.lock();
        if(x%2!=0)
        {
            cout<<"B -> "<<x<<endl;
            x++;
        }
        mtx.unlock();
    }
}

int main()
{
    thread a(A);
    thread b(B);
    a.join();
    b.join();
}
