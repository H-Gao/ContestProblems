package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ActiveSpells extends Spells
{
	DemonRageProjectiles demonRageProjectiles[] = new DemonRageProjectiles[100];
	
	int type[] = new int[10];
	
	int livingTime;
	
	int direction;
	int movementSpeed;
	int resetTimer;
	String spellID;
	
	public ActiveSpells(GameBase gameBase, String sID, ImageIcon image, int lT)
	{
		super(gameBase, image);
		
		spellID = sID;
		livingTime = lT;
		resetTimer = 0;
	}
	
	public void doSpells(int time, GameBase gameBase, Player player, Stats stats)
	{
		--livingTime;
		
		if (livingTime == 0)
			gameBase.setDead(this);
		
		if (spellID.equals("Fireball"))
		{
			this.damage = (int)((1.5*player.level) + (2*stats.intelligence));
			this.direction = 0;
			this.resetTimer = 40;
			
			if (time%2==0)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\Fireball_0.png"));
			else
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\Fireball_1.png"));
		}
		
		if (spellID.equals("SoulBurst"))
		{
			++type[0];
			
			this.damage = player.level + (stats.intelligence/2);
			this.direction = 0;
			
			if (type[0] < 5)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\SoulBurst_2.png"));
			
			else if (type[0] < 10)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\SoulBurst_1.png"));
			
			else if (type[0] < 15)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\SoulBurst_0.png"));

			else
				type[0] = 0;
		}
		
		if (spellID.equals("DemonRage"))
		{
			this.damage = (int)Math.round((1.5*player.level) + (stats.intelligence/2));
			this.direction = 0;
			
			if (type[1]==1)
				for (int n = 0;n != 100;++n)
					demonRageProjectiles[n] = new DemonRageProjectiles(gameBase, this);
			
			for (int n = 0;n != 100;++n)
			{
				if (type[1]>1)
					demonRageProjectiles[n].update(this, type[1]);
				else
					break;
			}
			
			for (int n = 0;n != 100;++n)
				if (type[1]==49)
					demonRageProjectiles[n].setVisible(false);
			
			++type[1];
			
			if (type[1] < 10)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\DemonRage_0.png"));
			
			else if (type[1] < 20)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\DemonRage_1.png"));
			
			else if (type[1] < 30)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\DemonRage_2.png"));
			
			else if (type[1] < 40)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\DemonRage_3.png"));
			
			else if (type[1] < 50)
				this.setIcon(new ImageIcon("C:\\RPG\\Spells\\DemonRage_4.png"));

			else
				type[1] = 0;
		}
	}
}
