package input;
import java.net.*; 
import java.lang.*;
import java.io.*;                           
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.JTable.*;
import java.text.*;
import javax.swing.border.*;




public class updateRetail_Customer extends JFrame 
{

  private JLabel l1,l2,l3;
  
  private JTextField t1;
  private JButton b1,b3;
  JComboBox cb1,cb2;
  JPanel p1=new JPanel();

  private Container cn;
  String str1,str2,str3;
  int f;
  
  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;



  public updateRetail_Customer()
  {
    
    

              JFrame fr = new JFrame("UPDATE");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        cn=fr.getContentPane();
               
         cn.setLayout(null);



     
                l1 = new JLabel("     Invoice No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(50,50,150,30);


		cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(260,50,150,30);

                l3 = new JLabel("  Product Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(50,130,150,30);


                cb2=new JComboBox();
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(260,130,150,30);

                b1=new JButton(" OK  ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(100,200,130,30);
                b1.setMnemonic('O');
                b1.addActionListener(new okListener());
             

                b3=new JButton( "EXIT");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(230,200,130,30);
                b3.setMnemonic('X');
                b3.addActionListener(new exitListener(fr));


		cn.add(l1);cn.add(cb1);
		cn.add(l3);cn.add(cb2);
                cn.add(b1);cn.add(b3);

		
   
    		    fr.pack();
                    fr.setSize(500,300);
		    fr.setVisible(true);
                    cn.setBackground(Color.pink);
		
                       connect(); 

		transCombo();
		      

             }



  public void transCombo()
        {
          try
             {
               // cb1.addItem("-SELECT-");
               rs=statement.executeQuery("select distinct(transno) from Retail_Customer order by transno");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
              
               cb1.addActionListener(new cbListener());
                 cb1.setSelectedIndex(0);
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Record In Primary Table");
              }

        }


      private class cbListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          
           String st;
          st=String.valueOf(cb1.getSelectedItem()).trim();
             try
                {
                  cb2.removeActionListener(this);
                  cb2.setEnabled(true);
                   cb2.removeAllItems();
                  rs=statement.executeQuery("select pdcode from Retail_Customer where transno='"+st+"' order by pdcode");
                     while(rs.next())
                      {
                      cb2.addItem(rs.getString(1));

                     }
                }
             catch(SQLException sqle)
                 {
                   JOptionPane.showMessageDialog(null,"Cant ADD");
                 }
         }


     }




       

  public void connect()
    {
     try
        {
         try
            {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

             connection=DriverManager.getConnection( "jdbc:odbc:amit","system","amit");

             statement=connection.createStatement();
     	    }
     	    catch(SQLException sqle)
            {
            	JOptionPane.showMessageDialog(null,"EXCEPTION"+sqle);
            }
        }

        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null,"NOT CONNECTED");
        }

   }  

 private class okListener implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
                  String s1,s2;
                  s1=(String)cb1.getSelectedItem();
                  s2=(String)cb2.getSelectedItem();
                  new subUpdateRetail_Customer(s1,s2);
                }
    	
        }



 private class exitListener implements  ActionListener
	{
		JFrame aw;
                public exitListener(JFrame aWindow)
		{
		 aw=aWindow;
		 }
		public void actionPerformed(ActionEvent e)
		{
                 aw.dispose();
                }
    	
    }


/*
  public static void main(String args[])
  {
       updateRetail_Customer uri= new updateRetail_Customer();
  }*/
  
}
