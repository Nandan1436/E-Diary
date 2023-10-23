package EDiary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Login {
	JFrame frame = new JFrame();
	JTextField userName = new JTextField();
	JTextField password = new JTextField();
	JLabel uNameLabel = new JLabel("User Name: ");
	JLabel passLabel = new JLabel("Password: ");
	JLabel title = new JLabel("Log In");
	JButton login = new JButton("Log in");
	
	Font myFont = new Font(null,Font.BOLD,15);
	
	public Login() {
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		title.setBounds(150,0,100,50);
		title.setFont(new Font(null,Font.BOLD,30));
		
		uNameLabel.setBounds(30,70,100,50);
		uNameLabel.setFont(myFont);
		passLabel.setBounds(30,130,100,50);
		passLabel.setFont(myFont);
		
		userName.setBounds(130,82,230,30);
		userName.setFont(myFont);
		password.setBounds(130,142,230,30);
		password.setFont(myFont);
		
		login.setBounds(150,202,100,50);
		login.setFont(myFont);
		
		frame.add(login);
		frame.add(title);
		frame.add(userName);
		frame.add(password);
		frame.add(uNameLabel);
		frame.add(passLabel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	
}
