import input.*;
import report.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;
import java.awt.print.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import static java.awt.event.InputEvent.*;
public class Menubar extends JFrame
{
  private JMenuBar menubar=new JMenuBar();
  private JMenu m1,m2,m3,m4,mi3,mi4,mi5;
  private JMenuItem mi1,mi2,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,sm1,sm2,sm3,sm4,sm5,sm6;

  
  private JLabel l1,l2;
  private JButton b1,b2,b3;
  private JPanel p1,p2;
  private Container cn;
  private String str1,str2,str3,str4,str5,str6,str;
  private Connection connection;
  private Statement statement;
  private ResultSet rs;
  Cursor cr=new Cursor(Cursor.HAND_CURSOR);

  public Menubar()
  {
    super("Gift Store");
    setLayout(null);
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-700)/4,(screensize.height-400)/4,700,400);
    setSize(800,550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    cn=getContentPane();
    cn.setBackground(new Color(200,140,100));

        l1=new JLabel("Gift Sales & Inventory Management System");
        l1.setFont(new Font("ALGERIAN",Font.BOLD, 40));
        l1.setForeground(new Color(250,0,0));
        p1=new JPanel();
        p1.setBounds(0,0,800,62);
        p1.setBackground(new Color(31,88,166));
        p1.add(l1);
        cn.add(p1,BorderLayout.NORTH);

        Icon ic=new ImageIcon("9.jpg");
	l2=new JLabel(ic);
	l2.setForeground(Color.red);
        l2.setBounds(180,0,400,350);


          p2=new JPanel();
          p2.setLayout(null);
          p2.setBounds(0,60,800,490);
//        p2.setBackground(new Color(31,88,166));
          p2.setBackground(new Color(200,140,100));
          cn.add(p2,BorderLayout.CENTER);



  
    setJMenuBar(menubar);

    //MENUS

    m1=new JMenu("  INPUT");
    m2=new JMenu("TRANSACTION");
    m3=new JMenu("   REPORT");
    m4=new JMenu("     HELP");
 
    //MENU MENUITEMS
       // Entry Item

         mi1=new JMenuItem("Gift Group");
         mi2=new JMenuItem("Product Detail");
         mi3=new JMenu("Supplier & cUst");
	 
         m1.add(mi1);
         m1.add(mi2);
         m1.add(mi3);
     
       //transaction
              
    mi4=new JMenu("Branch");
    mi5=new JMenu("Order");
    mi6=new JMenuItem("Issue Bill");
    mi7=new JMenuItem("Bill Payment");
    mi8=new JMenuItem("Retail Customer");

    m2.add(mi4);
    m2.add(mi5);
    m2.add(mi6);
    m2.add(mi7);
    m2.add(mi8);

        //REPORT MENUITEMS
    mi9=new JMenuItem("Monthly Sales");
    mi10=new JMenuItem("Product Stock");
    mi11=new JMenuItem("Dues Amount");
    mi12=new JMenuItem("Bulk Customer");

    m3.add(mi9);
    m3.add(mi11);
    m3.add(mi11);
    m3.add(mi12);

            //HELP MENUITEMS
    mi13=new JMenuItem("Software Deatil");
    mi14=new JMenuItem("Developer Detail");
    mi15=new JMenuItem("Instruction");
    mi16=new JMenuItem("Change Password");

    m4.add(mi13);
    m4.add(mi14);
    m4.add(mi15);
    m4.add(mi16);

    // Sub Menu Item

    sm1=new JMenuItem("Supplier");
    sm2=new JMenuItem("Customer");
    sm3=new JMenuItem("Inward");
    sm4=new JMenuItem("Outward");
    sm5=new JMenuItem("Customer Invoice");
    sm6=new JMenuItem("Party Invoice");

    mi3.add(sm1);
    mi3.add(sm2);
    mi4.add(sm3);
    mi4.add(sm4);
    mi5.add(sm5);
    mi5.add(sm6);
      // Button
   
                 b1=new JButton("DAILY CUSTOMER");
                 b1.setFont(new Font("Serif",Font.BOLD,20));
                 b1.setMnemonic('D');
                 b1.setBounds(200,300,250,35);
                 b1.addActionListener(new transactionlistener()); 
		 p2.add(b1);    
               
                 b2=new JButton("INVOICE CUSTOMER");
                 b2.setFont(new Font("Serif",Font.BOLD,20));
                 b2.setMnemonic('I');
                 b2.setBounds(480,300,250,35);
                 //b2.setBackground(new Color(150,180,60));
                 b2.addActionListener(new transactionlistener());     
                 p2.add(b2);
                 
                 b3=new JButton("EXIT");
                 b3.setFont(new Font("Serif",Font.BOLD,20));
                 b3.setMnemonic('X');
                 b3.setBounds(300,350,100,35);
                 b3.addActionListener(new exitListener());     
                 p2.add(b3);
		p2.add(l2);

         //MNEMONICS

     m1.setMnemonic('E');
     m2.setMnemonic('T');
     m3.setMnemonic('R');
     m4.setMnemonic('H');
     

     mi1.setAccelerator(KeyStroke.getKeyStroke('G',CTRL_DOWN_MASK));
     mi2.setAccelerator(KeyStroke.getKeyStroke('P',CTRL_DOWN_MASK));
     mi6.setAccelerator(KeyStroke.getKeyStroke('B',CTRL_DOWN_MASK));
     mi7.setAccelerator(KeyStroke.getKeyStroke('D',CTRL_DOWN_MASK));
     mi8.setAccelerator(KeyStroke.getKeyStroke('R',CTRL_DOWN_MASK));
     mi9.setAccelerator(KeyStroke.getKeyStroke('M',CTRL_DOWN_MASK));
     mi10.setAccelerator(KeyStroke.getKeyStroke('U',CTRL_DOWN_MASK));
     mi11.setAccelerator(KeyStroke.getKeyStroke('S',CTRL_DOWN_MASK));
     mi12.setAccelerator(KeyStroke.getKeyStroke('Y',CTRL_DOWN_MASK));
     mi13.setAccelerator(KeyStroke.getKeyStroke('W',CTRL_DOWN_MASK));
     mi14.setAccelerator(KeyStroke.getKeyStroke('V',CTRL_DOWN_MASK));
     mi15.setAccelerator(KeyStroke.getKeyStroke('M',CTRL_DOWN_MASK));
     mi16.setAccelerator(KeyStroke.getKeyStroke('N',CTRL_DOWN_MASK));

     sm1.setAccelerator(KeyStroke.getKeyStroke('K',CTRL_DOWN_MASK));
     sm2.setAccelerator(KeyStroke.getKeyStroke('T',CTRL_DOWN_MASK));
     sm3.setAccelerator(KeyStroke.getKeyStroke('I',CTRL_DOWN_MASK));
     sm4.setAccelerator(KeyStroke.getKeyStroke('O',CTRL_DOWN_MASK));
     sm5.setAccelerator(KeyStroke.getKeyStroke('C',CTRL_DOWN_MASK));
     sm6.setAccelerator(KeyStroke.getKeyStroke('A',CTRL_DOWN_MASK));
    

     menubar.add(m1);
     menubar.add(m2);
     menubar.add(m3);
     menubar.add(m4);
    

     //ACTIONLISTENERS

     mi1.addActionListener(new entrylistener());
     mi2.addActionListener(new entrylistener());
     sm1.addActionListener(new entrylistener());
     sm2.addActionListener(new entrylistener());

     sm3.addActionListener(new transactionlistener());
     sm4.addActionListener(new transactionlistener());
     sm5.addActionListener(new transactionlistener());
     sm6.addActionListener(new transactionlistener());
    
      mi6.addActionListener(new transactionlistener());
      mi7.addActionListener(new transactionlistener());
     mi8.addActionListener(new transactionlistener());

     mi9.addActionListener(new reportlistener());
     mi10.addActionListener(new reportlistener());
     mi11.addActionListener(new reportlistener());
     mi12.addActionListener(new reportlistener());

     mi13.addActionListener(new helplistener());
     mi14.addActionListener(new helplistener());
    // mi15.addActionListener(new helplistener());
      mi16.addActionListener(new helplistener());
    
   
    connect();
    setVisible(true);
    setResizable(false);
 }


  private class entrylistener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==mi1)
    {
       new Gift_Group();
    }
    if(e.getSource()==mi2)
    {
      new Product_Details();
    }
    if(e.getSource()==sm1)
    {
      new Bulk_Customer();
    }

    if(e.getSource()==sm2)
    {
      new Party_Master();
    }

   }
  }

  private class transactionlistener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==sm3)
    {
      new Inward();
    }

    if(e.getSource()==sm4)
    {
     new Outward();
    }

    if(e.getSource()==sm5)
    {
     new Customer_Invoice();
    }

    if(e.getSource()==sm6)
    {
     new Party_Invoice();
    }
    if(e.getSource()==mi6)
    {
     new Issue_Bill(); 
    }
    if(e.getSource()==mi7)
    {
        new Bill_Payment();
    }
    if(e.getSource()==mi8)
    {
       new Retail_Customer();
    }

    if(e.getSource()==b1)
    {
       new Retail_Customer();
    }

    if(e.getSource()==b2)
    {
       new Customer_Invoice();
    }
   }
  }

  private class reportlistener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==mi9)
    {
        new Monthly_Sales_Report();
    }
    if(e.getSource()==mi10)
    {
        new Outstanding_Report();
    }
    if(e.getSource()==mi11)
    {
       new Stock_Detail_Report();
    }
    if(e.getSource()==mi12)
    {
       new Bulk_Customer_Report();
    }
 
   }
  }

  private class helplistener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==mi13)
    {
        new aboutsw();
    }
    if(e.getSource()==mi14)
    {
        new developer();
    }
    if(e.getSource()==mi15)
    {
    // new instruction();
    }
    if(e.getSource()==mi16)
    {
       new ChangePassword();
    }
 
   }
  }

 public class exitListener implements ActionListener
 {
     int r;
     public void actionPerformed(ActionEvent e)
     {
      r=JOptionPane.showConfirmDialog(null,"EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
       dispose();
     }

 }

   protected void processWindowEvent(WindowEvent we)
   { int r;
     if(we.getID() == we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"Do You Want To Exit Now !","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
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
  Menubar mb=new Menubar();
}
}


