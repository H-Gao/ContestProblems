package EncodedFiles;

import javax.swing.*;

import java.awt.event.*;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class Encoder extends SimpleWindow implements ActionListener
{
	int key1 = 2;
	int key2 = 3;
	int key3 = 4;
	
	JTextArea output;
	JTextArea input;
	JTextArea input2;
	JTextArea fileExtension;
	JButton createFile;
	JButton readFile;
	
	public Encoder() 
	{
		super("Encoder", 800, 800, true);
	}
	
	public static void main(String[] args)
	{
		Encoder encoder = new Encoder();
	}
	
	public void createComponents()
	{
		output = new JTextArea();
		output.setBounds(0, 0, 800, 200);
		output.setText("Hello, what would you like to do?");
		add(output);
		
		input = new JTextArea();
		input.setBounds(0, 200, 800, 50);
		input.setText("The name goes here.");
		add(input);
		
		fileExtension = new JTextArea();
		fileExtension.setBounds(0, 250, 800, 50);
		fileExtension.setText("The file extension goes here.");
		add(fileExtension);
		
		input2 = new JTextArea();
		input2.setBounds(0, 300, 800, 100);
		input2.setText("The message goes here.");
		add(input2);
		
		createFile = new JButton("Create Encoded File");
		createFile.addActionListener(this);
		createFile.setBounds(0, 400, 800, 200);
		add(createFile);
		
		readFile = new JButton("Read Encoded File");
		readFile.addActionListener(this);
		readFile.setBounds(0, 600, 800, 200);
		add(readFile);
		
		repaint();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == createFile)
		{
			try
			{
				String in = input2.getText();
				char[] message = in.toCharArray();
				
				PrintWriter writer = new PrintWriter("C:\\EncodedFile\\" + input.getText() + "." + fileExtension.getText());
				
				for (int n = 0;n != message.length;++n)
				{
					if (n < 4)
						writer.print((char)((message[n] + (key1+key2) + n)-key3));
					else
						writer.print((char)((message[n] + (key1+key2))-key3));
				}
					
				writer.flush();
			}
			catch (Exception exception)
			{
				System.out.println("Something broke.");
			}
		}
		
		if (e.getSource() == readFile)
		{
			try
			{
				FileReader reader = new FileReader("C:\\EncodedFile\\" + input.getText() + "." + fileExtension.getText());
				Scanner scanner = new Scanner(reader);
				
				output.setText("");
				
				String message = scanner.nextLine();
				
				while(scanner.hasNextLine())
				{
					message += scanner.nextLine();
				}
				
				for (int n = 0;n != message.length();++n)
				{
					if (n < 4)
						output.setText(output.getText() + (char)((message.charAt(n) - (key1 + key2) - n) + key3));
					else
						output.setText(output.getText() + (char)((message.charAt(n) - (key1 + key2)) + key3));
				}
			}
			catch (Exception exception)
			{
				System.out.println("Something broke.");
				exception.printStackTrace();
			}
		}
	}
}
