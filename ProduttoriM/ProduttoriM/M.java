package ProduttoriM;
import java.io.*;
import java.util.*;
import ProduttoriM.*;

public class M
{
	private int m;
    private Random rand;
	public M()
	{
        rand=new Random();
        m=rand.nextInt(10)+1;
	}
	public synchronized void setM(int m)
	{
        this.m=m;
	}
	public synchronized int getM()
	{
		return m;
	}
    public synchronized void between1_5()
    {
        if((m>=1) && (m<=5))
        {
            notifyAll();
            m=rand.nextInt(10)+1;
            System.out.println("P1 -> M " + m);
        }
        else
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    public synchronized void between6_10()
    {
        if((m>=6) && (m<=10))
        {
            notifyAll();
            m=rand.nextInt(10)+1;
            System.out.println("P2 -> M " + m);
        }
        else
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
