package input;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 public class developer extends JFrame
 {
     private JButton b1;
     private JLabel l1;
     private JTextArea t1;
     Dimension screenSize;

     public developer()
 	{ 

	l1=new JLabel();
	l1.setFont(new Font("Copperplate Gothic Bold", 1, 34));
        l1.setText("Developer's Details");
        getContentPane().add(l1);
        l1.setBounds(10, 10, 510, 40);
		
	t1=new JTextArea();
        t1.setBackground(new Color(246, 156, 242));
        t1.setText("\n    Name\t:\t AMIT KUMAR SAH\n    Mobile No:\t 9504666460\t\n  Qualification \t      :\t BCA (IGNOU)\n   Address      :\t D-22,Birla Colony,\n :\t Phulwari Sharif \n :\t District Patna(BIHAR) \n :\tPin :Code-801505 \t \n  ");
        getContentPane().add(t1);
        t1.setBounds(40, 60, 350, 125);
	t1.setEditable(false);

        b1=new JButton();
        b1.setText("Close");
        getContentPane().add(b1);
        b1.setBounds(350, 185, 80, 23);
	b1.addActionListener(new closeListener());

		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(252,216,240));
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-438)/2, (screenSize.height-200)/3, 438, 210);
		setVisible(true);       
 	}

    private class closeListener implements ActionListener
  	{
		public void actionPerformed(ActionEvent e)
	  	{
	    	dispose();	 
	  	}
    }
/*    
    public static void main (String args[])
 	{
    	 developer dv=new developer();
  	}  */
 }
  