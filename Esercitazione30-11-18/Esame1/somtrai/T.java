package somtrai;
import java.io.*;
import java.util.*;
import somtrai.*;

public class T
{
	public static void main(String[] args)
	{
        N n=new N(100);
        TI tI=new TI(n);
        TD tD=new TD(n);
        try
        {
            tI.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        try
        {
            tD.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
	}
}
