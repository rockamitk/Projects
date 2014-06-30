package input;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.text.*;

public class subUpdateRetail_Customer extends JFrame
{
  private JLabel ttl,lpc,l1,l2,l3,l4,l5,l6,l7;
  private JTextField t1,t2,t3,t4,t5,t6,t7;
  private JButton b1,b2;
  private JPanel p1,p2,p3;
 

  private Container cn;

  String str1,str2,str3,str4,str5,str6,str7,str,st,s;
  int k,f,r,c;

  float up,cramt,invamt,qty;


  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;

  Cursor cr=new Cursor(Cursor.HAND_CURSOR);



  public subUpdateRetail_Customer(String s1,String s2)
  {
    super("Update");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    cn=getContentPane();
    cn.setBackground(new Color(180,180,120));
   
    BevelBorder edge=new BevelBorder(BevelBorder.RAISED);
    EtchedBorder edge1=new EtchedBorder(EtchedBorder.RAISED);

    str6=s1.trim();
    str7=s2.trim();

    p1=new JPanel();
   
    p3=new JPanel();

    ttl=new JLabel("PRODUCT UPDATION ");
    ttl.setFont(new Font("Algerian",Font.BOLD,32));
    ttl.setForeground(Color.RED);

    p1.add(ttl);
    p1.setBackground(new Color(31,88,161));
    p1.setBounds(0,0,500,40);

   
    p3.setLayout(null);
    p3.setBackground(new Color(224,232,255));
    p3.setBounds(0,40,500,420);

    l6=new JLabel("Transaction NO");
    l6.setFont(new Font("Serif",1,18));
    l6.setBounds(100,10,150,30);
    l6.setBackground(Color.red);
    p3.add(l6);

    t6=new JTextField(str6);
    t6.setFont(new Font("Serif",1,18));
    t6.setBounds(260,10,150,30);
    t6.setEditable(false);
    p3.add(t6);

    l7=new JLabel("  Product Code");
    l7.setFont(new Font("Serif",1,18));
    l7.setBounds(100,50,150,30);
    l7.setBackground(Color.red);
    p3.add(l7);

    t7=new JTextField(str7);
    t7.setFont(new Font("Serif",1,18));
    t7.setBounds(260,50,150,30);
    t7.setEditable(false);
    p3.add(t7);

    l1=new JLabel("   QUANTITY");
    l1.setFont(new Font("Serif",1,18));
    l1.setBounds(100,90,150,30);
    p3.add(l1);

    t1=new JTextField(20);
    t1.setFont(new Font("Serif",1,18));
    t1.setBounds(260,90,150,30);
    p3.add(t1);



    l2=new JLabel("      DATE ");
    l2.setFont(new Font("Serif",1,18));
    l2.setBounds(100,130,150,30);
    p3.add(l2);


    t2=new JTextField(20);
    t2.setFont(new Font("Serif",1,18));
    t2.setBounds(260,130,150,30);
    p3.add(t2);
 
    

    l3=new JLabel("       MRP");
    l3.setFont(new Font("Serif",1,18));
    l3.setBounds(100,170,150,30);
    p3.add(l3);



    t3=new JTextField(20);
    t3.setFont(new Font("Serif",1,18));
    t3.setBounds(260,170,150,30);
    p3.add(t3);




    l4=new JLabel("  Current Amount");
    l4.setFont(new Font("Serif",1,18));
    l4.setBounds(100,210,150,30);
    p3.add(l4);



    t4=new JTextField(20);
    t4.setFont(new Font("Serif",1,18));
    t4.setBounds(260,210,150,30);
    t4.setEditable(false);
    p3.add(t4);



    l5=new JLabel("Total Amount");
    l5.setFont(new Font("Serif",1,18));
    l5.setBounds(100,250,150,30);
    p3.add(l5);


    t5=new JTextField(20);
    t5.setFont(new Font("Serif",1,18));
    t5.setBounds(260,250,150,30);
    t5.setEditable(false);
    p3.add(t5);
   

    b1=new JButton("SAVE");
    b1.setToolTipText("Change in Records");
    b1.setBounds(100,310,155,30);
    b1.setCursor(cr);
    b1.addActionListener(new saveListener());
    b1.setMnemonic('S');
    p3.add(b1);


    b2=new JButton("EXIT");
    b2.setToolTipText("EXIT");
    b2.setMnemonic('X');
    b2.addActionListener(new exitListener());
    b2.setBounds(255,310,150,30);
    p3.add(b2);


    l1.setBorder(edge1);
    l2.setBorder(edge1);
    
    l3.setBorder(edge1);
    l4.setBorder(edge1);
    l5.setBorder(edge1);
    l6.setBorder(edge1);
    l7.setBorder(edge1);


    cn.add(p1);
    cn.add(p3);

 
    pack();
    setSize(500,450);
    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-900)/2,(screensize.height-700)/2,500,450);

    setVisible(true);
    setResizable(true);

     connect();
     date_enter();
     findMrp();
     findInv(); 
          
  }


   protected void processWindowEvent(WindowEvent we)
   {
     if(we.getID() == we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
      }
   }




    
         private void date_enter()
         {
               java.util.Date dt=new java.util.Date();
               DateFormat dft= DateFormat.getDateInstance(DateFormat.MEDIUM,java.util.Locale.UK);
              t2.setText((String)dft.format(dt));
              t2.setEditable(false);
                
         }
 
  public void connect()
    {
     try
        {
         try
            {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             connection=DriverManager.getConnection("jdbc:odbc:amit","system","amit");
             statement=connection.createStatement();
            }
         catch(SQLException sqle)
           {
            JOptionPane.showMessageDialog(null,sqle,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("bb.jpg"));
           }
        }
     catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("cc.jpg"));
       }
   

 } 


   private class exitListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
          r=JOptionPane.showConfirmDialog(null,"EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
          if(r==JOptionPane.YES_OPTION)
           dispose();
         }
      }

 


