package EDiary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class WelcomePage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton login = new JButton("Login");
	JButton signUp = new JButton("Sign Up");
	JLabel titleLine = new JLabel("Welcome to");
	JLabel title = new JLabel("E-Diary");
	
	public WelcomePage() {
		
		
		titleLine.setBounds(170, 0, 80, 40);
		titleLine.setFont(new Font(null,Font.PLAIN,13));
		title.setBounds(150,40,120,50);
		title.setFont(new Font(null,Font.BOLD,30));
		
		login.setBounds(170,190,80,40);
		login.setFocusable(false);
		login.addActionListener(this);
		signUp.setBounds(170,240,80,40);
		signUp.setFocusable(false);
		signUp.addActionListener(this);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(titleLine);
		frame.add(title);
		frame.add(login);
		frame.add(signUp);
		frame.setLocationRelativeTo(null);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			frame.dispose();
			new Login();
		}
		else {
			frame.dispose();
			new SignUp();
		}
		
	}
	
}
