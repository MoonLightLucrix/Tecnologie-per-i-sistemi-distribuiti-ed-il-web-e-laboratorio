package ProduttoriM;
import java.io.*;
import java.util.*;
import ProduttoriM.*;

public class PM
{
	public static void main(String[] args)
	{
        M m=new M();
        P1 p1=new P1(m);
        P2 p2=new P2(m);
        try
        {
            p1.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        try
        {
            p2.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
	}
}
