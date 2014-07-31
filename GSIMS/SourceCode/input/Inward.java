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



public class Inward extends JFrame
{
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JButton b1,b2,b3,b4,b5,b6,b7;
    String s,st,st1,st2,st3,str,str1,str2,str3,str4,str5,str6,str7,str8;
    JComboBox cb1,cb2;
    float invamt,up,qty,cramt;  

    Connection connection;
    Statement statement;
    private Icon icn;
    ResultSet rs,rs1;
    int c,k,f,r;

  Container cn=new Container();
  String[] fieldhead={"INWARD NO","DATE","GROUP CODE","PRODUCT CODE","QUANTITY"," MRP ","CURRENT AMOUNT"};
  Object cord[][]=new Object[30][7];
  JTable table=new JTable(cord,fieldhead);

       public Inward()
        
        {
                              
             
              JFrame fr = new JFrame("Inward Form");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/12,frsize.width/2,frsize.height/8);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              cn=fr.getContentPane();
               
                cn.setLayout(null);
                icn=new ImageIcon("5.jpg");
                l9=new JLabel(icn);
                l9.setBounds(0,0,375,600);
						
               l8 = new JLabel("Product Recieve ");
               l8.setForeground(Color.red);
               l8.setFont(new Font("Algerian",Font.BOLD,40));
               l8.setBounds(375,20,380,80);                       

                l1 = new JLabel(" Inward No");
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

                l2 = new JLabel("  Inward Date");
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
                

                l3 = new JLabel(" Product Code");
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
                
                l5= new JLabel( "Quantity");
                l5.setFont(new Font("Serif",Font.BOLD,20));
                l5.setBounds(380,310,150,30);

                t5 = new JTextField(20);
                t5.setFont(new Font("Serif",Font.BOLD,20));
                t5.setBounds(540,310,150,30);

                l6= new JLabel(" Unit Price");
                l6.setFont(new Font("Serif",Font.BOLD,20));
                l6.setBounds(380,350,150,30);

                t6= new JTextField(20);
                t6.setFont(new Font("Serif",Font.BOLD,20));
                t6.setBounds(540,350,150,30);


                l7= new JLabel("Amount");
                l7.setFont(new Font("Serif",Font.BOLD,20));
                l7.setBounds(380,390,150,30);

                t7= new JTextField(20);
                t7.setFont(new Font("Serif",Font.BOLD,20));
                t7.setBounds(540,390,150,30);
                t7.setEditable(false);

                l10= new JLabel("Inward Amount");
                l10.setFont(new Font("Serif",Font.BOLD,20));
                l10.setBounds(380,430,150,30);

                t8= new JTextField(20);
                t8.setFont(new Font("Serif",Font.BOLD,20));
                t8.setBounds(540,430,150,30);
//                t8.setEditable(false);
                
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


      
    JTable table=new JTable(cord,fieldhead);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setForeground(Color.black);
    table.setBackground(new Color(220,180,150));
   


    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    
    jsp.setBounds(2,520,890,400);
          

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
                cn.add(b5);
                cn.add(b6);
                cn.add(b7);
                cn.add(jsp);
                cn.setBackground(new Color(220,220,200));



                fr.pack();
                fr.setSize(900,720);
   
