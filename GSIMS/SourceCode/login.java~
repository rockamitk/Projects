import java.awt.*;
import java.sql.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

public class login extends JFrame implements ActionListener
{

JButton b1,b2;
JLabel l1,l2,l3,l4,l;
Choice ch;
TextField t1;
int i;
JPanel jp1,jp2,jp3;
String user="";
ResultSet rs;
Statement statement;
Connection myConnection;



 public login()
	{
			
			JFrame aWindow = new JFrame("LOGIN FORM");
			Toolkit theKit = aWindow.getToolkit();
			Dimension wndSize = theKit.getScreenSize(); 
			      
			aWindow.setBounds(wndSize.width/4,wndSize.height/4,wndSize.width/2,wndSize.height/2);
			Container cn=aWindow.getContentPane();
			aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//aWindow.setForeground(Color.blue);
	
	cn.setLayout(null);
        cn.setBackground(new Color(240,240,180));				

	l1=new JLabel("Gift Sales & Inventory Management System");
        l1.setFont(new Font("Times New Roman",Font.BOLD,26));
	l1.setForeground(new Color(80,80,180));
        l1.setBounds(0,1,500,50);
	
	l2=new JLabel("USER LOGIN FORM");
	l2.setBounds(150,40,200,50);
	l2.setFont(new Font("Corier",Font.BOLD,18));

	l3=new JLabel("USER NAME");
	l3.setBounds(100,90,70,40);
	
	

	l4=new JLabel("PASSWORD");
	l4.setBounds(100,130,80,30);
	
	b1=new JButton("LOGIN");
	b1.setBounds(110,190,85,35);
	
	b2=new JButton("CANCEL");
	b2.setBounds(250,190,85,35);

	ch=new Choice();
	ch.setBounds(230,100,130,35);
	ch.add("--SELECT USER--");
        ch.add("ADMINISTRATOR       ");
	ch.add("GUEST");

	t1=new TextField(15);
	t1.setBounds(230,130,130,25);
	t1.setEchoChar('*');

	cn.add(l1);cn.add(t1);
	cn.add(l2);cn.add(b1);
	cn.add(l3);cn.add(b2);
	cn.add(l4);cn.add(ch);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	aWindow.pack();
	aWindow.setSize(500,300);
	aWindow.setVisible(true);
	aWindow.setResizable(false);
	connect();

}

	
public void actionPerformed(ActionEvent evt)
	{
                String str,str1="",str2="",str3;
                int l,lpw,f;
		if(evt.getSource()==b1)
		{
			try
                        {      
                               
                                str=(String)ch.getSelectedItem();
                                l=str.length();
                                str=str.trim();

                                str3=t1.getText();
                                str3=str3.trim();
                                lpw=str3.length();  
			if(lpw>10)
			{
			JOptionPane.showMessageDialog(null,"Max 10 digit accept");
    			}	 
				
                        else
			{        
                            rs=statement.executeQuery("select * from login");
                                
                                f=0;
                                while(rs.next())
				{
                                      str1=rs.getString(1);
                                      str2=rs.getString(2);

                                      str1=str1.trim();
                                      str2=str2.trim();
                         if((str.compareTo(str1)==0)&&(str2.compareTo(str3)==0))
                           {
                             f=1;
                             break;
                           }
                          }

                          if(f==1 )
                            {
                                new Menubar();
                                t1.setText("");

                            }
                          if(f==0)
                            {
                            JOptionPane.showMessageDialog(null,"Invalid Password");
                            }
			}
	        }
	        catch(SQLException sqle)
	        {
                JOptionPane.showMessageDialog(null,"Error"+sqle);
	        }
        }
        if(evt.getSource()==b2)
        {
        	System.exit(0);
        }

     }  
     
   public void connect()
{
    try
     	{
	try {
         	 Class.forName("com.mysql.jdbc.Driver").newInstance();
         	 connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/amit","root","amit");
         	 statement= connection.createStatement();
	 	 System.out.println("Connected");
         	 /*connection.close();*/
             } 
		catch (Exception e)  
		{
	          e.printStackTrace();
	        }
	 }
	catch (Exception e)  
		{
	          JOptionPane.showMessageDialog(null,"JavaError:Not Connect");
	        }
}    
 
public static void main(String args[])
{
        login lg=new login();
}
}
