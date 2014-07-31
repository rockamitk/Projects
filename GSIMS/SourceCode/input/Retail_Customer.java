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



public class Retail_Customer extends JFrame
{
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    private JButton b1,b2,b3,b4,b5,b6,b7;
    String s,s1,s2,st1,st,str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
    JComboBox cb1,cb2,cb3;

    Connection connection;
    Statement statement;
    private Icon icn;
    ResultSet rs;
    int i,k,f,r,c;
    float tx,ds,qty,up,amt,transamt,cramt,billamt;
 
    String strtx[]={"-SELECT-","0","4","12"};
    String strds[]={"-SELECT-","0","5","10","15","20"};

  String[] fieldhead={"TRANSACTION NO","DATE","PRODUCT CODE","QUANTITY"," MRP ","TAX","DISCOUNT","CURRENT AMOUNT"};
  Object cord[][]=new Object[30][8];
  JTable table=new JTable(cord,fieldhead); 

         Container cn=new Container();
	       
       public Retail_Customer()
        
        {
                              
             
              JFrame fr = new JFrame("Retail_Customer");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/18,frsize.width/4,frsize.height/2);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              Container cn=fr.getContentPane();
               
                cn.setLayout(null);
                icn=new ImageIcon("m.jpg");
                l10=new JLabel(icn);
                l10.setBounds(0,0,300,470);

                l1 = new JLabel("  Transaction No");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(380,150,150,30);

                t1 = new JTextField(20);
                t1.setFont(new Font("Serif",Font.BOLD,20));
                t1.setBounds(540,150,150,30);

                l2=new JLabel("Transaction Date");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(380,190,150,30);

                t2=new JTextField(20);
                t2.setFont(new Font("Serif",Font.BOLD,20));
                t2.setBounds(540,190,150,30);


