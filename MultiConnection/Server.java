package MultiConnection;
import java.io.*;
import java.util.*;
import java.net.*;
import MultiConnection.*;

public class Server
{
	public static void stampaSocket(Socket remoteSock)
	{
		System.out.println("local address: " + remoteSock.getLocalAddress());
		System.out.println("local port: " + remoteSock.getLocalPort());
		System.out.println("remote address: " + remoteSock.getInetAddress());
		System.out.println("remote port: " + remoteSock.getPort());
	}
	public static void main(String[] args)
	{
        int porta=8080;
        if(args.length>=1)
        {
            porta=Integer.parseInt(args[0]);
        }
		try
        {
            ServerSocket localSock=new ServerSocket(porta);
            while(true)
            {
                try
                {
                    System.out.println(">>Wait for connection on port " + porta + "…");
                    Socket remoteSock=localSock.accept();
                    System.out.println(">Connection accepted!");
                    stampaSocket(remoteSock);
                    Connect connection=new Connect(remoteSock);
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
