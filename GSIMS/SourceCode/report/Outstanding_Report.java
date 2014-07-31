package report;
import java.util.*;
import javax.swing.JTable.*;
import java.lang.String;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.awt.print.*;
import java.text.*;

public class Outstanding_Report extends JFrame 
{
  String[] col1={"Customer Code","Customer Name","Address","Contact","Dues Amount"};
  Object cord1[][]=new Object[15][5];

  String[] col2={"Party Code","Party Name","Address","Contact","Dues Amount"};
  Object cord2[][]=new Object[15][5];

  JTable tab1,tab2;
  private JRadioButton rb1,rb2;
  private ButtonGroup bg=new ButtonGroup();


  private JPanel p1;
  private JButton b1,b2,b3,b4;
  private JLabel tl,l1;
  private JTextField t1;
  private Container cn;

  ResultSet rs;
  String str1,str2,str3,str4,str5;
  int r;
  Dimension screensize;
  PageFormat pageFormat;
  Connection connection;
  Statement statement;

 public Outstanding_Report()
 {
        setTitle("REPORT");


        p1=new JPanel();

       JFrame fr=new JFrame();      
       Toolkit tkt=fr.getToolkit();                  
       Dimension frsize=tkt.getScreenSize();
       setBounds(frsize.width/4,frsize.height/12,frsize.width/2,frsize.height/8);
       setLayout(null);

        cn=getContentPane();
//        cn.setBackground(new Color(224,232,248));
        cn.setBackground(new Color(160,200,50));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tl=new JLabel("Outstanding Report");
        tl.setFont(new Font("ALGERIAN",Font.BOLD, 40));
        tl.setForeground(new Color(250,0,0));
        p1.add(tl);

    //    p1.setBackground(new Color(50,170,230));
        p1.setBackground(new Color(31,88,166));
        cn.add(p1);
        p1.setBounds(0,0,600,50);


        l1=new JLabel("TILL DATE");
        l1.setBounds(350,55,100,30);
        l1.setFont(new Font("Serif",Font.BOLD,18));
//        l1.setForeground(new Color(20,100,18));
        l1.setForeground(new Color(149,49,49));

        t1=new JTextField(20);
        t1.setBounds(450,55,100,30);
        t1.setFont(new Font("Serif",Font.BOLD,16));
        t1.setEditable(false);
        t1.setBackground(new Color(160,200,50));

        b1=new JButton("DISPLAY");
        b1.setMnemonic('D');
        b1.addActionListener(new loadListener());
        b1.setBounds(60,440,120,30);

        b2=new JButton("PAGE SETUP");
        b2.setMnemonic('S');
        b2.addActionListener(new setupListener());
        b2.setBounds(180,440,120,30);

        b3=new JButton("PRINT");
        b3.setMnemonic('P');
        b3.addActionListener(new printListener());
        b3.setBounds(300,440,120,30);

        b4=new JButton("EXIT");
        b4.setMnemonic('X');
        b4.addActionListener(new exitListener());
        b4.setBounds(420,440,120,30);



                rb1=new JRadioButton("Customer Dues");
                rb1.setBounds(20,55,150,30);
                rb1.setBackground(new Color(160,200,50));
                rb1.setSelected(true);
  
                rb2=new JRadioButton("Party Dues");
                rb2.setBounds(175,55,150,30);
                rb2.setBackground(new Color(160,200,50));



/*
    JLabel ln=new JLabel();
    ln.setForeground(new Color(3,91,14));
    ln.setText("====================================================================================================================================================================================================================================================================================================================================================================================================");
    cn.add(ln);
    ln.setBounds(0,485,850,16);

    JLabel bt1=new JLabel();
    bt1.setForeground(new Color(177,20,170));
    bt1.setText("DEVELOPED BY  :-");
    cn.add(bt1);
    bt1.setBounds(500,498,100,15);

    JLabel bt2=new JLabel();
    bt2.setForeground(new Color(149,21,21));
    bt2.setText("prem kumar");
    bt2.setBounds(615,498,300,15);
    cn.add(bt2);
  */

    cn.add(l1);cn.add(t1);

    cn.add(b1);cn.add(b2);
    cn.add(b3);cn.add(b4);
    cn.add(rb1);cn.add(rb2);
    bg.add(rb1);bg.add(rb2);
                
                
    tab1=new JTable(cord1,col1);
    tab1.setFont(new Font("Serif",Font.BOLD,16));
    tab1.setBackground(new Color(200,170,100));
    tab1.setEnabled(false);

    JScrollPane jsp1=new JScrollPane(tab1);
    jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp1.setBounds(5,100,590,150);
    cn.add(jsp1);

    tab2=new JTable(cord2,col2);
    tab2.setFont(new Font("Serif",Font.BOLD,16));
    tab2.setBackground(new Color(200,205,100));
    tab2.setEnabled(false);

    JScrollPane jsp2=new JScrollPane(tab2);
    jsp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp2.setBounds(5,270,590,150);
    cn.add(jsp2);

    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    // setBounds((screensize.width-750)/2,(screensize.height-550)/2,600,500);

	
      setSize(600,520);
      setVisible(true);
      setVisible(true);
      setResizable(true);
      connect();
      date_create();


  }





