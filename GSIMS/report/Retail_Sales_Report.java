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

public class Retail_Sales_Report extends JFrame 
{
  String[] col={"Product Code","Product Name","Quantity","Unit Price","Sale Price"};
  Object data[][]=new Object[15][5];
  JTable table;


  private JPanel p1,p2,p3;
  private JButton b1,b2,b3,b4;
  private JLabel tl,l1,l2,l3,l4,l5,l6;
  private JTextField t1,t2,t3,t4;
  private JComboBox cb1,cb2;
  private Container cn;

  int i,r;
  ResultSet rs,rs1;
  String s,st,str,str1,str2,str3,str4,str5,str6,str7;
  Dimension screensize;
  PageFormat pageFormat;
  Connection connection;
  Statement statement;
  Statement statement1;

 public Retail_Sales_Report()
 {
        setTitle("REPORT");


        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();

       JFrame fr=new JFrame();      
       Toolkit tkt=fr.getToolkit();                  
       Dimension frsize=tkt.getScreenSize();
       setBounds(frsize.width/4,frsize.height/12,frsize.width/2,frsize.height/8);
       setLayout(null);

        cn=getContentPane();
        cn.setBackground(new Color(160,150,80));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tl=new JLabel("Retail sales Report");
        tl.setFont(new Font("Engravers MT", 1, 25));
        tl.setForeground(new Color(247,251,249));
        p1.add(tl);

        p1.setBackground(new Color(31,88,166));
        cn.add(p1);
        p1.setBounds(0,0,600,50);


        l1=new JLabel(" MONTH");
        l1.setBounds(0,70,100,30);
        l1.setFont(new Font("Serif",Font.BOLD,18));
        l1.setForeground(new Color(149,49,49));

        cb1=new JComboBox();
        cb1.setBounds(110,70,120,30);
        cb1.setFont(new Font("Serif",Font.BOLD,18));
        cb1.setBackground(new Color(180,180,100));
       

        l2=new JLabel("  YEAR");
        l2.setBounds(270,70,100,30);
        l2.setFont(new Font("Serif",Font.BOLD,18));
        l2.setForeground(new Color(149,49,49));

        cb2=new JComboBox();
        cb2.setBounds(380,70,120,30);
        cb2.setFont(new Font("Serif",Font.BOLD,18));
        cb2.setBackground(new Color(180,180,100));

        l3=new JLabel("TOTAL SALE PRICE");
        l3.setBounds(30,370,180,30);
        l3.setFont(new Font("Serif",Font.BOLD,18));
        l3.setForeground(new Color(149,49,49));

        t1=new JTextField(20);
        t1.setBounds(210,370,100,30);
        t1.setFont(new Font("Serif",Font.BOLD,16));
        t1.setBackground(new Color(180,180,140));
        t1.setEditable(false);

        l4=new JLabel("TOTAL COST PRICE");
        l4.setBounds(30,410,180,30);
        l4.setFont(new Font("Serif",Font.BOLD,18));
        l4.setForeground(new Color(149,49,49));

        t2=new JTextField(20);
        t2.setBounds(210,410,100,30);
        t2.setFont(new Font("Serif",Font.BOLD,16));
        t2.setBackground(new Color(180,180,140));
        t2.setEditable(false);

        l5=new JLabel(" PROFIT");
        l5.setBounds(310,370,80,30);
        l5.setFont(new Font("Serif",Font.BOLD,18));
        l5.setForeground(new Color(149,49,49));

        t3=new JTextField(20);
        t3.setBounds(390,370,100,30);
        t3.setFont(new Font("Serif",Font.BOLD,16));
        t3.setBackground(new Color(180,180,140));
        t3.setEditable(false);
         
        l6=new JLabel("   LOSS");
        l6.setBounds(310,410,80,30);
        l6.setFont(new Font("Serif",Font.BOLD,18));
        l6.setForeground(new Color(149,49,49));

        t4=new JTextField(20);
        t4.setBounds(390,410,100,30);
        t4.setFont(new Font("Serif",Font.BOLD,16));
        t4.setBackground(new Color(180,180,140));
        t4.setEditable(false);

        b1=new JButton("DISPLAY");
        b1.setMnemonic('D');
        b1.addActionListener(new dispListener());
        b1.setBounds(100,450,100,30);

        b2=new JButton("PAGE SETUP");
        b2.setMnemonic('S');
        b2.addActionListener(new setupListener());
        b2.setBounds(200,450,100,30);

        b3=new JButton("PRINT");
        b3.setMnemonic('P');
        b3.addActionListener(new printListener());
        b3.setBounds(300,450,100,30);

        b4=new JButton("EXIT");
        b4.setMnemonic('X');
        b4.addActionListener(new exitListener());
        b4.setBounds(400,450,100,30);


    cn.add(l1);cn.add(cb1);

    cn.add(l2);cn.add(cb2);
    cn.add(l3);cn.add(t1);
    cn.add(l4);cn.add(t2);
    cn.add(l5);cn.add(t3);
    cn.add(l6);cn.add(t4);

    cn.add(b1);cn.add(b2);
    cn.add(b3);cn.add(b4);


    table=new JTable(data,col);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setBackground(new Color(180,180,140));
    table.setEnabled(false);

    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jsp.setBounds(5,150,590,200);
    cn.add(jsp);

    screensize=Toolkit.getDefaultToolkit().getScreenSize();

	
      setSize(600,550);
      setVisible(true);
      setVisible(true);
      setResizable(true);
      connect();
      month();
      year();

  }



