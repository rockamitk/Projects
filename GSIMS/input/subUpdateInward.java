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

public class subUpdateInward extends JFrame
{
  private JLabel ttl,lpc,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
  private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
  private JButton b1,b2;
  private JPanel p1,p2,p3,p4;
 

  private Container cn;

  String str1,str2,str3,str4,str5,str6,str7,str8,str,st,s;
  int k,f,r,c;

  float up,cramt,invamt,qty;


  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;

  Cursor cr=new Cursor(Cursor.HAND_CURSOR);



  public subUpdateInward(String s1,String s2,String s3)
  {
    super("Update");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    cn=getContentPane();
    cn.setBackground(new Color(200,200,150));

    BevelBorder edge=new BevelBorder(BevelBorder.RAISED);
    EtchedBorder edge1=new EtchedBorder(EtchedBorder.RAISED);
    str6=s1.trim();
    str7=s2.trim();
    str8=s3.trim();

    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();

    ttl=new JLabel("PRODUCT UPDATION ");
    ttl.setFont(new Font("Algerian",Font.BOLD,32));
    ttl.setForeground(Color.RED);

    p1.add(ttl);
    p1.setBackground(new Color(30,90,161));
    p1.setBounds(0,0,500,40);

    p2.setLayout(null);
    p2.setBackground(new Color(200,180,130));
    p2.setBounds(0,40,500,100);



    p3.setLayout(null);
    p3.setBackground(new Color(200,200,150));
    p3.setBounds(0,140,500,420);




    l1=new JLabel("   QUANTITY");
    l1.setFont(new Font("Serif",1,18));
    l1.setBounds(100,10,150,30);
    p3.add(l1);

    t1=new JTextField(20);
    t1.setFont(new Font("Serif",1,18));
    t1.setBounds(260,10,150,30);
    p3.add(t1);



    l2=new JLabel("      DATE ");
    l2.setFont(new Font("Serif",1,18));
    l2.setBounds(100,50,150,30);
    p3.add(l2);


    t2=new JTextField(20);
    t2.setFont(new Font("Serif",1,18));
    t2.setBounds(260,50,150,30);
    p3.add(t2);
 
    

    l3=new JLabel("   Unit Price");
    l3.setFont(new Font("Serif",1,18));
    l3.setBounds(100,90,150,30);
    p3.add(l3);



      t3=new JTextField(20);
      t3.setFont(new Font("Serif",1,18));
      t3.setBounds(260,90,150,30);
      p3.add(t3);




    l4=new JLabel("  Current Amount");
    l4.setFont(new Font("Serif",1,18));
    l4.setBounds(100,130,150,30);
    p3.add(l4);



    t4=new JTextField(20);
    t4.setFont(new Font("Serif",1,18));
    t4.setBounds(260,130,150,30);
    t4.setEditable(false);
    p3.add(t4);



    l5=new JLabel("  Inward Amount");
    l5.setFont(new Font("Serif",1,18));
    l5.setBounds(100,170,150,30);
    p3.add(l5);


    t5=new JTextField(20);
    t5.setFont(new Font("Serif",1,18));
    t5.setBounds(260,170,150,30);
    t5.setEditable(false);
    p3.add(t5);
   

    l6=new JLabel("   Inward No");
    l6.setFont(new Font("Serif",1,18));
    l6.setBounds(10,10,150,30);
   
    p2.add(l6);


    l7=new JLabel("   Group Code");
    l7.setFont(new Font("Serif",1,18));
    l7.setBounds(170,10,150,30);
    p2.add(l7);

    l8=new JLabel("    Product Code");
    l8.setFont(new Font("Serif",1,18));
    l8.setBounds(330,10,150,30);
    p2.add(l8);


    l9=new JLabel("        "+str6);
    l9.setFont(new Font("Serif",1,22));
    l9.setBounds(10,40,150,30);
    p2.add(l9);

    l10=new JLabel("         "+str7);
    l10.setFont(new Font("Serif",1,22));
    l10.setBounds(170,40,150,30);
    p2.add(l10);

    l11=new JLabel("          "+str8);
    l11.setFont(new Font("Serif",1,22));
    l11.setBounds(330,40,150,30);
     p2.add(l11);



    b1=new JButton("SAVE");
    b1.setToolTipText("Change in Records");
    b1.setBounds(100,230,155,30);
    b1.setCursor(cr);
    b1.addActionListener(new saveListener());
    b1.setMnemonic('S');
    p3.add(b1);


    b2=new JButton("EXIT");
    b2.setToolTipText("EXIT");
    b2.setMnemonic('X');
    b2.addActionListener(new exitListener());
    b2.setBounds(255,230,150,30);
    p3.add(b2);


    l1.setBorder(edge1);
    l2.setBorder(edge1);
    
    l3.setBorder(edge1);
    l4.setBorder(edge1);
    l5.setBorder(edge1);
    l6.setBorder(edge1);
    l7.setBorder(edge1);
    l8.setBorder(edge1);
    l9.setBorder(edge1);
    l10.setBorder(edge1);
    l11.setBorder(edge1);

    cn.add(p1);
    cn.add(p2);
    cn.add(p3);

 
    pack();
    setSize(500,450);
    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-900)/2,(screensize.height-700)/2,500,450);

    setVisible(true);
    setResizable(true);

     connect();
     date_enter();
    // findMrp();
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



/*
 


public void findMrp()
         {
          
             try
               {
               rs=statement.executeQuery("select uprice from product_details where pdcode='"+str8+"'");
               rs.next();
               t3.setText(rs.getString(1));
               t3.setEditable(false);
               }
               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,sqle);

               }
          }

*/

 public void findInv()
      { 
        try
        
             {

           
             rs=statement.executeQuery("select inwno,sum(inwamt) from Inward group by inwno having inwno='"+str6+"'");

             rs.next();
             st=rs.getString(2);
             t5.setText(st);
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Calculate"+sqle);
        }


     }

  public void amountCal()
       {
                   qty=Float.parseFloat(str1);
                   up=Float.parseFloat(str3);
                   cramt=up*qty;
                   t4.setText(String.valueOf(cramt));
                   str4=t4.getText();
		
                  
           
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

          amountCal();
	 updateProduct();
          statement.executeUpdate("update Inward set inwdate='"+str2+"',qty='"+str1+"',mrp='"+str3+"',inwamt='"+str4+"' where inwno='"+str6+"' and group_code='"+str7+"' and pdcode='"+str8+"'");
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


 public void updateProduct()
     {

        String s1,st,s2,st1,str; 
	int q1,q2,q,tq;
	
        float a,b,c;
       try
          {

          rs=statement.executeQuery("select qty,pctag from  Product_Details where pdcode='"+str8+"'");
           rs.next();
       
    

        q=Integer.parseInt(rs.getString(1));
	a=Float.parseFloat(rs.getString(2));

       
          rs=statement.executeQuery("select qty from  Inward where inwno='"+str6+"' and pdcode='"+str8+"'");
           rs.next();

	q1=Integer.parseInt(rs.getString(1));

        q2=Integer.parseInt(t1.getText());
        tq=q+q2-q1; 
	st=String.valueOf(tq);

      

	b=Float.parseFloat(t3.getText());
        c=b+b*a/100;
        st1=String.valueOf(c);
                  
        statement.executeUpdate("update Product_Details set qty='"+st+"',uprice='"+str3+"',mrp='"+st1+"' where pdcode='"+str8+"'");
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
        subUpdateInward sui= new subUpdateInward("I0005","G0001","P0003");
  }*/
  
}

 
