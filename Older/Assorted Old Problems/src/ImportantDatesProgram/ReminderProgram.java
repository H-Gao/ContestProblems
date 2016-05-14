package ImportantDatesProgram;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import WindowDevelopmentClassesHenry.*;

import javax.swing.*;

public class ReminderProgram extends SimpleWindow
{
	File file = new File("C:\\ReminderProgram\\reminders.txt");
	
	Timer timer = new Timer(1000, new timerListener());
	
	int setHour;
	int setMinute;
	
	int doneType = 0;
	
	boolean isFinished = false;
	
	
	JTextArea text;
	JButton addReminders;
	JButton removeReminders;
	JButton setAlarm;
	
	JTextField input;
	JButton done;
	
	public ReminderProgram()
	{
		super("Reminder Program", 800, 600, true);
		
		update();
		
		timer.start();
	}
	
	public static void main(String[] args)
	{
		ReminderProgram reminderProgram = new ReminderProgram();
	}
	
	public void createComponents()
	{
		System.out.println("It works.");
		
		text = new JTextArea();
		text.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		text.setBounds(5, 0, 790, 300);
		text.setEditable(false);
		add(text);
		
		addReminders = new JButton("Add Reminders");
		addReminders.addActionListener(new reminders(0));
		addReminders.setBounds(5, 310, 790, 80);
		add(addReminders);
		
		removeReminders = new JButton("Remove Reminders");
		removeReminders.addActionListener(new reminders(2));
		removeReminders.setBounds(5, 390, 790, 80);
		add(removeReminders);
		
		setAlarm = new JButton("Set Alarm");
		setAlarm.addActionListener(new reminders(3));
		setAlarm.setBounds(5, 470, 790, 80);
		add(setAlarm);
		
		input = new JTextField();
		input.setBounds(-1000, -1000, 790, 80);
		add(input);
		
		done = new JButton("Done.");
		done.addActionListener(new reminders(1));
		done.setBounds(-1000, -1000, 790, 80);
		add(done);
		
		updateWindows();
	}
	
	public void createInput(int n)
	{
		doneType = n;
		
		text.setLocation(-1000, -1000);
		input.setLocation(5, 0);
		done.setLocation(5, 80);
		
		updateWindows();
	}
	
	public ReminderProgram returnReminderProgram()
	{
		return this;
	}
	
	public void update()
	{
		try
		{
			File file = new File("C:\\ReminderProgram\\reminders.txt");
			
			String reminders;
			
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			
			reminders = scanner.nextLine() + "\n";
			
			while (scanner.hasNextLine())
				reminders += scanner.nextLine() + "\n";
			
			text.setText(reminders);
		}
		catch (FileNotFoundException fileException)
		{
			System.out.println("We could not find the file!\nError log can be found in ErrorLog.txt");
			returnReminderProgram().dispose();
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			System.exit(0);
		}
	}
	
	public class reminders implements ActionListener
	{
		int ID;
		
		public reminders(int n)
		{
			ID = n;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				String reminders;
				
				FileReader reader = new FileReader(file);
				Scanner scanner = new Scanner(reader);
				
				reminders = scanner.nextLine();
				
				while (scanner.hasNextLine())
					reminders += "\n" + scanner.nextLine();
				
				if (ID == 0)
				{
					createInput(0);
				}
				
				if (ID == 1)
				{
					if (doneType == 0)
					{
						PrintWriter writer = new PrintWriter(file);
						writer.println(reminders + "\n" + input.getText());
						writer.flush();
					
						text.setLocation(5, 10);
						input.setLocation(-1000, -1000);
						done.setLocation(-1000, - 1000);
						update();
					}
					
					else if (doneType == 1)
					{
						String[] data = new String[100];
						
						FileReader reader2 = new FileReader(file);
						Scanner scanner2 = new Scanner(reader2);
						
						for (int n = 0;scanner2.hasNextLine();++n)
						{
							data[n] = scanner2.nextLine();
							System.out.println(data[n]);
						}
						
						PrintWriter writer2 = new PrintWriter(file);
						
						for (int n = 0;n != 100;++n)
						{
							if (n != Integer.parseInt(input.getText()) && data[n] != null)
								writer2.println(data[n]);
						}
						
						writer2.flush();
						
						text.setLocation(5, 10);
						input.setLocation(-1000, -1000);
						done.setLocation(-1000, - 1000);
						update();
					}
					
					else if (doneType == 2)
					{	
						PrintWriter writer3 = new PrintWriter("C:\\ReminderProgram\\time.txt");
						writer3.println(Integer.parseInt(input.getText().split(":")[0]) + ":" + Integer.parseInt(input.getText().split(":")[1]));
						writer3.flush();
						
						text.setLocation(5, 10);
						input.setLocation(-1000, -1000);
						done.setLocation(-1000, - 1000);
						update();
					}
				}
				
				if (ID == 2)
				{
					createInput(1);
				}
				
				if (ID == 3)
				{
				    createInput(2);
				}
			}
			catch (FileNotFoundException fileException)
			{
				System.out.println("We could not find the file!\nThe Error can be found in the Error Log");
				returnReminderProgram().dispose();
			}
			catch (Exception exception) 
			{
				exception.printStackTrace();
			}
		}
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				FileReader reader4 = new FileReader("C:\\ReminderProgram\\time.txt");
				Scanner scanner4 = new Scanner(reader4);
				
				String[] time = scanner4.next().split(":");
				
				setHour = Integer.parseInt(time[0]);
				setMinute = Integer.parseInt(time[1]);
				
				Calendar cal= new GregorianCalendar();
				int hour=cal.get(Calendar.HOUR);
				int minute=cal.get(Calendar.MINUTE);
		    
				String reminders2;
		    
				FileReader reader3 = new FileReader(file);
				Scanner scanner3 = new Scanner(reader3);
			
				reminders2 = scanner3.nextLine();
			
				while (scanner3.hasNextLine())
					reminders2 += "\n" + scanner3.nextLine();
				
				System.out.println(setHour + " " + setMinute);
		    
				if (hour == setHour && minute == setMinute && !isFinished)
				{
					System.out.println("It works.");
					
					Alarm alarm = new Alarm(reminders2, returnReminderProgram());
					
					text.setLocation(5, 10);
					input.setLocation(-1000, -1000);
					done.setLocation(-1000, - 1000);
					update();
					
					isFinished = true;
				}
				else if (hour != setHour || minute != setMinute)
				{
					isFinished = false;
				}
			}
			catch (Exception exception) { exception.printStackTrace(); }
		}
	}
}
