package PostItNotes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class PostItNoteBase extends SimpleWindow implements ActionListener, MouseMotionListener, MouseListener
{
	Timer timer = new Timer(100, this);
	
	PostItNoteManager manager;
	
	String fileName;
	
	boolean isMinimized = false;
	
	JTextField title;
	JTextArea text;
	
	JButton exit;
	JButton minimize;
	JButton move;
	
	public PostItNoteBase(PostItNoteManager m)
	{
		super("Post It Note", 400, 400, false);
		this.setUndecorated(true);
		this.addMouseListener(this);
		
		manager = m;
		
		fileName = "None";
		
		timer.start();
	}
	
	public PostItNoteBase(PostItNoteManager m, String fileNames, String fileTitle, String fileText)
	{
		super("Post It Note", 400, 400, false);
		this.setUndecorated(true);
		this.addMouseListener(this);
		
		manager = m;
		
		fileName = fileNames;
		
		title.setText(fileTitle);
		text.setText(fileText);
		
		timer.start();
	}
	
	public void createComponents()
	{
		exit = new JButton("X");
		exit.addActionListener(this);
		exit.setFont(new Font("TimesRoman", Font.PLAIN, 6));
		exit.setBounds(362, 0, 38, 38);
		add(exit);
		
		minimize = new JButton("-");
		minimize.addActionListener(this);
		minimize.setFont(new Font("TimesRoman", Font.PLAIN, 6));
		minimize.setBounds(324, 0, 38, 38);
		add(minimize);
		
		move = new JButton(">");
		move.addMouseMotionListener(this);
		move.setFont(new Font("TimesRoman", Font.PLAIN, 6));
		move.setBounds(0, 0, 38, 38);
		add(move);
		
		title = new JTextField("Enter Title Here");
		title.setOpaque(false);
		title.addMouseListener(this);
		title.setFont(new Font("Cambria", Font.ITALIC, 16));
		title.setBounds(38, 0, 324-38, 38);
		add(title);
		
		text = new JTextArea();
		text.setOpaque(false);
		text.addMouseListener(this);
		text.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		text.setBounds(0, 40, 400, 360);
		add(text);
		
		setBackground("C:\\PostItNotes\\Images\\Background.png");
		
		repaint();
	}
	
	public void minimizeWindow()
	{
		this.isMinimized = true;
		this.setSize(60, 60);
	}
	
	public void stopMinimizingWindow()
	{
		this.isMinimized = false;
		this.setSize(400, 400);
	}
	
	public void actionPerformed(ActionEvent e) 
	{	
		if (e.getSource() == exit)
		{
			try
			{
				System.out.println(fileName);
				
				if (fileName.equals("None"))
				{
					File file = new File("C:\\PostItNotes\\pNote.txt");
				
					for (int n = 2;file.exists();++n)
					{
						System.out.println(file.getPath().substring(0, file.getPath().length()-(4+((n+7)/10)))+n+".txt");
						file = new File(file.getPath().substring(0, file.getPath().length()-(4+((n+7)/10)))+n+".txt");
					}
				
					PrintWriter writer = new PrintWriter(file);
					
					if (!text.getText().equals(""))
						writer.write(title.getText() + ";" + text.getText());
					else
						writer.write(title.getText() + "; ");
					
					writer.close();
				
					this.dispose();
				}
				else
				{
					PrintWriter writer = new PrintWriter(fileName);
					
					if (!text.getText().equals(""))
						writer.write(title.getText() + ";" + text.getText());
					else
						writer.write(title.getText() + "; ");
					
					writer.close();
					
					this.dispose();
				}
			}
			catch (Exception exception)
			{
				System.out.println("We could not save the file!");
				exception.printStackTrace();
			}
		}
		if (e.getSource() == minimize)
		{
			this.minimizeWindow();
		}
		else
		{
			if (manager.isHiding)
				this.setVisible(false);
			
			if (!this.isVisible() && !manager.isHiding)
				this.setVisible(true);
		}
	}

	public void mouseDragged(MouseEvent e) 
	{
		if (isMinimized)
			this.setLocation(e.getXOnScreen() - 10, e.getYOnScreen() - 10);
		else
			this.setLocation(e.getXOnScreen() - 20, e.getYOnScreen() - 20);
	}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) 
	{
		if (manager.isDeleting)
			this.dispose();
		
		if (isMinimized)
		{
			this.stopMinimizingWindow();
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
