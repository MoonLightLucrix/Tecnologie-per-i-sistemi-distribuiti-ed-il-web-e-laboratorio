package LISTServer;
import java.io.*;
import java.util.*;
import java.net.*;
import LISTServer.*;

public class Server
{
	public static final int porta=7777;
	public static void stampaSocket(Socket remoteSock)
	{
		System.out.println("Local address: " + remoteSock.getLocalAddress());
		System.out.println("Local port: " + remoteSock.getLocalPort());
		System.out.println("Remote address: " + remoteSock.getInetAddress());
		System.out.println("Remote port: " + remoteSock.getPort());
	}
	public static void main(String[] args)
	{
		try
		{
			ServerSocket localSock=new ServerSocket(porta);
            String[] V=null;
            V=new String[10];
            int x=0;
            while(true)
            {
                try
                {
                    System.out.println(">>Wait for connection on port " + porta + "…");
                    Socket remoteSock=localSock.accept();
                    stampaSocket(remoteSock);
                    
                    InputStreamReader input1=new InputStreamReader(remoteSock.getInputStream());
                    BufferedReader in=new BufferedReader(input1);
                    
                    OutputStreamWriter output1=new OutputStreamWriter(remoteSock.getOutputStream());
                    PrintWriter out=new PrintWriter(output1,true);
                    
                    String input=in.readLine();
                    if(input.equals("LIST"))
                    {
                        for(int i=0; i<=x-1; i++)
                        {
                            out.println(V[i]);
                        }
                        in.close();
                        out.close();
                        remoteSock.close();
                        continue;
                    }
                    int i=0;
                    boolean flag=false;
                    for(i=0; (i<=x-1) && (!flag); i++)
                    {
                        if(input.equals(V[i]))
                        {
                            out.println("presente");
                            flag=true;
                        }
                    }
                    if((!flag) && (i<=9))
                    {
                        V[x]=input;
                        x++;
                        out.println("inserita");
                    }
                    else if((!flag) && (x==10))
                    {
                        Random rand=new Random();
                        i=rand.nextInt(9);
                        V[i]=input;
                        out.println("inserita");
                    }
                    in.close();
                    out.close();
                    remoteSock.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    continue;
                }
            }
		}
		catch(Exception e)
		{
            e.printStackTrace();
		}
	}
}
