package input;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;      
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;         

public class Product_Details extends JFrame
{
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    String st,str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
    JComboBox cb,cbtx;
	JPanel p1;
    Connection connection;
    Statement statement;
    private Icon icn;
    ResultSet rs;
    String[] strcb={"30","50","60","70","80","100"};
    int c,k;
    float pt,up,mrp;




       public Product_Details()
        {
                              
             
               JFrame fr = new JFrame("Product_Details");
               Toolkit tkt = fr.getToolkit();
               Dimension frsize = tkt.getScreenSize(); 
                          
              fr.setBounds(frsize.width/8,frsize.height/8,frsize.width/4,frsize.height/2);
              fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              Container cn=fr.getContentPane();
               
                cn.setLayout(null);
                icn=new ImageIcon("1.jpg");
                l=new JLabel(icn);
                l.setBounds(0,0,275,400);
		p1=new JPanel();
		// p1.setLayout(null);
		p1.setBounds(0,175,275,400);
		p1.add(l);
		cn.add(p1);
						
               l10 = new JLabel("PRODUCT DETAILS INFORMATION ");
               l10.setForeground(Color.red);
               l10.setFont(new Font("Algerian",Font.BOLD,40));
               l10.setBounds(250,20,700,80);                       

                l1 = new JLabel("Product Code");
                l1.setFont(new Font("Serif",Font.BOLD,20));
                l1.setBounds(300,150,180,30);

                t1 = new JTextField(20);
                t1.setFont(new Font("Serif",Font.BOLD,20));
                t1.setBounds(500,150,200,30);

                l2 = new JLabel("Product Name");
                l2.setFont(new Font("Serif",Font.BOLD,20));
                l2.setBounds(300,200,200,30);

                t2 = new JTextField(20);
                t2.setFont(new Font("Serif",Font.BOLD,20));
                t2.setBounds(500,200,200,30);


                l3 = new JLabel("Group Code");
                l3.setFont(new Font("Serif",Font.BOLD,20));
                l3.setBounds(300,250,200,30);

                 cb=new JComboBox();
                 cb.setFont(new Font("Serif",Font.BOLD,20));
                 cb.setBounds(500,250,200,30);


                l4 = new JLabel("Manufature Date");
                l4.setFont(new Font("Serif",Font.BOLD,20));
                l4.setBounds(300,300,200,30);

                t4= new JTextField(20);
                t4.setFont(new Font("Serif",Font.BOLD,20));
                t4.setBounds(500,300,200,30);
                
                
                l5= new JLabel( "Expiries ");
                l5.setFont(new Font("Serif",Font.BOLD,20));
                l5.setBounds(300,350,200,30);

                t5 = new JTextField(20);
                t5.setFont(new Font("Serif",Font.BOLD,20));
                t5.setBounds(500,350,200,30);


                l6= new JLabel( "Unit Price ");
                l6.setFont(new Font("Serif",Font.BOLD,20));
                l6.setBounds(300,400,200,30);

                t6= new JTextField(20);
                t6.setFont(new Font("Serif",Font.BOLD,20));
                t6.setBounds(500,400,200,30);

                l7= new JLabel( "MRP ");
                l7.setFont(new Font("Serif",Font.BOLD,20));
                l7.setBounds(300,450,200,30);

                t7= new JTextField(20);
                t7.setFont(new Font("Serif",Font.BOLD,20));
                t7.setBounds(500,450,200,30);
                t7.setEditable(false);


			  

                l8= new JLabel( "Price Tag ");
                l8.setFont(new Font("Serif",Font.BOLD,20));
                l8.setBounds(300,500,200,30);


                cbtx=new JComboBox(strcb);
                cbtx.setFont(new Font("Serif",Font.BOLD,20));
                cbtx.setBounds(500,500,200,30);


                l9= new JLabel( "QUANTITY ");
                l9.setFont(new Font("Serif",Font.BOLD,20));
                l9.setBounds(300,550,200,30);

                t9= new JTextField(20);
                t9.setFont(new Font("Serif",Font.BOLD,20));
                t9.setBounds(500,550,200,30);

                
                b1=new JButton(" NEW  ");
                b1.setFont(new Font("Serif",Font.BOLD,20));
                b1.setBounds(200,600,130,30);
                b1.setMnemonic('N');
                b1.addActionListener(new newListener());
               	
                b2=new JButton( "DELETE ");
                b2.setFont(new Font("Serif",Font.BOLD,20));
                b2.setBounds(330,600,130,30);
                b2.setMnemonic('D');
                b2.addActionListener(new deleteListener());
                
                b3=new JButton("SAVE");
                b3.setFont(new Font("Serif",Font.BOLD,20));
                b3.setBounds(460,600,130,30);
                b3.setMnemonic('S');
                b3.addActionListener(new saveListener());
                
                b4=new JButton("UPDATE");
                b4.setFont(new Font("Serif",Font.BOLD,20));
                b4.setBounds(590,600,130,30);
                b4.setMnemonic('U');
                b4.addActionListener(new updateListener());
                
               b5=new JButton("NEXT");
               b5.setFont(new Font("Serif",Font.BOLD,20));
               b5.setBounds(720,600,130,30);
               b5.setMnemonic('N');
               b5.addActionListener(new nextListener());
                
               b6=new JButton("PREVIOUS ");
               b6.setFont(new Font("Serif",Font.BOLD,20));
               b6.setBounds(200,650,135,30);
               b6.setMnemonic('P');
               b6.addActionListener(new previousListener());
                
               b7=new JButton("FIRST");
               b7.setFont(new Font("Serif",Font.BOLD,20));
               b7.setBounds(330,650,130,30);
               b7.setMnemonic('F');
               b7.addActionListener(new firstListener());

                
               b8=new JButton("LAST");
               b8.setFont(new Font("Serif",Font.BOLD,20));
               b8.setBounds(460,650,130,30);
               b8.setMnemonic('L');
               b8.addActionListener(new lastListener());
                

                
               b9=new JButton("SEARCH");
               b9.setFont(new Font("Serif",Font.BOLD,20));
               b9.setMnemonic('F');
               b9.setBounds(590,650,130,30);
               b9.addActionListener(new searchListener());

                
               b10=new JButton("EXIT");
               b10.setFont(new Font("Serif",Font.BOLD,20));
               b10.setMnemonic('X');
               b10.setBounds(720,650,130,30);
               b10.addActionListener(new exitListener(fr));
                

                cn.add(l10);
                cn.add(l1);cn.add(t1); 
                cn.add(l2);cn.add(t2);
                cn.add(l3);cn.add(cb);  
                cn.add(l4);cn.add(t4);
                cn.add(l5);cn.add(t5);
                cn.add(l6);cn.add(t6);
                cn.add(l7);cn.add(t7);
                cn.add(l8);cn.add(cbtx);
               
                cn.add(l9);cn.add(t9);


                cn.add(b1);cn.add(b2);
                cn.add(b3);cn.add(b4);
                cn.add(b5);
                cn.add(b6);
                cn.add(b7);
                cn.add(b8);
                cn.add(b9);
                cn.add(b10);
                cn.setBackground(new Color(220,220,180));
                



                fr.pack();
                fr.setSize(950,750);
   
                fr.setVisible(true);
                connect();


                addComboItem();
	
    }





