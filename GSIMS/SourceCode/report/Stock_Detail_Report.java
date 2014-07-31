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

public class Stock_Detail_Report extends JFrame 
{
  String[] col={"Product Code","Product Name","Quantity","Purchase Price","Sale Price"};
  Object cord[][]=new Object[15][5];
  JTable table;


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

 public Stock_Detail_Report()
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
        cn.setBackground(new Color(160,180,90));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tl=new JLabel("Stock Report");
        tl.setFont(new Font("ALGERIAN",Font.BOLD, 40));
        tl.setForeground(new Color(250,0,0));
        p1.add(tl);

    //    p1.setBackground(new Color(50,170,230));
        p1.setBackground(new Color(31,88,166));
        cn.add(p1);
        p1.setBounds(0,0,600,50);


        l1=new JLabel("      TILL DATE");
        l1.setBounds(125,70,150,30);
        l1.setFont(new Font("Serif",Font.BOLD,18));
//        l1.setForeground(new Color(20,100,18));
        l1.setForeground(new Color(149,49,49));

        t1=new JTextField(20);
        t1.setBounds(275,70,150,30);
        t1.setFont(new Font("Serif",Font.BOLD,16));
        t1.setEditable(false);

        b1=new JButton("DISPLAY");
        b1.setMnemonic('D');
        b1.addActionListener(new loadListener());
        b1.setBounds(60,350,120,30);

        b2=new JButton("PAGE SETUP");
        b2.setMnemonic('S');
        b2.addActionListener(new setupListener());
        b2.setBounds(180,350,120,30);

        b3=new JButton("PRINT");
        b3.setMnemonic('P');
        b3.addActionListener(new printListener());
        b3.setBounds(300,350,120,30);

        b4=new JButton("EXIT");
        b4.setMnemonic('X');
        b4.addActionListener(new exitListener());
        b4.setBounds(420,350,120,30);

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
   // cn.add(p1);


    table=new JTable(cord,col);
    table.setFont(new Font("Serif",Font.BOLD,18));
    table.setBackground(Color.magenta);

    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp.setBounds(5,120,590,200);
    cn.add(jsp);

    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    // setBounds((screensize.width-750)/2,(screensize.height-550)/2,750,550);

	
      setSize(600,500);
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
       load();
      }
    }

    public void load()
      {
       int k=0;
        try
         {

      statement.executeUpdate("commit");
      rs=statement.executeQuery("select pdcode,pdname,qty,uprice,mrp from Product_Details order by pdcode");

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

           JTable table=new JTable(cord,col);
           table.setFont(new Font("Serif",Font.BOLD,18));
           table.setForeground(Color.black);
           table.setBackground(Color.magenta);

           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
          cn.add(jsp);
           jsp.setBounds(5,120,590,200);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }

  
/*

public static void main(String args[])
 {
      Stock_Detail_Report sdr=new Stock_Detail_Report();
 }*/
  
}
 

