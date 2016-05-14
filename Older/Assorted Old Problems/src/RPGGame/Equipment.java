package RPGGame;

public class Equipment extends Items
{
	int equipmentType;
	
	public Equipment(GameBase gameBase, String ID, int x, int y) 
	{
		super(gameBase, ID, x, y);
		
		type = 1;
	}
	
	public void doItem(Player player)
	{
		if (player.getX() > (this.getX() - this.getIcon().getIconWidth()) && player.getX() < (this.getX() + this.getIcon().getIconWidth()) && player.getY() > (this.getY() - this.getIcon().getIconHeight()) && player.getY() < (this.getY() + this.getIcon().getIconHeight()))
		{
			for (int n = 0;n != 32;++n)
			{
				if (player.inventory[n] == null)
				{
					player.inventory[n] = this;
					break;
				}
			}
			
			this.setLocation(-600, -600);
		}
		
		if (name.equals("SorcererStaff"))
		{
			intelligenceBonus = 2;
			equipmentType = 1;
			spellDamageBonus = 10;
			spellSpeedBonus = 10;
		}
		
		if (name.equals("PaladinSword"))
		{
			equipmentType = 1;
			meleeDamageBonus = 20;
			meleeSpeedBonus = 2;
		}
		
		if (name.equals("SorcererRobes"))
		{
			equipmentType = 3;
			intelligenceBonus = 5;
			meleeDefenseBonus = 2;
			magicDefenseBonus = 6;
		}
		
		/*
		 * Equipment Type references.
		 * 1. Weapons
		 * 2. Head Gear
		 * 3. Chest Gear
		 * 4. Leg Gear
		 * 5. Footwear
		 * 6. Amulet
		 * 7. Charm
		 * 8. Necklace
		 * 9. Face Gear
		 */
	}
}