        public void addComboItem()
        {
          try
             {
              
               rs=statement.executeQuery("select group_code from Gift_Group order by group_code");
               while(rs.next())
               {
                 cb.addItem((String)rs.getString(1));
               }
               rs.close();
               cb.setSelectedIndex(0);
             }
             catch(SQLException sqle)
              {
               JOptionPane.showMessageDialog(null,"No Record In Primary Table");
              }

        }



      public void taxCal()
       {

                   pt=Float.parseFloat(str8);
                   up=Float.parseFloat(str6);
                   pt=up*pt/100;
                   mrp=up+pt;
                   t7.setText(String.valueOf(mrp));
                   str7=t7.getText();               
                  
           
       }
     public void clear()
     {
          
           t2.setText(" ");
           t4.setText(" ");
           t5.setText(" ");
           t6.setText(" ");
           t7.setText(" ");
           t9.setText(" ");
         
           t2.requestFocus();
           cbtx.setSelectedIndex(0);
           cb.setSelectedIndex(0);
        
     }
 
   private class saveListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
           
            try
              {
                  str1=t1.getText();
                   str2=t2.getText();
                   str3=(String)cb.getSelectedItem();
                   str4=t4.getText();
                   str5=t5.getText();
                   str6=t6.getText();
                   str8=(String)cbtx.getSelectedItem();
                   str9=t9.getText();
                   taxCal();

                   statement.executeUpdate("insert into Product_Details(pdcode,pdname,group_code,mfd,doe,uprice,mrp,pctag,qty) values('"+str1.trim()+"','"+str2.trim()+"','"+str3.trim()+"','"+str4.trim()+"','"+str5.trim()+"','"+str6.trim()+"','"+str7.trim()+"','"+str8.trim()+"','"+str9.trim()+"')");
                   statement.executeUpdate("commit");

                   JOptionPane.showMessageDialog(null,"Inserted");
                  
           	}
        	catch(SQLException  sqle)
        	{
                 JOptionPane.showMessageDialog(null,"could not Inserted"+sqle);
        	}

         }
        

     }
 
  private class newListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
             {
           
           rs=statement.executeQuery("select pdcode from lProduct_Details");
           rs.next();
           st=rs.getString(1);
           t1.setText(st);
           t1.setEditable(false);
                  clear();
           
          }
         catch(SQLException sqle)
         {
         JOptionPane.showMessageDialog(null,"Value does not exist");
         }
           
        }
    }


  private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        try
           {
            str=JOptionPane.showInputDialog("Enter Product_Code to be delete");

             rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty  from Product_Details where pdcode='"+str+"'");
             rs.next();
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             cb.setSelectedItem(rs.getString(3));
             t4.setText(rs.getString(4));
             t5.setText(rs.getString(5));
             t6.setText(rs.getString(6));
             t7.setText(rs.getString(7));
             cbtx.setSelectedItem(rs.getString(8));
             t9.setText(rs.getString(9));


            statement.executeUpdate("delete from Product_Details where pdcode='"+str+"'");                         
            statement.executeUpdate("Commit");
            JOptionPane.showMessageDialog(null,"Deleted");
            clear();
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
            str1=t1.getText();
            str2=t2.getText();
            str3=(String)cb.getSelectedItem();
            str4=t4.getText();
            str5=t5.getText();
            str6=t6.getText();
            str8=(String)cbtx.getSelectedItem();

            str9=t9.getText();
            taxCal();    
            statement.executeUpdate("Update Product_Details set pdname='"+str2+"',group_code='"+str3+"',mfd='"+str4+"',doe='"+str5+"',uprice='"+str6+"',mrp='"+str7+"',pctag='"+str8+"',qty='"+str9+"' where pdcode='"+str1+"'");
            statement.executeUpdate("commit");
            JOptionPane.showMessageDialog(null,"updated");

          }
        catch(SQLException  sqle)
          {
            System.out.println("Could not update"+sqle);
          }

     }
   }

 private class nextListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       
       try
          {
           str=t1.getText();
           if(str.equals(""))
             JOptionPane.showMessageDialog(null,"No Record Select");
           else
           {
              rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty from Product_Details");
            while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)
             break;
            }
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t4.setText(rs.getString(4));
            t5.setText(rs.getString(5));
            t6.setText(rs.getString(6));
            t7.setText(rs.getString(7));
            t9.setText(rs.getString(9));

            cb.setSelectedItem(rs.getString(3));
             
           String tmp=rs.getString(8);
            cbtx.setSelectedItem(tmp.substring(0,2));


           }
          }
       catch(SQLException sqle)
       {
        JOptionPane.showMessageDialog(null,"This is last record");
       }
      }
   }


 public class previousListener implements ActionListener
   {
    public void actionPerformed(ActionEvent e)
      {
       str=t1.getText();
       try
          {
           rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty from Product_Details");
           c=0;
           while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)

             break;
             c++;
            }

           rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,tax,qty from Product_Details");
           k=0;
           while(rs.next())
            {
             k++;
              if(k==c)
              break;
            }
           t1.setText(rs.getString(1));
           t2.setText(rs.getString(2));
           cb.setSelectedItem(rs.getString(3));
           t4.setText(rs.getString(4));
           t5.setText(rs.getString(5));
           t6.setText(rs.getString(6));
           t7.setText(rs.getString(7));
            String stx=rs.getString(8);

           cbtx.setSelectedItem(stx.substring(0,2));
           t9.setText(rs.getString(9));


         }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"This is First Record");
          }

     }
  }


  private class firstListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
       {
        try
           {
            rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty from Product_Details");
            rs.next();

            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));

            t4.setText(rs.getString(4));
            t5.setText(rs.getString(5));
            t6.setText(rs.getString(6));
            t7.setText(rs.getString(7));
            t9.setText(rs.getString(9));


            cb.setSelectedItem(rs.getString(3));
             String tmp=rs.getString(8);
            cbtx.setSelectedItem(tmp.substring(0,2));

           }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"First Record");
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
             rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty from Product_Details");
             while(rs.next())
             c=c+1;

             rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty from Product_Details");
             while(c!=0)
              {
               rs.next();
               c=c-1;
              }
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             cb.setSelectedItem(rs.getString(3));
             t4.setText(rs.getString(4));
             t5.setText(rs.getString(5));
             t6.setText(rs.getString(6));
             t7.setText(rs.getString(7));
             String tmp=rs.getString(8);
             cbtx.setSelectedItem(tmp.substring(0,2));

             t9.setText(rs.getString(9));
            


                                  
        }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null," Last Record");

          }
                        
     }

   }

 

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             st=JOptionPane.showInputDialog("Enter the Product Code to be search");
             rs=statement.executeQuery("select pdcode,pdname,group_code,TO_CHAR(mfd,'DD-MON-YYYY'),TO_CHAR(doe,'DD-MON-YYYY'),uprice,mrp,pctag,qty  from Product_Details where pdcode='"+st+"'");
             rs.next();
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             cb.setSelectedItem(rs.getString(3));
             t4.setText(rs.getString(4));
             t5.setText(rs.getString(5));
             t6.setText(rs.getString(6));
             t7.setText(rs.getString(7));
               String tmp=rs.getString(8);
             t9.setText(rs.getString(9));
             cbtx.setSelectedItem(tmp.substring(0,2));
             JOptionPane.showMessageDialog(null,"Searched");
            }
            catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,"Not Exist");
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


 

  public static void main (String args[])
    {
        Product_Details pd = new Product_Details();

    }
} 



