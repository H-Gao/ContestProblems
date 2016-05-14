package Default;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUICalculator extends JFrame
{
	JButton numbers[] = new JButton[10];
	
	boolean hasSign = false;
	
	String expression = "";
	JButton Expression = new JButton();
	
	Scanner scanner = new Scanner(System.in);
	
	public GUICalculator()
	{
		setTitle("Calculator");
		setSize(400, 610);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setButtons();
		
		JTextArea textArea = new JTextArea("Calculator by Henry Gao." 
		+ "\nThis is a calculator used to calculate numbers up to 2^32\n(4294967296)."
		+ "\nDate Created: January 5th, 2014");
		textArea.setFont(new Font("Serif", Font.ITALIC, 10));
		textArea.setEditable(false);
		textArea.setBounds(2, 495, 370, 180);
		add(textArea);
	}
	
	public static void main(String[] args)
	{
		GUICalculator guiCalculator = new GUICalculator();
	}
	
	public void setListener(GUICalculator guiCalculator)
	{
		Expression.addActionListener(guiCalculator.new ActionListenerCalculator());
	}
	
	public void setButtons()
	{
		setListener(this);
		
		for (int n = 0;n != 10;++n)
		{
			numbers[n] = new JButton(""+n);
			numbers[n].setBounds(n * 62, 140, 60, 80);
			
			if (n > 5) 
				numbers[n].setBounds((n-6) * 62, 220, 60, 80);
			
			numbers[n].addActionListener(new ActionListenerNumber(""+n));
			add(numbers[n]);
		}
		
		Expression.setBounds(10, 20, 360, 60);
		add(Expression);
		
		JButton addition = new JButton("+");
		addition.setBounds(4*62, 220, 60, 80);
		addition.addActionListener(new ActionListenerNumber("+"));
		add(addition);
		
		JButton subtraction = new JButton("-");
		subtraction.setBounds(5*62, 220, 60, 80);
		subtraction.addActionListener(new ActionListenerNumber("-"));
		add(subtraction);
		
		JButton Dot = new JButton(".");
		Dot.setBounds(3*62, 300, 60, 80);
		Dot.addActionListener(new ActionListenerNumber("."));
		add(Dot);
		
		JButton square = new JButton("^");
		square.setBounds(4*62, 300, 60, 80);
		square.addActionListener(new ActionListenerNumber("^"));
		add(square);
		
		JButton PI = new JButton("PI");
		PI.setBounds(5*62, 300, 60, 80);
		PI.addActionListener(new ActionListenerNumber(""+Math.PI));
		add(PI);
		
		JButton multiplication = new JButton("*");
		multiplication.setBounds(0, 400, 60, 80);
		multiplication.addActionListener(new ActionListenerNumber("*"));
		add(multiplication);
		
		JButton division = new JButton("/");
		division.setBounds(62, 400, 60, 80);
		division.addActionListener(new ActionListenerNumber("/"));
		add(division);
		
		JButton equals = new JButton("=");
		equals.setBounds(124, 400, 250, 80);
		equals.addActionListener(new ActionListenerEquals());
		add(equals);
	}
	
	public class ActionListenerNumber implements ActionListener
	{
		String theValue;
		
		public ActionListenerNumber(String value)
		{
			theValue = value;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (theValue.equals("0"))
			{
				try 
				{
					if (expression.charAt(expression.length()-1) != '0') 
					  expression += theValue;
				}
				 catch(StringIndexOutOfBoundsException n)
				 { 
					 System.out.println("You need to enter another number first!");
				 }
			}
			
			else if (theValue.equals("+") || theValue.equals("-") || theValue.equals("*") || theValue.equals("/") || theValue.equals("^"))
			{
				try 
				{
					if (expression.charAt(expression.length()-1) != '+' && expression.charAt(expression.length()-1) != '-' && expression.charAt(expression.length()-1) != '*' && expression.charAt(expression.length()-1) != '/' && expression.charAt(expression.length()-1) != '^' && !hasSign)
					{
						hasSign = true;
						expression += theValue;
					}
				}
				 catch(StringIndexOutOfBoundsException exception)
				 {
					 System.out.println("You have to enter a number first!");
				 }
			}
			
			else
			{
				expression += theValue;
			}
			
			Expression.setText(expression);
		}
	}
	
	public class ActionListenerCalculator implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			hasSign = false; 
			expression = "";
			Expression.setText(expression);
		}
	}
	
	public class ActionListenerEquals implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String values[] = new String[2];
			
			for (int n = 0;n != 2;++n)
				values[n] = "";
			
			for (int n = 0;n != expression.length();++n)
			{
				if ((int)(expression.charAt(n)) <= 47 && (int)(expression.charAt(n)) != 46|| (int)(expression.charAt(n)) == 94)
				{		
					//Searches for two values Ex. 2^8 The values will be 2 and 8.
					
					for (int k = 0;k != n;++k)
						values[0] += expression.charAt(k);
					
					for (int k = n+1;k != expression.length();++k)
						values[1] += expression.charAt(k);
					
					try
					{
						if (expression.charAt(n) == '+')
						{
							Expression.setText(""+(Double.parseDouble(values[0]) + Double.parseDouble(values[1])));
							expression = "";
							hasSign = false;
						}
						
						else if (expression.charAt(n) == '-')
						{
							Expression.setText(""+(Double.parseDouble(values[0]) - Double.parseDouble(values[1])));
							expression = "";
							hasSign = false;
						}
						
						else if (expression.charAt(n) == '*')
						{
							Expression.setText(""+(Double.parseDouble(values[0]) * Double.parseDouble(values[1])));
							expression = "";
							hasSign = false;
						}
						
						else if (expression.charAt(n) == '/')
						{
							Expression.setText(""+(Double.parseDouble(values[0]) / Double.parseDouble(values[1])));
							expression = "";
							hasSign = false;
						}
						
						else if (expression.charAt(n) == '^')
						{
							Double squareNum = Double.parseDouble(values[0]);
							
							if (Double.parseDouble(values[1]) == 0) squareNum = 1.0;
							 else if (Double.parseDouble(values[1]) == 1) squareNum = Double.parseDouble(values[0]);
							  else
							  {
								  for (int k = 1;k != Integer.parseInt(values[1]);++k) 
									  squareNum *= Double.parseDouble(values[0]);
							  }
							
							Expression.setText(""+squareNum);
							expression = "";
							hasSign = false;
						}
					}
					catch (NumberFormatException exception)
					{
						Expression.setText("You need two valid numbers.");
						expression = "";
						hasSign = false;
					}
					
					break;
				}
			}
		}
	}
}
