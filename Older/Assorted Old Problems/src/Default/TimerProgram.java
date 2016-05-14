package Default;

import java.awt.event.*;

import javax.swing.*;

public class TimerProgram extends JFrame
{
	int time = 0;
	
	Timer timer = new Timer(1000, new timerListener());
	JTextArea text = new JTextArea();
	JButton button = new JButton("Start");
	
	public TimerProgram()
	{
		setTitle("Timer");
		setSize(600, 600);
		setLayout(null);
		setVisible(true);
		
		text.setBounds(5, 50, 600, 100);
		add(text);
		
		button.setBounds(5, 160, 600, 100);
		button.addActionListener(new textListener());
		add(button);
	}

	public static void main(String[] args)
	{
		TimerProgram timerProgram = new TimerProgram();
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			++time;
			
			if (time/60==1)
				text.setText(""+time/60 + " Minute." + " " + time%60 + " Seconds.");
			
			else if (time > 60)
				text.setText(""+time/60 + " Minutes" + " " + time%60 + " Seconds.");
			
			else if (time == 1)
				text.setText(""+time + " Second.");
			
			else
				text.setText(""+time + " Seconds.");
		}
	}
	
	public class textListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (!timer.isRunning())
				timer.start();
			else
				timer.stop();
		}
	}
}
