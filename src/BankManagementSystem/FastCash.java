package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

@SuppressWarnings("serial")
public class FastCash extends JFrame implements ActionListener{
	
	JButton onehundred, fivehundred, onethousand, twothousand, fivethousand, tenthousand, back;
	String pinnumber;

	FastCash(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Select Withdrawl Amount");
		text.setBounds(225, 300, 700, 35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		onehundred = new JButton("Rs 100");
		onehundred.setBounds(170, 418, 150, 30);
		onehundred.addActionListener(this);
		image.add(onehundred);
		
		fivehundred = new JButton("Rs 500");
		fivehundred.setBounds(355, 418, 150, 30);
		fivehundred.addActionListener(this);
		image.add(fivehundred);
		
		onethousand = new JButton("Rs 1000");
		onethousand.setBounds(170, 452, 150, 30);
		onethousand.addActionListener(this);
		image.add(onethousand);
		
		twothousand = new JButton("Rs 2000");
		twothousand.setBounds(355, 452, 150, 30);
		twothousand.addActionListener(this);
		image.add(twothousand);
		
		fivethousand = new JButton("Rs 5000");
		fivethousand.setBounds(170, 487, 150, 30);
		fivethousand.addActionListener(this);
		image.add(fivethousand);
		
		tenthousand = new JButton("Rs 10000");
		tenthousand.setBounds(355, 487, 150, 30);
		tenthousand.addActionListener(this);
		image.add(tenthousand);
		
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
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")){
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource()!=back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date = new Date();
				String query = "INSERT INTO bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawl successfully!");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new FastCash("");
	}
	
}
