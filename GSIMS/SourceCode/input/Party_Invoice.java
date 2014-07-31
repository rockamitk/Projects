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



public class Party_Invoice extends JFrame
{
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,b11;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String s,st,st1,str,str1,str2,str3,str4,str5,str6,str7,str8;
    JComboBox cb1,cb2;
    float invamt,up,qty,cramt;  

    Connection connection;
    Statement statement;
    private Icon icn;
    ResultSet rs,rs1;
    int c,k,f,r;

  Container cn=new Container();
  String[] fld={"INVOICE NO","DATE","PARTY CODE","PRODUCT CODE","QUANTITY"," UNIT PRICE ","CURRENT AMOUNT"};
  Object col[][]=new Object[25][7];
  JTable table=new JTable(col,fld);

       public Party_Invoice()
        
        {
                              
             
              JFrame fr = new JFrame("Party Invoice");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              cn=fr.getContentPane();
               
                cn.setLayout(null);
                icn=new ImageIcon("pic001.jpg");
                l9=new JLabel(icn);
                l9.setBounds(0,0,300,510);
						
               l8 = new JLabel("PARTY INVOICE DETAILS ");
               l8.setForeground(Color.red);
               l8.setFont(new Font("Algerian",Font.BOLD,40));
               l8.setBounds(320,20,600,80);                       

                l1 = new JLabel("  Invoice No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(380,150,150,30);

                t1 = new JTextField(20);
                t1.setFont(new Font("Serif",Font.BOLD,20));
                t1.setBounds(540,150,150,30);

                b1=new JButton(" ADD  ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(720,150,130,30);
                b1.setMnemonic('A');
                b1.addActionListener(new newListener());

                l2 = new JLabel("  Invoice Date");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(380,190,150,30);

                t2 = new JTextField(20);
                t2.setFont(new Font("Serif",Font.BOLD,20));
                t2.setBounds(540,190,150,30);

                b2=new JButton( "DELETE ");
                b2.setFont(new Font("Serif",Font.BOLD,20));
                b2.setBounds(720,190,130,30);
                b2.setMnemonic('D');
                b2.addActionListener(new deleteListener());
                

                l3 = new JLabel(" Party Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(380,230,150,30);

             
                cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(540,230,150,30);

                b3=new JButton("SAVE");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(720,230,130,30);
                b3.setMnemonic('S');
                b3.addActionListener(new saveListener());
                

                l4 = new JLabel(" Product Code");
                l4.setFont(new Font("Serif",Font.BOLD,20));
                l4.setBounds(380,270,150,30);

                
                cb2=new JComboBox();
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(540,270,150,30);

                b4=new JButton("UPDATE");
                b4.setFont(new Font("Serif",Font.BOLD,20));
                b4.setBounds(720,270,130,30);
                b4.setMnemonic('U');
                b4.addActionListener(new updateListener());
                
                l5=new JLabel( "Quantity");
                l5.setFont(new Font("Serif",Font.BOLD,20));
                l5.setBounds(380,310,150,30);

                t5=new JTextField(20);
                t5.setFont(new Font("Serif",Font.BOLD,20));
                t5.setBounds(540,310,150,30);

                l6=new JLabel(" Unit Price");
                l6.setFont(new Font("Serif",Font.BOLD,20));
                l6.setBounds(380,350,150,30);

                t6=new JTextField(20);
                t6.setFont(new Font("Serif",Font.BOLD,20));
                t6.setBounds(540,350,150,30);


                l7=new JLabel("Current Amount");
                l7.setFont(new Font("Serif",Font.BOLD,20));
                l7.setBounds(380,390,150,30);

                t7=new JTextField(20);
                t7.setFont(new Font("Serif",Font.BOLD,20));
                t7.setBounds(540,390,150,30);
                t7.setEditable(false);

                l10=new JLabel("Invoice Amount");
                l10.setFont(new Font("Serif",Font.BOLD,20));
                l10.setBounds(380,430,150,30);

                t8= new JTextField(20);
                t8.setFont(new Font("Serif",Font.BOLD,20));
                t8.setBounds(540,430,150,30);
                t8.setEditable(false);
                
                 b5=new JButton("SEARCH");
                 b5.setFont(new Font("Serif",Font.BOLD,20));
                 b5.setMnemonic('F');
                 b5.setBounds(720,310,130,30);
                 b5.addActionListener(new searchListener());

                
                 b6=new JButton("EXIT");
                 b6.setFont(new Font("Serif",Font.BOLD,20));
                 b6.setMnemonic('X');
                 b6.setBounds(720,350,130,30);
                 b6.addActionListener(new exitListener(fr));


               b7=new JButton("LOAD");
               b7.setFont(new Font("Serif",Font.BOLD,20));
               b7.setMnemonic('L');
               b7.setBounds(720,390,130,30);
               b7.addActionListener(new loadListener());

               b8=new JButton("BILL PAY");
               b8.setFont(new Font("Serif",Font.BOLD,20));
               b8.setMnemonic('B');
               b8.setBounds(720,430,130,30);
               b8.addActionListener(new billListener());


      
    JTable table=new JTable(col,fld);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setForeground(Color.black);
 //   table.setBackground(new Color(200,160,160));
    table.setBackground(Color.magenta);


    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    
    jsp.setBounds(2,520,890,180);
          

                cn.add(l1);cn.add(t1); 
                cn.add(l2);cn.add(t2);
                cn.add(l3);cn.add(cb1);
                cn.add(l4);cn.add(cb2);
                cn.add(l5);cn.add(t5);
                cn.add(l6);cn.add(t6);
                cn.add(l7);cn.add(t7);
                cn.add(l10);cn.add(t8);
                cn.add(l8);cn.add(l9);


                cn.add(b1);cn.add(b2);
                cn.add(b3);cn.add(b4);
                cn.add(b5);cn.add(b6);
                cn.add(b7);cn.add(b8);
                cn.add(jsp);
                cn.setBackground(Color.PINK);



                fr.pack();
                fr.setSize(900,720);
   
                fr.setVisible(true);
                 connect();
                 date_create();
                 productCodeCombo();
                 partyCodeCombo();

	
    }


                      private void date_create()
                      {
                       java.util.Date dt=new java.util.Date();
                       DateFormat dft= DateFormat.getDateInstance(DateFormat.MEDIUM,java.util.Locale.UK);
                       t2.setText((String)dft.format(dt));
                
                      }

    public void partyCodeCombo()
        {
          try
             {
               cb1.addItem("   -SELECT-");
               rs=statement.executeQuery("select pcode from Party_Master");
               while(rs.next())
               {
                 cb1.addItem((String)rs.getString(1));
               }
               rs.close();
               cb1.setSelectedIndex(0);
		
               
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Record In Party_Master");
              }

        }


    public void productCodeCombo()
        {
          try
             {
               cb2.addItem("   -SELECT-");
               rs=statement.executeQuery("select pdcode from Product_Details");
               while(rs.next())
               {
                 cb2.addItem((String)rs.getString(1));
               }
               rs.close();
//               cb2.addActionListener(new cbListener());
               cb2.setSelectedIndex(0);
               
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Products Found ");
              }

        }


      private class cbListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          
             String st;
             st=String.valueOf(cb2.getSelectedItem()).trim();
             try
               {
               rs=statement.executeQuery("select mrp from product_details where pdcode='"+st+"'");
               rs.next();
               t6.setText(rs.getString(1));
               t6.setEditable(false);
               }
               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,sqle);

               }
          }


     }



  public void amountCal(Float invamt)
       {
                   qty=Float.parseFloat(str5);
                   up=Float.parseFloat(str6);
                   cramt=up*qty;
                   t7.setText(String.valueOf(cramt));
                   str7=t7.getText();
                   invamt=invamt+cramt;
                   t8.setText(String.valueOf(invamt));
                   str8=t8.getText();
                  
           
       }


    public void invoiceFind(String str1)
      { 

	try

            {

           
             rs=statement.executeQuery("select invno,sum(invamt) from Party_Invoice group by invno having invno='"+str1+"'");

             rs.next();
             str=rs.getString(2);
                 t8.setText(str);
                 rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Error to Calculate"+sqle);
        }

      }



   public void clear()
      {

       try
          {
          rs=statement.executeQuery("select * from  lParty_Invoice");
           rs.next();

           String st=rs.getString(1);
           t1.setText(st);
           rs.close();
           date_create();
           t5.setText(" ");
           t6.setText(" ");
           t7.setText(" ");
           invamt=0;
           t8.setText(String.valueOf(invamt));
           
           cb1.setEnabled(true);
           cb2.setEnabled(true);
	   cb1.setSelectedIndex(0);
           cb2.setSelectedIndex(0);

          }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Error");
          }
       
       }
                



    public void updateProduct(String st4,String str5,String str6)
     {

	 float a,b,c;
	int q1,q,tq;
       try
          {
		q=Integer.parseInt(str5);
		b=Float.parseFloat(str6);

          rs=statement.executeQuery("select qty,pctag from  Product_Details");
           rs.next();

        st=rs.getString(1);
	s=rs.getString(2);

        q1=Integer.parseInt(st);
	a=Float.parseFloat(s);

        tq=q1+q;
        st=String.valueOf(tq);
	
        c=b+b*a/100;
        st1=String.valueOf(c);


        statement.executeUpdate("update Product_Details set qty='"+st.trim()+"',uprice='"+str6.trim()+"',mrp='"+st1.trim()+"' where pdcode='"+str4.trim()+"'");
        statement.executeUpdate("commit");

        JOptionPane.showMessageDialog(null,"Products update");
	
          }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Products does not update");
          }
       

      }

   private class saveListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
           
        int flg=0;
           try
            {
              str1=t1.getText();
              str3=(String)cb1.getSelectedItem();
              str4=(String)cb2.getSelectedItem();
                  
             rs=statement.executeQuery("select pdcode from Party_Invoice where invno='"+str1+"' and pcode='"+str3+"'");
              while(rs.next())
               {
        
                   str=rs.getString(1);

                   if(str4.compareTo(str)==0)
                     {
                      flg=1;
                      break;
                     }
                  
              }

              if(flg==1)
                 {
                  JOptionPane.showMessageDialog(null,"product code already exists ");
                 }
             else
                {
                                       

                   str1=t1.getText();

                   str2=t2.getText();
                   str3=(String)cb1.getSelectedItem();     
                   str4=(String)cb2.getSelectedItem();
              
                   str5=t5.getText();
                   str6=t6.getText();
                   str8=t8.getText();

                   invamt=Float.parseFloat(str8);
                   amountCal(invamt);
         
                   updateProduct(str4,str5,str6);

                   statement.executeUpdate("insert into Party_Invoice values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"')");
                   statement.executeUpdate("commit");
                   JOptionPane.showMessageDialog(null,"INSERTED");
                      load();

                   r=JOptionPane.showConfirmDialog(null,"Add More Product","INFO",JOptionPane.INFORMATION_MESSAGE);
                   if(r==JOptionPane.YES_OPTION)
                     {
                      t1.setEditable(false);
                      cb1.setEnabled(false);
                      cb2.setSelectedIndex(0);
                      t5.setText("");
                      t6.setText("");
                      t7.setText("");

                     }
            if(r==JOptionPane.NO_OPTION)
              {


		int a,b;

                       
                 str1=t1.getText();

                     rs=statement.executeQuery("select invno from lParty_Invoice");
                     rs.next();
                     st1=rs.getString(1);
             s=st1.substring(2);

             a=Integer.parseInt(s);

             str=str1.substring(2);
                     
             b=Integer.parseInt(str);
                        
                   if(a==b)
                   {
                  try

                     {

                  rs=statement.executeQuery("select invno from lParty_Invoice");
                     rs.next();
                     str1=rs.getString(1);



                     rs=statement.executeQuery("select lpad(to_char(to_number(substr('"+str1+"',3))+1),3,'0') from dual");
                     rs.next();
                     str1="PI"+rs.getString(1);
                     
                      statement.executeUpdate("update lParty_Invoice set invno='"+str1+"'");
                      clear();
                      t1.setEditable(true);

                      cb1.setEnabled(true);
                      cb1.setSelectedIndex(0);
                    }
                    catch(SQLException sqle)
                    {
                     
                    JOptionPane.showMessageDialog(null,"not cancati"+sqle);
                    }
                  }
                  else
                  clear();
               }


       
            }
           }
        catch(SQLException  sqle)
        {
        JOptionPane.showMessageDialog(null,"Error tO INSERT"+sqle);
        }

      }
       

   }
                                   

  private class newListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {

          k=JOptionPane.showConfirmDialog(null,"OK=ADD NEW INVOICE OR NO=ADD EXIST","INFO",JOptionPane.INFORMATION_MESSAGE);
          if(k==JOptionPane.YES_OPTION)
          {
            clear();

          }
          else
          {
           try
            {
             str1=JOptionPane.showInputDialog("ENTER INVOICE NO FOR EDIT");
             rs=statement.executeQuery("select * from Party_Invoice where invno='"+str1+"'");
             rs.next();
             t1.setText(rs.getString(1));
            
                      t5.setText("");
                      t6.setText("");
                      t7.setText("");
             str3=rs.getString(3);
             cb1.setSelectedItem(str3.trim());
             cb1.setEnabled(false);
             cb2.setSelectedIndex(0);
             rs.close();
             invoiceFind(str1);

            }
            catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,"NOT EXIST");
             }
          }
        }
    }
      

  private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        
        new deleteParty_Invoice();                     
      }
    }

  private class updateListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
         new updateParty_Invoice();
       }
    }

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
          new searchParty_Invoice();
        }
     }

  private class billListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
