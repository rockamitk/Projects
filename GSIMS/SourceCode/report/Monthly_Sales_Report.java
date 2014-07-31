package report;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Monthly_Sales_Report extends JFrame 
{
  private JPanel p1;
  private JButton b1,b2,b3;
  private JLabel tl;
  private Container cn;

  Dimension screensize;
  int r;

 public Monthly_Sales_Report()
 {
        setTitle("REPORT");


        p1=new JPanel();
      
       JFrame fr=new JFrame();      
       Toolkit tkt=fr.getToolkit();                  
       Dimension frsize=tkt.getScreenSize();
       setBounds(frsize.width/4,frsize.height/12,frsize.width/2,frsize.height/8);
       setLayout(null);

        cn=getContentPane();
        cn.setBackground(new Color(200,180,50));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tl=new JLabel("Monthly sales Report");
        tl.setFont(new Font("Engravers MT", 1, 25));
        tl.setForeground(new Color(247,251,249));
        p1.add(tl);

        p1.setBackground(new Color(31,88,166));
        cn.add(p1);
        p1.setBounds(0,0,500,50);



        b1=new JButton("INVOICE REPORT");
        b1.setMnemonic('I');
        b1.addActionListener(new invoiceListener());
        b1.setBounds(100,100,150,30);

        b2=new JButton("RETAIL REPORT");
        b2.setMnemonic('R');
        b2.addActionListener(new retailListener());
        b2.setBounds(250,100,150,30);

        b3=new JButton("EXIT");
        b3.setMnemonic('X');
        b3.addActionListener(new exitListener());
        b3.setBounds(200,200,100,30);


/*
    JLabel ln=new JLabel();
    ln.setForeground(new Color(3,91,14));
    ln.setText("====================================================================================================================================================================================================================================================================================================================================================================================================");
    cn.add(ln);
    ln.setBounds(0,485,850,16);

    JLabel bt1=new JLabel();
    bt1.setForeground(new Color(177,20,170));
    bt1.setText("DEVELOPED BY  :-");
    cn.add(bt1);
    bt1.setBounds(500,498,100,15);

    JLabel bt2=new JLabel();
    bt2.setForeground(new Color(149,21,21));
    bt2.setText("prem kumar");
    bt2.setBounds(615,498,300,15);
    cn.add(bt2);
  */

    cn.add(b1);cn.add(b2);
    cn.add(b3);



    screensize=Toolkit.getDefaultToolkit().getScreenSize();

	
      setSize(500,350);
      setVisible(true);
      setVisible(true);
      setResizable(true);


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

  
public class invoiceListener implements ActionListener
{
        public void actionPerformed(ActionEvent e)
        {
              new Invoice_Sales_Report();

         }    
 }

public class retailListener implements ActionListener
{
        public void actionPerformed(ActionEvent e)
        {
              new Retail_Sales_Report();

         }    
 }
 public class exitListener implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
     {
      r=JOptionPane.showConfirmDialog(null,"EXIT","WARNING",JOptionPane.WARNING_MESSAGE);
       if(r==JOptionPane.YES_OPTION)
       dispose();
     }

 }

/*
   public static void main(String args[])
     {
      Monthly_Sales_Report msr=new Monthly_Sales_Report();
     }*/
 
}
 


