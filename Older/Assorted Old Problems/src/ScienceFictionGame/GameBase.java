package ScienceFictionGame;

import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeListener;

public class GameBase extends JFrame
{	
	int ID[] = new int[10];
	
	int pointX = 0;
	int pointY = 0;
	
	int time = 0;
	
	Random random = new Random();
	
	Timer timer = new Timer(15, new timerListener());
	
	GameBaseCharacter selected[] = new GameBaseCharacter[20];
	
	ImageIcon image = new ImageIcon("C:\\ScienceFictionGame\\Player\\"+"Player_0"+".png");
	Player player = new Player(image);
	StandardInfantry imperialMarine[] = new StandardInfantry[100];
	ITH ith = new ITH();
	Explosion explosion = new Explosion(1, 1, 1, 3);
	
	Bullet bullet[] = new Bullet[100];
	AntiAirMissle antiAircraftMissle[] = new AntiAirMissle[100];
	
	Particles smoke[] = new Particles[100];
	
	GUIBuyUnit guiBuyUnit;// = new GUIBuyUnit(this);
	
	public GameBase()
	{
		setTitle("GameBaseTest");
		setSize(400, 600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new mouseListener());
		addKeyListener(new keyListener());
		
		createPlayer();
		createImperialMarine();
		createITH();
		createExplosion();
		createSmoke(50, 100, 100);
		
		//guiBuyUnit.setVisible(true);
		
		timer.start();
	}
	
	public static void main(String[] args)
	{
		GameBase gamebase = new GameBase();
	}
	
	public void createSmoke(int amount, int x, int y)
	{
		for (int n = 0;n != amount;++n)
		{
			if (smoke[n] == null)
				smoke[n] = new Particles("smoke");
			
			smoke[n].setVisible(true);
			smoke[n].setBounds(x + (random.nextInt(100)-50), y + (random.nextInt(100)-50), smoke[n].getIcon().getIconWidth(),  smoke[n].getIcon().getIconHeight());
			add(smoke[n]);
		}
	}
	
	public void executeSmoke()
	{
		for (int n = 0;n != 100;++n)
		{
			if (smoke[n] != null && time%100==0)
			{
				setDead(smoke[n]);
			}
		}
	}
	
	public void createPlayer()
	{
		player.setFocusable(true);
		player.addMouseListener(new selectListener(player));
		player.setBounds(80, 80, image.getIconWidth(), image.getIconHeight());
		add(player);
	}
	
	public void createExplosion()
	{
		explosion.setFocusable(true);
		explosion.setBounds(-200, -200, explosion.getIcon().getIconWidth(), explosion.getIcon().getIconHeight());
		add(explosion);
	}
	
	public void createImperialMarine()
	{
			++ID[2];
			
			imperialMarine[ID[2]] = new StandardInfantry(2);
			imperialMarine[ID[2]].setFocusable(true);
			imperialMarine[ID[2]].addMouseListener(new selectListener(imperialMarine[ID[2]]));
			imperialMarine[ID[2]].setBounds(80, 80, imperialMarine[ID[2]].getIcon().getIconWidth(), imperialMarine[ID[2]].getIcon().getIconHeight());
			add(imperialMarine[ID[2]]);
	}
	
	public void createITH()
	{
		ith.setFocusable(true);
		ith.addMouseListener(new selectListener(ith));
		ith.setBounds(80, 80, ith.getIcon().getIconWidth(), ith.getIcon().getIconHeight());
		add(ith);
	}
	
	public void goToPoint(GameBaseCharacter character, int amount)
	{
		if (character.isMoving)
		{
			if (character.getX() < pointX) move(character, 0 + amount, 0);
			if (character.getX() > pointX) move(character, 0 + amount, 2);
			if (character.getY() < pointY) move(character, 0 + amount, 1);
			if (character.getY() > pointY) move(character, 0 + amount, 3);
		}
		
		if (character.getX() == pointX && character.getY() == pointY)
		{
			character.isMoving = false;
		}
	}
	
