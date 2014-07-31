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
public class Party_Master extends JFrame
{
  private JLabel ttl,lpc,l1,l2,l3,l4,l5,l6;
  private JTextField t1,t2,t3,t4,t5,t6;
  private JButton b1,b2,b3,b4,b5,b6,b7;
  private JPanel p1,p2,p3,p4;

  private Container cn;

  String str1,str2,str3,str4,str5,str6,str,st,s;
  int f,r;

  String[] fieldhead={"Party Code","Party Name","Organisation","Address","Contact","DUES Amount"};
  Object cord[][]=new Object[30][6];
  JTable table=new JTable(cord,fieldhead);

  Connection connection;
  Statement statement;
  Dimension screensize;
  ResultSet rs;

  Cursor cr=new Cursor(Cursor.HAND_CURSOR);
  public Party_Master()
  {
    super("PARTY MASTER");
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

    lpc=new JLabel();
    Icon img=new ImageIcon("4.jpg");
    lpc.setIcon(img);
    p2.add(lpc);
    p2.setBounds(0,0,300,800); 
    cn.add(p2); 

    ttl=new JLabel("SUPLIER INFORMATION");
    ttl.setFont(new Font("Algerian",Font.BOLD,32));
    ttl.setForeground(Color.RED);

    p1.add(ttl);
    p1.setBackground(new Color(31,88,161));
    p1.setBounds(300,10,500,40);

    p3.setLayout(null);
    p3.setBackground(new Color(224,232,255));
    p3.setBounds(300,50,500,750);
    cn.add(p3);



    l1=new JLabel("  Party Code");
    l1.setFont(new Font("Serif",1,18));
    l1.setBounds(20,10,150,30);
    p3.add(l1);

    t1=new JTextField(20);
    t1.setFont(new Font("Serif",1,18));
    t1.setBounds(180,10,150,30);
    t1.addActionListener(new enterListener());
    p3.add(t1);
    t1.setEditable(false);

    b1=new JButton("ADD");
    b1.setToolTipText("Add New Record");
    b1.setBounds(350,10,100,30);
    b1.setCursor(cr);
    b1.addActionListener(new newListener());
    b1.setMnemonic('A');
    p3.add(b1);


    l2=new JLabel("  Party Name");
    l2.setFont(new Font("Serif",1,18));
    l2.setBounds(20,60,150,30);
    p3.add(l2);


    t2=new JTextField(20);
    t2.setFont(new Font("Serif",1,18));
    t2.setBounds(180,60,150,30);
    t2.addActionListener(new enterListener());
    p3.add(t2);
    t1.setEditable(true);

    b2=new JButton("SAVE");
    b2.setToolTipText("Save Record");
    b2.setMnemonic('S');
    b2.addActionListener(new saveListener());
    b2.setCursor(cr);
    b2.setBounds(350,60,100,30);
    p3.add(b2);


    l3=new JLabel(" Oraganisation");
    l3.setFont(new Font("Serif",1,18));
    l3.setBounds(20,110,150,30);
    p3.add(l3);


    t3=new JTextField(30);
    t3.setFont(new Font("Serif",1,18));
    t3.setBounds(180,110,150,30);
    t3.addActionListener(new enterListener());
    p3.add(t3);


    b3=new JButton("DELETE");
    b3.setBounds(350,110,100,30);
    b3.setToolTipText("Delete Record");
    b3.setMnemonic('D');
    b3.addActionListener(new deleteListener());
    b3.setCursor(cr);
    p3.add(b3);



    l4=new JLabel("Address");
    l4.setFont(new Font("Serif",1,18));
    l4.setBounds(20,160,150,30);
    p3.add(l4);


    t4=new JTextField(50);
    t4.setFont(new Font("Serif",1,18));
    t4.setBounds(180,160,150,30);
    t4.addActionListener(new enterListener());
    p3.add(t4);


    b4=new JButton("UPDATE");
    b4.setBounds(350,160,100,30);
    b4.setToolTipText("Update Record");
    b4.setMnemonic('U');
    b4.addActionListener(new updateListener());
    b4.setCursor(cr);
    p3.add(b4);



    l5=new JLabel("  Contact");
    l5.setFont(new Font("Serif",1,18));
    l5.setBounds(20,210,150,30);
    p3.add(l5);


    t5=new JTextField(20);
    t5.setFont(new Font("Serif",1,18));
    t5.setBounds(180,210,150,30);
    t5.addActionListener(new enterListener());
    p3.add(t5);

    l6=new JLabel("Dues Amount");
    l6.setFont(new Font("Serif",1,18));
    l6.setBounds(20,260,150,30);
    p3.add(l6);


    t6=new JTextField(20);
    t6.setFont(new Font("Serif",1,18));
    t6.setBounds(180,260,150,30);
    t6.addActionListener(new enterListener());
    p3.add(t6);



    b5=new JButton("SEARCH");
    b5.setBounds(350,210,100,30);
    b5.setToolTipText("Search Record");
    b5.setMnemonic('R');
    b5.addActionListener(new searchListener());
    b5.setCursor(cr);
    p3.add(b5);


    b6=new JButton("LOAD");
    b6.setBounds(130,310,100,30);
    b6.setToolTipText("Insert in Table");
    b6.setMnemonic('L');
    b6.addActionListener(new loadListener());
    b6.setCursor(cr);
    p3.add(b6);


    b7=new JButton("EXIT");
    b7.setBounds(230,310,100,30);
    b7.setToolTipText("Exit");
    b7.setMnemonic('X');
    b7.addActionListener(new exitListener());
    b7.setCursor(cr);
    p3.add(b7);





    b1.setCursor(cr);

    l1.setBorder(edge);
    l2.setBorder(edge);
    
    l3.setBorder(edge);
    l4.setBorder(edge);
    l5.setBorder(edge);
    l6.setBorder(edge);
    
    t1.setBorder(edge1);
    t2.setBorder(edge1);
    t3.setBorder(edge1);
    t4.setBorder(edge1);
    t5.setBorder(edge1);
    t6.setBorder(edge1);

    JTable table=new JTable(cord,fieldhead);
    table.setFont(new Font("Serif",Font.BOLD,16));
    table.setForeground(Color.white);
    table.setBackground(new Color(200,160,160));

    JScrollPane jsp=new JScrollPane(table);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  //  jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    p3.add(jsp);
    jsp.setBounds(0,350,495,400);

    cn.add(p1);
    cn.add(p2);
    cn.add(p3);
 
    pack();
    setSize(900,1000);
    screensize=Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screensize.width-900)/2,(screensize.height-700)/2,800,700);

    setVisible(true);
    setResizable(false);

    connect();
  }


   protected void processWindowEvent(WindowEvent we)
   {
     if(we.getID() == we.WINDOW_CLOSING)
     {
       r=JOptionPane.showConfirmDialog(null,"WANT TO EXIT !","WARNING",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
         dispose();
      }
   }
        public void clear()
        {

          t2.setEditable(true);
          t3.setEditable(true);
          t4.setEditable(true);
          t5.setEditable(true);
          t6.setEditable(true);
          t1.setText("");
          t2.setText("");
          t3.setText("");
          t4.setText("");
          t5.setText("");
          t6.setText("");
        }

        private class enterListener implements ActionListener
        {
                public void actionPerformed(ActionEvent e)
                {
                  if(e.getSource()==t1)
                    t2.requestFocus();
                  if(e.getSource()==t2)
                    t3.requestFocus();
                  if(e.getSource()==t3)
                    t4.requestFocus();
                  if(e.getSource()==t4)
                    t5.requestFocus();
                  if(e.getSource()==t5)
                    t6.requestFocus();
                  if(e.getSource()==t6)
                    b1.requestFocus();
                }
         }


  private class newListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {

       try
          {
            clear();    
           
           rs=statement.executeQuery("select pcode from lParty_Master");
           rs.next();
           st=rs.getString(1);
           t1.setText(st);
           t1.setEditable(false);
          
          }
         catch(SQLException sqle)
         {
         JOptionPane.showMessageDialog(null,"Value does not exist");
         }
          
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
            JOptionPane.showMessageDialog(null,sqle,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("oracle.gif"));
           }
        }
     catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e,"DataBase Error",JOptionPane.ERROR_MESSAGE,new ImageIcon("pic001.jpg"));
       }
    }

   private class exitListener implements ActionListener
      {
       public void actionPerformed(ActionEvent e)
         {
          r=JOptionPane.showConfirmDialog(null,"WANT TO EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
          if(r==JOptionPane.YES_OPTION)
           dispose();
         }
      }

   private class saveListener implements ActionListener
     {
      public void actionPerformed(ActionEvent e)
        {
         try
            {
             
             str1=t1.getText();
             rs=statement.executeQuery("select * from Party_Master");
             f=0;
             while(rs.next())
              {
                st=rs.getString(2);
                 if(str1.compareTo(st)==0)
                    {
                      f=1;
                      break;
                    }
              }
             if(f==1)
             JOptionPane.showMessageDialog(null,"Record Exist","INFO:",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("BELLRING.gif"));
              else
              {
               str2=t2.getText();
               str3=t3.getText();
               str4=t4.getText();
               str5=t5.getText();
               str6=t6.getText();

            statement.executeUpdate("insert into Party_Master values('','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"')");
            statement.executeUpdate("commit");
            JOptionPane.showMessageDialog(null,"Record is Saved","INFO:",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("b1.gif"));
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
             str=JOptionPane.showInputDialog("Enter Product Code to Delete" );
             if(str.compareTo("")!=0)
                {
                  r=JOptionPane.showConfirmDialog(null,"Are you to Delete","INFORMATION",JOptionPane.WARNING_MESSAGE);
                  if(r==JOptionPane.YES_OPTION)
                     {
                      statement.executeUpdate("delete from Party_Master where pcode='"+str+"'");
                      statement.executeUpdate("commit");
                      load();
                      t1.setText("");
                      t2.setText("");
                      t3.setText("");
                      t4.setText("");
                      t5.setText("");
                      t6.setText("");
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
         str=JOptionPane.showInputDialog("Enter the Product Code to Search");
         rs=statement.executeQuery("select * from Party_Master where pcode='"+str+"'");     
         rs.next();
          
         t1.setText(rs.getString(1));
         t2.setText(rs.getString(2));
         t3.setText(rs.getString(3));
         t4.setText(rs.getString(4));
         t5.setText(rs.getString(5));
         t6.setText(rs.getString(6));

         JOptionPane.showMessageDialog(null,"FOUND","Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("search.gif"));
        }
          catch(SQLException sqle)
            {
             JOptionPane.showMessageDialog(null,"NOT FOUND","Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("BELLRING.gif"));
            }
         }
     }



  private class updateListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
       {
        try
          {
           if(t1.getText().compareTo("")==0)
         JOptionPane.showMessageDialog(null,"NO Entry","Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("BELLRING.gif"));
        else
         {
          str1=t1.getText();
          str2=t2.getText();
          str3=t3.getText();
          str4=t4.getText();
          str5=t5.getText();
          str6=t6.getText();

          statement.executeUpdate("update Party_Master set pcode='"+str1+"',pname='"+str2+"',organisation='"+str3+"',address='"+str4+"',contact='"+str5+"',duesamt='"+str6+"' where pcode='"+str1+"'");
          statement.executeUpdate("commit");
          JOptionPane.showMessageDialog(null,"Record is Updated","Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("SendChat.gif"));
          load();
         }
        } 

     catch(SQLException sqle)
       {
         JOptionPane.showMessageDialog(null,sqle,"Information",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("BELLRING.gif"));
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
          rs=statement.executeQuery("select * from Party_Master order by pcode");
          while(rs.next())
           {
            str1=rs.getString(1);
            str2=rs.getString(2);
            str3=rs.getString(3);
            str4=rs.getString(4);
            str5=rs.getString(5);
            str6=rs.getString(6);
            
               cord[k][0]=str1;
               cord[k][1]=str2;
               cord[k][2]=str3;
               cord[k][3]=str4;
               cord[k][4]=str5;
               cord[k][5]=str6;
             
               k++;
           }
            cord[k][0]=" ";
            cord[k][1]=" ";
            cord[k][2]=" ";
            cord[k][3]=" ";
            cord[k][4]=" ";
            cord[k][5]=" ";

           JTable table=new JTable(cord,fieldhead);
           table.setFont(new Font("Serif",Font.BOLD,16));
           table.setForeground(Color.blue);
           JScrollPane jsp=new JScrollPane(table);
           jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
           p3.add(jsp);
           jsp.setBounds(0,350,495,400);
           p3.add(jsp);
                
                 
       }
       catch(SQLException sqle)
         {
          JOptionPane.showMessageDialog(null,"Record not transfer");                      
         }
            
      }

/*

  public static void main(String args[])
  {
        Party_Master pm= new Party_Master();
  }*/
}


