package JUDPServer;
import java.io.*;
import java.util.*;
import java.net.*;
import JUDPServer.*;

public class Server
{
    //public static final int port=8080;
	public static void main(String[] args)
	{
		DatagramSocket socket=null;
        int port=8080;
        try
        {
            if(args.length==0)
            {
                port=8080;
            }
            else
            {
                port=Integer.parseInt(args[0]);
            }
        }
        catch(Exception e)
        {
            System.err.println("Porta sbagliata!");
            e.printStackTrace();
            System.exit(1);
        }
		try
		{
			socket=new DatagramSocket(port);
		}
		catch(SocketException e)
		{
			System.err.println("Errore nella creazione della socket!");
			e.printStackTrace();
			System.exit(1);
		}
		try
		{
			while(true)
			{
				System.out.println("\nIn attesa di richieste");
				DatagramPacket packet=null;
				InetAddress mittAddr=null;
				int mittPort=0;
				try
				{
					byte[] buf=new byte[256];
					packet=new DatagramPacket(buf,buf.length);
					socket.receive(packet);
					mittAddr=packet.getAddress();
					mittPort=packet.getPort();
					System.out.println("Ricevuta richiesta da "+mittAddr+" "+mittPort);
					
				}
				catch(IOException e)
				{
					System.err.println("Errore nella ricezione del messaggio!");
					e.printStackTrace();
					continue;
				}
                try
                {
                    String msg=DatagramUtility.getContent(packet);
                    byte[] data=new byte[256];
                    data=msg.getBytes();
                    packet=new DatagramPacket(data,data.length,mittAddr,mittPort);
                    socket.send(packet);
                    System.out.println("Risposta inviata a: "+mittAddr+" "+mittPort);
                }
                catch(IOException e)
                {
                    System.err.println("Errore nell'invio della risposta: "+e.getMessage());
                    e.printStackTrace();
                    continue;
                }
			}
		}
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Server: termino…");
        socket.close();
	}	
}
