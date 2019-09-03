import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.UIManager;



class TextBox implements ActionListener{
JFrame jf;
	JButton jb1,jb2;
	JLabel jl1,jl2;
	JTextField jtf,jtf1;
	JTextArea jta;
	Client c1;
	Statement st;
	String ms,to;
	String uname;
	public TextBox(String uname){
		System.out.println(uname);
		build();
		c1=new Client(uname,jta);
		
			
	}
	
	
	
	public void build(){
		jf=new JFrame("APP");
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setVisible(true);
		//jf.setLayout(new BorderLayout());
        jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ASHUTOSH\\Downloads\\Abc.jpg")));
       // jf.setLayout(new FlowLayout());
		
		jb1=new JButton("Send");
		//jb2=new JButton("New User?Register Now!");
		//jl1=new JLabel("Username:");
		//jl2=new JLabel("Password:");
		jtf=new JTextField("message");
		jtf1=new JTextField("reciever uname");
		jta=new JTextArea();
		jta.setBounds(10,10,300,300);
		jtf.setBounds(50,320,200,30);
		jtf1.setBounds(50,370,200,30);
		
		jb1.setBounds(270,350,100,40);
		jb1.addActionListener(this);
		jf.add(jb1);
		jf.add(jtf);
		jf.add(jtf1);
		jf.add(jta);
		//jf.setSize(399,399);
        //jf.setSize(400,400);
		jf.setSize(430,550);
		try{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e4){
			System.out.println("not set look and feel");
		}
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==jb1){
			this.to=jtf1.getText();
			this.ms=jtf.getText();
			System.out.println("button clicked");
			c1.msg1=this.ms;
			System.out.println("bc1");
			c1.to=this.to;
			System.out.println("bc2");
			c1.flag=1;
			System.out.println("bc3");
			
			
			
			
			
			
		}
		
		}





}