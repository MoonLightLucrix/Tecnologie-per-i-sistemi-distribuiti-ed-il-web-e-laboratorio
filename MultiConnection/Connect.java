package MultiConnection;
import java.io.*;
import java.util.*;
import java.net.*;
import MultiConnection.*;

public class Connect extends Thread
{
	private Socket remoteSock;
	private BufferedReader in;
	private PrintWriter out;
	public Connect(Socket remoteSock)
	{
		this.remoteSock=remoteSock;
		this.start();
	}
	public void run()
	{
		try
		{
			InputStreamReader input1=new InputStreamReader(remoteSock.getInputStream());
			in=new BufferedReader(input1);
			OutputStreamWriter output1=new OutputStreamWriter(remoteSock.getOutputStream());
			out=new PrintWriter(output1,true);
			String str=in.readLine();
			out.println(str);
			in.close();
			out.close();
			remoteSock.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
