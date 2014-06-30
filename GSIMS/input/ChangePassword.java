package input;
import java.awt.*;
import java.sql.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
/*****************MAIN CLASS*****************/

public class ChangePassword extends JFrame  implements ActionListener
{

JButton cgpw,cancel;
JLabel l1,l2,l3,l4;
Choice txtnm;
TextField t1,t2,t3;
int i;
JPanel p1;
ResultSet rs;
Statement statement;
Connection myConnection;

/******************COSTRUCTOR***************/


 public ChangePassword()
	{
			
                        super("CHANGE PASSWORD");
                       // setLayout(null);
                        Dimension wndSize=Toolkit.getDefaultToolkit().getScreenSize(); 
                        Container myContainer=getContentPane();
                        myContainer.setBackground(Color.cyan);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,900,400);

	l1=new JLabel("Select Username");
	l1.setFont(new Font("Times New Roman",Font.BOLD,15));
	l1.setForeground(Color.blue);
        l1.setBounds(30,10,200,30);
        p1.add(l1);

	l2=new JLabel("Type Current Password");
        l2.setBounds(30,45,200,30);
	l2.setFont(new Font("Times New Roman",Font.BOLD,15));
	l2.setForeground(Color.blue);
        p1.add(l2);

        l3=new JLabel("Type New Password");
        l3.setBounds(30,80,200,30);
	l3.setFont(new Font("Times New Roman",Font.BOLD,15));
	l3.setForeground(Color.blue);
        p1.add(l3);

	l4=new JLabel("Confirm Password");
        l4.setBounds(30,115,200,30);
	l4.setFont(new Font("Times New Roman",Font.BOLD,15));
	l4.setForeground(Color.blue);
        p1.add(l4);
        

	txtnm=new Choice();
        txtnm.setBounds(235,10,150,30);
	txtnm.add("--SELECT USER--");
        txtnm.add("ADMINISTRATOR");
	txtnm.add("GUEST");
        p1.add(txtnm);

        t1=new TextField(20);
        t1.setBounds(235,45,150,30);
        t1.setEchoChar('*');
        p1.add(t1);

        t2=new TextField(20);
        t2.setBounds(235,80,150,30);
	t2.setEchoChar('*');
        p1.add(t2);

        t3=new TextField(20);
        t3.setBounds(235,115,150,30);
        t3.setEchoChar('*'); 
        p1.add(t3);

        cgpw=new JButton("Change Password");
        cgpw.setBounds(60,165,160,30);
        p1.add(cgpw);

	cancel=new JButton("Cancel");
        cancel.setBounds(250,165,80,30);
        p1.add(cancel);


        myContainer.add(p1);
        cgpw.addActionListener(this);
        cancel.addActionListener(this);
	
        pack();
        setVisible(true);
        setBounds((wndSize.width-410)/4,(wndSize.height-250)/4,900,235);
        setSize(410,235);   

        //setResizable(false);
	connect();

}

/*******************ACTION LISTENER*****************/
	
public void actionPerformed(ActionEvent evt)
  {
    String strun,strpw,strnpw,strcfpw,pw="";
    int l,f,f1;
    if(evt.getSource()==cgpw)
     {
     try
       {       
            strun=(String)txtnm.getSelectedItem();
            strun=strun.trim();
            strpw=t1.getText();
            strpw=strpw.trim();

            if(strpw.equals(""))
            {
            JOptionPane.showMessageDialog(null,"TextBox:Blanck");
            t1.requestFocus();
            }
             rs=statement.executeQuery("select pwd from login where name='"+strun+"'");
             rs.next();
             pw=rs.getString(1);
             pw=pw.trim();

           if(strpw.compareTo(pw)==0)
           {
           strnpw=t2.getText();
           strcfpw=t3.getText();
           if(strnpw==""||strcfpw=="")
            {
            JOptionPane.showMessageDialog(null,"Type New Password and Confirm Password");
            t2.requestFocus(); 
            }
             strnpw=strnpw.trim();
             strcfpw=strcfpw.trim();

             if(strnpw.compareTo(strcfpw)==0)
              {
              statement.executeUpdate("update login set pwd='"+strnpw+"' where name='"+strun+"'");
              statement.executeUpdate("commit");
              JOptionPane.showMessageDialog(null,"Password Changed");
              t1.setText("");
              t2.setText("");
              t3.setText("");
              t1.requestFocus();
              }
              else
              {
              JOptionPane.showMessageDialog(null,"New Password Incorrectly Confirmed.Retype New Password");
              t2.setText("");
              t3.setText("");
              t2.requestFocus();
              }
           }
           else
           {
           JOptionPane.showMessageDialog(null,"Incorrect Current Password");
           t1.setText("");
           t1.requestFocus();
           }

      }
       catch(SQLException sqle)
         {
         JOptionPane.showMessageDialog(null,"aamessage"+sqle);
         }
      }
    if(evt.getSource()==cancel)
    {
     dispose();
    }

  }
   	public void connect()
	{
		try
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                myConnection=DriverManager.getConnection("jdbc:odbc:amit","system","amit");
                                statement=myConnection.createStatement();//(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)
			}
			catch(SQLException sqle)
			{
					JOptionPane.showMessageDialog(null,sqle);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex);
		}
        }
/*
public static void main(String args[])
{
        ChangePassword cpw=new ChangePassword();
*/
}
