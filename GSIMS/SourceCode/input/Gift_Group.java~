package input;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Gift_Group extends JFrame
{
 private JPanel p1,p2,p3,p4,p5,p6;
 private JTextField t1,t2;
 private JLabel l1,l2,l3;

 private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

 private Container cn;
 String str,str1,str2,str3;

   Connection connection;

   Statement statement;
   Dimension screensize;
   ResultSet rs;
   int f,k,c;

     public Gift_Group()
     {
       super(" Gift_Group ");
       setSize(1000,700);
       getContentPane().setLayout(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       cn=getContentPane();
       cn.setLayout(new GridLayout(10,12));
       cn.setBackground(new Color(225,180,146));


       l1=new JLabel("  Group Code   ");
       l1.setFont(new Font("Serif",Font.BOLD,18));



       l2=new JLabel("  Group Name   ");
       l2.setFont(new Font("Serif",Font.BOLD,18));


       p1=new JPanel();
       p2=new JPanel();
       p3=new JPanel();
       p4=new JPanel();
       p5=new JPanel();
       p6=new JPanel();

       t1=new JTextField(15);
       t2=new JTextField(15);

       b1=new JButton("       New     ");
       b1.addActionListener(new newListener());
       b1.setToolTipText("Add new Record");
       b1.setMnemonic('N');
       b1.setBackground(Color.red);


       b2=new JButton("    DELETE   ");
       b2.addActionListener(new deleteListener());
       b2.setToolTipText("Delete a record");
       b2.setMnemonic('D');
       b2.setBackground(Color.red);


       b3=new JButton("      SAVE   ");
       b3.addActionListener(new saveListener());
       b3.setToolTipText("Save the Record");
       b3.setMnemonic('S');
       b3.setBackground(Color.red);



       b4=new JButton("   UPDATE  ");
       b4.addActionListener(new updateListener());
       b4.setToolTipText("Update the Record");
       b4.setMnemonic('U');
       b4.setBackground(Color.red);





       b5=new JButton("       NEXT    ");
       b5.addActionListener(new nextListener());
       b5.setToolTipText("next Record");
       b5.setMnemonic('N');
       b5.setBackground(Color.red);





       b6=new JButton(" PREVIOUS ");
       b6.addActionListener(new previousListener());
       b6.setToolTipText("previous Record");
       b6.setMnemonic('P');
       b6.setBackground(Color.red);


     

         
       b7=new JButton("     FIRST    ");
       b7.addActionListener(new firstListener());
       b7.setToolTipText("First Record");
       b7.setMnemonic('F');
       b7.setBackground(Color.red);


                        


       b8=new JButton("    LAST     ");
       b8.addActionListener(new lastListener());
       b8.setToolTipText("last Record");
       b8.setMnemonic('L');
       b8.setBackground(Color.red);






       b9=new JButton("    SEARCH    ");
       b9.addActionListener(new searchListener());
       b9.setToolTipText("Find the Record");
       b9.setMnemonic('F');
       b9.setBackground(Color.red);






       b10=new JButton("    EXIT      ");
       b10.addActionListener(new exitListener());
       b10.setToolTipText("Close");
       b10.setMnemonic('X');
       b10.setBackground(Color.red);



       p1.add(l1);p1.add(t1);
       
       p2.add(l2);p2.add(t2);

       p3.add(b1);p3.add(b2);p3.add(b3);
        
       p4.add(b4);p4.add(b5);p4.add(b6);

       p5.add(b7);p5.add(b8);p5.add(b9);

                  p6.add(b10);

       

       cn.add(p1);
       cn.add(p2);
       cn.add(p3);
       cn.add(p4);
       cn.add(p5);
       cn.add(p6);         
       
       pack();
       setVisible(true);
screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-900)/2,(screensize.height-700)/2,500,450);


       connect();



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
 


 private class newListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {

try
          {
                 
           
           rs=statement.executeQuery("select group_code from lGift_Group");
           rs.next();
           str=rs.getString(1);
           t1.setText(str);
           t1.setEditable(false);
            t2.setText("");
           
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
          str3=JOptionPane.showInputDialog("Enter group_code to be delete");
          statement.executeUpdate("delete from Gift_Group where group_code='"+str3+"'");
          statement.executeUpdate("commit");
          JOptionPane.showMessageDialog(null,"Deleted");

         }

       catch(SQLException sqle)
            {
             JOptionPane.showMessageDialog(null,"Falure to Delete");
            }
                             
      }
    }


 private class saveListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       try
          {
                          
                 str1=t1.getText();
                 str2=t2.getText();
                 statement.executeUpdate("insert into Gift_Group values('"+str1+"','"+str2+"')");
                 statement.executeUpdate("commit");                                          
                 JOptionPane.showMessageDialog(null,"Successfully insert");

                
          }
           catch(SQLException sqle)
                {
                 JOptionPane.showMessageDialog(null,"Insertion Falure");
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
           statement.executeUpdate("Update Gift_Group set group_name='"+str2+"' where group_code='"+str1+"'");
           statement.executeUpdate("commit");
           JOptionPane.showMessageDialog(null,"Updated");
          }
          catch(SQLException sqle)
          {


           JOptionPane.showMessageDialog(null,"Could not Update"+sqle);
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
           JOptionPane.showMessageDialog(null,"Click on Next button");
           else
           {
            rs=statement.executeQuery("select * from Gift_Group");
            while(rs.next())
            {
             str3=rs.getString(1);
             if(str.compareTo(str3)==0)
             break;
            }
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
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
           rs=statement.executeQuery("select * from Gift_Group");
           c=0;
           while(rs.next())
            {
             str3=rs.getString(1);
             if(str.compareTo(str3)==0)

             break;
             c++;
            }

           rs=statement.executeQuery("select * from Gift_Group");
           k=0;
           while(rs.next())
            {
             k++;
              if(k==c)
              break;
            }
           t1.setText(rs.getString(1));
           t2.setText(rs.getString(2));
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
            rs=statement.executeQuery("select * from Gift_Group");
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(2));
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
             rs=statement.executeQuery("select * from Gift_Group");
             while(rs.next())
             c=c+1;

             rs=statement.executeQuery("select * from Gift_Group");
             while(c!=0)
              {
               rs.next();
               c=c-1;
              }
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
                                  
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
             str3=JOptionPane.showInputDialog("Enter the Group_code to be search");
             rs=statement.executeQuery("select * from Gift_Group where group_code='"+str3+"'");
             rs.next();
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             JOptionPane.showMessageDialog(null,"Searched");
            }
            catch(SQLException sqle)
             {
              JOptionPane.showMessageDialog(null,"Not Exist");
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
     Gift_Group gf=new Gift_Group();

   } */



 
}
