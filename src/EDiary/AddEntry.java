package EDiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddEntry implements ActionListener{
	JFrame frame = new JFrame();
	JLabel date = new JLabel("Date:");
	JLabel time = new JLabel("Time:");
	JLabel entryAdded = new JLabel();
	JButton back = new JButton("Back");
	JButton add = new JButton("Add");
	JTextField dateField = new JTextField();
	JTextField timeField = new JTextField();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	Font font = new Font(null,Font.BOLD,15);
	Account account;
	
	public AddEntry(Account account)
	{
		this.account=account;
		
		date.setBounds(20,5,50,30);
		date.setFont(font);
		dateField.setBounds(75,5,100,30);
		dateField.setFont(font);
		time.setBounds(180,5,100,30);
		timeField.setFont(font);
		
		add.setBounds(230,400,70,30);
		add.setFont(new Font(null,Font.BOLD,12));
		add.setFocusable(false);
		add.addActionListener(this);
		
		textArea.setBounds(20,40,350,350);
		textArea.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		textArea.setEditable(true);
		textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        
        scrollPane.setBounds(20, 40, 400, 350);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        back.setBounds(150,400,70,30);
        back.setFocusable(false);
        back.addActionListener(this);
   
        entryAdded.setBounds(120,440,250,30);
        entryAdded.setFont(new Font(null,Font.PLAIN,16));
        
		frame.setSize(450,520);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(date);
		frame.add(dateField);
		frame.add(add);
		frame.add(back);
		frame.add(scrollPane);
		frame.add(entryAdded);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back) {
			 frame.dispose();
	         new Menu(account);
		}
		if(e.getSource()==add) {
			String filePath = account.getEmail()+".txt";
			String date=dateField.getText();
			String content=textArea.getText();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
	            writer.write(date);
	            writer.newLine(); 
	            writer.write(content);
	            writer.newLine();
	            writer.write("----");
	            writer.newLine(); 
	            entryAdded.setText("Entry added successfully");
	            dateField.setText("");
	            textArea.setText("");
	        } catch (IOException e2) {
	            System.out.println("Failed appending");
	        }
		}
		
		
	}
	
	
	
}
