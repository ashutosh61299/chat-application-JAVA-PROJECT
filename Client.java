// Java implementation for multithreaded chat client 
// Save file as Client.java 

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.UIManager;

public class Client 
{ 
	final static int ServerPort = 1234; 
	static String name1;
	static String to;
	static int flag=0;
	static String msg1;
	static JTextArea jta;
	public Client(String name,JTextArea jta1){
		name1=name;
		jta=jta1;
		try{
		Crun();
		}catch(Exception e){System.out.println(e);}
	}

	public static void Crun() throws UnknownHostException, IOException 
	{ 
		
		Scanner scn = new Scanner(System.in); 
		
		// getting localhost ip 
		InetAddress ip = InetAddress.getByName("localhost"); 
		
		// establish the connection 
		//Server.uname=name1;
		Socket s = new Socket(ip, ServerPort);
		
		
		// obtaining input and out streams 
		DataInputStream dis = new DataInputStream(s.getInputStream()); 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
		System.out.println("lalalalalal............"+name1);
		dos.writeUTF(name1);
		
		// sendMessage thread 
		Thread sendMessage = new Thread(new Runnable() 
		{ 
			@Override
			public void run() { 
				while (true) { 
					System.out.println("inside runnnn of client");
					// read the message to deliver. 
					//String msg1 = scn.nextLine();
					while (flag!=1){try{Thread.sleep(1000);}catch(Exception er){}};
					System.out.println("flag is set to 1");
					
					String msg=msg1+"#"+to;
					 
					System.out.println(msg);
					
					try { 
						// write on the output stream 
						dos.writeUTF(msg); 
						flag=0;
						System.out.println("flag is set to 0");
						StringTokenizer st = new StringTokenizer(msg, "#"); 
						String MsgToSend = st.nextToken();
						jta.append("YOU :"+MsgToSend+"\n");
					} catch (IOException e) { 
						e.printStackTrace(); 
					} 
				} 
			} 
		}); 
		
		// readMessage thread 
		Thread readMessage = new Thread(new Runnable() 
		{ 
			@Override
			public void run() { 

				while (true) { 
					try { 
						// read the message sent to this client 
						String msg = dis.readUTF(); 
						System.out.println(msg);
						jta.append(msg+"\n");
					} catch (IOException e) { 

						e.printStackTrace(); 
					} 
				} 
			} 
		}); 

		sendMessage.start(); 
		readMessage.start(); 

	}
} 
