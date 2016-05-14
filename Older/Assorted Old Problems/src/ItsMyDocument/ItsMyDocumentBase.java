package ItsMyDocument;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import RPGGame.GameBase.keyListener;
import WindowDevelopmentClassesHenry.SimpleWindow;

public class ItsMyDocumentBase extends SimpleWindow implements ActionListener, MouseListener, MouseMotionListener
{
	Timer timer = new Timer(2000, this);
	static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	String name;
	
	int type = 0;
	
	JTextPane line[];
	JTextField title;
	JButton exitButton, minimize;
	JLabel topBar;
	
	public ItsMyDocumentBase() 
	{
		super("It's My Document", screenWidth, screenHeight, false);
		this.setUndecorated(true);
		this.setVisible(true);
		timer.start();
	}
	
	public void createComponents()
	{
		line = new JTextPane[100];
		
		title = new JTextField("This is my Document.");
		title.setEditable(false);
		title.setBounds(110, -60, 800, 200);
		title.setOpaque(false);
		title.setBorder(null);
		title.setFont(new Font("TimesNewRoman", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		exitButton = new JButton();
		exitButton.setBorder(null);
		exitButton.addMouseListener(this);
		exitButton.addActionListener(this);
		exitButton.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Exit.png"));
		exitButton.setBounds(this.screenWidth - 115, 0, 110, 60);
		add(exitButton);
		
		minimize = new JButton();
		minimize.setBorder(null);
		minimize.addMouseListener(this);
		minimize.addActionListener(this);
		minimize.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Minimize.png"));
		minimize.setBounds(this.screenWidth - 195, 5, 80, 40);
		add(minimize);
		
		topBar = new JLabel(new ImageIcon("C:\\It'sMyDocument\\Images\\GUI\\TopBar.png"));
		topBar.addMouseMotionListener(this);
		topBar.setBounds(this.screenWidth - 2000, -20, 2000, 140);
		add(topBar);
		
		initLine(0, 32);
		
		repaint();
	}
	
	public static void main(String[] args)
	{
		ItsMyDocumentBase itsMyDocumentBase = new ItsMyDocumentBase();
	}
	
	public void initLine(int index, int number)
	{
		for (int n = 0;n != number;++n)
		{
			line[index+n] = new JTextPane();
			line[index+n].setText(" ");
			line[index+n].setFont(new Font("TimesRoman", Font.PLAIN, 12));
			line[index+n].getInputMap().put( KeyStroke.getKeyStroke((char)KeyEvent.VK_ENTER), "nextLine");
			line[index+n].getActionMap().put("nextLine", new keybinding((char)KeyEvent.VK_ENTER));
			line[index+n].setBounds(20+(n*5), 100 + (20*n), this.screenWidth - 40, 20);
			add(line[index+n]);
		}
	}
	
	public void checkTitleLength()
	{
		if (title.getText().length() > 34)
			title.setText(title.getText().substring(0, 31) + "...");
	}
	
	public void checkTextLength()
	{
		for (int n = 1;n != line.length;++n)
		{
			if (line[n] != null)
			{
				int size = line[n].getFontMetrics(line[n].getFont()).stringWidth(line[n].getText());
				int widthOfLine = line[n].getWidth();
				
				if (size >= widthOfLine && line[n+1] != null)
				{
					line[n+1].setText(line[n].getText().substring(line[n].getText().length(), line[n].getText().length()) + line[n+1].getText());
					line[n].setText(line[n].getText().substring(0, line[n].getText().length()));
				}
			}
			else
				break;
		}
	}
	
	public void onClose()
	{
		this.dispose();
	}
	
	public void onMinimize()
	{
		if (this.getSize().getHeight() == 100)
			this.setSize(this.screenWidth, this.screenHeight);
		else
			this.setSize(this.screenWidth, 100);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == exitButton)
		{
			onClose();
		}
		
		else if (e.getSource() == minimize)
		{
			onMinimize();
		}
		
		else
		{
			checkTextLength();
		}
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		int mouseX = e.getXOnScreen();
		
		if (e.getSource() == topBar)
		{
			++type;
			
			if (type%2!=0)
				this.setLocation(e.getX(), e.getY());
			
			System.out.println(this.getX() + " " + this.getY());
			System.out.println(e.getX() + " " + e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) 
	{
		if (e.getSource() == exitButton)
		{
			exitButton.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Exit_Touched.png"));
		}
		
		else if (e.getSource() == minimize)
		{
			minimize.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Minimize_Touched.png"));
		}
	}

	public void mouseExited(MouseEvent e) 
	{
		if (e.getSource() == exitButton)
		{
			exitButton.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Exit.png"));
		}
		
		else if (e.getSource() == minimize)
		{
			minimize.setIcon(new ImageIcon("C:\\It'sMyDocument\\Images\\Components\\Minimize.png"));
		}
	}
	
	public class keybinding extends AbstractAction
	{
		char key;
		
		public keybinding(char n)
		{
			key = n;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (key == 'a')
			{
				System.out.println("Click.");
			}
			
			if (key == KeyEvent.VK_ENTER)
			{
				System.out.println("Click.");
			}
		}
	}
}
