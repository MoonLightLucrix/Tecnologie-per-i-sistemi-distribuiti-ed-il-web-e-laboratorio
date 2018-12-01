package somtrai;
import java.io.*;
import java.util.*;
import somtrai.*;

public class TD extends Thread
{
	private N n;
	public TD(N n)
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
				Thread.sleep(300);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
			if(n.isBelow80())
			{
                System.out.println("\t\t\t\ttD termina!");
				return;
			}
			else
			{
				n.setN(n.sottr());
                System.out.println("\t\t\t\ttD -> " + n.getN());
			}
		}
	}
}