	public void goToPoint(AntiAirMissle character, int amount)
	{
		if (character.isMoving)
		{
			if (character.getX() < pointX) move(character, 0 + amount, 0);
			if (character.getX() > pointX) move(character, 0 + amount, 2);
			if (character.getY() < pointY) move(character, 0 + amount, 1);
			if (character.getY() > pointY) move(character, 0 + amount, 3);
		}
		
		if (character.getX() < (ith.getX() + ith.getIcon().getIconWidth()) && character.getX() > (ith.getX() - ith.getIcon().getIconWidth()) && character.getY() < (ith.getY() + ith.getIcon().getIconHeight()) && character.getY() > (ith.getY() - ith.getIcon().getIconHeight()))
		{
			createSmoke(50, ith.getX(), ith.getY());
			explosion.setLocation(character.getX(), character.getY());
			explosion.isExploding = true;
			explosion.timeExploding = time;
			character.isMoving = false;
			character.setVisible(false);
			character.setLocation(-100, -100);
			ith.health -= (int)(character.damage);
			ith.damageCooldown = 20;
			System.out.println(ith.health);
		}
	}
	
	public void goToPoint(Bullet character, GameBaseCharacter start, GameBaseCharacter player, int pX, int pY, int n)
	{
		if (character.isMoving)
		{
			character.setLocation(character.getX() + (start.getX() - player.getX())/4, character.getY() + (start.getY() - player.getY())/4);
			
			System.out.println(character.getX() + " " + character.getY() + " " + player.getX() + " " + player.getY());
			
			if (character.getX() < (pX + player.bulletAccuracy) && character.getX() > (pX - player.bulletAccuracy) && character.getY() < (pY + player.bulletAccuracy) && character.getY() > (pY - player.bulletAccuracy))
				setDead(character);
		}
	}
	
	public void move(GameBaseCharacter character, int amount, int direction)
	{
		if (time%2==0)
		{
			if (direction == 0) character.setLocation(character.getX() + (character.movementSpeed + amount), character.getY());
			 if (direction == 1) character.setLocation(character.getX(), character.getY()  + (character.movementSpeed + amount));
			 if (direction == 2) character.setLocation(character.getX()  - (character.movementSpeed + amount), character.getY());
			 if (direction == 3) character.setLocation(character.getX(), character.getY()  - (character.movementSpeed + amount));
			 
			 character.direction = direction;
		}
	}
	
	public void move(AntiAirMissle character, int amount, int direction)
	{
		if (time%2==0)
		{
			if (direction == 0) character.setLocation(character.getX() + (character.movementSpeed + amount), character.getY());
			 if (direction == 1) character.setLocation(character.getX(), character.getY()  + (character.movementSpeed + amount));
			 if (direction == 2) character.setLocation(character.getX()  - (character.movementSpeed + amount), character.getY());
			 if (direction == 3) character.setLocation(character.getX(), character.getY()  - (character.movementSpeed + amount));
			 
			 character.direction = direction;
		}
	}
	
	public void move(Bullet character, int amount, int direction)
	{
		if (direction == 0) character.setLocation(character.getX() + amount, character.getY());
		 if (direction == 1) character.setLocation(character.getX(), character.getY()  +  amount);
		 if (direction == 2) character.setLocation(character.getX()  -  amount, character.getY());
		 if (direction == 3) character.setLocation(character.getX(), character.getY()  -  amount);
	}
	
	public void checkDead(GameBaseCharacter character)
	{
		if (character.health < 0)
			setDead(character);
	}
	
	public void checkDead(ITH character, boolean checkITHDead)
	{
		if (character.health < 0)
		{
			character.setVisible(false);
			character.isMoving = false;
			character.health = -9873;
			
			if (character.health == -9873)
			{
				explosion.setLocation(character.getX(), character.getY());
				explosion.isExploding = true;
				explosion.timeExploding = time;
				character.setLocation(-1800, -1800);
				character.health = -2141515;
				
				for (int n = 0;n != 10;++n)
				{
					if (antiAircraftMissle[n] != null)
						setDead(antiAircraftMissle[n], true);
				}
			}
		}
	}
	
	public class selectListener implements MouseListener
	{
		GameBaseCharacter select;
		
		public selectListener(GameBaseCharacter character)
		{
			select = character;
		}
		
		public void mouseClicked(MouseEvent e) {}

		public void mousePressed(MouseEvent e) 
		{
			if (e.isControlDown())
			{
				if (selected[ID[1]] == null)
						selected[ID[1]] = select;
							++ID[1];
			}
			else if (e.isShiftDown())
			{
				if (selected[0] == ith)
				{
					for (int n = 1;n != 20;++n)
					{
						if (selected[n] != null && selected[n].health >= 0)
						{
							selected[n].setVisible(true);
							selected[n] = null;
							ID[1] = 0;
						}
					}
				}
			}
			else
			{
				for (int n = 0;n != 20;++n)
					selected[n] = null;
				
					selected[0] = select;
					ID[1] = 0;
			}
		}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
	}
	
