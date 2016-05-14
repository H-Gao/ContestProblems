package Default;

import javax.swing.*;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Slideshow extends JFrame
{
	Timer timer = new Timer(2000, new LoopListener());
		
	int n = 0;
	
	JLabel picture[];
	JLabel frame;
	
	JButton pause;
	JButton start;
	JButton next;
	JButton back;
	
	public Slideshow()
	{
		setTitle("Slideshow");
		
		setSize(1366, 728);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try 
		{
			FileReader reader = new FileReader("C:\\Slideshow\\PictureFiles.txt");
			Scanner in = new Scanner(reader);
			String pictures = in.nextLine();
			
			String imageFile[] = pictures.split(",");
			
			setButtons(imageFile);
			
			repaint();
		} 
		catch (FileNotFoundException e){}
	}
	
	public void setButtons(String imageFile[])
	{		
		picture = new JLabel[imageFile.length];
		
		for (int n = 0;n != imageFile.length;++n)
		{	
			picture[n] = new JLabel(new ImageIcon("C:\\Slideshow\\" + imageFile[n] + ".png"));
			picture[n].setBounds(-1000, -1000, picture[n].getIcon().getIconWidth(), picture[n].getIcon().getIconHeight());
			add(picture[n]);
		}
		
		picture[0].setLocation(50, 50);
		
		frame = new JLabel(new ImageIcon("C:\\Slideshow\\"+"Frame"+".png"));
		frame.setBounds(0, 0, getWidth(), getHeight());
		add(frame);
		
		pause = new JButton("Pause");
		pause.setBounds(1100, 200, 200, 100);
		pause.addActionListener(new ButtonListener(3));
		add(pause);
		
		start = new JButton("Start");
		start.setBounds(1100, 310, 200, 100);
		start.addActionListener(new ButtonListener(4));
		add(start);
		
		next = new JButton("Next");
		next.setBounds(1100, 420, 200, 100);
		next.addActionListener(new ButtonListener(0));
		add(next);
		
		back = new JButton("Back");
		back.setBounds(1100, 530, 200, 100);
		back.addActionListener(new ButtonListener(1));
		add(back);
		
		timer.start();
	}
	
	public class LoopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				FileReader reader = new FileReader("C:\\Slideshow\\PictureFiles.txt");
				Scanner in = new Scanner(reader);
				String pictures = in.nextLine();
				
				String imageFile[] = pictures.split(",");
				
				for (int k = 0;k != imageFile.length;++k)
				picture[k].setLocation(-1000, -1000);
				
				++n;
				
				if (n >= imageFile.length) n = 0;
				
				picture[n].setLocation(50, 50);
			}
			 catch (FileNotFoundException exception){}
			
			repaint();
		}
	}
	
	public class ButtonListener implements ActionListener
	{
		int ButtonID;
		
		public ButtonListener(int value)
		{
			ButtonID = value;
		}

		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				FileReader reader = new FileReader("C:\\Slideshow\\PictureFiles.txt");
				Scanner in = new Scanner(reader);
				String pictures = in.nextLine();
				
				String imageFile[] = pictures.split(",");
				
				if (ButtonID < 3)
				{
					for (int k = 0;k != imageFile.length;++k)
					picture[k].setLocation(-1000, -1000);
				
					if (ButtonID == 0) ++n;
			
					else if (ButtonID == 1) --n;
				
					if (n >= imageFile.length) n = 0;
					 else if (n < 0) n = imageFile.length-1;
				
					picture[n].setLocation(50, 50);
					
					repaint();
				}
				else if (ButtonID == 3) timer.stop();
				 else if (ButtonID == 4) timer.start();
			}
			 catch (FileNotFoundException exception){}
		}
	}
	
	public static void main(String[] args)
	{
		Slideshow slideshow = new Slideshow();
	}
}
