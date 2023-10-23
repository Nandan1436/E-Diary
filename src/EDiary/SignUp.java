package EDiary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class SignUp implements ActionListener{
	JFrame frame = new JFrame("Sign Up");
	
	JLabel title = new JLabel("Sign Up");
	JLabel firstName= new JLabel("First Name:");
	JLabel lastName= new JLabel("Last Name:");
	JLabel dateOfBirth= new JLabel("Date of Birth:");
	JLabel userName= new JLabel("User Name:");
	JLabel password= new JLabel("Password:");
	JLabel confirmPassword= new JLabel("Confirm Password:");
	
	JTextField fNameLabel = new JTextField();
	JTextField lNameLabel = new JTextField();
	JTextField dobLabel = new JTextField();
	JTextField uNameLabel = new JTextField();
	JTextField passLabel = new JTextField();
	JTextField cPassLabel = new JTextField();
	
	JButton confirm = new JButton("Confirm");
	JButton back = new JButton("Back");
	
	Font myFont = new Font(null,Font.BOLD,15);
	
	public SignUp() {
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		back.setBounds(150,450,130,50);
		back.setFocusable(false);
		back.addActionListener(this);
		confirm.setBounds(320,450,130,50);
		confirm.setFocusable(false);
		confirm.addActionListener(this);
		
		title.setBounds(230,0,140,50);
		title.setFont(new Font(null,Font.BOLD,35));
		
		fNameLabel.setBounds(180,82,370,30);
		fNameLabel.setFont(myFont);
		lNameLabel.setBounds(180,142,370,30);
		lNameLabel.setFont(myFont);
		dobLabel.setBounds(180,202,370,30);
		dobLabel.setFont(myFont);
		uNameLabel.setBounds(180,262,370,30);
		uNameLabel.setFont(myFont);
		passLabel.setBounds(180,322,370,30);
		passLabel.setFont(myFont);
		cPassLabel.setBounds(180,382,370,30);
		cPassLabel.setFont(myFont);
		
		firstName.setBounds(30, 70, 150, 50);
		firstName.setFont(myFont);
		lastName.setBounds(30,130,150,50);
		lastName.setFont(myFont);
		dateOfBirth.setBounds(30,190,150,50);
		dateOfBirth.setFont(myFont);
		userName.setBounds(30,250,150,50);
		userName.setFont(myFont);
		password.setBounds(30,310,150,50);
		password.setFont(myFont);
		confirmPassword.setBounds(30,370,150,50);
		confirmPassword.setFont(myFont);
		
		frame.add(title);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(dateOfBirth);
		frame.add(userName);
		frame.add(password);
		frame.add(confirmPassword);
		frame.add(back);
		frame.add(confirm);
		frame.add(fNameLabel);
		frame.add(lNameLabel);
		frame.add(dobLabel);
		frame.add(uNameLabel);
		frame.add(passLabel);
		frame.add(cPassLabel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			frame.dispose();
			new WelcomePage();
		}
		else {
			
		}
		
	}
	
	
}
