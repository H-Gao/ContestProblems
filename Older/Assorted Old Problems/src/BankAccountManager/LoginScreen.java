package BankAccountManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

public class LoginScreen extends JFrame
{
	boolean isFinished;
	
	String loginString;
	String passwordString;
	
	JTextField login = new JTextField();
	JPasswordField password = new JPasswordField();
	
	JButton done = new JButton("Done");
	
	public LoginScreen()
	{
		this.setTitle("Login");
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		doComponents();
	}
	
	public static void main(String[] args)
	{
		LoginScreen loginScreen = new LoginScreen();
	}
	
	public void doComponents()
	{
		login.setBounds(0, 0, 600, 100);
		add(login);
		
		password.setBounds(0, 100, 600, 100);
		add(password);
		
		done.addActionListener(new doneListener());
		done.setBounds(0, 200, 600, 100);
		add(done);
	}
	
	public LoginScreen returnLoginScreen()
	{
		return this;
	}
	
	public class doneListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				File file = new File("C:\\BankAccountManager\\LoginData.txt");
				
				if (file.exists())
				{
					FileReader reader = new FileReader(file);
					Scanner scanner = new Scanner(reader);
					
					String data[] = scanner.nextLine().split(":");
					
					for (int n = 0;n != data.length;n += 2)
					{
						if (login.getText().equals(data[n]) && password.getText().equals(data[n+1]))
						{
							System.out.println(login.getText() + " has logged in.");
							
							isFinished = true;
							
							loginString = login.getText();
							passwordString = password.getText();
							
							BankAccountBase bankAccount = new BankAccountBase(returnLoginScreen());							
							returnLoginScreen().dispose();
						}
					}
					
					if (!isFinished)
						throw new FileNotFoundException();
				}
			}
			catch (Exception exception)
			{
				login.setText("The login or password has not been found! Retype/Recheck them.");
				exception.printStackTrace();
			}
		}
	}
}
