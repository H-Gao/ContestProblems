package RPGGame;

import javax.swing.*;

public class Items extends JLabel
{
	String name;
	
	int equipmentType;
	
	int healthBonus;
	int meleeDamageBonus;
	int spellDamageBonus;
	int meleeSpeedBonus;
	int spellSpeedBonus;
	int movementSpeedBonus;
	
	int meleeDefenseBonus;
	int magicDefenseBonus;
	
	int strengthBonus;
	int defenseBonus;
	int intelligenceBonus;
	int dexerityBonus;
	int charismaBonus;
	
	int type;
	
	public Items(GameBase gameBase, String ID, int x, int y)
	{
		super(new ImageIcon("C:\\RPG\\Items\\"+ID+".png"));
		
		name = ID;
		
		this.setBounds(x, y, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		gameBase.add(this);
	}
}