      private void date_create()
       {
        java.util.Date dt=new java.util.Date();
        DateFormat dft= DateFormat.getDateInstance(DateFormat.MEDIUM,java.util.Locale.UK);
        t1.setText((String)dft.format(dt));
                
       }
      
   protected void processWindowEvent(WindowEvent we)
   {
     if(we.getID()==we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"EXIT","WARNNING",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
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
                        connection=DriverManager.getConnection("jdbc:odbc:amit","system","amit");
                        statement=connection.createStatement();
                }
                catch(SQLException sqle)
                {
                        JOptionPane.showMessageDialog(null,sqle);
                }
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null,"NOT CONNECTED");
        }
 }



 public class exitListener implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
     {
       int n= JOptionPane.showConfirmDialog(null,"EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
       if(n==JOptionPane.YES_OPTION)
       dispose();
     }

 }



private class printListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
      String cmd = e.getActionCommand();
      if (cmd.equals("PRINT"))
      {
        PrinterJob printJob = PrinterJob.getPrinterJob();
         if (pageFormat == null)
           pageFormat = printJob.defaultPage();
         if (printJob.printDialog())
         {
          try
            {
              printJob.print();
            }
            catch (PrinterException exception)
            {
             JOptionPane.showMessageDialog(null, exception);
            }
         }
      }
    }
  }


private class setupListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
      String cmd = e.getActionCommand();
      if(cmd.equals("PAGE SETUP"))
      {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        if (pageFormat == null)
            pageFormat = printJob.defaultPage();
        pageFormat = printJob.pageDialog(pageFormat);
      }
   }
}                                                               

private class loadListener implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
      {             
          if(rb1.isSelected())
		loadCustomer();    

	  if(rb2.isSelected())
          loadParty();
      }
    }

    public void loadCustomer()
      {
       int k=0;
        try
         {

      statement.executeUpdate("commit");
      rs=statement.executeQuery("select ccode,cname,address,contact,osamt from Bulk_Customer order by ccode");

      while(rs.next())
       {
        str1=rs.getString(1);
        str2=rs.getString(2);
        str3=rs.getString(3);
        str4=rs.getString(4);
        str5=rs.getString(5);
            
        cord1[k][0]=str1;
        cord1[k][1]=str2;
        cord1[k][2]=str3;
        cord1[k][3]=str4;
        cord1[k][4]=str5;

               k++;
               
       }
           
            cord1[k][0]=" ";
            cord1[k][1]=" ";
            cord1[k][2]=" ";
            cord1[k][3]=" ";
            cord1[k][4]=" ";

    tab1=new JTable(cord1,col1);
    tab1.setFont(new Font("Serif",Font.BOLD,16));
    tab1.setBackground(new Color(200,170,100));

    JScrollPane jsp1=new JScrollPane(tab1);
    jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp1.setBounds(5,100,590,150);
    cn.add(jsp1);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Customer record not Found");                      
         }
            
      }

  

    public void loadParty()
      {
       int k=0;
        try
         {

      statement.executeUpdate("commit");
      rs=statement.executeQuery("select pcode,pname,address,contact,duesamt from Party_Master order by pcode");

      while(rs.next())
       {
        str1=rs.getString(1);
        str2=rs.getString(2);
        str3=rs.getString(3);
        str4=rs.getString(4);
        str5=rs.getString(5);
            
        cord2[k][0]=str1;
        cord2[k][1]=str2;
        cord2[k][2]=str3;
        cord2[k][3]=str4;
        cord2[k][4]=str5;

               k++;
               
       }
           
            cord2[k][0]=" ";
            cord2[k][1]=" ";
            cord2[k][2]=" ";
            cord2[k][3]=" ";
            cord2[k][4]=" ";

    tab2=new JTable(cord2,col2);
    tab2.setFont(new Font("Serif",Font.BOLD,16));
    tab2.setBackground(new Color(200,205,100));

    JScrollPane jsp2=new JScrollPane(tab2);
    jsp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp2.setBounds(5,270,590,150);
    cn.add(jsp2);


                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Party Record Not FOUND");                      
         }
            
      }

/*
public static void main(String args[])
 {
      Outstanding_Report or=new Outstanding_Report();
 }*/
  
}
 

