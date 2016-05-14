package JavaClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class FrameAndButton extends SimpleWindow implements ActionListener
{
	int n;
	
	JButton button;
	
	public FrameAndButton() 
	{
		super("Frame and Button", 800, 800, true);
	}	
	
	public void createComponents()
	{
		button = new JButton("Press This.");
		button.addActionListener(this);
		button.setBounds(0, 0, 600, 100);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		++n;
		System.out.println(n);
	}
	
	public static void main(String[] args)
	{
		FrameAndButton frameAndButton = new FrameAndButton();
	}
}
