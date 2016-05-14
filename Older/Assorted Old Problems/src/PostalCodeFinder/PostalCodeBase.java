package PostalCodeFinder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class PostalCodeBase extends SimpleWindow implements ActionListener
{
	JTextField input;
	JTextField output;
	
	JButton done;
	
	public PostalCodeBase()
	{
		super("Postal Code Finder", 1000, 1000, true);
	}
	
	public void createComponents()
	{
		input = new JTextField();
		input.setBounds(0, 0, 1000, 50);
		input.addActionListener(this);
		add(input);
		
		output = new JTextField();
		output.setText("Enter your Canadian Postal Code above.");
		output.setBounds(0, 50, 1000, 50);
		output.addActionListener(this);
		add(output);
		
		done = new JButton("Find My Location!");
		done.setBounds(0, 110, 1000, 50);
		done.addActionListener(this);
		add(done);
		
		repaint();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == done)
		{
			output.setText(convertPostalCodeCountry(input.getText()) + convertPostalCodeCity(input.getText()) + ".");
		}
	}
	
	public static void main(String[] args)
	{
		PostalCodeBase postalCodeBase = new PostalCodeBase();
	}
	
	public static String convertPostalCodeCity(String input)
	{
		File file = new File("C:\\PostalCodeFinder\\FSA.txt");
		
		String output = "";
		
		try
		{
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			
			for (int n = 1;scanner.hasNextLine();++n)
			{
				String fileIn = scanner.nextLine();
				
				if (n%2!=0)
				{
					if (input.split(" ")[0].equalsIgnoreCase(fileIn))
					{
						if (scanner.hasNextLine())
						{
							String city = scanner.nextLine();
							output = city;
							break;
						}
						else
							break;
					}
							
				}
			}
			
			return output;
		}
		catch (FileNotFoundException fException)
		{
			fException.printStackTrace();
			return output;
		}
	}
	
	public static String convertPostalCodeCountry(String input)
	{
		String output = "";
		
		if (input.charAt(0) >= 'G' && input.charAt(0) <= 'P')
		{
			if (input.charAt(0) >= 'G' && input.charAt(0) <= 'J')
				output += "Quebec, ";
			else
				output += "Ontario, ";
		}
		else
		{
			if (input.charAt(0) == 'A' || input.charAt(0) == (char)('A'+33))
				output += "Newfoundland and Labrabor, ";
		
			else if (input.charAt(0) == 'B' || input.charAt(0) == (char)('B'+33))
				output += "Nova Scotia, ";
		
			else if (input.charAt(0) == 'C' || input.charAt(0) == (char)('C'+33))
				output += "Prince Edward Island, ";
		
			else if(input.charAt(0) == 'E' || input.charAt(0) == (char)('E'+33))
				output += "New Brunswick, ";
			
			else if(input.charAt(0) == 'R' || input.charAt(0) == (char)('R'+33))
				output += "Manatoba, ";
			
			else if(input.charAt(0) == 'S' || input.charAt(0) == (char)('S'+33))
				output += "Saskatawan, ";
			
			else if(input.charAt(0) == 'T' || input.charAt(0) == (char)('T'+33))
				output += "Alberta, ";
			
			else if(input.charAt(0) == 'V' || input.charAt(0) == (char)('V'+33))
				output += "British Columbia, ";
			
			else if(input.charAt(0) == 'X' || input.charAt(0) == (char)('X'+33))
				output += "Nunavut, ";
			
			else if(input.charAt(0) == 'Y' || input.charAt(0) == (char)('Y'+33))
				output += "Yukon, ";
		}
		
		return output;
	}
}
