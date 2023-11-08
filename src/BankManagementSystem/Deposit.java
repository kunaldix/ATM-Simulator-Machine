package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

@SuppressWarnings("serial")
public class Deposit extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton deposit, back;
	String pinnumber;

	Deposit(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter Amount you want to Deposit");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(210, 300, 400, 20);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 16));
		amount.setBounds(203, 350, 275, 25);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355, 487, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355, 522, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == deposit) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount you want to Deposit");
			}
			else {
				try {
					Conn c = new Conn();
					String query = "INSERT INTO bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" deposited successfully!");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}
	
}
