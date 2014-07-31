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


public class updateOutward extends JFrame 
{

  private JLabel l1,l2,l3;
  
  private JButton b1,b3;
  JComboBox cb1,cb2,cb3;
  JPanel p1=new JPanel();

  private Container cn;
  String str1,str2,str3;
  int f;
  
  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs,rs1;



  public updateOutward()
  {
    
    

              JFrame fr = new JFrame("UPDATE");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        cn=fr.getContentPane();
               
         cn.setLayout(null);



     
                l1 = new JLabel("     Outward No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(50,50,150,30);


		cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(260,50,150,30);

		
                l2 = new JLabel("   Group Code");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(50,90,150,30);

                cb2=new JComboBox();
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(260,90,150,30);

                l3 = new JLabel("  Product Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(50,130,150,30);


                cb3=new JComboBox();
                cb3.setFont(new Font("Serif",Font.BOLD,20));
                cb3.setBounds(260,130,150,30);

                b1=new JButton(" OK  ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(100,200,130,30);
                b1.setMnemonic('O');
                b1.addActionListener(new okListener());



               

                b3=new JButton("EXIT");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(230,200,130,30);
                b3.setMnemonic('X');
                b3.addActionListener(new exitListener(fr));


		cn.add(l1);cn.add(cb1);
		cn.add(l2);cn.add(cb2);
                cn.add(l3);cn.add(cb3);
                cn.add(b1);cn.add(b3);

		
   
    		    fr.pack();
                    fr.setSize(500,300);
		    fr.setVisible(true);
                    cn.setBackground(new Color(150,150,100));
		
                       connect(); 

		OutwardCombo();
		      

             }



  public void OutwardCombo()
        {
		
          try
             {
               rs=statement.executeQuery("select distinct(outno) from Outward order by outno");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();
             
               cb2.setEnabled(false);
	       cb3.setEnabled(false);
	      
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
          
         if(e.getSource()==cb1)
	    {
             str1=String.valueOf(cb1.getSelectedItem()).trim();

			cb2.removeActionListener(this);
			cb2.setEnabled(true);
			cb2.removeAllItems();
			 
            try
              {
               rs=statement.executeQuery("select distinct(group_code) from Outward where outno='"+str1+"' order by group_code");
                while(rs.next())
		{

                cb2.addItem(rs.getString(1));
		}               
                 cb2.addActionListener(this); 
		 cb2.setSelectedIndex(0);          
              
	      }

               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,"Can't Load Group Code"+sqle);

               }
            }
	if(e.getSource()==cb2)
	    {

 
                cb3.setEnabled(true);
		cb3.removeActionListener(this);
		cb3.removeAllItems(); 
                
                 
	    try
               {
		
	       str1=String.valueOf(cb1.getSelectedItem()).trim();
               str2=String.valueOf(cb2.getSelectedItem()).trim();
               rs=statement.executeQuery("select distinct(pdcode) from Outward where outno='"+str1+"'and group_code='"+str2+"' order by pdcode");
                while(rs.next())
		{

                cb3.addItem(rs.getString(1));
		}  
	       }             
                  catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,"Can't Load Group Code"+sqle);

               }           

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
                  str1=(String)cb1.getSelectedItem();
                  str2=(String)cb2.getSelectedItem();
                  str3=(String)cb3.getSelectedItem();
                 new subUpdateOutward(str1,str2,str3);
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
        updateOutward uo= new updateOutward();
  }*/
  
}
