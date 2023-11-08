package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.Date;

@SuppressWarnings("serial")
public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;

	Withdrawl(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter Amount you want to Withdraw");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(210, 300, 400, 20);
		text.setForeground(Color.WHITE);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 16));
		amount.setBounds(203, 350, 275, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 487, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
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
		else if(ae.getSource() == withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the amount you want to Withdraw");
			}
			else {
				try {
					Conn c = new Conn();
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
					if(ae.getSource()!=back && balance < Integer.parseInt(number)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
					String query = "INSERT INTO bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" withdrawl successfully!");
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
		new Withdrawl("");
	}
	
}

