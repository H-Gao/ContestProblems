package HenryDocuments;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class EditorManager extends SimpleWindow
{
	JFileChooser chooser;
	JButton openFile;
	
	public EditorManager() 
	{
		super("Henry Document",(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(),true,true);
	}
	
	public void createComponents()
	{
		chooser = new JFileChooser();
		chooser.setSelectedFile(new File("C:\\Users\\Henry\\Documents\\'HenryDocument\\New Document.txt"));
		chooser.setBounds(-1000, -1000, 480, 480);
		chooser.addActionListener(new actionListener(1));
		add(chooser);
		
		openFile = new JButton("Select Files");
		openFile.setIcon(new ImageIcon("C:\\HenryDocument\\Images\\StartScreen\\Button.png"));
		openFile.addActionListener(new actionListener(0));
		openFile.setBounds(10, 520, 860, 160);
		add(openFile);
		
		this.setBackground("C:\\HenryDocument\\Images\\StartScreen\\StartScreen.png");
		
		repaint();
	}
	
	public EditorManager returnEditorManager()
	{
		return this;
	}
	
	public class actionListener implements ActionListener
	{
		int ID;
		
		public actionListener(int n)
		{
			ID = n;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (ID == 0)
			{
				chooser = new JFileChooser();
				chooser.setSelectedFile(new File("C:\\HenryDocument\\ "));
				chooser.setBounds(868, 10, 480, 480);
				chooser.addActionListener(new actionListener(1));
				returnEditorManager().add(chooser);
				
				repaint();
			}
			
			if (ID == 1)
			{
				EditorBase editor = new EditorBase(chooser.getSelectedFile().toString());
				
				chooser.setBounds(-1000, -1000, 480, 480);
				
				repaint();
			}
			
			returnEditorManager().setVisible(false);
			returnEditorManager().setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{
		EditorManager manager = new EditorManager();
	}
}