public void findMrp()
         {
          
             try
               {
               rs=statement.executeQuery("select mrp from product_details where pdcode='"+str7+"'");
               rs.next();
               t3.setText(rs.getString(1));
               t3.setEditable(false);
               }
               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,sqle);

               }
          }



 public void findInv()
      { 
        try
        
             {

           
             rs=statement.executeQuery("select transno,sum(billamt) from Retail_Customer group by transno having transno='"+str6+"'");

             rs.next();
             st=rs.getString(2);
             t5.setText(st);
            }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Calculate"+sqle);
        }


     }

  public void amountCal(String str6,String str7)
       {
        String s1,s2,s3; 
	float t,d,n;	
	
     try
        {

          rs=statement.executeQuery("select tax,dis from  Retail_Customer where transno='"+str6+"' and pdcode='"+str7+"'");
          rs.next();

	s1=rs.getString(1);
	s2=rs.getString(2);
	
	  t=Float.parseFloat(s1);
	  d=Float.parseFloat(s2);
           
	   qty=Float.parseFloat(str1);
            up=Float.parseFloat(str3);
	     cramt=up*qty;
	     t=cramt*t/100;
	     d=cramt*d/100;
	     n=cramt+t-d;          
                   t4.setText(String.valueOf(n));
                   str4=t4.getText();
		
                
           
       }
        catch(SQLException sq)
       {
         JOptionPane.showMessageDialog(null,"error"+sq);
       }
 }

  private class saveListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        try
          {
             str1=t1.getText();
             if(str1.equals(""))
          
          JOptionPane.showConfirmDialog(null,"Please Enter Quantity","WARNING",JOptionPane.WARNING_MESSAGE);

      else
         {

          str1=t1.getText();
          str2=t2.getText();
          str3=t3.getText();

          amountCal(str6,str7);
          updateProduct(str6,str7);
          statement.executeUpdate("update Retail_Customer set transdate='"+str2+"',qty='"+str1+"',mrp='"+str3+"',billamt='"+str4+"' where transno='"+str6+"' and pdcode='"+str7+"'");
          statement.executeUpdate("commit");

                findInv();


          JOptionPane.showMessageDialog(null,"Record is Updated","Information",JOptionPane.INFORMATION_MESSAGE); 

         }

        }
        catch(SQLException sqle)
       {
         JOptionPane.showMessageDialog(null,sqle,"Information",JOptionPane.INFORMATION_MESSAGE);
       }
   }
 }


 public void updateProduct(String str6,String str7)
     {

        String s1,st,str; 
	int q1,q2,q,tq;
	
       try
          {

          rs=statement.executeQuery("select qty from  Product_Details where pdcode='"+str7+"'");
           rs.next();

        s1=rs.getString(1);
        q=Integer.parseInt(s1);

       
          rs=statement.executeQuery("select qty from  Retail_Customer where transno='"+str6+"' and pdcode='"+str7+"'");
           rs.next();

	st=rs.getString(1);
	
	q1=Integer.parseInt(st);

        str=t1.getText();

        q2=Integer.parseInt(str);


               tq=q+q1-q2; 

	st=String.valueOf(tq);
	          
        statement.executeUpdate("update Product_Details set qty='"+st+"' where pdcode='"+str7+"'");
	 statement.executeUpdate("commit");
           JOptionPane.showMessageDialog(null,"Quantity update");

	
          }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Qauntity does not update");
          }
       

      }     
  
/*
  public static void main(String args[])
  {
   subUpdateRetail_Customer surc=new subUpdateRetail_Customer("R0001","P0001");
  }*/
  
}

 
