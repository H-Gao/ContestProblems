package PostItNotes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class PostItNoteManager extends SimpleWindow implements ActionListener
{
	boolean isHiding = false;
	boolean isDeleting = false;
	
	JButton addPostItNotes;
	JButton createPostItNotes;
	JButton deletePostItNotes;
	JButton hidePostItNotes;
	
	public PostItNoteManager()
	{
		super("Post It Notes", 800, 800, true);
	}
	
	public void createComponents()
	{
		createPostItNotes();
		
		addPostItNotes = new JButton("Show Post It Notes");
		addPostItNotes.setBounds(0, 445, 800, 75);
		addPostItNotes.addActionListener(this);
		add(addPostItNotes);
		
		createPostItNotes = new JButton("Create Post It Notes");
		createPostItNotes.setBounds(0, 520, 800, 75);
		createPostItNotes.addActionListener(this);
		add(createPostItNotes);
		
		deletePostItNotes = new JButton("Close Post It Notes (Without Saving)");
		deletePostItNotes.setBounds(0, 595, 800, 75);
		deletePostItNotes.addActionListener(this);
		add(deletePostItNotes);
		
		hidePostItNotes = new JButton("Hide Post It Notes");
		hidePostItNotes.setBounds(0, 670, 800, 75);
		hidePostItNotes.addActionListener(this);
		add(hidePostItNotes);
		
		setBackground("C:\\PostItNotes\\Images\\Manager.png");
		
		repaint();
	}
	
	public static void main(String[] args)
	{
		PostItNoteManager postItNoteManager = new PostItNoteManager();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == addPostItNotes)
		{
			createPostItNotes();
		}
		if (e.getSource() == createPostItNotes)
		{
			PostItNoteBase postItNoteBase = new PostItNoteBase(this);
			postItNoteBase.setVisible(true);
		}
		if (e.getSource() == deletePostItNotes)
		{
			if (!isDeleting)
				isDeleting = true;
			else
				isDeleting = false;
		}
		if (e.getSource() == hidePostItNotes)
		{
			if (!this.isHiding)
				this.isHiding = true;
			else
				this.isHiding = false;
		}
	}
	
	public void createPostItNotes()
	{
		try
		{
			File file = new File("C:\\PostItNotes\\pNote.txt");
			
			if (file.exists())
			{
				String selectedFile = "";
			
				FileReader reader = new FileReader(file);
				Scanner scanner = new Scanner(reader);
		
				if (scanner.hasNextLine())
					selectedFile += scanner.nextLine();
		
				while (scanner.hasNextLine())
					selectedFile += scanner.nextLine();
		
				String fileTitle = selectedFile.split(";")[0];
				String fileText = selectedFile.split(";")[1];
			
				PostItNoteBase postItNoteBase = new PostItNoteBase(this, file.getPath(), fileTitle, fileText);
				postItNoteBase.setVisible(true);
			}
			
			for (int n = 2;n != 11;++n)
			{
				file = new File(file.getPath().substring(0, file.getPath().length()-(4+((n+7)/10)))+n+".txt");
				
				if (file.exists())
				{
					String selectedFile = "";
				
					FileReader reader = new FileReader(file);
					Scanner scanner = new Scanner(reader);
			
					if (scanner.hasNextLine())
						selectedFile += scanner.nextLine();
			
					while (scanner.hasNextLine())
						selectedFile += scanner.nextLine();
			
					String fileTitle = selectedFile.split(";")[0];
					String fileText = selectedFile.split(";")[1];
				
					PostItNoteBase postItNoteBase = new PostItNoteBase(this, file.getPath(), fileTitle, fileText);
					postItNoteBase.setVisible(true);
				}
			}
		}
		catch (Exception exception) 
		{
			System.out.println("One or more files failed to open.");
			exception.printStackTrace();
		}
	}
}