                fr.setVisible(true);
                 connect();
                 date_create();
//                 productCodeCombo();
                  groupCodeCombo();

	
    }


                      private void date_create()
                      {
                       java.util.Date dt=new java.util.Date();
                       DateFormat dft= DateFormat.getDateInstance(DateFormat.MEDIUM,java.util.Locale.UK);
                       t2.setText((String)dft.format(dt));
                
                      }


  public void groupCodeCombo()
        {
          try
             {
              
               rs=statement.executeQuery("select group_code from Gift_Group order by group_code");
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
               JOptionPane.showMessageDialog(null,"No Record In Primary Table");
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
                        rs=statement.executeQuery("select pdcode from product_details where group_code='"+String.valueOf(cb1.getSelectedItem()).trim()+"'");
                        while(rs.next())
			cb2.addItem(rs.getString(1));
			}
                        catch(SQLException sqle)
			{
                                JOptionPane.showMessageDialog(null,sqle,"Database Error on Fetchin",JOptionPane.ERROR_MESSAGE);
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


    public void amountFind(String str1)
      { 

	try

            {

           
             rs=statement.executeQuery("select inwno,sum(inwamt) from Inward group by inwno having inwno='"+str1+"'");

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
           rs=statement.executeQuery("select * from lInward");
           rs.next();

           String st=rs.getString(1);
           t1.setText(st);
           rs.close();
           date_create();
           t5.setText("");
           t6.setText("");
           t7.setText("");
           invamt=0;
           t8.setText(String.valueOf(invamt));
           cb1.setSelectedItem(0);

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

	tq=q+q1;		
	str=String.valueOf(tq);

        c=b+b*a/100;
        st1=String.valueOf(c);

        statement.executeUpdate("update Product_Details set qty='"+str+"',mrp='"+st1+"',uprice='"+str6+"' where pdcode='"+str4+"'");
	 statement.executeUpdate("commit");

	
          }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Qauntity does not update");
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
                  
             rs=statement.executeQuery("select pdcode from Inward where inwno='"+str1+"' and group_code='"+str3+"'");
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
                   
         

                   statement.executeUpdate("insert into Inward values('"+str1.trim()+"','"+str2.trim()+"','"+str3.trim()+"','"+str4.trim()+"','"+str5.trim()+"','"+str6.trim()+"','"+str7.trim()+"')");
                   statement.executeUpdate("commit");
                   JOptionPane.showMessageDialog(null,"INSERTED");
		
                      load();
                     updateProduct(str4,str5,str6);

                   r=JOptionPane.showConfirmDialog(null,"Add More Product","INFO",JOptionPane.INFORMATION_MESSAGE);
                   if(r==JOptionPane.YES_OPTION)
                     {
                      t1.setEditable(false);
                      cb1.setSelectedIndex(0);
                      t5.setText("");
                      t6.setText("");
                      t7.setText("");

                     }
             if(r==JOptionPane.NO_OPTION)
              {

		int a,b;

                       
                 str1=t1.getText();

                     rs=statement.executeQuery("select inwno from lInward");
                     rs.next();
                     st2=rs.getString(1);
             st=st2.substring(2);

             a=Integer.parseInt(st);

             str=str1.substring(2);
                     
             b=Integer.parseInt(str);
              
                   if(a==b)
                   {
                    
                  try

                     {
                       
                     rs=statement.executeQuery("select inwno from lInward");
                     rs.next();
                     str1=rs.getString(1);
        
                     rs=statement.executeQuery("select lpad(to_char(to_number(substr('"+str1+"',2))+1),4,'0') from dual");
                     rs.next();
                     str1="I"+rs.getString(1);
   
                     
                      statement.executeUpdate("Update lInward set inwno='"+str1+"'");
                       statement.executeUpdate("commit");

                     JOptionPane.showMessageDialog(null,"Cmt");

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
                     JOptionPane.showMessageDialog(null," not cancat");

                 }


       
            }
           }
        catch(SQLException  sqle)
        {
        JOptionPane.showMessageDialog(null,"CAN'T INSERT"+sqle);
        }

      }
       

   }
                                   

  private class newListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {

          k=JOptionPane.showConfirmDialog(null,"RECIEVE NEW PRODUCT  OR EDIT IN EXISTING","INFO",JOptionPane.INFORMATION_MESSAGE);
          if(k==JOptionPane.YES_OPTION)
          {
            clear();

          }
          else
          {
           try
            {
             str1=JOptionPane.showInputDialog("ENTER INWARD NO FOR EDIT");
             rs=statement.executeQuery("select * from Inward where inwno='"+str1+"'");
             rs.next();
             t1.setText(rs.getString(1));
            
                      t5.setText("");
                      t6.setText("");
                      t7.setText("");
             str3=rs.getString(3);
             cb1.setSelectedItem(str3.trim());
             cb2.setSelectedIndex(0);
             rs.close();
             amountFind(str1);

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
        
        //new deleteInwardForm();                     
      }
    }

  private class updateListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
         new updateInward();
       }
    }

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
          new searchInward();
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
          rs=statement.executeQuery("select inwno,TO_CHAR(inwdate,'DD-MON-YYYY'),group_code,pdcode,qty,mrp,inwamt from Inward order by inwno");

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
           table.setForeground(Color.black);
           table.setBackground(new Color(220,180,150));

           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
          cn.add(jsp);
           jsp.setBounds(2,520,890,400);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }

  
/*
  public static void main (String args[])
    {
        Inward in = new Inward();

    }  */
} 


   
