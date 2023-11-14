package EDiary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Menu implements ActionListener{
	JFrame frame = new JFrame("Main Menu");
	JButton add = new JButton("Add new Entry");
	JButton prev = new JButton("View previous Entry");
	JButton logout = new JButton("Log out");
	JLabel greet = new JLabel();
	JLabel title = new JLabel("E-Diary");
	Font font = new Font(null,Font.BOLD,17);
	
	private Account account;
	
	public Menu(Account account)
	{
		this.account = account;
		
		title.setBounds(165,0,120,50);
		title.setFont(new Font(null,Font.BOLD,30));
		greet.setBounds(20,55,300,30);
		greet.setFont(new Font(null,Font.ITALIC,20));
		greet.setText("Welcome, "+account.getFirstName()+"!");

		add.setBounds(125,140,190,60);
		add.setFont(font);
		add.addActionListener(this);
		add.setFocusable(false);
		
		prev.setBounds(125,210,190,60);
		prev.setFont(new Font(null,Font.BOLD,16));
		prev.addActionListener(this);
		prev.setFocusable(false);
		
		logout.setBounds(125,280,190,60);
		logout.setFont(font);
		logout.addActionListener(this);
		logout.setFocusable(false);
		
		frame.setSize(450,450);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(title);
		frame.add(greet);
		frame.add(add);
		frame.add(prev);
		frame.add(logout);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logout) {
			frame.dispose();
			new WelcomePage();
		}
		if(e.getSource()==add) {
			frame.dispose();
			new AddEntry(account);
			
		}
		if(e.getSource()==prev) {
			frame.dispose();
			new ViewEntry(account);
		}
	}
	
}
