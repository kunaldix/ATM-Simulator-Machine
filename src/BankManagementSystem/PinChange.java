package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PinChange extends JFrame implements ActionListener{
	
	String pinnumber;
	JPasswordField pin, repin;
	JButton change, back;
	
	PinChange(String pinnumber) {
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(255, 290, 400, 20);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setBounds(165, 330, 180, 25);
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 16));
		pin.setBounds(330, 330, 180, 25);
		image.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setBounds(165, 365, 180, 25);
		repintext.setForeground(Color.WHITE);
		image.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 16));
		repin.setBounds(330, 365, 180, 25);
		image.add(repin);
		
		change = new JButton("Change");
		change.setBounds(355, 487, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(355, 522, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == change) {
			try {
				String spin = pin.getText();
				String srepin = repin.getText();
				if(!spin.equals(srepin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match!");
					return;
				}
				
				if(spin.equals("") || srepin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter new PIN");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "update bank set pin ='"+srepin+"' where pin = '"+pinnumber+"'";
				String query2 = "update login set pinnumber ='"+srepin+"' where pinnumber = '"+pinnumber+"'";
				String query3 = "update signupthree set pin_number ='"+srepin+"' where pin_number = '"+pinnumber+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully!");
				
				setVisible(false);
				new Transaction(srepin).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		new PinChange("");
	}
	
}
