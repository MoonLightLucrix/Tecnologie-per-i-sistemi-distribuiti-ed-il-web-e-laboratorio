package somtrai;
import java.io.*;
import java.util.*;
import somtrai.*;

public class TI extends Thread
{
	private N n;
	public TI(N n)
	{
		this.n=n;
		this.start();
	}
	public void run()
	{
		for(int ciclo=0; ciclo<=1000; ciclo++)
		{
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
			if(n.isAbove150())
			{
                System.out.println("tI termina!");
				return;
			}
			else
			{
				n.setN(n.somma());
				System.out.println("tI -> " + n.getN());
			}
		}
	}
}
