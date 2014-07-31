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




public class searchCustomer_Invoice extends JFrame 
{

  private JLabel l1,l2,l3;
  
  private JTextField t3;
  private JButton b1,b2;
  private JComboBox cb1,cb2;

  
  private Container cn;
  String st,str1,str2,str3,str4,str5,str6,str7;
  int f,r,k;
  
  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;


String[] fieldhead={"PRODUCT CODE","DATE","QUANTITY"," MRP ","CURRENT AMOUNT"};
  Object cord[][]=new Object[15][5];
  JTable table=new JTable(cord,fieldhead);


  public searchCustomer_Invoice()
  {
    
    

               
              JFrame fr = new JFrame("SEARCH");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        cn=fr.getContentPane();
               
         cn.setLayout(null);



     
                l1 = new JLabel("       Invoice No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(30,50,150,30);


                cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(190,50,150,30);
                cb1.setBackground(Color.magenta);
		
                l2 = new JLabel("   Customer Code");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(360,50,150,30);

		cb2=new JComboBox();
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(520,50,150,30);
                cb2.setBackground(Color.magenta);



                l3 = new JLabel(" Invoice Amount");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds( 350,310,150,30);


                t3 = new JTextField(20);
                t3.setFont(new Font("Serif",Font.BOLD,20));
                t3.setBounds(510,310,150,30);
                t3.setEditable(false);
                t3.setBackground(Color.magenta);

                b1=new JButton(" OK ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(210,350,130,30);
                b1.setMnemonic('O');
                b1.addActionListener(new loadListener());


                b2=new JButton(" CLOSE  ");
                b2.setFont(new Font("Serif",Font.BOLD,20));
                b2.setBounds(350,350,130,30);
                b2.setMnemonic('C');
                b2.addActionListener(new closeListener(fr));



   JTable table=new JTable(cord,fieldhead);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setForeground(Color.black);
 //   table.setBackground(new Color(200,160,160));
    table.setBackground(Color.green);


    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    
    jsp.setBounds(2,100,690,200);

                cn.add(l1);cn.add(cb1);
                cn.add(l2);cn.add(cb2);

		cn.add(l3);cn.add(t3);
		cn.add(jsp);

                cn.add(b1);cn.add(b2);

		
   
    		    fr.pack();
                    fr.setSize(700,430);
		    fr.setVisible(true);
                    cn.setBackground(Color.pink);
		
                       connect(); 
		invoiceCombo();


             }




   public void invoiceCombo()
        {
          try
             {
              
               rs=statement.executeQuery("select distinct(invno) from Customer_Invoice order by invno");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();
		cb2.setEnabled(false);
               cb1.addActionListener(new cbListener());
               cb1.setSelectedIndex(0);

             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Record in INVOICE TABLE");
              }

        }
        private class cbListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
			cb2.removeActionListener(this);
			cb2.setEnabled(true);
			cb2.removeAllItems();
			try
			{
                        rs=statement.executeQuery("select distinct(ccode) from Customer_Invoice where invno='"+String.valueOf(cb1.getSelectedItem()).trim()+"'");
                        while(rs.next())
			cb2.addItem(rs.getString(1));
			}
                        catch(SQLException sqle)
			{
                                JOptionPane.showMessageDialog(null,sqle,"Database Error on Fetchin",JOptionPane.ERROR_MESSAGE);
			}

                }
        }



private class loadListener implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
      { try
          {

               str6=(String)cb1.getSelectedItem();
               str7=(String)cb2.getSelectedItem();
           
             load(str6,str7);
             rs=statement.executeQuery("select invno,sum(invamt) from Customer_Invoice group by invno having invno='"+str6+"'/*and ccode='"+str7+"'*/");

             rs.next();
             st=rs.getString(2);
             t3.setText(st);
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Calculate"+sqle);
        }

      }


   }          

    public void load(String str6,String str7)
    {
      k=0;
        try
         {

          statement.executeUpdate("commit");
                                            
          rs=statement.executeQuery("select distinct(pdcode),TO_CHAR(invdate,'DD-MON-YYYY'),qty,mrp,invamt from Customer_Invoice where invno='"+str6+"' and ccode='"+str7+"'");

          while(rs.next())
          {
            str1=rs.getString(1);
            str2=rs.getString(2);

      
            str3=rs.getString(3);
            str4=rs.getString(4);
            str5=rs.getString(5);
           
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               cord[k][3]=str4;
               cord[k][4]=str5;
              
             
               k++;
               
           }
           
            cord[k][0]=" ";
            cord[k][1]=" ";
            cord[k][2]=" ";
            cord[k][3]=" ";
            cord[k][4]=" ";
            

           JTable table=new JTable(cord,fieldhead);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setForeground(Color.black);
           table.setBackground(Color.green);

           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
          cn.add(jsp);
           jsp.setBounds(2,100,690,200);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
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



 private class closeListener implements  ActionListener
	{
		JFrame aw;
                public closeListener(JFrame aWindow)
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
        searchCustomer_Invoice sb= new searchCustomer_Invoice();
  }*/
}
