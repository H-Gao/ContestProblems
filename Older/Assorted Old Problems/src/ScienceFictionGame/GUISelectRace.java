package ScienceFictionGame;

import javax.swing.*;

import java.awt.event.*;

public class GUISelectRace extends JFrame
{
	boolean willClose = false;
	
	int time = 0;
	
	int race = -1;
	
	Timer timer = new Timer(10, new timeListener());
	String name = "";
	JTextArea text = new JTextArea();
	JTextArea input = new JTextArea();
	
	JButton imperial = new JButton("Imperial");
	JButton legion = new JButton("Legion");
	JButton venes = new JButton("Venes");
	
	public GUISelectRace()
	{
		setTitle("GameBaseTest");
		setSize(350, 600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addKeyListener(new inputListener());
		
		imperial.setBounds(0, -500, 100, 50);
		imperial.addActionListener(new raceListener(0));
		legion.setBounds(100, -500, 100, 50);
		legion.addActionListener(new raceListener(1));
		venes.setBounds(200, -500, 100, 50);
		venes.addActionListener(new raceListener(2));
		add(imperial);
		add(legion);
		add(venes);
		
		text.setEditable(false);
		text.setBounds(10, 50, 350, 200);
		add(text);
		
		input.setEditable(false);
		input.setBounds(10, 260, 350, 100);
		add(input);
		
		text.setText("Please enter a name.");
		
		timer.start();
	}
	
	public static void main(String[] args)
	{
		GUISelectRace guiSelectRace = new GUISelectRace();
	}
	
	public class inputListener implements KeyListener
	{
		public void keyTyped(KeyEvent e) 
		{
		}

		public void keyPressed(KeyEvent e)
		{
			input.setText(input.getText() + e.getKeyChar());
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				name = input.getText();
				input.setText("");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class raceListener implements ActionListener
	{
		int selector;
		
		public raceListener(int value)
		{
			selector = value;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			race = selector;
		}
	}
	
	public class timeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (!name.equals(""))
			{
				++time;
				
				if (time <= 400)
				{
					text.setLineWrap(true);
					text.setText("Hello, " + name
						+ "You are being promoted...\n"
						+ "you will now lead the SERPENT Program.\n"
						+ "as you may be aware, an ancient empire has fallen.\n"
						+ "They left behind many resources on their forgien lands.\n"
						+ "you need to acquire planets they abandoned.\n"
						+ "I assure it will not be easy.\n"
						+ "Three races will be trying to capture the same planets.\n"
						+ "There will be conflict. ");
				}
				else
				{					
					imperial.setLocation(0, 450);
					legion.setLocation(100, 450);
					venes.setLocation(200, 450);
					
					text.setSize(450, 400);
					input.setLocation(-100, -100);
							
					text.setText("Now, you have to choose a faction to side with.\n"
							+ "the three races are\n"
							+ "The Imperials:\n"
							+ "Humans, they are a growing race with little room left\n"
							+ "on earth. They are not very technologically advanced, but\n"
							+ "the overpopulation does bring some pros, for example\n"
							+ "they can aquire soldiers for very little resources!\n"
							+ "\n"
							+ "The Legion:\n"
							+ "Unknown race, they are a moderately advanced race.\n"
							+ "They have powerful infantry weapons and their tanks are not\n"
							+ "to be reckoned with.\n"
							+ "However, they have the worst aircraft.\n"
							+ "\n"
							+ "The Venes:\n"
							+ "A race of intellectuals, they have very advanced\n"
							+ "Vehicles and decent infantry.\n"
							+ "that beening said, they need a lot of resources to get going.\n"
							+ "\n"
							+ "Now pick!");
						}
				}
			}
		}
	}
