package input;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;               
import javax.swing.JTable.*;
import java.text.*;


public class BillParty_Invoice extends JFrame 
{
    private JTextField t1,t2,t3,t4,t5;
    private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    private JPanel p1;
    JComboBox cb1;


    String s,s1,st,str,str1,str2,str3,str4,str5;
    Connection connection;
    Statement statement;
    private Icon icn;
    ResultSet rs;
    int c,k;           

     Cursor cr=new Cursor(Cursor.HAND_CURSOR);

     String[] fieldhead={"Invoice No","Party Code","DUES Amount"};
     Object cord[][]=new Object[10][3];
     JTable table=new JTable(cord,fieldhead);
                  

       public BillParty_Invoice()
        
        {
                              
             
              JFrame fr = new JFrame("Bill Payment");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/8,frsize.width/4,frsize.height/5);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              Container cn=fr.getContentPane();
               
                  cn.setLayout(null);
                  p1=new JPanel();
                  p1.setLayout(null);
                  p1.setBackground(new Color(224,232,255));
                  p1.setBounds(280,500,800,200);
                  cn.add(p1);

						
               l10 = new JLabel(" PAYMENT INFORMATION ");
               l10.setForeground(Color.red);
               l10.setFont(new Font("Algerian",Font.BOLD,40));
               l10.setBounds(300,20,700,80);                       
                                     
                l1=new JLabel("      INVOICE NO");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(300,150,180,30);

		cb1=new JComboBox();
                cb1.setFont(new Font("Serif",Font.BOLD,20));
                cb1.setBounds(500,150,200,30);

                l2=new JLabel("    Party CODE");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(300,200,200,30);

                t2=new JTextField(20);
                t2.setFont(new Font("Serif",Font.BOLD,20));
                t2.setBounds(500,200,200,30);
		t2.setEditable(false);

                l3=new JLabel("   BILL AMOUNT");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(300,250,200,30);

                t3= new JTextField(20);
                t3.setFont(new Font("Serif",Font.BOLD,20));
                t3.setBounds(500,250,200,30);
              	t3.setEditable(false);  


                l4=new JLabel("    PAID AMOUNT");
                l4.setFont(new Font("Serif",Font.BOLD,20));
                l4.setBounds(300,300,200,30);

                t4=new JTextField(20);
                t4.setFont(new Font("Serif",Font.BOLD,20));
                t4.setBounds(500,300,200,30);
//                t4.setEditable(false);
		t4.addActionListener(new enterListener());


                l5=new JLabel("   DUES AMOUNT");
                l5.setFont(new Font("Serif",Font.BOLD,20));
                l5.setBounds(300,350,200,30);

                t5=new JTextField(20);
                t5.setFont(new Font("Serif",Font.BOLD,20));
                t5.setBounds(500,350,200,30);
	        t5.setEditable(false);                

                
                b1=new JButton("BILL PAY");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(770,150,130,30);
                b1.setMnemonic('B');
                b1.addActionListener(new newListener());
               	
                b2=new JButton("DELETE ");
                b2.setFont(new Font("Serif",Font.BOLD,20));
                b2.setBounds(770,200,130,30);
                b2.setMnemonic('D');
                b2.addActionListener(new deleteListener());
                
                b3=new JButton("SAVE");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(770,250,130,30);
                b3.setMnemonic('S');
                b3.addActionListener(new saveListener());
                
                b4=new JButton("UPDATE");
                b4.setFont(new Font("Serif",Font.BOLD,20));
                b4.setBounds(770,300,130,30);
                b4.setMnemonic('U');
                b4.addActionListener(new updateListener());

                
                
               b9=new JButton("SEARCH");
               b9.setFont(new Font("Serif",Font.BOLD,20));
               b9.setMnemonic('R');
               b9.setBounds(770,350,130,30);
               b9.addActionListener(new searchListener());

                
               b10=new JButton("EXIT");
               b10.setFont(new Font("Serif",Font.BOLD,20));
               b10.setMnemonic('X');
               b10.setBounds(770,400,130,30);
               b10.addActionListener(new exitListener(fr));
                               
