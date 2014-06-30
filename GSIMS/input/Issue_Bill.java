package input;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.JTable.*;
import java.text.*;

public class Issue_Bill extends JFrame
{
  private JLabel ttl,lpc,l1,l2,l3,l4,l5,l6,l7,l8;
  private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
  private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
  private JPanel p1,p2,p3,p4;
  JComboBox cb1,cb2,cb3;

  Float invamt,billamt,up,qty,ivamt;


  private Container cn;

  String str1,str2,str3,str4,str5,str6,str7,str8,str,st,s;
  int k,f,r,c;

  String[] fieldhead={"INVOICE NO","CUSTOMER CODE","INVOICE AMOUNT","TOTAL QUANYITY","TAX","DISCOUNT","BILL AMOUNT"};
  Object cord[][]=new Object[30][7];
  JTable table=new JTable(cord,fieldhead);

  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;


    String tx[]={"     -SELECT-","0","4","12"};
    String ds[]={"     -SELECT-","0","5","10","15","20"};


  Cursor cr=new Cursor(Cursor.HAND_CURSOR);
  public Issue_Bill()
  {
    super("Issue_Bill");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    cn=getContentPane();
    cn.setBackground(new Color(180,180,120));
    cn.setBackground(new Color(252,200,250));

    BevelBorder edge=new BevelBorder(BevelBorder.RAISED);
    EtchedBorder edge1=new EtchedBorder(EtchedBorder.RAISED);

    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();

    lpc=new JLabel();
    Icon img=new ImageIcon("m.jpg");
    lpc.setIcon(img);
    p2.add(lpc);
    p2.setBounds(0,0,300,480); 
    cn.add(p2); 

    ttl=new JLabel("BILL GENERATION");
    ttl.setFont(new Font("Algerian",Font.BOLD,32));
    ttl.setForeground(Color.RED);

    p1.add(ttl);
    p1.setBackground(new Color(31,88,161));
    p1.setBounds(300,0,500,40);
    cn.add(p1);

    p3.setLayout(null);
    p3.setBackground(new Color(224,232,255));
    p3.setBounds(300,40,500,440);
    cn.add(p3);

    p4.setLayout(null);
    p4.setBackground(new Color(224,232,255));
    p4.setBounds(0,480,800,400);
    cn.add(p4);


    l1=new JLabel("  Invoice No");
    l1.setFont(new Font("Serif",1,18));
    l1.setBounds(20,10,150,30);
    p3.add(l1);

    cb1=new JComboBox();
    cb1.setFont(new Font("Serif",1,18));
    cb1.setBounds(180,10,150,30);
    p3.add(cb1);
    

    b1=new JButton("NEW BILL");
    b1.setToolTipText("Add New Record");
    b1.setBounds(350,10,100,30);
    b1.setCursor(cr);
    b1.addActionListener(new newListener());
    b1.setMnemonic('B');
    p3.add(b1);


    l2=new JLabel("  Customer Code");
    l2.setFont(new Font("Serif",1,18));
    l2.setBounds(20,60,150,30);
    p3.add(l2);


    t2=new JTextField(20);
    t2.setFont(new Font("Serif",1,18));
    t2.setBounds(180,60,150,30);
    t2.setEditable(false);
    t2.setEditable(false);
    p3.add(t2);

    
    b2=new JButton("SAVE");
    b2.setToolTipText("Save Record");
    b2.setMnemonic('S');
    b2.addActionListener(new saveListener());
    b2.setCursor(cr);
    b2.setBounds(350,60,100,30);
    p3.add(b2);


    l3=new JLabel("  Invoice Amount");
    l3.setFont(new Font("Serif",1,18));
    l3.setBounds(20,110,150,30);
    p3.add(l3);


    t3=new JTextField(20);
    t3.setFont(new Font("Serif",1,18));
    t3.setBounds(180,110,150,30);
    t3.setEditable(false);
    p3.add(t3);


    b3=new JButton("DELETE");
    b3.setBounds(350,110,100,30);
    b3.setToolTipText("Delete Record");
    b3.setMnemonic('D');
   b3.addActionListener(new deleteListener());
    b3.setCursor(cr);
    p3.add(b3);



    l4=new JLabel("Total Quantity ");
    l4.setFont(new Font("Serif",1,18));
    l4.setBounds(20,160,150,30);
    p3.add(l4);


    t4=new JTextField(20);
    t4.setFont(new Font("Serif",1,18));
    t4.setBounds(180,160,150,30);
    t4.setEditable(false);
    p3.add(t4);

    b4=new JButton("UPDATE");
    b4.setBounds(350,160,100,30);
    b4.setToolTipText("Update Record");
    b4.setMnemonic('U');
    b4.addActionListener(new updateListener());
    b4.setCursor(cr);
    p3.add(b4);

    b5=new JButton("SEARCH");
    b5.setBounds(350,210,100,30);
    b5.setToolTipText("Search Record");
    b5.setMnemonic('F');
    b5.addActionListener(new searchListener());
    b5.setCursor(cr);
    p3.add(b5);

    l6=new JLabel("  TAX  ");
    l6.setFont(new Font("Serif",1,18));
    l6.setBounds(20,210,150,30);
    p3.add(l6);


    cb2=new JComboBox(tx);
    cb2.setFont(new Font("Serif",1,18));
    cb2.setBounds(180,210,150,30);
    p3.add(cb2);

    b6=new JButton("NEXT");
    b6.setBounds(350,260,100,30);
    b6.setToolTipText("Get Next Record");
    b6.setMnemonic('N');
    b6.addActionListener(new nextListener());
    p3.add(b6);


    l7=new JLabel(" Discount ");
    l7.setFont(new Font("Serif",1,18));
    l7.setBounds(20,260,150,30);
    p3.add(l7);

    cb3=new JComboBox(ds);
    cb3.setFont(new Font("Serif",1,18));
    cb3.setBounds(180,260,150,30);
    cb3.addActionListener(new cbListener());
    p3.add(cb3);


    b7=new JButton("PREVIOUS");
    b7.setBounds(350,310,100,30);
    b7.setToolTipText("Get PREVIOUS Record");
    b7.setMnemonic('P');
    b7.addActionListener(new previousListener());
    b7.setCursor(cr);
    p3.add(b7);



    l8=new JLabel("  Bill Amount");
    l8.setFont(new Font("Serif",1,18));
    l8.setBounds(20,310,150,30);
    p3.add(l8);

    t8=new JTextField(20);
    t8.setFont(new Font("Serif",1,18));
    t8.setBounds(180,310,150,30);
    t8.setEditable(false);
    p3.add(t8);


    b8=new JButton("EXIT");
    b8.setBounds(350,360,100,30);
    b8.setToolTipText("Exit");
    b8.setMnemonic('X');
    b8.addActionListener(new exitListener());
    b8.setCursor(cr);
    p3.add(b8);




    b9=new JButton("LOAD");
    b9.setBounds(0,400,100,30);
    b9.setToolTipText("Insert in Table");
    b9.setMnemonic('O');
    b9.addActionListener(new loadListener());
    b9.setCursor(cr);
    p3.add(b9);





    b1.setCursor(cr);

    l1.setBorder(edge);
    l2.setBorder(edge);
    
    l3.setBorder(edge);
    l4.setBorder(edge);
    l6.setBorder(edge);
    l7.setBorder(edge);
    l8.setBorder(edge);
    
    t2.setBorder(edge1);
    t3.setBorder(edge1);
    t4.setBorder(edge1);
    t8.setBorder(edge1);


    JTable table=new JTable(cord,fieldhead);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setForeground(Color.white);
    table.setBackground(new Color(200,160,160));


    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    p4.add(jsp);
    jsp.setBounds(5,0,785,350);

 
    pack();
    setSize(900,1000);
    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-900)/2,(screensize.height-700)/2,800,700);

    setVisible(true);
    setResizable(true);

     connect();
     
    invoiceComboBox();
          
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

   

 public void invoiceComboBox()
        {
          try
             {
               cb1.addItem("     -SELECT-");
               rs=statement.executeQuery("select invno from Customer_Invoice group by invno");
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

		 if(e.getSource()==cb1)
                      {
                        String st,st1;

			st=String.valueOf(cb1.getSelectedItem()).trim();
			try
			{
                        rs=statement.executeQuery("select ccode from customer_invoice where invno='"+st+"'");
                        rs.next();
			st1=rs.getString(1);
                        t2.setText(st1);
                        t2.setEditable(false);
                        rs.close();
                        invoiceFind(st);
			quantityFind(st);
                        
			}
                        catch(SQLException sqle)
			{
                                JOptionPane.showMessageDialog(null,sqle,"Database Error on Fetchin",JOptionPane.ERROR_MESSAGE);
			}
		}

	  
               if(e.getSource()==cb3)
               {
               int tax,dis;
               float invamt;
           invamt=Float.parseFloat(t3.getText());
           tax=Integer.parseInt(String.valueOf(cb2.getSelectedItem()).trim());
           dis=Integer.parseInt(String.valueOf(cb3.getSelectedItem()).trim());
           amountCal(invamt,tax,dis);
                 }


                }
        }

           
   public void invoiceFind(String st)
      { 

	try

            {
             
           
             rs=statement.executeQuery("select invno,sum(invamt) from Customer_Invoice group by invno having invno='"+st+"'");

             rs.next();

             str=rs.getString(2);
                 t3.setText(str);
		t3.setEditable(false);
		rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Calculate"+sqle);
        }

      }



   public void quantityFind(String st)
      { 

	try

            {
             
           
             rs=statement.executeQuery("select invno,sum(qty) from Customer_Invoice group by invno having invno='"+st+"'");

             rs.next();
         
             s=rs.getString(2);
                 t4.setText(s);
		t4.setEditable(false);
		rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Count"+sqle);
        }

      }


      public void amountCal(float invamt,int tax,int dis)
       {
                   float namt,t,d;
                   namt=invamt;
                   t=namt*tax/100;
                   d=namt*dis/100;
                   billamt=namt+t-d;
                   str8=String.valueOf(billamt);
                   t8.setText(str8);
           
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
            JOptionPane.showMessageDialog(null,sqle,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("oracle.gif"));
           }
        }
     catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("oracle.gif"));
       }
    }


   private class exitListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
          r=JOptionPane.showConfirmDialog(null,"DO YOU WANT TO EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
          if(r==JOptionPane.YES_OPTION)
           dispose();
         }
      }


   private class newListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
            clear();
            

         }
      }

        public void clear()
        {
        //  cb1.setSelectedIndex(0);
          t2.setText("");
          t3.setText("");
          t4.setText("");
          t8.setText("");
          cb2.setSelectedIndex(0);
          cb3.setSelectedIndex(0);
          

        }



   private class saveListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             
             str=(String)cb1.getSelectedItem();
             rs=statement.executeQuery("select invno from Issue_Bill");
             f=0;
             while(rs.next())
              {
                st=rs.getString(1);
                 if(str.compareTo(st)==0)
                    {
                      f=1;
                      break;
                    }
              }
             if(f==1)
             JOptionPane.showMessageDialog(null,"Bill Already Generated","INFO:",JOptionPane.INFORMATION_MESSAGE);
              else
              {
               str1=(String)cb1.getSelectedItem();
               str2=t2.getText();
               str3=t3.getText();
               str4=t4.getText();
               str6=(String)cb2.getSelectedItem();
               str7=(String)cb3.getSelectedItem();
               str8=t8.getText();

            statement.executeUpdate("insert into Issue_Bill values('"+str1.trim()+"','"+str2.trim()+"','"+str3.trim()+"','"+str4.trim()+"','"+str6.trim()+"','"+str7.trim()+"','"+str8.trim()+"')");
            statement.executeUpdate("commit");
            JOptionPane.showMessageDialog(null,"Bill is Generated","INFO:",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("b1.gif"));
            load();
               }
           }
           catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,sqle,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("oracle.gif"));
             }
       }
  }


  private class deleteListener implements ActionListener
    {
      int r;
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             str=JOptionPane.showInputDialog("Enter Invoice No to Delete" );
             if(str.compareTo("")!=0)
                {
                  r=JOptionPane.showConfirmDialog(null,"Are Want you to Delete","INFORMATION",JOptionPane.WARNING_MESSAGE);
                  if(r==JOptionPane.YES_OPTION)
                     {
                      statement.executeUpdate("delete from Issue_Bill where invno='"+str+"'");
                      statement.executeUpdate("commit");
                      load();
                      t2.setText("");
                      t3.setText("");
                      t4.setText("");
                      t8.setText("");

                      JOptionPane.showMessageDialog(null,"DELETED","INFORMATION",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("SendChat.gif"));
                     statement.executeUpdate("commit");
                      }
                }
            }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"CanNot be DELETED","Information",JOptionPane.ERROR_MESSAGE,new ImageIcon("error.gif"));
         }
      }

  }

  
  private class searchListener implements ActionListener
    {
    
    public void actionPerformed(ActionEvent e)
      {
       try
         {
         str=JOptionPane.showInputDialog("Enter the Invoice No to be Search");
         rs=statement.executeQuery("select * from Issue_Bill where invno='"+str.trim()+"'");     
         rs.next();
         t2.setText(rs.getString(2));
         t3.setText(rs.getString(3));
         t4.setText(rs.getString(4));
         s=rs.getString(5);
         st=rs.getString(6);
         t8.setText(rs.getString(7));

       
         cb2.setSelectedItem(s.trim());
         cb3.setSelectedItem(st.trim());
          cb1.setSelectedItem(rs.getString(1));  

         JOptionPane.showMessageDialog(null,"FOUND");
        }
          catch(SQLException sqle)
            {
             JOptionPane.showMessageDialog(null,"NOT FOUND"+sqle);
            }
         }
     }




  private class updateListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {

        try
        {
          str1=(String)cb1.getSelectedItem();
          str6=(String)cb2.getSelectedItem();
          str7=(String)cb3.getSelectedItem();
          str8=t8.getText();

            
          statement.executeUpdate("update Issue_Bill set tax='"+str6+"',dis='"+str7+"',billamt='"+str8+"' where invno='"+str1+"'");
         JOptionPane.showMessageDialog(null,"a");

          statement.executeUpdate("commit");
          JOptionPane.showMessageDialog(null,"Record is Updated","Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("SendChat.gif"));
          load();
         
        } 

     catch(SQLException sqle)
       {
         JOptionPane.showMessageDialog(null,sqle,"Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("BELLRING.gif"));
       }
   }
 }


 private class nextListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
   
       try
          {
           str=(String)cb1.getSelectedItem();
           if(str.equals(""))
             JOptionPane.showMessageDialog(null,"No Primary Record Select");
           else
           {
                        rs=statement.executeQuery("select * from Issue_Bill");
            while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)
             break;
            }
            rs.next();
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));        
            t8.setText(rs.getString(7));
            cb2.setSelectedItem(rs.getString(5));
            cb3.setSelectedItem(rs.getString(6));
            cb1.setSelectedItem(rs.getString(1));
                      

           }
          }
       catch(SQLException sqle)
       {
        JOptionPane.showMessageDialog(null,"LAST RECORD");
       }     
      }
    }


 public class previousListener implements ActionListener
   {
    public void actionPerformed(ActionEvent e)
      {
       str=(String)cb1.getSelectedItem();
       try
          {
           rs=statement.executeQuery("select * from Issue_Bill");
           c=0;
           while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)

             break;
             c++;
            }

           rs=statement.executeQuery("select * from Issue_Bill");
           k=0;
           while(rs.next())
            {
             k++;
              if(k==c)
              break;
            }
           t2.setText(rs.getString(2));
           t3.setText(rs.getString(3));
           t4.setText(rs.getString(4));
           t8.setText(rs.getString(7));
            cb2.setSelectedItem(rs.getString(5));
            cb3.setSelectedItem(rs.getString(6));
            cb1.setSelectedItem(rs.getString(1));
                      
          
         }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"This is First Record");
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
          rs=statement.executeQuery("select * from Issue_Bill");
          while(rs.next())
           {
            str1=rs.getString(1);
            str2=rs.getString(2);
            str3=rs.getString(3);
            str4=rs.getString(4);
            str5=rs.getString(5);
            str6=rs.getString(6);
            str7=rs.getString(7);
           
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               cord[k][3]=str4;
               cord[k][4]=str5;
               cord[k][5]=str6;
               cord[k][6]=str7;
              
             
               k++;
           }
            cord[k][0]=" ";
            cord[k][1]=" ";
            cord[k][2]=" ";
            cord[k][3]=" ";
            cord[k][4]=" ";
            cord[k][5]=" ";
            cord[k][6]=" ";
            


           JTable table=new JTable(cord,fieldhead);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setForeground(Color.blue);
           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
           jsp.setBounds(0,0,795,400);
           p4.add(jsp);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }


/*
  public static void main(String args[])
  {
        Issue_Bill ib= new Issue_Bill();
  }  */
}


