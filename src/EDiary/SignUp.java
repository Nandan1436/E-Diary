package EDiary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SignUp implements ActionListener{
	JFrame frame = new JFrame("Sign Up");
	
	JLabel title = new JLabel("Sign Up");
	JLabel firstName= new JLabel("First Name:");
	JLabel lastName= new JLabel("Last Name:");
	JLabel dateOfBirth= new JLabel("Date of Birth:");
	JLabel email= new JLabel("email:");
	JLabel password= new JLabel("Password:");
	JLabel confirmPassword= new JLabel("Confirm Password:");
	JLabel checkPass = new JLabel();
	
	JTextField fNameLabel = new JTextField();
	JTextField lNameLabel = new JTextField();
	JTextField dobLabel = new JTextField();
	JTextField emailLabel = new JTextField();
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
		emailLabel.setBounds(180,262,370,30);
		emailLabel.setFont(myFont);
		passLabel.setBounds(180,322,370,30);
		passLabel.setFont(myFont);
		cPassLabel.setBounds(180,382,370,30);
		cPassLabel.setFont(myFont);
		checkPass.setBounds(100,505,400,50);
		checkPass.setFont(myFont);
		
		firstName.setBounds(30, 70, 150, 50);
		firstName.setFont(myFont);
		lastName.setBounds(30,130,150,50);
		lastName.setFont(myFont);
		dateOfBirth.setBounds(30,190,150,50);
		dateOfBirth.setFont(myFont);
		email.setBounds(30,250,150,50);
		email.setFont(myFont);
		password.setBounds(30,310,150,50);
		password.setFont(myFont);
		confirmPassword.setBounds(30,370,150,50);
		confirmPassword.setFont(myFont);
		
		frame.add(title);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(dateOfBirth);
		frame.add(email);
		frame.add(password);
		frame.add(confirmPassword);
		frame.add(back);
		frame.add(confirm);
		frame.add(fNameLabel);
		frame.add(lNameLabel);
		frame.add(dobLabel);
		frame.add(emailLabel);
		frame.add(passLabel);
		frame.add(cPassLabel);
		frame.add(checkPass);
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
			if(!passLabel.getText().equals(cPassLabel.getText())) {
				checkPass.setForeground(Color.red);
				checkPass.setText("Password and confirm password doesn't match");
				return;
			}
			
			Scanner input = null;
			try {
				String filePath = "UserList.txt";
				input = new Scanner(new File(filePath));
			} 
			catch (FileNotFoundException e1) {
				System.err.printf("Error opening file");
				System.exit(1);
			}
			ArrayList<Account> record = new ArrayList<Account>();
			try
			{
				while(input.hasNext())
				{
					Account temp = new Account(input.next(),input.next(),input.next(),input.next(),input.next());
					record.add(temp);
				}
			}
			catch(NoSuchElementException elementException) {
				System.err.println("File improperly formed.");
			}
			Account newAcc = new Account(fNameLabel.getText(),lNameLabel.getText(),dobLabel.getText(),emailLabel.getText(),passLabel.getText());
			record.add(newAcc);
			input.close();
			Formatter output = null;
			try {
				output = new Formatter("UserList.txt");
			}
			catch(FileNotFoundException e1) {
				System.err.printf("Error opening file");
				System.exit(1);
			}
			try
			{
				for(Account x : record)
				{
					output.format("%s %s %s %s %s\n",x.getFirstName(),x.getLastName(),x.getDateOfBirth(),x.getEmail(),x.getPassword());
				}
			}
			catch(FormatterClosedException f) {
				System.err.println("Error writing to file.");
				return;
			}
			String filePath = newAcc.getEmail()+".txt";

	        Path path = Paths.get(filePath);

	        try {
	            Files.createFile(path);
	            System.out.println("File created: " + path.toAbsolutePath());
	        } catch (IOException e3) {
	            System.out.println("File could not be created");
	            return;
	        }
			output.close();
			frame.dispose();
			new Login();
		}
		
	}
	
	
}
