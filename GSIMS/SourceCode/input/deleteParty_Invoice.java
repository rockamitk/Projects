package input;
import java.net.*; 
import java.lang.*;
import java.io.*;                           
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import java.text.*;
import javax.swing.border.*;




public class deleteParty_Invoice extends JFrame 
{

  private JLabel l1,l2,l3;
  
  private JTextField t1;
  private JButton b1,b3;
  JComboBox cb1,cb2;

  private Container cn;
  String st,str,str1,str2,str3;
  int f;
  
  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;



  public deleteParty_Invoice()
  {
    
    

              JFrame fr = new JFrame("DELETE FORM");
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

		
                l2 = new JLabel("    Party Code");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(50,90,150,30);

                t1 = new JTextField(20);
                t1.setFont(new Font("Serif",Font.BOLD,20));
                t1.setBounds(260,90,150,30);

                l3 = new JLabel("  Product Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(50,130,150,30);


                cb2=new JComboBox();
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(260,130,150,30);

                b1=new JButton("Delete");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(100,200,130,30);
                b1.setMnemonic('D');
                b1.addActionListener(new deleteListener());



               

                b3=new JButton( "EXIT");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(230,200,130,30);
                b3.setMnemonic('X');
                b3.addActionListener(new exitListener(fr));


		cn.add(l1);cn.add(cb1);
		cn.add(l2);cn.add(t1);
                cn.add(l3);cn.add(cb2);
                cn.add(b1);cn.add(b3);

		
   
    		    fr.pack();
                    fr.setSize(500,300);
		    fr.setVisible(true);
                    cn.setBackground(Color.pink);
		
                       connect(); 

		invoiceCombo();
		      

             }



  public void invoiceCombo()
        {
          try
             {
               cb1.addItem("  -SELECT-");
               rs=statement.executeQuery("select distinct(invno) from Party_Invoice order by invno");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();
               cb1.setSelectedIndex(0);
	       cb1.addActionListener(new cbListener());
                
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
          
            
           str1=String.valueOf(cb1.getSelectedItem()).trim();
             try
               {
               rs=statement.executeQuery("select pcode from Party_Invoice where invno='"+str1+"'");
               rs.next();
               str=rs.getString(1);
               t1.setText(str);
               t1.setEditable(false);
               rs.close();

			cb2.removeActionListener(this);
			cb2.setEnabled(true);
			cb2.removeAllItems();
                  try
                     {
                       rs=statement.executeQuery("select pdcode from Party_Invoice where pcode='"+str+"' order by pdcode");
                      while(rs.next())
                        {
                         cb2.addItem(rs.getString(1));

                        }
                        rs.close();
                     }
                  catch(SQLException sqle)
                      {
                         JOptionPane.showMessageDialog(null,"Cant ADD");

                      }

               }
               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,sqle);

               }
          }


     }



 private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        try

           {

            str1=(String)cb1.getSelectedItem();
	    str2=t1.getText();
            str3=(String)cb2.getSelectedItem();

		 updateProduct(str1,str3);

            statement.executeUpdate("delete from Party_Invoice where invno='"+str1+"' and pcode='"+str2+"' and pdcode='"+str3+"'");
            statement.executeUpdate("Commit");
            JOptionPane.showMessageDialog(null,"Deleted");
           }
        catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Failure to Delete");
         }
                             
      }
    }

       
 public void updateProduct(String str1,String str3)
     {

      
	int q1,q,tq;
       try
          {

          rs=statement.executeQuery("select qty from  Party_Invoice where invno='"+str1+"' and pdcode='"+str3+"'");
           rs.next();

	str=rs.getString(1);
	q1=Integer.parseInt(str);
       
          rs=statement.executeQuery("select qty from  Product_Details where pdcode='"+str3+"'");
           rs.next();

	st=rs.getString(1);
	q=Integer.parseInt(st);

               tq=q-q1; 


	st=String.valueOf(tq);
                  
        statement.executeUpdate("update Product_Details set qty='"+st+"' where pdcode='"+str3+"'");
	 statement.executeUpdate("commit");
           JOptionPane.showMessageDialog(null,"Quantity update");

	
          }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Qauntity does not update");
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
        deleteParty_Invoice dpi= new deleteParty_Invoice();
  }  */
  
}
