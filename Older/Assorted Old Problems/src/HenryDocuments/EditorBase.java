package HenryDocuments;

import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

import WindowDevelopmentClassesHenry.SimpleWindow;

public class EditorBase extends SimpleWindow
{
	int actionID = 0;
	
	String name = "New Document";
	
	JFileChooser chooser;
	
	JTextPane text;
	
	JButton newDocument;
	JButton save;
	JButton open;
	
	public EditorBase() 
	{
		super("", (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), true, true);
	}
	
	public EditorBase(String path) 
	{
		super(path, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), true);
		this.open(path);
		System.out.println(path);
	}
	
	public void createComponents()
	{
		this.chooser = new JFileChooser();
		this.chooser.addActionListener(new actionListener("File Chooser"));
		this.chooser.setBounds(-1000,-1000, 400, 400);
		this.add(chooser);
		
		this.text = new JTextPane();
		this.text.setBounds(0, 20, 900, 700);
		this.add(text);
		
		this.newDocument = new JButton("New");
		this.newDocument.addActionListener(new actionListener("Create New Document"));
		this.newDocument.setBounds(0, 0, 100, 20);
		this.add(newDocument);
		
		this.save = new JButton("Save");
		this.save.addActionListener(new actionListener("Save"));
		this.save.setBounds(100, 0, 100, 20);
		this.add(save);
		
		this.open = new JButton("Open");
		this.open.addActionListener(new actionListener("Open"));
		this.open.setBounds(200, 0, 100, 20);
		this.add(open);
		
		this.repaint();
	}
	
	public void createNewDocument()
	{
		String path = "C:\\Users\\Henry\\Documents\\'HenryDocument\\New Document";
		
		File file = new File(path+".txt");
		
		System.out.println("***"+file);
		
		if (file.exists())
		{
			for (int n = 2;file.exists();++n)
			{
				System.out.println(file);
				file = new File(path+n+".txt");
			}
		}
		
		System.out.println(file);
		
		this.setTitle(file.getName());
		text.setText("");
	}
	
	public void open(String path)
	{
		String importedText = "";
		
		this.name = new File(path).getName();
		
		this.setTitle(name);
		
		try
		{
			FileReader reader = new FileReader(path);
			Scanner scanner = new Scanner(reader);
			
			String[] data = scanner.nextLine().split(";");
			
			if (scanner.hasNextLine())
			{
				importedText = scanner.nextLine();
				
				while (scanner.hasNextLine())
					importedText += scanner.nextLine();
			}
			
			if (Boolean.parseBoolean(data[0]))
				text.setEditable(true);
			else
				text.setEditable(false);
		}
		catch (Exception exception)
		{
			System.out.println("The file was not found.");
			exception.printStackTrace();
		}
		finally
		{
			text.setText(importedText);
		}
	}
	
	public void save(String path)
	{
		try
		{
			PrintWriter writer = new PrintWriter(path);
			
			writer.print("true;0\n");
			writer.print(text.getText());
			
			writer.flush();
			
			name = new File(path).getName();
			
			this.setTitle(name);
		}
		catch (Exception exception) {}
	}
	
	public void callFileChooser(int n)
	{
		System.out.println(chooser.getLocation());
		
		if (n == 0)
			chooser.setApproveButtonText("Save");
		
		if (n == 1)
			chooser.setApproveButtonText("Open");
		
		actionID = n;
		chooser.setLocation(900, 10);
	}
	
	public EditorBase returnEditorBase()
	{
		return this;
	}
	
	public void reloadWindow()
	{
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public class actionListener implements ActionListener
	{
		String ID;
		
		public actionListener(String identification)
		{
			ID = identification;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (ID.equals("File Chooser") && chooser.getSelectedFile().toString() != null)
			{
					System.out.println(chooser.getSelectedFile().toString());

					if (actionID == 0)
					{
						if (chooser.getSelectedFile().toString().contains(".txt"))
							save(chooser.getSelectedFile().toString());
						else
							save(chooser.getSelectedFile().toString() + ".txt");
					}
				
					if (actionID == 1)
					{
						if (chooser.getSelectedFile().toString().contains(".txt"))
							open(chooser.getSelectedFile().toString());
						else	
							open(chooser.getSelectedFile().toString() + ".txt");
					}
					
					chooser.setBounds(-1000,-1000, 400, 400);
					reloadWindow();
			}
			
			if (ID.equals("Save"))
			{
				callFileChooser(0);
			}
			
			if (ID.equals("Open"))
			{
				callFileChooser(1);
			}
			
			if (ID.equals("Create New Document"))
			{
				createNewDocument();
			}
		}
	}
}
