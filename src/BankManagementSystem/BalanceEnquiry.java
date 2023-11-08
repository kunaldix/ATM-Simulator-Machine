package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class BalanceEnquiry extends JFrame implements ActionListener{

	String pinnumber;
	JButton back;
	
	BalanceEnquiry(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(355, 522, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
			String query = "SELECT * from bank where pin = '"+pinnumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current account balance is Rs "+balance);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(185, 300, 400, 20);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(true);
			new Transaction(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
	
}
