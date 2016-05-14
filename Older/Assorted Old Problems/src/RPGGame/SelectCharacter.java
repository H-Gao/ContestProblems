package RPGGame;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URI;

import javax.swing.*;

public class SelectCharacter extends JFrame
{
	Timer timer = new Timer(10, new timerListener());
	
	int time = -1;
	
	boolean isFinished = false;
	boolean doBeginning = true;
	
	String name;
	
	String classes;
	
	int progress = 0;
	
	JTextArea textArea = new JTextArea();
	JTextArea information = new JTextArea();
	JButton button = new JButton("Confirm.");
	
	JButton selectClassButton[] = new JButton[3];
	
	public SelectCharacter()
	{
		setTitle("Character Selection");
		setSize(1368, 735);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		checkBeginning();
		
		createTextArea();
		createButton();
		createInformationTextArea();
		
		timer.start();
	}
	
	public void checkBeginning()
	{
		if (!doBeginning)
		{
			isFinished = true;
			returnSelectCharacter().dispose();
		}
	}
	
	public void createTextArea()
	{
		textArea.setEditable(false);
		textArea.setBounds(5, 5, 1363, 200);
		add(textArea);
	}
	
	public void createButton()
	{
		button.setBounds(5, 210, 1363, 200);
		button.addActionListener(new buttonListener(0));
		add(button);
	}
	
	public void createInformationTextArea()
	{
		information.setBounds(-600, -600, 600, 200);
		add(information);
	}
	
	public void createSelectClassButtons()
	{
		for (int n = 0;n != 3;++n)
		{
			if (n == 0)
				selectClassButton[n] = new JButton("Sorcerer");
			
			if (n == 1)
				selectClassButton[n] = new JButton("Fire Mage");
			
			if (n == 2)
				selectClassButton[n] = new JButton("Paladin");
			
			selectClassButton[n].setBounds(5+(600*n)-(600*(n/2)), 210 + (200*(n/2)), 600, 200);
			selectClassButton[n].addActionListener(new buttonListener(n+1));
			selectClassButton[n].addMouseListener(new touchButtonListener(n));
			add(selectClassButton[n]);
		}
	}
	
	public SelectCharacter returnSelectCharacter()
	{
		return this;
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			++time;
			
			if (progress == 0)
			{		
				if (time < 200 && time%20==0)
					textArea.setText("Hello, please select a name. You may enter your name in... " + (10-(time/20)));
				
				if (time == 200)
				{
					textArea.setEditable(true);
					textArea.setText("");
				}
			}
			
			if (progress == 1)
			{
				++progress;
				
				try
				{
					Desktop desktop = Desktop.getDesktop();
					//desktop.browse(new URI("http://en.wikipedia.org/wiki/Role-playing_video_game"));
				}
				catch(Exception exception)
				{
					System.out.println("Something Broke.");
					exception.printStackTrace();
					returnSelectCharacter().dispose();
				}
			}
			
			if (progress == 2)
			{		
				textArea.setText("Hello, " + name + " remember to confirm you agree to the TERMS OF SERVICE.\n"
						+ termsOfService()
						+ "\nYou may confirm or close the windows to decline.");
			}
		}
	}
	
	public String termsOfService()
	{
		return ("\nTerms Of Service: \n"
				+ "----------------------------------------- \n"
				+ "Terms of service to be added.");
	}
	
	public class touchButtonListener implements MouseListener
	{
		int value;
		
		public touchButtonListener(int v)
		{
			value = v;
		}
		
		public void mouseClicked(MouseEvent e){}
		
		public void mousePressed(MouseEvent e){}

		public void mouseReleased(MouseEvent e){}

		public void mouseEntered(MouseEvent e) 
		{
			information.setLocation(5, 405);
			
			if (value == 0)
				information.setText("Sorcerer\n"
						+ "===================\n"
						+ "A magicien that practises dark magic.\n"
						+ "They attack using dark magic, and by transforming into\n"
						+ "dark creatures.\n"
						+ "Base Stats:\n"
						+ "Health: 120\n"
						+ "Armor: 10\n"
						+ "Damage: 20-100\n"
						+ "Movement Speed: 2\n"
						+ "Sprint: 100\n");
			
			if (value == 1)
				information.setText("Fire Mage");
			
			if (value == 2)
				information.setText("Paladin");
		}

		public void mouseExited(MouseEvent e)
		{
			information.setText("");
			information.setLocation(-600, -600);
		}
	}
	
	public class buttonListener implements ActionListener
	{
		int type = 0;
		
		public buttonListener(int value)
		{
			type = value;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (progress == 0)
			{
				if (!textArea.getText().contains("Hello, please select a name.") && !textArea.getText().equals(""))
				{
					++progress;
					name = textArea.getText();
				}
			}
			if (progress == 2)
			{
				++progress;
				button.setLocation(-800, -800);
				createSelectClassButtons();
				repaint();
			}
			
			if (progress == 3 && type > 0)
			{
				if (type == 1)
					classes = "Sorcerer";
				if (type == 2)
					classes = "Fire Mage";
				if (type == 3)
					classes = "Paladin";
					
				isFinished = true;
				returnSelectCharacter().dispose();
			}
		}
	}
}
