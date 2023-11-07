package EDiary;

import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
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

		email.setBounds(130, 82, 230, 30);
		email.setFont(myFont);
		password.setBounds(130, 142, 230, 30);
		password.setFont(myFont);

		login.setBounds(150, 202, 100, 50);
		login.setFont(myFont);
		login.addActionListener(this);

		frame.add(login);
		frame.add(title);
		frame.add(email);
		frame.add(password);
		frame.add(emailLabel);
		frame.add(passLabel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ObjectInputStream input=null;

		try {
			input = new ObjectInputStream(new FileInputStream("UserList.txt"));
		} 
		catch (IOException ioException) {
			System.err.println("Error opening file.");
		}
		Account record;
		try {
			while (input!=null) {
				record = (Account) input.readObject();
				if(record.getEmail().equals(email.getText()) || record.getPassword().equals(password.getText())) {
					
				}
			}
			System.out.println("Ok");
		} 
		catch (EOFException endOfFileException) {
			return;
		} 
		catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
		} 
		catch (IOException ioException) {
			System.err.println("Error during read from file.");
		}
		try
		{
			if (input != null)
				input.close();
		} 
		catch (IOException ioException) {
			System.err.println("Error closing file.");
			System.exit(1);
		} 

	}

}
