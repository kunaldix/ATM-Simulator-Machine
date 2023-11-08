package BankManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SignupTwo extends JFrame implements ActionListener{

	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox<String> religion, category, income, education, occupation;
	String formno;

	SignupTwo(String formno){
		
		this.formno = formno;
		
		setLayout(null);
		
		setTitle("New Account Application form Page 2");
		
		JLabel additionaldetails = new JLabel("Page 2: Additional Details");
		additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionaldetails.setBounds(290, 80, 400, 30);
		add(additionaldetails);
		
		JLabel religionlabel = new JLabel("Religion:");
		religionlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		religionlabel.setBounds(100, 140, 100, 30);
		add(religionlabel);
		
		String[] valReligion = {"Hindu", "Muslim", "Sikh", "Chirstian", "other"};
		religion = new JComboBox<>(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel categorylabel = new JLabel("Category:");
		categorylabel.setFont(new Font("Raleway", Font.BOLD, 20));
		categorylabel.setBounds(100, 190, 200, 30);
		add(categorylabel);
		
		String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
		category = new JComboBox<>(valCategory);
		category.setBackground(Color.WHITE);
		category.setBounds(300, 190, 400, 30);
		add(category);
		
		JLabel incomelabel = new JLabel("Income:");
		incomelabel.setFont(new Font("Raleway", Font.BOLD, 20));
		incomelabel.setBounds(100, 240, 200, 30);
		add(incomelabel);
		
		String[] incomeCategory = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "<10,00,000"};
		income = new JComboBox<>(incomeCategory);
		income.setBackground(Color.WHITE);
		income.setBounds(300, 240, 400, 30);
		add(income);
		
		JLabel educationlabel = new JLabel("Educational");
		educationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		educationlabel.setBounds(100, 290, 200, 30);
		add(educationlabel);
		
		JLabel qualificationlabel = new JLabel("Qualification:");
		qualificationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		qualificationlabel.setBounds(100, 315, 200, 30);
		add(qualificationlabel);
		
		String[] educationValue = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
		education = new JComboBox<>(educationValue);
		education.setBackground(Color.WHITE);
		education.setBounds(300, 315, 400, 30);
		add(education);
		
		JLabel occupationlabel = new JLabel("Occupation:");
		occupationlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		occupationlabel.setBounds(100, 390, 200, 30);
		add(occupationlabel);
		
		String[]occupationValue = {"Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Others"};
		occupation = new JComboBox<>(occupationValue);
		occupation.setBackground(Color.WHITE);
		occupation.setBounds(300, 390, 400, 30);
		add(occupation);
		
		JLabel panlabel = new JLabel("PAN Number:");
		panlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		panlabel.setBounds(100, 440, 200, 30);
		add(panlabel);
		
		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		JLabel aadharlabel = new JLabel("Aadhar Number:");
		aadharlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		aadharlabel.setBounds(100, 490, 200, 30);
		add(aadharlabel);
		
		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		JLabel seniorcitizenlabel = new JLabel("Senior Citizen:");
		seniorcitizenlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorcitizenlabel.setBounds(100, 540, 200, 30);
		add(seniorcitizenlabel);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 60, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450, 540, 120, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup scitizengroup = new ButtonGroup();
		scitizengroup.add(syes);
		scitizengroup.add(sno);
		
		JLabel existingaccountlabel = new JLabel("Existing Account:");
		existingaccountlabel.setFont(new Font("Raleway", Font.BOLD, 20));
		existingaccountlabel.setBounds(100, 590, 200, 30);
		add(existingaccountlabel);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 60, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450, 590, 120, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existinggroup = new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);

		next = new JButton("Next");
		next.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {

		String sreligion = (String)religion.getSelectedItem();
		String scategory = (String)category.getSelectedItem();
		String sincome  = (String)income.getSelectedItem();
		String seducation  = (String)education.getSelectedItem();
		String soccupation  = (String)occupation.getSelectedItem();
		
		String span = pan.getText();
		String saadhar = aadhar.getText();
		
		String seniorcitizen = null;
		if(syes.isSelected())seniorcitizen = "Yes";
		else if(sno.isSelected())seniorcitizen = "No";
		
		String existingaccount = null;
		if(eyes.isSelected())existingaccount = "Yes";
		else if(eno.isSelected())existingaccount = "No";
		
		
		
		try {
			Conn c = new Conn();
			String query = "INSERT INTO signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new SignupTwo("");

	}

}
