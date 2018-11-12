package JTCPClient;
import java.io.*;
import java.util.*;
import java.net.*;
import JTCPClient.*;

public class Client
{
	public static void main(String[] args) throws IOException
	{
        Socket socket=null;
        BufferedReader in=null, stdin=null;
        PrintWriter out=null;
        InetAddress remote_addr;
        int porta=8080;
        if(args.length==0)
        {
            remote_addr=InetAddress.getByName(null);
        }
        else
        {
            remote_addr=InetAddress.getByName(args[0]);
        }
        if(args.length>=1)
        {
            porta=Integer.parseInt(args[1]);
        }
        try
        {
            socket=new Socket(remote_addr,porta);
            System.out.println("Client: started");
            System.out.println("Client Socket: "+ socket);
            
            InputStreamReader input1=new InputStreamReader(socket.getInputStream());
            in=new BufferedReader(input1);
            
            OutputStreamWriter output1=new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bw=new BufferedWriter(output1);
            out=new PrintWriter(bw,true);
            
            stdin=new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            
            while(true)
            {
                userInput=stdin.readLine();
                out.println(userInput);
                System.out.println(in.readLine());
            }
        }
        catch(UnknownHostException e)
        {
            System.err.println("Don't know about host "+ remote_addr);
            System.exit(1);
        }
        catch(IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to: " + remote_addr);
            System.exit(1);
        }
        System.out.println("Client: closing…");
        out.close();
        in.close();
        stdin.close();
        socket.close();
	}
}
