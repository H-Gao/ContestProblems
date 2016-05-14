package RPGGame;

import javax.swing.*;


import java.util.Random;

import ScienceFictionGame.Bullet;
import ScienceFictionGame.GameBaseCharacter;

import java.awt.event.*;

public class GameBase extends JFrame
{
	//If you are seeing this and your name is not Henry, you are probably a hacker. (Although, I suppose a hacker could be named Henry too,
	//if this is the case... Oh well!) Anyways, Enjoy the program! :) One more thing, remind me I need a new anti-virus.
	
	Equipment equipment[] = new Equipment[100];
	
	Random random = new Random();
	
	Stats stats = new Stats();
	
	int stepResetTime = 0;
	int step = 0;
	
	int swingTime = -1;
	
	int spellSpeed = 0;
	
	Background background = new Background(0, this);
	
	Timer timer = new Timer(10, new timeListener());
	
	StatusBar healthBar = new StatusBar(this);
	StatusBar sprintBar = new StatusBar(this, healthBar);
	
	ActiveSpells fireball[] = new ActiveSpells[100];
	ActiveSpells soulBurst[] = new ActiveSpells[100];
	ActiveSpells demonRage[] = new ActiveSpells[10];
	
	Goblin goblin = new Goblin(this, 10, 600);
	
	JLabel soulBurstParticle = new JLabel(new ImageIcon("C:\\RPG\\Spells\\SoulBurst_Particle.png"));
	
	int time = 0;
	
	int ID[] = new int[10];
	
	char spellAttacks[] = new char[10];
	
	boolean hasFinished;
	
	char move_Left = 'a';
	char move_Right = 'd';
	char move_Up = 'w';
	char move_Down = 's';
	
	char view_Inventory = '1';
	char view_Equipment = '2';
	char view_KeyBinding = '3';
	
	String sprint = "SPACE";
	
	Player player = new Player(this, 0, 0);
	
	public GameBase()
	{
		try
		{
		setTitle("RPG Game");
		setSize(1368, 735);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		doKeys();
		
		doSoulBurstParticle();
		
		hasFinished = true;
		
		swingTime = 0;
		
		doSwing();
		
		addItem("SorcererStaff", 85, 108);
		
		spellAttacks[0] = 'f';
		spellAttacks[1]= 'e';
		spellAttacks[2]= 'r';
		
		for (int n = 0;n != 10;++n)
		{
			player.getInputMap().put(KeyStroke.getKeyStroke(spellAttacks[n]), "spellAttack"+n);
			player.getActionMap().put("spellAttack"+n, new keyListener((char)(3+n)));
		}
		
		timer.start();
		}
		catch (Exception e) 
		{doError(e);}
	}
	
	public void goToPoint(ActiveSpells character, Player start, Goblin player, int spellSpeed, double recalFactor)
	{
		int monsterX = player.getX() - (int) Math.round(spellSpeed*recalFactor);
		
		if (character.isMoving)
		{
			character.setLocation((int)character.getX() - Math.round((start.getX() - monsterX)/spellSpeed), (int)character.getY() - Math.round((start.getY() - player.getY())/spellSpeed));
			
			if (character.getX() > (player.getX() + player.getIcon().getIconWidth()) && character.getX() < (player.getX() - player.getIcon().getIconWidth()) && character.getY() > (player.getY() + player.getIcon().getIconHeight()) && character.getY() < (player.getY() - player.getIcon().getIconHeight()))
				System.out.println("It Works.");
		}
	}
	
	public class keyListener extends AbstractAction
	{
		char n;
		
		public keyListener(char value)
		{
			n = value;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			movePlayer(n, player);
		}
	}
	
