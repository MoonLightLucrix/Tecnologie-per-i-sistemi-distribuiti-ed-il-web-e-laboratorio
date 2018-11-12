package JTCPServer;
import java.io.*;
import java.util.*;
import java.net.*;
import JTCPServer.*;

public class TCPServer
{
	public static void main(String[] args) throws IOException
	{
        int porta=8080;
        if(args.length>=1)
        {
            porta=Integer.parseInt(args[0]);
        }
        ServerSocket local_sock=new ServerSocket(porta);
        System.out.println("Server: started ");
        System.out.println("Server Socket: " + local_sock);
        Socket remote_sock=null;
        BufferedReader in=null;
        PrintWriter out=null;
        try
        {
            remote_sock=local_sock.accept();
            System.out.println("Connection accepted: "+ remote_sock);
            
            InputStreamReader input1=new InputStreamReader(remote_sock.getInputStream());
            in=new BufferedReader(input1);
            
            OutputStreamWriter output1=new OutputStreamWriter(remote_sock.getOutputStream());
            BufferedWriter bw=new BufferedWriter(output1);
            out=new PrintWriter(bw,true);
            
            boolean flag=false;
            while(flag!=true)
            {
                String str=in.readLine();
                if(str.equals("interrupt"))
                {
                    flag=true;
                }
                else
                {
                    System.out.println(str);
                    out.println(str);
                }
            }
        }
        catch(IOException e)
        {
            System.err.println("Accept failed");
            System.exit(1);
        }
        System.out.println("Server: closing…");
        out.close();
        in.close();
        remote_sock.close();
        local_sock.close();
	}
}
