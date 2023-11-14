package EDiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ViewEntry implements ActionListener {
	JFrame frame = new JFrame();
	JLabel date = new JLabel("Date:");
	JButton back = new JButton("Back");
	JButton find = new JButton("Find");
	JTextField dateField = new JTextField();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);

	Font font = new Font(null, Font.BOLD, 15);
	Account account;

	public ViewEntry(Account account) {
		this.account = account;

		date.setBounds(20, 5, 50, 30);
		date.setFont(font);
		dateField.setBounds(75, 5, 100, 30);
		dateField.setFont(font);

		find.setBounds(185, 10, 60, 20);
		find.setFont(new Font(null, Font.BOLD, 12));
		find.setFocusable(false);
		find.addActionListener(this);

		textArea.setBounds(20, 40, 350, 350);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		scrollPane.setBounds(20, 40, 400, 350);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		back.setBounds(180, 400, 90, 30);
		back.setFocusable(false);
		back.addActionListener(this);

		frame.add(scrollPane);
		frame.setSize(450, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(date);
		frame.add(dateField);
		frame.add(find);
		frame.add(back);
		// frame.add(textArea);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			frame.dispose();
			new Menu(account);
		}
		if (e.getSource() == find) {
			String targetDate = dateField.getText();

			String filePath = account.getEmail() + ".txt";
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				while ((line = reader.readLine()) != null) {

					String tempDate = line.trim(); 

					if (!tempDate.equals(targetDate)) {
						while ((line = reader.readLine()) != null && !line.equals("----")) {
						}
						continue; 
					}

					if (!tempDate.equals(targetDate))
						continue;

					StringBuilder entryContentBuilder = new StringBuilder();
					while ((line = reader.readLine()) != null && !line.equals("----")) {
						entryContentBuilder.append(line).append("\n");
					}

					textArea.setText(entryContentBuilder.toString().trim());
					break;

				}
			} catch (IOException e2) {
				System.out.println("Error reading file");
			}
		}

	}

}