	public void doKeys()
	{
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Left), "moveLeft");
		player.getActionMap().put("moveLeft", new keyListener(move_Left));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Right), "moveRight");
		player.getActionMap().put("moveRight", new keyListener(move_Right));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Up), "moveUp");
		player.getActionMap().put("moveUp", new keyListener(move_Up));
		
		player.getInputMap().put( KeyStroke.getKeyStroke(move_Down), "moveDown");
		player.getActionMap().put("moveDown", new keyListener(move_Down));
		
		player.getInputMap().put(KeyStroke.getKeyStroke(sprint), "sprint");
		player.getActionMap().put("sprint", new keyListener((char)1));
		
		player.getInputMap().put(KeyStroke.getKeyStroke(view_Inventory), "viewInventory");
		player.getActionMap().put("viewInventory", new keyListener(view_Inventory));
		
		player.getInputMap().put(KeyStroke.getKeyStroke(view_Equipment), "viewEquipment");
		player.getActionMap().put("viewEquipment", new keyListener(view_Equipment));
		
		player.getInputMap().put(KeyStroke.getKeyStroke(view_KeyBinding), "viewKeyBinding");
		player.getActionMap().put("viewKeyBinding", new keyListener(view_KeyBinding));
	}
	
	public void addItem(String name, int x, int y)
	{
		++ID[3];
		
		equipment[ID[3]] = new Equipment(this, name, x, y);
	}
	
	public void executeSpell(Spells spells[], String name, int n, int numTimes, int spellTime, int livingTime)
	{
		if (hasFinished)
		{
			for (int i = 0;i != numTimes;++i)
			{
				spellSpeed = spellTime;
					
				++ID[n];
		
				if (ID[n] >= 100)
					ID[n] = 0;
		
				if (spells[ID[n]] == null)
				{
					spells[ID[n]] = new ActiveSpells(this, name, new ImageIcon("C:\\RPG\\Spells\\"+name+"_0.png"), livingTime);
					add(spells[ID[n]]);
				}
			
				doSwing();
			
				spells[ID[n]].isMoving = true;
				spells[ID[n]].setLocation(player.getX() + random.nextInt(20) - 10, player.getY() + (random.nextInt(20) + 10));
				spells[ID[n]].setVisible(true);
			}
		}
	}
	
	public void doResetStep()
	{
		++stepResetTime;
		
		if (stepResetTime > 10)
			step = 0;
	}
	
	public void doSwing()
	{
		if (hasFinished)
		{
			swingTime = time;
			hasFinished = false;
		}
	}
	
	public void doSoulBurstParticle()
	{
		soulBurstParticle.setBounds(0, 0, 32, 32);
		add(soulBurstParticle);
	}
	
	public void executeSwing(int direction)
	{
		if (!hasFinished)
		{		
			if (swingTime > 920)
				swingTime = 0;
			
			if (time > swingTime + (20-spellSpeed))
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Slash\\Player_"+direction+"_Slash.png"));
			
			if (time > swingTime + (40-spellSpeed))
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Slash\\Player_"+direction+"_Slash2.png"));
			
			if (time > swingTime + (60-spellSpeed))
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Slash\\Player_"+direction+"_Slash3.png"));
		
			if (time == swingTime + (80-spellSpeed))
				hasFinished = true;
		}
	}
	
	public void movePlayer(char n, Player player)
	{
		if (n == (char)1 && !player.isSprinting)
			player.isSprinting = true;
		
		else if (n == (char)1)
			player.isSprinting = false;
		
		if (n == (char)3)
			executeSpell(fireball, "Fireball", 0, 1, 0, 200);
		
		else if (n == (char)4)
			executeSpell(soulBurst, "SoulBurst", 1, 3, 5, 250);
		
		else if (n == (char)5)
			executeSpell(demonRage, "DemonRage", 2, 1, 5, 150);
		
		else if (n == (char)6);
		
		else if (n == (char)7);
		
		else if (n == (char)8);
		
		else if (n == (char)9);
		
		else if (n == (char)10);
		
		else if (n == (char)11);
		
		else if (n == (char)12);
		
		else
		{
			if (player.isSprinting)
			{
				if (time%2==0)
					--player.sprint;
			
				if (n == move_Right)
					player.direction = 0;
		
				if (n == move_Down)
					player.direction = 1;
		
				if (n == move_Left)
					player.direction = 2;
				
				if (n == move_Up)
					player.direction = 3;
				
				stepResetTime = 0;
			
				move(player, player.movementSpeed, player.direction);
				++step;
			}
			else
			{
				if (n == move_Right)
					player.direction = 0;
		
				if (n == move_Down)
					player.direction = 1;
		
				if (n == move_Left)
					player.direction = 2;
				
				if (n == move_Up)
					player.direction = 3;
			
				move(player, 0, player.direction);
				++step;
			}
			
			System.out.println(step);
			
			stepResetTime = 0;
			
			if (step > 5 && step < 10)
			{
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Step\\Player_"+player.direction+"_Step.png"));
			}
			
			else if (step > 10 && step < 15)
			{
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Step\\Player_"+player.direction+"_Step2.png"));
			}
			
			else if (step > 15 && step < 20)
			{
				player.setIcon(new ImageIcon("C:\\RPG\\Player\\Step\\Player_"+player.direction+"_Step3.png"));
			}
			
			if (step > 20)
				step = 0;
			
			if (n == view_Inventory)
			{
				GUIInventory guiInventory = new GUIInventory(player, 32);
			}
			
			if (n == view_Equipment)
			{
				GUIEquipment guiEquipment = new GUIEquipment(player);
			}
			
			if (n == view_KeyBinding)
			{
				GUIKeyBinding guiKeyBinding = new GUIKeyBinding(this);
			}
		}
	}
	
	public void doError(Exception e)
	{
		disposeGamebase();
		ErrorScreen errorScreen = new ErrorScreen();
		e.printStackTrace();
	}
	
	public void move(Living character, int amount, int direction)
	{
		if (direction == 0) character.setLocation(character.getX() + (character.movementSpeed + amount), character.getY());
			if (direction == 1) character.setLocation(character.getX(), character.getY()  + (character.movementSpeed + amount));
			if (direction == 2) character.setLocation(character.getX()  - (character.movementSpeed + amount), character.getY());
			if (direction == 3) character.setLocation(character.getX(), character.getY()  - (character.movementSpeed + amount));
			 
			character.direction = direction;
	}
	
	public void move(ActiveSpells character, int amount, int direction)
	{
		if (direction == 0) character.setLocation(character.getX() + (character.movementSpeed + amount), character.getY());
			if (direction == 1) character.setLocation(character.getX(), character.getY()  + (character.movementSpeed + amount));
			if (direction == 2) character.setLocation(character.getX()  - (character.movementSpeed + amount), character.getY());
			if (direction == 3) character.setLocation(character.getX(), character.getY()  - (character.movementSpeed + amount));
	}
	
	public void sprint(Living character, int amount, int direction)
	{
		if (time%2==0)
		{
			if (direction == 0) character.setLocation(character.getX() + (character.movementSpeed*2 + amount), character.getY());
			 if (direction == 1) character.setLocation(character.getX(), character.getY()  + (character.movementSpeed*2 + amount));
			 if (direction == 2) character.setLocation(character.getX()  - (character.movementSpeed*2 + amount), character.getY());
			 if (direction == 3) character.setLocation(character.getX(), character.getY()  - (character.movementSpeed*2 + amount));
			 
			 character.direction = direction;
		}
	}
	
	public void doTime()
	{
		++time;
		
		if (time == 1000)
		{
			time = 0;
		}
	}
	
	public void setDead(Goblin character)
	{
		character.setLocation(-1000, -1000);
		character.setVisible(false);
		character.isAlert = false;
	}
	
	public void setDead(ActiveSpells character)
	{
		character.setLocation(-1000, -1000);
		character.setVisible(false);
	}
	
	public void setDead(DemonRageProjectiles character) 
	{		
		character.setLocation(-1000, -1000);
		character.setVisible(false);
	}
	
	public void doSpells()
	{
		for (int n = 0;n != 100;++n)
		{
			if (fireball[n] != null)
				fireball[n].doSpells(time, this, player, stats);
			
			if (soulBurst[n] != null)
				soulBurst[n].doSpells(time, this, player, stats);
			
			if (n < 10 && demonRage[n] != null)
				demonRage[n].doSpells(time, this, player, stats);	
		}
	}
	
	public void disposeGamebase()
	{
		timer.stop();
		this.dispose();
	}
	
	public GameBase returnGameBase()
	{
		return this;
	}
	
	public void breakGame()
	{
		int error[] = new int[100];
		error[100] = 0;
	}
	
	public void doItems()
	{
		for (int n = 1;n != 100;++n)
		{
			if (equipment[n] != null)
				equipment[n].doItem(player);
			
			else
				break;
		}
	}
	
	public class timeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				doTime();
				player.update(returnGameBase(), time);
				healthBar.update(player);
				sprintBar.update(player, healthBar);
				background.doBackground(0, returnGameBase());
				goblin.update(player, time, 400);
				
				doItems();
				doResetStep();
				
				executeSwing(player.direction);
				
				for (int n = 0;n != 100;++n)
				{
					if (fireball[n] != null)
					{
						if (time%3==0)
							goToPoint(fireball[n], player, goblin, 40, 1);
						
						goblin.onHit(returnGameBase(), player, fireball[n]);
					}
					
					if (soulBurst[n] != null)
					{
						if (time%3==0)
							goToPoint(soulBurst[n], player, goblin, 30, 1);
						
						goblin.onHit(returnGameBase(), player, soulBurst[n]);
					}
					
					for (int k = 0;k != 100;++k)
						if (n < 9 && demonRage[n] != null && demonRage[n].demonRageProjectiles[k] != null)
							goblin.onHit(returnGameBase(), player, demonRage[n].demonRageProjectiles[k]);


				}
			
				if (soulBurst[1] != null)
					soulBurstParticle.setLocation(soulBurst[1].getX() - 10, soulBurst[1].getY() - 10);
			
				doSpells();
			}
			catch (Exception exception) 
			{doError(exception);}
		}
	}
}

/*
 * Date started: January 28th, 2014~.
 * log1: NO COMMENTS ADDED!
 * log2: NO COMMENTS ADDED!
 * log3: NO COMMENTS ADDED!
 * log4: NO COMMENTS ADDED!
 * log5: NO COMMENTS ADDED!
 * log6: NO COMMENTS ADDED!
 * ... (x = the log where I had finally added some comments).
 * logx: Febuary 2nd, 2014. FINALLY ADDED COMMENTS!
 */

/*
 * Plans:
 * Storyline: TO BE ADDED EVENTUALLY!
 * Combat System: Spells being implemented, Melee attacks are not yet finished.
 * Quests: Haven't gotten there yet.
 * Item and Inventory: Items will be created as seperate classes, extending from the superclass Items! Inventory can be arrays of the items
 * There will be four types of items(Weapons and Equipment, Consumables and Usables, Misc Items, and Quest Items.)
 * 
 */
