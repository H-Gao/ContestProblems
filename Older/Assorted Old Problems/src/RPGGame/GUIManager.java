package RPGGame;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.*;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class GUIManager extends JFrame
{
	String name = "Default Player";
	String playerClass = "Sorcerer";
	
	Timer timer = new Timer(10, new timerListener());
	
	SelectCharacter selectCharacter = new SelectCharacter();
	StartScreen startScreen;
	
	public GUIManager()
	{
		setTitle("GUIManager");
		setSize(10, 10);
		setVisible(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		timer.start();
	}
	
	public static void main(String[] args)
	{
		GUIManager guiManager = new GUIManager();
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
		  try
		  {
			FileReader reader = new FileReader("C:\\RPG\\ProgramInfo\\beginningInfo.txt");
			FileReader reader2 = new FileReader("C:\\RPG\\PlayerData\\Player.txt");
			Scanner scanner = new Scanner(reader);
			Scanner scanner2 = new Scanner(reader2);
			
			int hasFinishedBeginning = scanner.nextInt();
			
			if (startScreen != null && startScreen.isFinished)
			{
				GameBase gameBase = new GameBase();
				startScreen.isFinished = false;
				
				gameBase.player.name = selectCharacter.name;
				gameBase.player.playerClass = selectCharacter.classes;
				
				PrintWriter writer = new PrintWriter("C:\\RPG\\ProgramInfo\\beginningInfo.txt");
				writer.println("1");
				writer.close();
				
				if (gameBase.player.playerClass.equals("Sorcerer"))
				{
					gameBase.player.health = 120;
					gameBase.player.damage = 20;
					gameBase.player.movementSpeed = 2;
					gameBase.player.max_Health = gameBase.player.health;
					gameBase.player.max_Damage = gameBase.player.damage;
					gameBase.player.max_MovementSpeed = gameBase.player.movementSpeed*2;
					gameBase.player.sprint = 100;
				}
					
				if (gameBase.player.playerClass.equals("Fire Mage"))
				{
					gameBase.player.health = 80;
					gameBase.player.damage = 10;
					gameBase.player.movementSpeed = 1;
					gameBase.player.max_Health = gameBase.player.health;
					gameBase.player.max_Damage = gameBase.player.damage;
					gameBase.player.max_MovementSpeed = gameBase.player.movementSpeed*2;
					gameBase.player.sprint = 100;
				}
					
				if (gameBase.player.playerClass.equals("Paladin"))
				{
					gameBase.player.health = 200;
					gameBase.player.damage = 30;
					gameBase.player.movementSpeed = 3;
					gameBase.player.max_Health = gameBase.player.health;
					gameBase.player.max_Damage = gameBase.player.damage;
					gameBase.player.max_MovementSpeed = gameBase.player.movementSpeed*2;
					gameBase.player.sprint = 100;
				}
			
				timer.stop();
			}
			
			if (hasFinishedBeginning == 0 && selectCharacter.isFinished)
			{
				startScreen = new StartScreen();
				selectCharacter.isFinished = false;
			}
			
			else if (hasFinishedBeginning == 1)
			{
				GameBase gameBase = new GameBase();
				gameBase.player.name = name;
				gameBase.player.playerClass = playerClass;
				
				gameBase.player.health = 120;
				gameBase.player.damage = 20;
				gameBase.player.movementSpeed = 2;
				gameBase.player.max_Health = gameBase.player.health;
				gameBase.player.max_Damage = gameBase.player.damage;
				gameBase.player.max_MovementSpeed = gameBase.player.movementSpeed*2;
				gameBase.player.sprint = 100;
				timer.stop();
			}
		  }catch (Exception exception) {exception.printStackTrace();timer.stop();}
		}
	}
}
