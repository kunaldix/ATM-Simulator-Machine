package BankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class SignupThree extends JFrame implements ActionListener{

	String formno;
	JRadioButton savingaccount, currentaccount, fixeddepositaccount, reccuringaccount;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancel;
	
	SignupThree(String formno) {
		
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("New Account Application form Page 3");
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD, 20));
		type.setBounds(100, 125, 200, 30);
		add(type);
		
		savingaccount = new JRadioButton("Saving Account");
		savingaccount.setFont(new Font("Raleway", Font.BOLD, 16));
		savingaccount.setBackground(Color.WHITE);
		savingaccount.setBounds(100,180,150,20);
		add(savingaccount);
		
		fixeddepositaccount = new JRadioButton("Fixed Deposit Account");
		fixeddepositaccount.setFont(new Font("Raleway", Font.BOLD, 16));
		fixeddepositaccount.setBackground(Color.WHITE);
		fixeddepositaccount.setBounds(350,180,250,20);
		add(fixeddepositaccount);
		
		currentaccount = new JRadioButton("Current Account");
		currentaccount.setFont(new Font("Raleway", Font.BOLD, 16));
		currentaccount.setBackground(Color.WHITE);
		currentaccount.setBounds(100,220,250,20);
		add(currentaccount);
		
		reccuringaccount = new JRadioButton("Recurring Deposit Account");
		reccuringaccount.setFont(new Font("Raleway", Font.BOLD, 16));
		reccuringaccount.setBackground(Color.WHITE);
		reccuringaccount.setBounds(350,220,250,20);
		add(reccuringaccount);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(savingaccount);
		groupaccount.add(fixeddepositaccount);
		groupaccount.add(currentaccount);
		groupaccount.add(reccuringaccount);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 20));
		card.setBounds(100, 280, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		number.setBounds(330, 280, 250, 30);
		add(number);
		
		JLabel details = new JLabel("Your 16 digits card number");
		details.setFont(new Font("Raleway", Font.BOLD, 12));
		details.setBounds(100, 300, 250, 30);
		add(details);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 350, 100, 30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		pnumber.setBounds(330, 350, 100, 30);
		add(pnumber);
		
		JLabel pdetails = new JLabel("Your 4 digits Password");
		pdetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pdetails.setBounds(100, 370, 250, 30);
		add(pdetails);
		
		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway", Font.BOLD, 20));
		services.setBounds(100, 430, 200, 30);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBackground(Color.WHITE);
		c1.setBounds(100, 480, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBackground(Color.WHITE);
		c2.setBounds(350, 480, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBackground(Color.WHITE);
		c3.setBounds(100, 530, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBackground(Color.WHITE);
		c4.setBounds(350, 530, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBackground(Color.WHITE);
		c5.setBounds(100, 580, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statements");
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBackground(Color.WHITE);
		c6.setBounds(350, 580, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declares that the above entered details to the best of my knowledge");
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBackground(Color.WHITE);
		c7.setBounds(100, 630, 600, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250, 700, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 700, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == submit) {
			
			String accountType = null;
			if(savingaccount.isSelected()) {
				accountType = "Saving Account";
			}
			else if(fixeddepositaccount.isSelected()) {
				accountType = "Fixed Deposit Account";
			}
			else if(currentaccount.isSelected()) {
				accountType = "Current Account";
			}
			else if(reccuringaccount.isSelected()) {
				accountType = "Reccuring Account";
			}
			
			Random ran = new Random();
			
			String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
			String pinnumber = "" + Math.abs(ran.nextInt(9000) + 1000);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + " ATM Card";
			}
			if(c2.isSelected()) {
				facility = facility + " Internet Banking";
			}
			if(c3.isSelected()) {
				facility = facility + " Mobile Banking";
			}
			if(c4.isSelected()) {
				facility = facility + " Email & SMS Alerts";
			}
			if(c5.isSelected()) {
				facility = facility + " Cheque Book";
			}
			if(c6.isSelected()) {
				facility = facility + " E-Statements";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else {
					Conn c = new Conn();
					String query1 = "INSERT INTO signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
					String query2 = "INSERT INTO login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
					
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin: "+pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
			}
			catch(Exception e) {
				System.out.println();
			}
			
		}
		else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new SignupThree("");
	}

}