	public class keyListener implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) 
		{
			setDirection(e);
			
			if (e.getKeyChar() == 'a')
				player.isMoving = false;
			
			if (e.getKeyChar() == 'd')
			{
				if (selected[0] != null)
				{
					for (int n = 0;n != 20;++n)
					{
						if (selected[n] != null && selected[n] != ith)
						{
							++ID[0];
							
							if (ID[0] < 100 && bullet[ID[0]] == null && selected[n].shotCooldown <= 0)
							{
								bullet[ID[0]] = new Bullet(0);
								
								selected[n].shotCooldown = selected[n].max_ShotCooldown;
				
								bullet[ID[0]].damage = selected[n].damage;
								bullet[ID[0]].accuracy = selected[n].bulletAccuracy;
								bullet[ID[0]].BulletID = selected[n].race;
								bullet[ID[0]].setDirection(selected[n].direction);
								bullet[ID[0]].isMoving = true;
								bullet[ID[0]].setBounds(selected[n].getX(), selected[n].getY()+30, 15, 3);
								add(bullet[ID[0]]);
							}
							else if (ID[0] == 100)
							{
								ID[0] = 0;
							}
							else if (bullet[ID[0]] != null && selected[n].shotCooldown <= 0 && selected[n].target != null)
							{
								selected[n].shotCooldown = selected[n].max_ShotCooldown;
				
								bullet[ID[0]].damage = selected[n].damage;
								bullet[ID[0]].accuracy = selected[n].bulletAccuracy;
								bullet[ID[0]].BulletID = selected[n].race;
								bullet[ID[0]].setVisible(true);
								bullet[ID[0]].setDirection(selected[n].direction);
								bullet[ID[0]].isMoving = true;
								bullet[ID[0]].setLocation(selected[n].getX(), selected[n].getY()+30);
							}
						}
					}
				}
			}
			
			if (e.getKeyChar() == 'f')
			{
				createSmoke(20, 100, 100);
			}
			
			if (e.getKeyChar() == 'e')
			{
				if (ith != null && ith.health >= 0)
				{						
					if (ID[2] < 10)
					{						
						++ID[2];
						antiAircraftMissle[ID[2]] = new AntiAirMissle(0);
						antiAircraftMissle[ID[2]].BulletID = 0;
						antiAircraftMissle[ID[2]].isMoving = true;
						antiAircraftMissle[ID[2]].setBounds(5, 5, antiAircraftMissle[ID[2]].getIcon().getIconWidth(), antiAircraftMissle[ID[2]].getIcon().getIconHeight());
						add(antiAircraftMissle[ID[2]]);
					}
				}
			}
		}

		public void keyReleased(KeyEvent e) {}
	}
	
	public class mouseListener implements MouseListener
	{
		public void mouseClicked(MouseEvent e) 
		{
			if (selected[0] != null)
			{
				for (int n = 0;n != 20;++n)
				{
					if (selected[n] != null)
					{
						selected[n].isMoving = true;
			
						pointX = e.getX() - 5;
						pointY = e.getY() - 60;
					}
				}
			}
		}
		
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e)  {}
	}
	
	public void setDead(GameBaseCharacter character)
	{
		character.setVisible(false);
		character.setLocation(-400, -400);
		character.isMoving = false;
	}
	
	public void setDead(Particles character)
	{
		character.setVisible(false);
		character.setLocation(-400, -400);
	}
	
	public void setDead(AntiAirMissle antiAircraftMissle2, boolean chooseAntiAircraftMissle)
	{
		antiAircraftMissle2.setVisible(false);
		antiAircraftMissle2.setLocation(-400, -400);
	}
	
	public void setDead(Bullet character)
	{
		character.setVisible(false);
		character.setLocation(-400, -400);
		character.isMoving = false;
	}
	
	public void setDirection(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.direction = 0;
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.direction = 2;
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
			player.direction = 3;
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			player.direction = 1;
	}
	
	public class timerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			++time;
			--player.damageCooldown;
			
			executeSmoke();
			
			player.setIcon(new ImageIcon("C:\\ScienceFictionGame\\Player\\Player_"+player.direction+".png"));
			
			if (time > 1000) time = 0;
			
			if (explosion.timeExploding > 946)
				explosion.timeExploding = 0;
			
			if (explosion.isExploding && time < explosion.timeExploding + 8)
				explosion.type = 1;
			
			 	else if (explosion.isExploding && time < explosion.timeExploding + 16)
			 		explosion.type = 2;
			
			 	else if (explosion.isExploding && time < explosion.timeExploding + 24)
			 		explosion.type = 3;
			
			 	else if (explosion.isExploding && time < explosion.timeExploding + 32)
			 		explosion.type = 4;
			
			 	else if (explosion.isExploding && time < explosion.timeExploding + 40)
			 		explosion.type = 5;
			
			 	else if (explosion.isExploding && time < explosion.timeExploding + 48)
			 		explosion.type = 6;
			
			 	else
			 	{
			 		explosion.type = 1;
			 		explosion.setLocation(-800, -800);
			 		explosion.isExploding = false;
			 	}
			
				if (time == explosion.timeExploding + 33)
					explosion.setLocation(explosion.getX() - 150, explosion.getY() - 150);
				
				if (time ==  explosion.timeExploding + 41)
					explosion.setLocation(explosion.getX() - 320, explosion.getY() - 320);
				
				explosion.setIcon(new ImageIcon("C:\\ScienceFictionGame\\Explosion\\Explosion_" + explosion.type + ".png"));
				explosion.setSize(explosion.getIcon().getIconWidth(), explosion.getIcon().getIconHeight());
			
			if (selected[0] != null)
			{
				for (int n = 0;n != 20;++n)
				{		
					if (selected[0] == ith)
					{
						for (int k = 1;k != 20;++k)
						{
							if (selected[k] != null)
							{
								selected[k].setLocation(ith.getX(), ith.getY());
								selected[k].setVisible(false);
								
								if (ith.health <= 0)
									selected[k].health = -1;
							}
						}
						
						if (time%2==0)
								goToPoint(selected[0], 0);
					}
					else if (selected[n] != null && time%2==0 && selected[n].isGround)
					{
						--selected[n].shotCooldown;
						
							goToPoint(selected[n], 0);
							findTarget(n, player);
						
						for (int k = 0;k != 10;++k)
						{
							if (imperialMarine[k] != null)
								findTarget(n, imperialMarine[k]);
						}
					}
					else if (selected[n] != null && !selected[n].isGround)
					{
						--selected[n].shotCooldown;
						
						goToPoint(selected[n], 0);
						findTarget(n, ith);
					}
				}
			}
			
			for (int n = 0;n != 100;++n)
			{		
				if (n < 10 && antiAircraftMissle[n] != null)
				{
					if (time%3==0)
						goToPoint(antiAircraftMissle[n], 0);
				}
				
				if (n < 10)
				{
					doDamage(ith, n, true);
				}
				
				if (selected[0] != null)
				{		
					checkDead(ith, true);
					
					for (int k = 0;k != 20;++k)
					{		
						if (k < 10 && bullet[n] != null && player != null && imperialMarine[k] != null)
						{		
							if (k == 1)
							doDamage(player, n);
							
							doDamage(imperialMarine[k], n);
							doDamage(ith, n);
							checkDead(player);
							checkDead(imperialMarine[k]);
						}
						
						if (selected[k] != null && bullet[n] != null && selected[k].target != null)
						{
							++bullet[n].n;
					
							if (time%3==0)
								goToPoint(bullet[n], player, selected[k], selected[k].target.getX(), selected[k].target.getY(), bullet[n].n);
						}
					}
				}
				}
			}
		}
	
	public void doDamage(GameBaseCharacter character, int n)
	{
		--character.damageCooldown;
		
		if (character.damageCooldown <= 0 && random.nextInt(100)<100-5*(bullet[n].accuracy) && bullet[n].BulletID != character.race && bullet[n].getX() < character.getX() + character.getIcon().getIconWidth() && bullet[n].getX() > character.getX() -character.getIcon().getIconWidth() && bullet[n].getY() < character.getY() + player.getIcon().getIconHeight() && bullet[n].getY() > character.getY() - character.getIcon().getIconHeight())
		{
			character.health -= (int)(bullet[n].damage*((double)(100-character.armor)/100));
			character.damageCooldown = 20;
			System.out.println(character.health);
		}
	}
	
	public void doDamage(ITH character, int n, boolean isCheckingMissle)
	{
		--character.damageCooldown;
	}
	
	public void findTarget(int n, GameBaseCharacter character)
	{
		for (int k = 0;k != 10;++k)
		{
			if (character != player && player != null && selected[n].race != player.race && player.health > 0)
			{
				selected[n].target = player;
				break;
			}
			 else if (character != imperialMarine[k] && imperialMarine[k] != null && selected[n].race != imperialMarine[k].race && imperialMarine[k].health > 0)
			 {
				 selected[n].target = imperialMarine[k];
				 break;
			 }
		}
	}
	}
