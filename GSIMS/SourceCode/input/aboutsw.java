package input;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

  public class aboutsw extends JFrame
   {
        private JButton b1;
    	private JLabel l1,l2,l3,l4,l5;
    	Dimension screenSize;
   
     	public aboutsw() 
      	{
        b1=new JButton();
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        l5=new JLabel();
        
        getContentPane().setLayout(null);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
       
        getAccessibleContext().setAccessibleName("About");
        
        b1.setText("Close");
        getContentPane().add(b1);
        b1.setBounds(250, 180, 80, 25);
	b1.addActionListener(new closeListener());

        l1.setFont(new Font("Microsoft Sans Serif", 0, 20));
        l1.setForeground(new java.awt.Color(153,153,255));
        l1.setText("Plateform  : ");
        getContentPane().add(l1);
        l1.setBounds(50,70,120, 20);

        l2.setText("Gift Sales & Management System");
        l2.setFont(new Font("Century Schoolbook", 1, 16));
        l2.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(l2);
        l2.setBounds(34,10,410,30);

        l3.setForeground(new Color(0, 0, 153));
        l3.setText("Windows 98 / 2000 / XP / Vista / 7");
        getContentPane().add(l3);
        l3.setBounds(100,95,200,20);

        l4.setText("Powered by :");
        l4.setFont(new Font("Microsoft Sans Serif", 0, 18));
        l4.setForeground(new java.awt.Color(153, 153, 255));
        getContentPane().add(l4);
        l4.setBounds(50, 120, 130, 20);

        
        l5.setText("Amit Kumar Sah");
        l5.setFont(new Font("Microsoft Sans Serif", 0, 18));
        getContentPane().add(l5);
        l5.setBounds(100, 150, 190, 20);
        l5.setForeground(new Color(100,100, 51));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-220)/2,450, 240);

		setVisible(true);
	}

   	private class closeListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
	  	{
	    	dispose();	 
	  	}
    }
    
     public static void main (String args[])
   	{	
   		 aboutsw asw = new aboutsw();
  	}
   
}
