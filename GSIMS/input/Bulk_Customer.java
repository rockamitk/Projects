package input;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Bulk_Customer extends JFrame
{
 private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
 private JTextField t1,t2,t3,t4,t5;
 private JLabel l1,l2,l3,l4,l5,l6,l7;
 private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

 private Container cn;
 String st,str,str1,str2,str3,str4,str5;

   Connection connection;

   Statement statement;
   ResultSet rs;
   Dimension screensize;
   int f,k,c;

     public Bulk_Customer()
     {
       super("Bulk Customer");
       setSize(800,700);
       getContentPane().setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       cn=getContentPane();
       cn.setLayout(new GridLayout(12,8));
       cn.setBackground(Color.gray);

              
       l6=new JLabel("DAILY CUSTOMER INFORMATION  \n ");
       l6.setFont(new Font("Algerian",Font.BOLD,40));
       l6.setForeground(Color.blue);
        


       l1=new JLabel("Customer Code");
       l1.setFont(new Font("Serif",Font.BOLD,20));
       l1.setForeground(Color.blue);


       l2=new JLabel("Customer Name");
       l2.setFont(new Font("Serif",Font.BOLD,20));
       l2.setForeground(Color.blue);


       l3=new JLabel("  Address            ");
       l3.setFont(new Font("Serif",Font.BOLD,20));
       l3.setForeground(Color.blue);

       l4=new JLabel("  Contact            ");
       l4.setFont(new Font("Serif",Font.BOLD,20));
       l4.setForeground(Color.blue);
       
       l7=new JLabel(" DUES Amount        ");
       l7.setFont(new Font("Serif",Font.BOLD,20));
       l7.setForeground(Color.blue);
       


       p1=new JPanel();
       p2=new JPanel();
       p3=new JPanel();
       p4=new JPanel();
       p5=new JPanel();
       p6=new JPanel();
       p7=new JPanel();
       p8=new JPanel();
       p9=new JPanel();
       p10=new JPanel();
       p1.setBackground(Color.pink);
       p2.setBackground(Color.pink);
       p3.setBackground(Color.pink);
       p4.setBackground(Color.pink);
       p5.setBackground(Color.pink);
       p6.setBackground(Color.pink);
       p7.setBackground(Color.pink);
       p9.setBackground(Color.red);
       p8.setBackground(Color.pink);
       p10.setBackground(Color.pink);


       t1=new JTextField(15);
       t2=new JTextField(15);
       t3=new JTextField(15);
       t4=new JTextField(15);
       t5=new JTextField(15);

       b1=new JButton("    ADD      ");
       b1.addActionListener(new newListener());
       b1.setToolTipText("Add new Record");
       b1.setMnemonic('A');
      // b1.setBackground(Color.red);
       b1.setForeground(Color.blue);


       b2=new JButton("   DELETE    ");
       b2.addActionListener(new deleteListener());
       b2.setToolTipText("Delete a record");
       b2.setMnemonic('D');
     //  b2.setBackground(Color.red);
       b2.setForeground(Color.blue);


       b3=new JButton("     SAVE     ");
       b3.addActionListener(new saveListener());
       b3.setToolTipText("Save the Record");
       b3.setMnemonic('S');
      // b3.setBackground(Color.white);
       b3.setForeground(Color.blue);



       b4=new JButton("   UPDATE   ");
       b4.addActionListener(new updateListener());
       b4.setToolTipText("Update the Record");
       b4.setMnemonic('U');
      // b4.setBackground(Color.red);
       b4.setForeground(Color.blue);





       b5=new JButton("    NEXT   ");
       b5.addActionListener(new nextListener());
       b5.setToolTipText("next Record");
       b5.setMnemonic('N');
      // b5.setBackground(Color.red);
       b5.setForeground(Color.blue);





       b6=new JButton(" PREVIOUS");
       b6.addActionListener(new previousListener());
       b6.setToolTipText("previous Record");
       b6.setMnemonic('P');
//       b6.setBackground(Color.red);
       b6.setForeground(Color.blue);


     

         
       b7=new JButton("     FIRST     ");
       b7.addActionListener(new firstListener());
       b7.setToolTipText("First Record");
       b7.setMnemonic('F');
  //     b7.setBackground(Color.red);
       b7.setForeground(Color.blue);


                        


       b8=new JButton("     LAST     ");
       b8.addActionListener(new lastListener());
       b8.setToolTipText("last Record");
       b8.setMnemonic('L');
      // b8.setBackground(Color.red);
       b8.setForeground(Color.blue);






       b9=new JButton("   SEARCH  ");
       b9.addActionListener(new searchListener());
       b9.setToolTipText("Find the Record");
       b9.setMnemonic('R');
       b9.setForeground(Color.blue);
      // b9.setBackground(Color.red);






       b10=new JButton("    EXIT     ");
       b10.addActionListener(new exitListener());
       b10.setToolTipText("Close");
       b10.setMnemonic('X');
      // b10.setBackground(Color.red);
       b10.setForeground(Color.blue);

      
                  p9.add(l6);

       p1.add(l1);p1.add(t1);
       p2.add(l2);p2.add(t2);
       p3.add(l3);p3.add(t3);
       p4.add(l4);p4.add(t4);
       p10.add(l7);p10.add(t5);
       
                         
       p5.add(b1);p5.add(b2);p5.add(b3);
        
       p6.add(b4);p6.add(b5);p6.add(b6);

       p7.add(b7);p7.add(b8);p7.add(b9);

                 p8.add(b10);

       cn.add(p9);
       cn.add(p1);
       cn.add(p2);
       cn.add(p3);
       cn.add(p4);
       cn.add(p10);
       cn.add(p5);
       cn.add(p6);         
       cn.add(p7);         
       cn.add(p8);         
       pack();
       setVisible(true);
      screensize=Toolkit.getDefaultToolkit().getScreenSize();
      setBounds((screensize.width-900)/2,(screensize.height-700)/2,800,700);


       connect();



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
               JOptionPane.showMessageDialog(null,"Exception"+sqle);
              }
        }
      catch(Exception e)
           {
            JOptionPane.showMessageDialog(null,"NOT CONNECTED");
           }
    }   


 private class newListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
     
           try
              {
              String s1="";
                rs=statement.executeQuery("select * from lBulk_Customer");
                rs.next();
              s1=rs.getString(1);
               t1.setText(s1);
               t1.setEditable(false);
               
               
               t2.setText("");
               t3.setText("");
               t4.setText("");
               t5.setText("");


 
          }
          catch(SQLException sqle)
           {
           JOptionPane.showMessageDialog(null,"Value does not exist"+sqle);
           }
                               
      }
    }


 private class deleteListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       try
         {
          st=JOptionPane.showInputDialog("Enter Customer Code to be Delete");
          statement.executeUpdate("delete from Bulk_Customer where ccode='"+st+"'");
          statement.executeUpdate("commit");
          JOptionPane.showMessageDialog(null,"DELETED");
          t1.setText("");
          t2.setText("");
          t3.setText("");
          t4.setText("");
          t5.setText("");

          t1.requestFocus();

         }

       catch(SQLException sqle)
            {
             JOptionPane.showMessageDialog(null,"Error:NOT DELETED");
            }
                             
      }
    }


 private class saveListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       try
          {
                 str2=t2.getText();
                 str3=t3.getText();
                 str4=t4.getText();
                 str5=t5.getText();

                 statement.executeUpdate("insert into Bulk_Customer(cname,address,contact) values('"+str2.trim()+"','"+str3.trim()+"','"+str4.trim()+"','"+str5.trim()+"')");
                 statement.executeUpdate("commit");                                          
                 JOptionPane.showMessageDialog(null,"INSERT");

               
          }
           catch(SQLException sqle)
                {
                 JOptionPane.showMessageDialog(null,"NOT INSERTED");
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
           str3=t3.getText();
           str4=t4.getText();
           str5=t5.getText();


           statement.executeUpdate("Update Bulk_Customer set cname='"+str2+"',address='"+str3+"',contact='"+str4+"',osamt='"+str5+"' where ccode='"+str1+"'");
           statement.executeUpdate("commit");
           JOptionPane.showMessageDialog(null,"UPDATED");
          }
          catch(SQLException sqle)
          {


           JOptionPane.showMessageDialog(null,"NOT UPDATED"+sqle);
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
           if(t1.getText().equals(""))
              JOptionPane.showMessageDialog(null,"Select a Record");
 

            else
           {
            rs=statement.executeQuery("select * from Bulk_Customer");
            while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)                     
             break;
            }
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
            t5.setText(rs.getString(5));


           }

          }
       catch(SQLException sqle)
       {
        JOptionPane.showMessageDialog(null,"Last Record");
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
           rs=statement.executeQuery("select * from Bulk_Customer");
           c=0;
           while(rs.next())
            {
             st=rs.getString(1);
             if(str.compareTo(st)==0)

             break;
             c++;
            }

           rs=statement.executeQuery("select * from Bulk_Customer");
           k=0;
           while(rs.next())
            {
             k++;
              if(k==c)
              break;
            }
           t1.setText(rs.getString(1));
           t2.setText(rs.getString(2));
           t3.setText(rs.getString(3));
           t4.setText(rs.getString(4));
           t5.setText(rs.getString(5));

         }

         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"First Record");
          }

     }
  }

  private class firstListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
       {
        try
           {
            rs=statement.executeQuery("select * from Bulk_Customer");
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
            t3.setText(rs.getString(3));
            t4.setText(rs.getString(4));
           t5.setText(rs.getString(5));


           }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Record Not Exist");
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
             rs=statement.executeQuery("select * from Bulk_Customer");
             while(rs.next())
             c=c+1;

             rs=statement.executeQuery("select * from Bulk_Customer");
             while(c!=0)
              {
               rs.next();
               c=c-1;
              }
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));
           t5.setText(rs.getString(5));
                                  
            }
         catch(SQLException sqle)
          {
           JOptionPane.showMessageDialog(null,"Record Not Exist");

          }
                        
     }

   }

  private class searchListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             st=JOptionPane.showInputDialog("Enter the Customer Code to be Search");
             rs=statement.executeQuery("select * from Bulk_Customer where ccode='"+st+"'");
             rs.next();
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));
             t5.setText(rs.getString(5));


             JOptionPane.showMessageDialog(null,"FOUND");
            }
            catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,"NOT FOUND");
             }
                             
        }
     }

   
  private class exitListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         dispose();
        }

     }

 /* public static void main(String args[])

   {
     Bulk_Customer bc=new Bulk_Customer();

   }
       */


 
}