                l3 = new JLabel("Product Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(380,230,150,30);

                t3 = new JTextField(20);
                cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(540,230,150,30);


                l4 = new JLabel(" Quantity");
                l4.setFont(new Font("Serif",Font.BOLD,20));
                l4.setBounds(380,270,150,30);

                t4= new JTextField(20);
                t4.setFont(new Font("Serif",Font.BOLD,20));
                t4.setBounds(540,270,150,30);
                
                
                l5= new JLabel("  Unit Price  ");
                l5.setFont(new Font("Serif",Font.BOLD,20));
                l5.setBounds(380,310,150,30);

                t5 = new JTextField(20);
                t5.setFont(new Font("Serif",Font.BOLD,20));
                t5.setBounds(540,310,150,30);
                t5.setEditable(false);


                l6= new JLabel("   TAX   ");
                l6.setFont(new Font("Serif",Font.BOLD,20));
                l6.setBounds(380,350,150,30);

                cb2=new JComboBox(strtx);
                cb2.setFont(new Font("Serif",Font.BOLD,20));
                cb2.setBounds(540,350,150,30);

                l7= new JLabel(" Discount ");
                l7.setFont(new Font("Serif",Font.BOLD,20));
                l7.setBounds(380,390,150,30);

                cb3=new JComboBox(strds);
                cb3.setFont(new Font("Serif",Font.BOLD,20));
                cb3.setBounds(540,390,150,30);
                                
                l9= new JLabel("Current Amount>");
                l9.setFont(new Font("Serif",Font.BOLD,20));
                l9.setBounds(320,430,150,30);

                t8=new JTextField(20);
                t8.setFont(new Font("Serif",Font.BOLD,20));
                t8.setBounds(470,430,150,30);
                t8.setEditable(false);

                l11=new JLabel("<Total Amount ");
                l11.setFont(new Font("Serif",Font.BOLD,20));
                l11.setBounds(770,430,150,30);

                t9=new JTextField(20);
                t9.setFont(new Font("Serif",Font.BOLD,20));
                t9.setBounds(620,430,150,30);
                t9.setEditable(false);
		                 	

               l8 = new JLabel("   RETAILS CUSTOMER DETAILS ");
               l8.setForeground(Color.red);
               l8.setFont(new Font("Algerian",Font.BOLD,40));
               l8.setBounds(320,20,720,80);




                
                b1=new JButton(" NEW  ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(720,150,130,30);
                b1.setMnemonic('N');
                b1.addActionListener(new newListener());
               	
                b2=new JButton( "DELETE ");
                b2.setFont(new Font("Serif",Font.BOLD,20));
                b2.setBounds(720,190,130,30);
                b2.setMnemonic('D');
                b2.addActionListener(new deleteListener());
                
                b3=new JButton("SAVE");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(720,230,130,30);
                b3.setMnemonic('S');
                b3.addActionListener(new saveListener());
                
                b4=new JButton("UPDATE");
                b4.setFont(new Font("Serif",Font.BOLD,20));
                b4.setBounds(720,270,130,30);
                b4.setMnemonic('U');
                b4.addActionListener(new updateListener());
                
                
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
    table.setFont(new Font("Serif",Font.BOLD,14));
   // table.setForeground(Color.white);
    table.setBackground( new Color(150,180,120));
 
	

     JScrollPane jsp=new JScrollPane(table);
     jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    
         cn.add(jsp);       
      jsp.setBounds(2,480,940,190);

       
                

                cn.add(l1);cn.add(t1); 
                cn.add(l2);cn.add(t2);
                cn.add(l3);cn.add(cb1);
                cn.add(l4);cn.add(t4);
                cn.add(l5);cn.add(t5);
                cn.add(l6);cn.add(cb2);
                cn.add(l7);cn.add(cb3);
                cn.add(l9);cn.add(t8);
                cn.add(l11);cn.add(t9);
                cn.add(l8);
                cn.add(l10);


                cn.add(b1);cn.add(b2);
                cn.add(b3);cn.add(b4);
                cn.add(b5);
                cn.add(b6);
		cn.add(b7);
                cn.setBackground(new Color(180,180,120));



                fr.pack();
                fr.setSize(950,710);
               cb3.addActionListener(new cbListener());
   
                fr.setVisible(true);
                 connect();

                date_create();
                 productCodeCombo();
                 
	
    }


                      private void date_create()
                      {
                       java.util.Date dt=new java.util.Date();
                       DateFormat dft= DateFormat.getDateInstance(DateFormat.MEDIUM,java.util.Locale.UK);
                       t2.setText((String)dft.format(dt));
                
                      }




       

       public void productCodeCombo()
        {
	  try
	     { 
		rs=statement.executeQuery("select pdcode from Product_Details");
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

                 JOptionPane.showMessageDialog(null,"No Records");
             }

         }

      private class cbListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          if(e.getSource()==cb1)
          {
             String st;
             st=String.valueOf(cb1.getSelectedItem()).trim();
             try
               {
               rs=statement.executeQuery("select mrp from product_details where pdcode='"+st+"'");
               rs.next();
               t5.setText(rs.getString(1));
               t5.setEditable(false);
               }
               catch(SQLException sqle)
               {
                  JOptionPane.showMessageDialog(null,sqle);

               }
          }
               if(e.getSource()==cb3)
               {
               int qn,tx,dis;
               float up;
               qn=Integer.parseInt(t4.getText());
               up=Float.parseFloat(t5.getText());
               transamt=Float.parseFloat(t9.getText());

               tx=Integer.parseInt(String.valueOf(cb2.getSelectedItem()).trim());
               dis=Integer.parseInt(String.valueOf(cb3.getSelectedItem()).trim());

               amountCal(qn,dis,tx,up,transamt);
               }

        }


     }




      public void amountCal(int q,int d,int t,float u,float transamt)
       {
                   float namt;
                   namt=transamt;
                   qty=q;
                   up=u;
                   tx=t;
                   ds=d;
                   cramt=(up*qty);
                   tx=cramt*tx/100;
                   ds=cramt*ds/100;
                   cramt=cramt+tx-ds;
                  
                   namt=namt+cramt;
                   t8.setText(String.valueOf(cramt));
                   t9.setText(String.valueOf(namt));
                   str8=t8.getText();               
                   str9=t9.getText();               
                  
           
       }


    public void transAmount(String str1)
      { 

	try

            {

           
             rs=statement.executeQuery("select transno,sum(billamt) from  Retail_Customer group by transno having transno='"+str1.trim()+"'");

             rs.next();
             str=rs.getString(2);
                 t9.setText(str);
                 rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Error in Total Amount"+sqle);
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
                  
             rs=statement.executeQuery("select pdcode from Retail_Customer where transno='"+str1+"'");
              while(rs.next())
               {
        
                   str=rs.getString(1);

                   if(str3.compareTo(str)==0)
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
                   str4=t4.getText();
                   str5=t5.getText();
		   str9=t9.getText();
                   str3=(String)cb1.getSelectedItem();
                   str6=(String)cb2.getSelectedItem();
                   str7=(String)cb3.getSelectedItem();
		
                          

                   statement.executeUpdate("insert into Retail_Customer values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"')");
                   statement.executeUpdate("commit");
                    JOptionPane.showMessageDialog(null,"INSERTED");
                    backup();
                    load(0);

                   r=JOptionPane.showConfirmDialog(null,"Add More Product","INFO",JOptionPane.INFORMATION_MESSAGE);
                   if(r==JOptionPane.YES_OPTION)
                     {
                      t1.setEditable(false);
                      cb1.setSelectedIndex(0);
                      t4.setText("");
                      t5.setText("");
                      cb2.setSelectedIndex(0);
                      t8.setText("");

                     }

           if(r==JOptionPane.NO_OPTION)
                {

   
                int a,b; 
                   
               rs=statement.executeQuery("select transno from lRetail_Customer");
               rs.next();        
               st1=rs.getString(1);
               s=st1.substring(1);
               a=Integer.parseInt(s);

               str1=t1.getText();
               str=str1.substring(1);
               b=Integer.parseInt(str);
                  
              
               if(a==b)
                {
                  try

                     {
                     rs=statement.executeQuery("select lpad(to_char(to_number(substr('"+str1+"',2))+1),4,'0') from dual");
                     rs.next();
                     str1="R"+rs.getString(1);
                     
                      statement.executeUpdate("update lRetail_Customer set transno='"+str1+"'");
                      clear();
                      t1.setEditable(true);

                     
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
         JOptionPane.showMessageDialog(null,"COULD NOT INSERT"+sqle);
      	}

     }
        

  }

      public void clear()
         {
           try
            {

            rs=statement.executeQuery("select * from  lRetail_Customer");
             rs.next();

           String st=rs.getString(1);
           t1.setText(st);
           rs.close();
           date_create();
          

           t4.setText(" ");
           t5.setText(" ");
           cb1.setSelectedIndex(0);
           cb2.setSelectedItem(0);
           cramt=0;
           t8.setText(String.valueOf(cramt));
           transamt=0;
           t9.setText(String.valueOf(transamt));
          
           }
          catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Error to load Primary Value"+sqle);
          }
       
       }

  private class newListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {

          k=JOptionPane.showConfirmDialog(null,"OK=NEW Transaction OR NO= add  in EXISTING","INFO",JOptionPane.INFORMATION_MESSAGE);
          if(k==JOptionPane.YES_OPTION)
          {
            clear();

          }
          else
          {
           try
            {
             str1=JOptionPane.showInputDialog("ENTER Trans NO FOR EDIT");
             rs=statement.executeQuery("select transno from Retail_Customer where transno='"+str1+"'");
             rs.next();
             t1.setText(rs.getString(1));
            
                      t4.setText("");
                      t5.setText("");
                      t8.setText("");
             
             cb1.setSelectedIndex(0);
             
             cb2.setSelectedIndex(0);
             
             transAmount(str1);

            }       
       
         catch(SQLException sqle)
         {
         JOptionPane.showMessageDialog(null,"Transno does not exist");
         }

      }
     }	
  }



 public void backup()
     {
      try
        {
          s=str2.substring(3,6);
          st=str2.substring(9,11);
          statement.executeUpdate("insert into bRetail_Customer values('"+str1+"','"+str3+"','"+str4+"','"+s+"','"+st+"')");
          statement.executeUpdate("commit");
          JOptionPane.showMessageDialog(null,"BACKUP updated");
        }
        catch(SQLException sqle)
        {
        JOptionPane.showMessageDialog(null,"NOT update bck"+sqle);
        }
     }






                
  private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        
        new deleteRetail_Customer();                     
      }
    }

  private class updateListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
	new updateRetail_Customer();        

       }
  }

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
             st=JOptionPane.showInputDialog("Enter the Transaction No to be Search");
            load(1);
	     transAmount(st);

             JOptionPane.showMessageDialog(null,"FOUND");
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

             statement=connection.createStatement();//ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
       load(0);
      }
    }

    public void load(int i)
      {
       String s1,s2;
        int k=0;

        try
         {

	if(i==0)
	{

          statement.executeUpdate("commit");
          rs=statement.executeQuery("select transno,TO_CHAR(transdate,'DD-MON-YYYY'),pdcode,qty,mrp,tax,dis,billamt from Retail_Customer order by transno");

	}

      else
	{

          statement.executeUpdate("commit");
          rs=statement.executeQuery("select transno,TO_CHAR(transdate,'DD-MON-YYYY'),pdcode,qty,mrp,tax,dis,billamt from Retail_Customer where transno='"+st+"'");
        for(c=0;c<=r;c++)
	{
            cord[c][0]=" ";
            cord[c][1]=" ";
            cord[c][2]=" ";
            cord[c][3]=" ";
            cord[c][4]=" ";
            cord[c][5]=" ";
            cord[c][6]=" ";
            cord[c][7]=" ";
	}


	}
          r=0;
          while(rs.next())
          {
            
            str1=rs.getString(1);
            str2=rs.getString(2);

            str3=rs.getString(3);
            str4=rs.getString(4);
      
            str5=rs.getString(5);
            str6=rs.getString(6);
            str7=rs.getString(7);
            str8=rs.getString(8);
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               cord[k][3]=str4;
               cord[k][4]=str5;
               cord[k][5]=str6;
               cord[k][6]=str7;
               cord[k][7]=str8;
              
             
               k++;
               r++;
           }

           JTable table=new JTable(cord,fieldhead);
           table.setFont(new Font("Serif",Font.BOLD,16));
          // table.setForeground(Color.white);
          table.setBackground(new Color(150,180,100));

            JScrollPane jsp=new JScrollPane(table);
           jsp.setBounds(2,482,940,192);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //   jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            
           cn.add(jsp);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }


/*
  public static void main (String args[])
    {
        Retail_Customer rc = new Retail_Customer();

    }*/
} 


   
