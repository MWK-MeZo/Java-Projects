/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_network_project;

import com.sun.corba.se.spi.activation.Server;
import java.io.*;
import java.util.*;
import java.net.*;

// Server class

public class Sever
{

	
	// Vector to store active clients
	static Vector<ClientHandler> ar = new Vector<>(10);
        
	// counter for clients
	static int i = 1;

	public static void main(String[] args) throws IOException
	{
		// server is listening on port 1234
		ServerSocket ss = new ServerSocket(1234);
		
		Socket s;
		
		// running infinite loop for getting
		// client request
		while (true)
		{
			// Accept the incoming request
			s = ss.accept();

			System.out.println("New client request received : " + s);
			
			// obtain input and output streams
			//DataInputStream dis = new DataInputStream(s.getInputStream());
			//DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                         OutputStream out = s.getOutputStream(); 
                            DataOutputStream dos = new DataOutputStream(out);
                         InputStream in = s.getInputStream();
                            DataInputStream dis = new DataInputStream(in);
			
			System.out.println("Creating a new handler for this client...");

			// Create a new handler object for handling this request.
			ClientHandler mtch = new ClientHandler(s,"client " + i, dis, dos);

			// Create a new Thread with this object.
			Thread t = new Thread(mtch);
			
			System.out.println("Adding this client to active client list");

			// add this client to active clients list
			ar.add(mtch);

			// start the thread.
			t.start();

			// increment i for new client.
			// i is used for naming only, and can be replaced
			// by any naming scheme
			i++;

		}
	}
}

// ClientHandler class
class ClientHandler implements Runnable
{
	Scanner scn = new Scanner(System.in);
	private String name;
	 DataInputStream dis;
	 DataOutputStream dos;
	Socket s;
	boolean isloggedin;
	
	// constructor
	public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos) {
		this.dis = dis;
		this.dos = dos;
		this.name = name;
		this.s = s;
		this.isloggedin=true;
	}

	@Override
	public void run() {

		String received;
		while (true)
		{
			try
			{
				// receive the string
                             int len = dis.readInt();
                             byte[] chiper = new byte[len];
                             dis.readFully(chiper);
			     received = dis.readUTF();
				System.out.print(RSA.bToS(chiper));
				System.out.println(received);
				
				if(received.equals("logout")){
					this.isloggedin=false;
					this.s.close();
					break;
				}
				
				// break the string into message and recipient part
				StringTokenizer st = new StringTokenizer(received, "#");
				//String MsgToSend = st.nextToken();
				String recipient = st.nextToken();

				// search for the recipient in the connected devices list.
				// ar is the vector storing client of active users
				for (ClientHandler mc : Sever.ar)
				{
					// if the recipient is found, write on its
					// output stream
					if (mc.name.equals(recipient) && mc.isloggedin==true)
					{
                                            mc.dos.writeInt(len);
                                            mc.dos.writeUTF(this.name+" : ");
                                            System.out.println("here : " + this.name+ " : ");
                                            mc.dos.write(chiper);
						
						break;
					}
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
