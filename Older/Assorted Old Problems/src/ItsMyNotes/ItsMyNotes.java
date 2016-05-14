package ItsMyNotes;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class ItsMyNotes extends SimpleWindow implements ActionListener, MouseListener
{
	Timer timer = new Timer(10, this);
	
	int EncryptKey = 1;
	int EncryptKey2 = 3;
			
	String file_Name;
	
	JButton exit;
	
	JTextField title;
	
	JTextArea text;
	
	FontMetrics dimensionFinder = text.getFontMetrics(text.getFont());
	
	public ItsMyNotes() 
	{
		super("It's My Notes", 350, 450, false);
		
		this.setUndecorated(true);
		this.setVisible(true);
		
		timer.start();
	
		System.out.println(encrypt("It works.", "It works.".length()-1));
		System.out.println(decrypt("Bmphkdl'", "Bmphkdl'".length()-1));
	}
	
	public void createComponents()
	{
		exit = new JButton();
		exit.addActionListener(this);
		exit.addMouseListener(this);
		exit.setIcon(new ImageIcon("C:\\It'sMyNotes\\Images\\TopBar\\Exit.png"));
		exit.setBorder(null);
		exit.setBounds(310, 0, 42, 25);
		add(exit);
		
		title = new JTextField("My Note.");
		title.setOpaque(false);
		title.setBorder(null);
		title.setFont(new Font("TimeNewRoman", Font.PLAIN, 18));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setBounds(0, 0, 280, 30);
		add(title);
		
		text = new JTextArea();
		text.setOpaque(false);
		text.setBorder(null);
		text.setFont(new Font("TimeNewRoman", Font.PLAIN, 12));
		text.setBounds(0, 50, 350, 400);
		add(text);
		
		this.setBackground("C:\\It'sMyNotes\\Images\\Background\\Background.png");
	}
	
	public static void main(String[] args)
	{
		ItsMyNotes itsMyNotes = new ItsMyNotes();
	}
	
	public void requestExit()
	{
		this.save();
		this.dispose();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == exit)
		{
			this.requestExit();
		}
		else
		{
			String[] lines = text.getText().split("\\n");
		}
	}
	
	public void save()
	{
		try
		{
			String fileName = "C:\\It'sMyNotes\\Notes\\Note_1";
		
			for (int i = 1;new File(fileName + ".imn").exists();++i)
				fileName = "C:\\It'sMyNotes\\Notes\\Note_"+i;
				
			PrintWriter fileSaver = new PrintWriter(new File(fileName + ".imn"));
			PrintWriter dataSaver = new PrintWriter(new File(fileName + ".imnd"));
			
			String[] lines = text.getText().split("\\n");
		
			for (int i = 0;i != lines.length;++i)
				fileSaver.println(encrypt(lines[i], lines[i].length()-1));
			
			fileSaver.flush();
			
			dataSaver.print(title.getText() + ";" + this.getX() + ";" + this.getY());
			dataSaver.flush();
		} 
		
		catch (FileNotFoundException exception)
		{
			System.out.println("Saving aborted. An error occured.");
		}
	}
	
	public String encrypt(String str, int n)
	{
		int EncryptAmount = ((EncryptKey2-EncryptKey)-(EncryptKey2*EncryptKey2));
		
		if (n == 0)
		{
			return String.valueOf((char)(str.charAt(0)+EncryptAmount));
		}
		else
		{
			String lastStr = encrypt(str, n-1);
			return lastStr + String.valueOf((char)(str.charAt(n)+EncryptAmount));
		}
	}
	
	public String decrypt(String str, int n)
	{
		int DecryptAmount = ((EncryptKey2-EncryptKey)-(EncryptKey2*EncryptKey2));
		
		if (n == 0)
		{
			return String.valueOf((char)(str.charAt(0)-DecryptAmount));
		}
		else
		{
			String lastStr = decrypt(str, n-1);
			return lastStr + String.valueOf((char)(str.charAt(n)-DecryptAmount));
		}
	}
	
	public void getLineSize(String[] lines, int n)
	{
		int size = dimensionFinder.stringWidth(lines[n]);
		
		if (n == 0)
		{
			if (size > 350)
			{
				System.out.println(size);
			}
		}
		else
		{
			getLineSize(lines, n-1);
			
			if (size > 350);
			{
				System.out.println("*******"+size);
			}
		}
	}
	
	public void shiftLines(String[] lines, int n)
	{
	}

	public void mouseEntered(MouseEvent e) 
	{
		if (e.getSource() == exit)
		{
			exit.setIcon(new ImageIcon("C:\\It'sMyNotes\\Images\\TopBar\\Exit_Touched.png"));
		}
	}

	public void mouseExited(MouseEvent e) 
	{
		if (e.getSource() == exit)
		{
			exit.setIcon(new ImageIcon("C:\\It'sMyNotes\\Images\\TopBar\\Exit.png"));
		}
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
}

/* User Guide: March 27th, 2014.
 * 
 * Note: Remember to finish your geography presentation.
 * 
 * It's My Notes.
 * ===================
 * Made by Henry Gao.
 * Started at: March 26th, 2014.
 * Finished at: ------.
 * ===================
 * Purpose to provide the user Sticky Notes.
 * The sticky notes will save the notes in
 * .imn and .imnd files.
 * They will be encrypted with a special changeable key.
 * The notes will also save line by line.
 * ===================
 * .imn files stand for .It's My Notes files.
 * They will store the text, but will not store
 * extra data such as the name and version.
 * They will be encrypted.
 * ===================
 * .imnd files stand for .It's My Notes Data files.
 * They store the extra data, but not the text.
 * They will be encrypted, as well.
 */
