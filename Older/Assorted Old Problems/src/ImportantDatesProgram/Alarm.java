package ImportantDatesProgram;

import java.awt.Font;

import javax.swing.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class Alarm extends SimpleWindow
{
	JTextArea text;
	String reminder;
	
	public Alarm(String reminderP, ReminderProgram reminderProgram)
	{
		super("Alarm", 800, 600, true);
		
		reminder = reminderP;
		
		text.setFont(new Font("IMPACT", Font.BOLD, 48));
		text.setText("Have you finished these events?\n" + reminder);
	}
	
	public void createComponents()
	{
		text = new JTextArea();
		text.setBounds(0, 0, 800, 600);
		add(text);
	}
}
