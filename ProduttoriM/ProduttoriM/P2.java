package ProduttoriM;
import java.io.*;
import java.util.*;
import ProduttoriM.*;

public class P2 extends Thread
{
    private M m;
    public P2(M m)
    {
        this.m=m;
        this.start();
    }
    public void run()
    {
        while(true)
        {
	    try
            {
                Thread.sleep(1000L);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            m.between6_10();
        }
    }
}
