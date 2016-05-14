package BankAccountManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

public class BankAccountBase extends JFrame
{
	int transactionType = 0;
	
	JTextField input = new JTextField();
	JButton done = new JButton("Done");
	
	JTextField accountInfo = new JTextField();
	JTextField money = new JTextField();
	JButton deposit = new JButton("Deposit");
	JButton withdraw = new JButton("Withdraw");
	
	public BankAccountBase(LoginScreen login)
	{
		this.setTitle("Bank Account: " + login.loginString);
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		doComponents(login);
	}
	
	public void doComponents(LoginScreen login)
	{
		try
		{					
			FileReader reader = new FileReader("C:\\BankAccountManager\\" + login.loginString + ".txt");
			Scanner scanner = new Scanner(reader);
			
			String[] accountData = scanner.nextLine().split(":");
			
			input.setBounds(-1000, -1000, 600, 50);
			add(input);
			
			done.addActionListener(new actionListener(login, 2));
			done.setBounds(-1000, -1000, 600, 50);
			add(done);
			
			money.setEditable(false);
			money.setText("Balance: $ " + accountData[0]);
			money.setBounds(0, 0, 600, 50);
			add(money);
			
			deposit.addActionListener(new actionListener(login, 0));
			deposit.setBounds(0, 55+400, 600, 50);
			add(deposit);
			
			withdraw.addActionListener(new actionListener(login, 1));
			withdraw.setBounds(0, 110+400, 600, 50);
			add(withdraw);
			
			accountInfo.setText("Name: " + login.loginString);
			accountInfo.setBounds(0, 5+400, 600, 50);
			add(accountInfo);
		}
		catch (Exception exception)
		{
			System.out.println("Your account data cannot be loaded!");
			exception.printStackTrace();
			this.dispose();
		}
	}
	
	public void update(int n)
	{
		money.setText("Balance: $"+n);
		
		input.setLocation(-1000, -1000);
		done.setLocation(-1000, -1000);
	}
	
	public void createInput(int n)
	{
		input.setLocation(100, 100);
		done.setLocation(100, 200);
		transactionType = n;
	}
	
	public void done(LoginScreen login)
	{
		try
		{
			FileReader reader = new FileReader("C:\\BankAccountManager\\" + login.loginString + ".txt");
			Scanner scanner = new Scanner(reader);
			
			String[] accountData = scanner.nextLine().split(":");
			
			PrintWriter writer = new PrintWriter("C:\\BankAccountManager\\" + login.loginString + ".txt");
			
			if (transactionType == 0)
			{
				writer.write((Integer.parseInt(accountData[0])+Integer.parseInt(input.getText()) + ":1"));
				update((Integer.parseInt(accountData[0])+Integer.parseInt(input.getText())));
			}
			
			if (transactionType == 1)
			{
				writer.write((Integer.parseInt(accountData[0])-Integer.parseInt(input.getText()) + ":1"));
				update((Integer.parseInt(accountData[0])-Integer.parseInt(input.getText())));
			}

			writer.flush();
		}
		catch (Exception exception)
		{
			System.out.println("Transaction failed!");
			exception.printStackTrace();
			this.dispose();
		}
	}
	
	public void deposit()
	{
		createInput(0);
	}
	
	public void withdraw()
	{
		createInput(1);
	}
	
	public BankAccountBase returnBankAccount()
	{
		return this;
	}
	
	public class actionListener implements ActionListener
	{
		LoginScreen login;
		int n;
		
		public actionListener(LoginScreen l, int x)
		{
			login = l;
			n = x;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (n==0)
				deposit();
			
			if (n==1)
				withdraw();
			
			if (n==2)
				done(login);
		}
	}
}
