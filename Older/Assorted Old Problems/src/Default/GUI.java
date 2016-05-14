package Default;

import java.awt.event.*;

import javax.swing.*;

//Usually we like to write our applications inherited from JFrame, then our application is a JFrame too.
//and all methods in JFrame are avaliable for our application.

public class GUI extends JFrame
{
	public GUI()
	{
		setTitle("GUI Application");
		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton button = new JButton("Quit");
		button.setBounds(60, 60, 120, 60);
		button.addActionListener(new MyActionListener());
		add(button);
		
		JButton second_Button = new JButton();
		second_Button.setBounds(80, 120, 80, 40);
		add(second_Button);
	}
	
	public static void main(String[] args)
	{
		//In here we create Objects of GUI and then our program has a Frame.
		GUI simpleFrame = new GUI();
	}
	
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("A Button Has Been Clicked.");
		}
	}
}