//         new BillParty_Invoice();
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
       String s1,s2; 
        try
         {

          statement.executeUpdate("commit");
          rs=statement.executeQuery("select invno,TO_CHAR(invdate,'DD-MON-YYYY'),pcode,pdcode,qty,mrp,invamt from Party_Invoice order by invno");

          while(rs.next())
          {
            str1=rs.getString(1);
            str2=rs.getString(2);

            str3=rs.getString(3);
            str4=rs.getString(4);
      
            str5=rs.getString(5);
            str6=rs.getString(6);
            str7=rs.getString(7);
           
            
               col[k][0]=str1;
               col[k][1]=str2;
               col[k][2]=str3;
               col[k][3]=str4;
               col[k][4]=str5;
               col[k][5]=str6;
               col[k][6]=str7;
              
             
               k++;
               
           }
           
            col[k][0]=" ";
            col[k][1]=" ";
            col[k][2]=" ";
            col[k][3]=" ";
            col[k][4]=" ";
            col[k][5]=" ";
            col[k][6]=" ";
            


           JTable table=new JTable(col,fld);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setForeground(Color.black);
           table.setBackground(Color.magenta);

           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
          cn.add(jsp);
           jsp.setBounds(2,520,890,180);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }

  /*

  public static void main (String args[])
    {
        Party_Invoice pi = new Party_Invoice();

    }  */
} 


   
