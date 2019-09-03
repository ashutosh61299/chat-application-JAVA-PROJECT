import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.UIManager;

class Register extends Thread implements ActionListener{ 
	JFrame jf;
	JButton sub,cancle;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4,l5;
	JPasswordField p,pp;
	Statement st;
public void run(){
build();
dbcon();
System.out.println("Thread Register");

}

public void dbcon(){
		try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ashutosh","ashu");
		st=con.createStatement();
	}catch(Exception exc){System.out.println(exc);}}
void build(){

		jf=new JFrame("REGISTER PAGE");
		
		//jf.setLayout(new BorderLayout());
        jf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ASHUTOSH\\Downloads\\Abc.jpg")));
       // jf.setLayout(new FlowLayout());
		t1=new JTextField();
		t2=new JTextField();
		p=new JPasswordField();
		pp=new JPasswordField();
		t4=new JTextField();
		
		
		l1=new JLabel("Name:");
		l2=new JLabel("username:");
		l3=new JLabel("Password:");
		l4=new JLabel("confirm password:");
		l5=new JLabel("Email:");
		
		l1.setBounds(10,100,200,50);
		l2.setBounds(10,160,200,50);
		l3.setBounds(10,220,200,50);
		l4.setBounds(10,280,200,50);
		l5.setBounds(10,340,200,50);
		
		t1.setBounds(100,100,100,50);
		t2.setBounds(100,160,100,50);
		p.setBounds(100,220,100,50);
		pp.setBounds(100,280,100,50);
		t4.setBounds(100,340,300,50);
	   
	   jf.add(l1);
	   jf.add(l2);
	   jf.add(l3);
	   jf.add(l4);
	   jf.add(l5);
	   jf.add(t1);
	   jf.add(t2);
	   jf.add(p);
	   jf.add(pp);
	   jf.add(t4);
	   sub=new JButton("submit");
	   cancle=new JButton("cancle");
	   sub.setBounds(150,400,100,40);
	   cancle.setBounds(150,450,100,40);
	   sub.addActionListener(this);
	   cancle.addActionListener(this);
	   jf.add(sub);
	   jf.add(cancle);
	   jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		jf.setSize(400,600);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setVisible(true);
	   
}
 public void actionPerformed(ActionEvent ee){
	if(ee.getSource()==sub){
		if(p.getText().equals(pp.getText())){
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=p.getText();
		String s4=t4.getText();
		String q1 = "insert into userf values('" +s1+ "', '" +s2+ "', '" +s3+ "', '" +s4+ "')"; 
            try{
			int x = st.executeUpdate(q1); 
            if (x > 0) {            
                System.out.println("Successfully Registered");
			JOptionPane.showMessageDialog(null, "Registered");}
            else {           
                System.out.println("Insert Failed");
		JOptionPane.showMessageDialog(null, "Registration Failed");
			}}catch(Exception eee){System.out.println("eee");}
		}
		else{JOptionPane.showMessageDialog(null, "passwords do not matched!");}
		
	}
	else if(ee.getSource()==cancle){
		jf.setVisible(false);
	}
	
	
	
}


}