package RPGGame;

import javax.swing.ImageIcon;

public class PassiveSpell extends Spells
{
	String spellID;
	int spellLevel;
	
	public PassiveSpell(String sID, GameBase gameBase, ImageIcon image)
	{
		super(gameBase, image);
		
		spellID = sID;
	}
	
	public void doSpell(Player player)
	{
		if (spellID.equals(""))
			
		if (spellID.equals("ShadowBuff"))
		{
			player.health += 2*spellLevel;
		}
	}
}
