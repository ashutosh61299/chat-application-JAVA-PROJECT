import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.UIManager;
class Login extends Thread implements ActionListener {
	JFrame jf;
	JButton jb1,jb2;
	JLabel jl1,jl2;
	JTextField jtf;
	JPasswordField jpf;
	Statement st;
	public void run(){
		System.out.println("Thread Login");
		build();
		dbcon();
	}
	
	public void dbcon(){
		try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ashutosh","ashu");
		st=con.createStatement();
	}catch(Exception exc){System.out.println(exc);}}
	
	
	
	public void build(){
		jf=new JFrame("LOGIN PAGE");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400,400);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setVisible(true);
		//jf.setLayout(new BorderLayout());
        jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ASHUTOSH\\Downloads\\Abc.jpg")));
       // jf.setLayout(new FlowLayout());
		
		jb1=new JButton("Sign In");
		jb2=new JButton("New User?Register Now!");
		jl1=new JLabel("Username:");
		jl2=new JLabel("Password:");
		jtf=new JTextField("");
		jpf=new JPasswordField("");
		jl1.setBounds(50,50,100,60);
		jl2.setBounds(50,100,100,30);
		jtf.setBounds(150,60,200,30);
		jpf.setBounds(150,100,200,30);
		jb1.setBounds(130,200,100,40);
		jb2.setBounds(80,280,200,40);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jf.add(jb1);
		jf.add(jb2);
		jf.add(jl1);
		jf.add(jl2);
		jf.add(jtf);
		jf.add(jpf);
		jf.setSize(399,399);
        jf.setSize(400,400);
		try{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e4){
			System.out.println("not set look and feel");
		}
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==jb1){
			try{
			System.out.println("Login is pressed!");
			ResultSet rs=st.executeQuery("select * from userf");
			ResultSetMetaData rsmt=rs.getMetaData();
			while(rs.next()){
				if(rs.getString(2).equals(jtf.getText())&&rs.getString(3).equals(jpf.getText())){
					System.out.println("valid user");
					new TextBox(jtf.getText());
					}
				else
					continue;
				
			}
			}catch(Exception exc){
				System.out.println(exc);
			}
		}
		else if(ee.getSource()==jb2){
			Register r1=new Register();
			Thread t2=new Thread(r1,"threadRegister");
			t2.start();
		}
	}
/*public static void main(String... s){
	
	Login ln=new Login();
	
	
}*/		
}