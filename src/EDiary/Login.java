package EDiary;

import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.util.*;

public class Login implements ActionListener {
	JFrame frame = new JFrame();
	JTextField email = new JTextField();
	JTextField password = new JTextField();
	JLabel emailLabel = new JLabel("Email: ");
	JLabel passLabel = new JLabel("Password: ");
	JLabel checkLogin = new JLabel();
	JLabel title = new JLabel("Log In");
	JButton login = new JButton("Log in");

	Font myFont = new Font(null, Font.BOLD, 15);

	public Login() {
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		title.setBounds(150, 0, 100, 50);
		title.setFont(new Font(null, Font.BOLD, 30));

		emailLabel.setBounds(30, 70, 100, 50);
		emailLabel.setFont(myFont);
		passLabel.setBounds(30, 130, 100, 50);
		passLabel.setFont(myFont);
		checkLogin.setBounds(100,260,200,100);
		checkLogin.setFont(new Font(null,Font.BOLD,15));

		email.setBounds(130, 82, 230, 30);
		email.setFont(myFont);
		password.setBounds(130, 142, 230, 30);
		password.setFont(myFont);

		login.setBounds(150, 202, 100, 50);
		login.setFont(myFont);
		login.addActionListener(this);
		login.setFocusable(false);

		frame.add(login);
		frame.add(title);
		frame.add(email);
		frame.add(password);
		frame.add(emailLabel);
		frame.add(passLabel);
		frame.add(checkLogin);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Scanner input = null;
		try {
			input = new Scanner(new File("UserList.txt"));
		} 
		catch (FileNotFoundException e1) {
			System.err.printf("Error opening file");
			System.exit(1);
		}
		Account record = new Account();
		try
		{
			while(input.hasNext())
			{
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setDateOfBirth(input.next());
				record.setEmail(input.next());
				record.setPassword(input.next());
				
				if(record.getEmail().equals(email.getText()) && record.getPassword().equals(password.getText())) {
					frame.dispose();
					new Menu(record);
					return;
				}
			}
			checkLogin.setForeground(Color.red);
			checkLogin.setText("Wrong email or Password");
		}
		catch(NoSuchElementException elementException) {
			System.err.println("File improperly formed.");
		}
		
		input.close();
		

	}

}