   protected void processWindowEvent(WindowEvent we)
   {
     if(we.getID()==we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"WARNNING","EXIT",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
      }
   }


 public void month()
        {
          try
             {
               cb1.addItem(" -SELECT-");
               rs=statement.executeQuery("select distinct(month) from bRetail_Customer order by month");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();
               cb1.setSelectedIndex(0);
	        
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"Month Does Not Found");
              }

        }

 public void year()
        {
          try
             {
               cb2.addItem(" -SELECT-");
               rs=statement.executeQuery("select distinct(year) from bRetail_Customer order by year");
               while(rs.next())
               {
		String s="20"+(String)rs.getString(1);
                 cb2.addItem(s);
               }
               rs.close();
               cb2.setSelectedIndex(0);
	        
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"Year Does Not Load");
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
                          statement1=connection.createStatement();
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


  
public class dispListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
    {
     float a,b,sum;
     int k=0;
     sum=0;
     try
       {
          str1=(String)cb1.getSelectedItem();
          s=(String)cb2.getSelectedItem();
          str2=s.substring(2);
          rs=statement.executeQuery("select distinct(pdcode) from bRetail_Customer where month='"+str1+"' and year='"+str2+"' order by pdcode");
          while(rs.next())
          {
           str3=rs.getString(1);


           rs1=statement1.executeQuery("select sum(qty) from bRetail_Customer where pdcode='"+str3.trim()+"'");
           rs1.next();
           str5=rs1.getString(1);

            rs1=statement1.executeQuery("select pdname,uprice,mrp from Product_Details where pdcode='"+str3.trim()+"'");
            rs1.next();
            str4=rs1.getString(1);
            str6=rs1.getString(2);
            str7=rs1.getString(3);

               data[k][0]=str3;
               data[k][1]=str4;
               data[k][2]=str5;
               data[k][3]=str6;
               data[k][4]=str7;
              
             
               k++;
               a=Float.parseFloat(str5);
               b=Float.parseFloat(str6);
               sum=sum+(a*b);
          }
           
            data[k][0]=" ";
            data[k][1]=" ";
            data[k][2]=" ";
            data[k][3]=" ";
            data[k][4]=" ";

            str=String.valueOf(sum);
            t2.setText(str);

           table=new JTable(data,col);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setBackground(new Color(180,180,140));

          JScrollPane jsp=new JScrollPane(table);
          jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          jsp.setBounds(5,150,590,200);
           cn.add(jsp);
          saleamount();
       }
       catch(Exception sq)
            {
              JOptionPane.showMessageDialog(null,"error"+sq);
            }
        }    
 }
   public void saleamount()
   {
       float a,b,c,sum;
          sum=0;
          c=0;
     try
       {
          str1=(String)cb1.getSelectedItem();
          s=(String)cb2.getSelectedItem();
          str2=s.substring(2);
          rs=statement.executeQuery("select distinct(transno) from bRetail_Customer where month='"+str1+"' and year='"+str2+"' order by transno");
          while(rs.next())
          {
           st=rs.getString(1);
            rs1=statement1.executeQuery("select sum(billamt) from Retail_Customer where transno='"+st.trim()+"'");
            rs1.next();
            str=rs1.getString(1);
            sum=sum+Float.parseFloat(str);
          }
          str=String.valueOf(sum);
          t1.setText(str);

          st=t2.getText();
          b=Float.parseFloat(st);

          if(sum>=b)
          {
           a=sum-b;
           t3.setText(String.valueOf(a));
           t4.setText(String.valueOf(c));
          }
          else
          {
           a=b-sum;
           t4.setText(String.valueOf(a));
           t3.setText(String.valueOf(c));
          }
        }
       catch(Exception sqle)
            {
              JOptionPane.showMessageDialog(null,"Bill Error "+sqle);
            }
   }

 public class exitListener implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
     {
       int n= JOptionPane.showConfirmDialog(null,"Would U Really Want To Exit","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(n==JOptionPane.YES_OPTION)
       dispose();
     }

 }

private class printListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
      String cmd=e.getActionCommand();
      if (cmd.equals("PRINT"))
      {
        PrinterJob printJob=PrinterJob.getPrinterJob();
         if (pageFormat==null)
           pageFormat=printJob.defaultPage();
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
      String cmd=e.getActionCommand();
      if(cmd.equals("PAGE SETUP"))
      {
        PrinterJob printJob=PrinterJob.getPrinterJob();
        if (pageFormat==null)
            pageFormat=printJob.defaultPage();
        pageFormat=printJob.pageDialog(pageFormat);
      }
   }
} 

/*   
   public static void main(String args[])
 {
      Retail_Sales_Report rsr=new Retail_Sales_Report();
 }*/
 
}
 

