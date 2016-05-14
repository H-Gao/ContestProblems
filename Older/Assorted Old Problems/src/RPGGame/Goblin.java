package RPGGame;

import javax.swing.ImageIcon;
import java.util.Random;

public class Goblin extends Monster
{
	Random random = new Random();
	
	public Goblin(GameBase gameBase, int x, int y)
	{
		super(new ImageIcon("C:\\RPG\\Monsters\\Goblin_0.png"));
		
		this.health = 50;
		this.damage = 1;
		this.movementSpeed = 1;
		
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		gameBase.add(this);
	}
	
	public void update(Player player, int time, int range)
	{
		if (time%800==0)
			++health;
		
		if (health < 5)
			movementSpeed = 2;
		
		executeMonster(player, time, range);
	}
	
	public void onHit(GameBase gameBase, Player player, ActiveSpells fireball)
	{
		--damageCooldown;
		
		if (damageCooldown <= 0 && fireball.getX() > (this.getX() - this.getIcon().getIconWidth()) && fireball.getX() < (this.getX() + this.getIcon().getIconWidth()) && fireball.getY() > (this.getY() - this.getIcon().getIconHeight()) && fireball.getY() < (this.getY() + this.getIcon().getIconHeight()))
		{
			this.health -= fireball.damage;
			this.damageCooldown = fireball.resetTimer;
			System.out.println(this.health);
		}
		
		if (this.health <= 0)
		{
			player.exp += 5;
			gameBase.setDead(this);
		}
	}	
	
	public void onHit(GameBase gameBase, Player player, DemonRageProjectiles fireball)
	{
		--damageCooldown;
		
		if (damageCooldown <= 0 && fireball.getX() > (this.getX() - this.getIcon().getIconWidth()) && fireball.getX() < (this.getX() + this.getIcon().getIconWidth()) && fireball.getY() > (this.getY() - this.getIcon().getIconHeight()) && fireball.getY() < (this.getY() + this.getIcon().getIconHeight()))
		{
			this.health -= player.level;
			this.setLocation(player.getX() + random.nextInt(100) - 50, player.getX() + random.nextInt(100) - 50);
			System.out.println(this.health);
			damageCooldown = 100;
			gameBase.setDead(fireball);
		}
		
		if (this.health <= 0)
		{
			player.exp += 5;
			gameBase.setDead(this);
		}
	}
}
