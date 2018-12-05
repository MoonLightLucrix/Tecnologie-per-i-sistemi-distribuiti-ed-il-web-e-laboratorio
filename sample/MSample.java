package sample;
import java.io.*;
import java.util.*;
import sample.*;

public class MSample
{
	public static void main(String[] args)
	{
        Sample sample=new Sample();
        Thd th1=new Thd(sample,1);
        Thd th2=new Thd(sample,2);
        Thd th3=new Thd(sample,3);
        try
        {
            th1.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        try
        {
            th2.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        try
        {
            th3.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Valore di sample finale " + sample.getSample());
	}
}
