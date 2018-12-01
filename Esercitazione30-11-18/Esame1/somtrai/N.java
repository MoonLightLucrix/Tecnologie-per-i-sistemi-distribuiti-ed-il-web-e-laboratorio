package somtrai;
import java.io.*;
import java.util.*;
import somtrai.*;

public class N
{
	private int n;
    private Random rand;
	public N(int n)
	{
		rand=new Random();
		this.n=n;
	}
	public synchronized void setN(int n)
	{
		this.n=n;
	}
	public synchronized int getN()
	{
		return n;
	}
	public synchronized boolean isAbove150()
	{
		if(n>=151)
		{
			return true;
		}
		return false;
	}
	public synchronized boolean isBelow80()
	{
		if(n<=79)
		{
			return true;
		}
		return false;
	}
	public synchronized int somma()
	{
		return n+=rand.nextInt(10);
	}
	public synchronized int sottr()
	{
		return n-=rand.nextInt(10);
	}
}
