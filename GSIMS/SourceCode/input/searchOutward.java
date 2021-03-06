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




public class searchOutward extends JFrame 
{

  private JLabel l1,l3;
  
  private JTextField t3;
  private JButton b1,b2;
  private JComboBox cb1;

  
  private Container cn;
  String st,str1,str2,str3,str4,str5,str6,str7;
  int f,r,k;
  
  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;


String[] fieldhead={"GROUP CODE","PRODUCT CODE","DATE","QUANTITY"," MRP ","CURRENT AMOUNT"};
  Object cord[][]=new Object[15][6];
  JTable table=new JTable(cord,fieldhead);


  public searchOutward()
  {
    
    

               
              JFrame fr = new JFrame("SEARCH");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        cn=fr.getContentPane();
               
         cn.setLayout(null);



     
                l1 = new JLabel("     Outward No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(30,50,150,30);


                cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(190,50,150,30);
                cb1.setBackground(Color.magenta);

                l3 = new JLabel(" Outward Amount");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds( 350,310,150,30);


                t3=new JTextField(20);
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

		cn.add(l3);cn.add(t3);
		cn.add(jsp);

                cn.add(b1);cn.add(b2);

		
   
    		    fr.pack();
                    fr.setSize(700,430);
		    fr.setVisible(true);
                    cn.setBackground(Color.pink);
		
                       connect(); 
                outwardCombo();


             }




   public void outwardCombo()
        {
          try
             {
                  cb1.addItem("    -SELECT-");
               rs=statement.executeQuery("select distinct(outno) from Outward order by outno");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();

             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Record in Outawrd Table");
              }

        }


private class loadListener implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
      { try
          {

               str6=(String)cb1.getSelectedItem();
           
             load(str6);
             rs=statement.executeQuery("select outno,sum(outamt) from Outward group by outno having outno='"+str6+"'");

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

    public void load(String str6)
    {
      k=0;
        try
         {

          statement.executeUpdate("commit");
                                            
          rs=statement.executeQuery("select group_code,pdcode,TO_CHAR(outdate,'DD-MON-YYYY'),qty,mrp,outamt from Outward where outno='"+str6+"'");

          while(rs.next())
          {
            str1=rs.getString(1);
            str2=rs.getString(2);

      
            str3=rs.getString(3);
            str4=rs.getString(4);
            str5=rs.getString(5);
           
            str7=rs.getString(6);
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               cord[k][3]=str4;
               cord[k][4]=str5;
              
               cord[k][5]=str7;
             
               k++;
               
           }
           
            cord[k][0]=" ";
            cord[k][1]=" ";
            cord[k][2]=" ";
            cord[k][3]=" ";
            cord[k][4]=" ";
            cord[k][5]=" ";
            

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
        searchOutward so= new searchOutward();
  }*/
}
