package JUDPClient;
import java.io.*;
import java.util.*;
import java.net.*;
import JUDPClient.*;

public class Client
{
	//public static final int port=8080;
	
	public static void main(String[] args)
	{
        DatagramSocket socket=null;
        try
        {
            socket=new DatagramSocket();
            //socket.setSoTimeout(30000);
        }
        catch(SocketException e)
        {
            System.err.println("Problemi nella creazione della socket!");
            e.printStackTrace();
            System.exit(1);
        }
        InetAddress addr=null;
        try
        {
            if(args.length==0)
            {
                addr=InetAddress.getByName(null);
            }
            else
            {
                addr=InetAddress.getByName(args[0]);
            }
        }
        catch(UnknownHostException e)
        {
            System.err.println("Indirizzo del server sbagliato!");
            e.printStackTrace();
            System.exit(2);
        }
	int port=8080;
	try
	{
		if(args.length==0)
		{
			port=8080;
		}
		else
		{
			port=Integer.parseInt(args[1]);
		}
	}
	catch(Exception e)
	{
		System.err.println("Porta sbagliata!");
		e.printStackTrace();
		System.exit(3);
	}
        BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
        String mess=null;
        try
        {
            while(stdIn.readLine()!=null)
            {
                try
                {
                    System.out.println("invio");
                    mess=stdIn.readLine();
                    //mess="Ciao";
                    //System.out.println(addr+" "+port+" "+mess);
                    DatagramPacket packetOUT = DatagramUtility.buildPacket(addr,port,mess); //N.P.
                    socket.send(packetOUT);
                }
                catch(IOException e)
                {
                    System.err.println("Problemi nell'invio del messaggio!");
                    e.printStackTrace();
                    continue;
                }
                DatagramPacket packetIN=null;
                try
                {
                    byte[] buf=new byte[256];
                    packetIN=new DatagramPacket(buf,buf.length);
                    socket.receive(packetIN);
                }
                catch(IOException e)
                {
                    System.err.println("Errore nella ricezione del messaggio!");
                    e.printStackTrace();
                    continue;
                }
                String risposta=new String(packetIN.getData());
                System.out.println(risposta);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        socket.close();
	}
}