                b11=new JButton("LOAD");
                b11.setFont(new Font("Serif",Font.BOLD,20));
                b11.setBounds(800,450,130,30);
                b11.setToolTipText("Insert in Table");
                b11.setMnemonic('O');
                b11.addActionListener(new loadListener());
                b11.setCursor(cr);

                

                cn.add(l10);
                cn.add(l1);cn.add(cb1); 
                cn.add(l2);cn.add(t2);
                cn.add(l3);cn.add(t3);
                cn.add(l4);cn.add(t4);
                cn.add(l5);cn.add(t5);
                

                cn.add(b1);cn.add(b2);
                cn.add(b3);cn.add(b4);
                cn.add(b9);
                cn.add(b11);
                cn.add(b10);
                cn.setBackground(new Color(180,180,40));


                      JTable table=new JTable(cord,fieldhead);
                      table.setFont(new Font("Serif",Font.BOLD,14));
                      table.setForeground(Color.black);
                     // table.setBackground(new Color(200,160,160));


                      JScrollPane jsp=new JScrollPane(table);
                      jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                      p1.add(jsp);
                      jsp.setBounds(0,0,670,200);
                        
 



                fr.pack();
                fr.setSize(950,700);
   
                fr.setVisible(true);
                connect();
		 invoiceComboBox();

	
    }


 public void invoiceComboBox()
        {
          try
             {
               cb1.addItem("     -SELECT-");
               rs=statement.executeQuery("select invno from Party_Invoice group by invno order by invno");
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
                      st=String.valueOf(cb1.getSelectedItem()).trim();
			try
			{
                        rs=statement.executeQuery("select pcode from Party_Invoice where invno='"+st+"'");
                        rs.next();
                        s1=rs.getString(1);
                        t2.setText(s1);
                        t2.setEditable(false);
                        rs.close();
                        billAmountFind(st);
                        duesAmountFind(s1);
		                        
			}
                        catch(SQLException sqle)
			{
                                JOptionPane.showMessageDialog(null,"CUstomer CODE not FOUND"+sqle);
			}
                }

   }

   public void billAmountFind(String st)
      { 

	try

            {
             
           
             rs=statement.executeQuery("select invno,sum(invamt) from Party_Invoice group by invno having invno='"+st+"'");

             rs.next();

                 str=rs.getString(2);
                 t3.setText(str);
                 t3.setEditable(false);
		rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't FIND"+sqle);
        }

      }

   public void duesAmountFind(String s1)
      { 

	try

            {
             rs=statement.executeQuery("select duesamt from Party_Master where pcode='"+s1+"'");

             rs.next();

             s=rs.getString(1);
                 t5.setText(s);
		rs.close();
           }
        catch(SQLException sqle)
        {
         JOptionPane.showMessageDialog(null,"Can't Find DUES"+sqle);
        }

      }


 private class enterListener implements ActionListener
   {
     public void actionPerformed(ActionEvent e)
      {
	float billamt,pdamt,dsamt;

           if(e.getSource()==t4)
              {
		billamt=0;
                
                billamt=Float.parseFloat(t3.getText());
                pdamt=Float.parseFloat(t4.getText());
                dsamt=Float.parseFloat(t5.getText());
                dsamt=dsamt+billamt-pdamt;
		str5=String.valueOf(dsamt);
                t5.setText(str5);
                JOptionPane.showMessageDialog(null,"PAID");
	
              }
               else
                 JOptionPane.showMessageDialog(null,"Select a record and Enter Paid amount");
        }
    }

 
   private class saveListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
           
            try
              {
                   str1=(String)cb1.getSelectedItem();
                   str2=t2.getText();
                   str5=t5.getText();

                   statement.executeUpdate("update Party_Invoice set osamt='"+str5+"' where invno='"+str1+"'");
                   statement.executeUpdate("commit");
                   statement.executeUpdate("Update Party_Master set duesamt='"+str5+"' where pcode='"+str2+"'");
                   statement.executeUpdate("commit");
                   load();
                   JOptionPane.showMessageDialog(null,"INSERTED");
                  
           	}
        	catch(SQLException  sqle)
        	{
                 JOptionPane.showMessageDialog(null,"INSERTION FAIL"+sqle);
        	}

         }
        

     }
 
  private class newListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
           t2.setText(" ");
           t3.setText(" ");
           t4.setText(" ");
           t5.setText(" ");
           
        }
    }


  private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        try
           {
            str=JOptionPane.showInputDialog("Enter Invoice");
            statement.executeUpdate("delete osamt from Party_Invoice where invno='"+str+"'");
            statement.executeUpdate("Commit");
            load();
            JOptionPane.showMessageDialog(null,"Deleted");
           }
        catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Failure to Delete");
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
            str2=t2.getText();
            str3=t3.getText();
            str4=t4.getText();
            str5=t5.getText();
	        
            statement.executeUpdate("Update Party_Invoice set osamt='"+str5+"' where invno='"+str1+"'");
            statement.executeUpdate("commit");
            statement.executeUpdate("Update Party_Master set osamt='"+str5+"' where ccode='"+str2+"'");
            statement.executeUpdate("commit");
            load();
            JOptionPane.showMessageDialog(null,"UPDATED");

          }
        catch(SQLException  sqle)
          {
            System.out.println("CANNOT UPDATE"+sqle);
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
            rs=statement.executeQuery("select * from Bill_Payment");
            while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)
             {

                JOptionPane.showMessageDialog(null,"LAST RECORD");
                break;
             }
            }
            rs.next();
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
             String tmp=rs.getString(5);
                     st=rs.getString(1);
             cb1.setSelectedItem(st.trim());
             t5.setText(tmp);

        }
     
       catch(SQLException sqle)
       {
        JOptionPane.showMessageDialog(null,"CAN'T FIND NEXT RECORD");
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
           rs=statement.executeQuery("select * from Bill_Payment");
           c=0;
           while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)

             break;
             c++;
            }

           rs=statement.executeQuery("select * from Bill_Payment");
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
             String tmp=rs.getString(5);
                     st=rs.getString(1);
             cb1.setSelectedItem(st.trim());
             t5.setText(tmp);
         }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"CAN'T FIND");
          }

     }
  }



  private class firstListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
       {
        try
           {
            rs=statement.executeQuery("select * from Bill_Payment");
            rs.next();
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
             String tmp=rs.getString(5);
                    st=rs.getString(1);
             cb1.setSelectedItem(st.trim());
             t5.setText(tmp);

//           JOptionPane.showMessageDialog(null,"First Record");


           }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Cannot find 1st record ");
          }
            
       }

     }


  private class lastListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
        
         try
            {
             c=0;
             rs=statement.executeQuery("select * from Bill_Payment");
             while(rs.next())
             c=c+1;

             rs=statement.executeQuery("select * from Bill_Payment");
             while(c!=0)
              {
               rs.next();
               c=c-1;
              }
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));

             String tmp=rs.getString(5);
                     st=rs.getString(1);
             cb1.setSelectedItem(st.trim());
             t5.setText(tmp);
           JOptionPane.showMessageDialog(null,"LAST RECORD");
                           
                                                    
            }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null," CAN'T FIND LAST RECORD");

          }
                        
     }

   }

   

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             s1=JOptionPane.showInputDialog("Enter INVOICE");
             rs=statement.executeQuery("select * from Bill_Payment where invno='"+s1.trim()+"'");
             rs.next();
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));
             String tmp=rs.getString(5);
             st=rs.getString(1);
             cb1.setSelectedItem(st.trim());
             t5.setText(tmp);
             JOptionPane.showMessageDialog(null,"FOUND");
            }
            catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,"NOT EXIST");
             }
                             
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
       load();
      }
    }

    public void load()
      {
       int k=0;
        
        try
         {
          statement.executeUpdate("commit");
          rs=statement.executeQuery("select distinct(invno),pcode,osamt from Party_Invoice order by invno");
          while(rs.next())
           {
            str1=rs.getString(1);
            str2=rs.getString(2);
            str3=rs.getString(3);
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               k++;
           }
            cord[k][0]=" ";
            cord[k][1]=" ";
            cord[k][2]=" ";


           JTable table=new JTable(cord,fieldhead);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setForeground(Color.blue);
           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//           p3.add(jsp);
           jsp.setBounds(0,0,670,200);
           p1.add(jsp);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"ERROR TO LOAD");                      
         }
            
      }




/*

  public static void main (String args[])
    {
        BillParty_Invoice bpi=new BillParty_Invoice();

    }*/
} 


