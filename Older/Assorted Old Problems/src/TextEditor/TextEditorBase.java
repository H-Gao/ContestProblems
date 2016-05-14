package TextEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.*;

public class TextEditorBase extends JFrame
{
	int time = 0;
	
	Timer timer = new Timer(10, new timerListener());
	
	String name = "TextEditor";
	
	JTextField selectName = new JTextField();
	JButton done = new JButton("Done.");
	JButton save = new JButton("Save.");
	JButton autoSave = new JButton("Auto Save");
	
	JTextArea textArea = new JTextArea();
	
	public TextEditorBase()
	{
		this.setTitle(name);
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		createComponents();
		
		timer.start();
	}
	
	public void createComponents()
	{
		textArea.setBounds(10, 60, 580, 530);
		add(textArea);
		
		save.setBounds(0, 0, 100, 40);
		save.addActionListener(new actionListener(1));
		add(save);
		
		autoSave.setBounds(105, 0, 100, 40);
		autoSave.addActionListener(new actionListener(2));
		add(autoSave);
		
		selectName.setBounds(-800, -800, 200, 50);
		add(selectName);
		
		done.setBounds(-800, -800, 100, 50);
		done.addActionListener(new actionListener(0));
		add(done);
		
		repaint();
	}
	
	public static void main(String[] args)
	{
		TextEditorBase textEditor = new TextEditorBase();
	}
	
	public TextEditorBase returnTextEditor()
	{
		return this;
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			++time;
			
			if (time%100==0)
				System.out.println("The file will auto-save in " + 10*(10000/time) + "seconds.");
			
			if (time == 10000)
			{
				save();
				time = 0;
			}
		}
	}
	
	public class actionListener implements ActionListener
	{
		int n;
		
		public actionListener(int x)
		{
			n = x;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (n == 0)
			{
				try
				{
					name = selectName.getText();
				
					returnTextEditor().setTitle(name);
				
					File file = new File("C:\\JavaProjects\\TextEditor\\"+name+".txt");
					file.createNewFile();
				
					PrintWriter writer = new PrintWriter(file);
					writer.println(textArea.getText());
					writer.flush();
				
					selectName.setLocation(-800, -800);
					done.setLocation(-800, -800);
				}
				catch (Exception exception)
				{
					System.out.println("Something broke.");
					exception.printStackTrace();
				}
			}
			
			else if (n == 1)
				save();
			
			else if (n == 2)
			{
				if (timer.isRunning())
					timer.stop();
				else
					timer.start();
			}
		}
	}
	
	public void save()
	{
		selectName.setLocation(260, 0);
		done.setLocation(365, 0);
		
		repaint();
	}
}
