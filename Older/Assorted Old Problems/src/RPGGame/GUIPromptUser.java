package RPGGame;

import java.awt.event.*;

import javax.swing.*;

public class GUIPromptUser extends JFrame
{
	int n = 0;
	
	boolean isFinished = false;
	
	JTextField input = new JTextField();
	JTextField output = new JTextField();
	JButton accept = new JButton("Confirm");
	
	public GUIPromptUser(SelectCharacter x)
	{
		this.setTitle("Prompting User");
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		createButtons(x);
		
		repaint();
	}
	
	public void createButtons(SelectCharacter x)
	{
		input.setBounds(10, 120, 580, 100);
		add(input);
		
		output.setText("Hello, before you may start, we must prompt you for information.");
		output.setBounds(10, 10, 580, 100);
		add(output);
		
		accept.setBounds(10, 230, 500, 100);
		accept.addActionListener(new actionListener(x));
		add(accept);
	}
	
	public class actionListener implements ActionListener
	{
		SelectCharacter x;
		
		public actionListener(SelectCharacter k)
		{
			x = k;
		}
		
		public void actionPerformed(ActionEvent e) 
		{	
			if (n == 0)
			{
				++n;
				
				output.setText("Alright, do you want to skip the tutorial?");
			}
			
			if (n == 1)
			{
				if (input.getText().equalsIgnoreCase("yes") || input.getText().equalsIgnoreCase("no"))
					output.setText("You may only type Yes or No.");
					
				else 
				{
					++n;
					
					if (input.getText().equalsIgnoreCase("yes"))
					{
						x.setVisible(true);
						x.doBeginning = true;
					}
	
					else if (input.getText().equalsIgnoreCase("no"))
					{
						x.isFinished = true;
						x.setVisible(false);
						x.doBeginning = false;
					}
					
					isFinished = true;
				}
			}
		}
	}
}
