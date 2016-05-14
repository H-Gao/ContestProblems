package RPGGame;

import javax.swing.*;

public class InventorySlot extends JButton
{
	String name;
	
	int equipmentType;
	int meleeDefenseBonus;
	int magicDefenseBonus;
	
	int healthBonus;
	int meleeDamageBonus;
	int spellDamageBonus;
	int meleeSpeedBonus;
	int spellSpeedBonus;
	int movementSpeedBonus;
	
	int strengthBonus;
	int defenseBonus;
	int intelligenceBonus;
	int dexerityBonus;
	int charismaBonus;
	
	int type;
	
	public InventorySlot(GUIInventory guiInventory, Player player, int squareSize, int n)
	{
		if (player.inventory[n] != null && player.inventory[n].getIcon() != null)
		{
			name = player.inventory[n].name;
			type = player.inventory[n].type;
			
			equipmentType = player.inventory[n].equipmentType;
			meleeDefenseBonus = player.inventory[n].meleeDefenseBonus;
			magicDefenseBonus = player.inventory[n].magicDefenseBonus;
			
			healthBonus = player.inventory[n].healthBonus;
			meleeDamageBonus = player.inventory[n].meleeDamageBonus;
			spellDamageBonus = player.inventory[n].spellDamageBonus;
			meleeSpeedBonus = player.inventory[n].meleeSpeedBonus;
			spellSpeedBonus = player.inventory[n].spellSpeedBonus;
			movementSpeedBonus = player.inventory[n].movementSpeedBonus;
				
			strengthBonus = player.inventory[n].strengthBonus;
			defenseBonus = player.inventory[n].defenseBonus;
			intelligenceBonus = player.inventory[n].intelligenceBonus;
			dexerityBonus = player.inventory[n].dexerityBonus;
			charismaBonus = player.inventory[n].charismaBonus;
			
			this.setIcon(player.inventory[n].getIcon());
		}
		
		else
			this.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\InventorySlot.png"));
		
		repaint();
		
		this.setBounds(squareSize*(8-(n%8)), (squareSize*(n/8))+squareSize, squareSize, squareSize);
		guiInventory.add(this);
	}
	
	public InventorySlot(GUIEquipment guiInventory, Items item, int squareSize, int n, int x, int y)
	{
		if (item != null)
		{
			name = item.name;
			type = item.type;
			
			equipmentType = item.equipmentType;
			meleeDefenseBonus = item.meleeDefenseBonus;
			magicDefenseBonus = item.magicDefenseBonus;
			
			healthBonus = item.healthBonus;
			meleeDamageBonus = item.meleeDamageBonus;
			spellDamageBonus = item.spellDamageBonus;
			meleeSpeedBonus = item.meleeSpeedBonus;
			spellSpeedBonus = item.spellSpeedBonus;
			movementSpeedBonus = item.movementSpeedBonus;
				
			strengthBonus = item.strengthBonus;
			defenseBonus = item.defenseBonus;
			intelligenceBonus = item.intelligenceBonus;
			dexerityBonus = item.dexerityBonus;
			charismaBonus = item.charismaBonus;
		}
		
		this.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\InventorySlot.png"));
		
		repaint();
		
		this.setBounds(x, y, squareSize, squareSize);
		guiInventory.add(this);
	}
		
    public InventorySlot(GUIEquipment guiInventory, int squareSize, int n, int x, int y)
    {
		this.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\InventorySlot.png"));
		
		repaint();
		
		this.setBounds(x, y, squareSize, squareSize);
		guiInventory.add(this);
	}
	
	public void resetSlot()
	{
		this.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\InventorySlot.png"));
		
		name = null;
		type = 0;
		
		equipmentType = 0;
		meleeDefenseBonus = 0;
		magicDefenseBonus = 0;
		
		healthBonus = 0;
		meleeDamageBonus = 0;
		spellDamageBonus = 0;
		meleeSpeedBonus = 0;
		spellSpeedBonus = 0;
		movementSpeedBonus = 0;
			
		strengthBonus = 0;
		defenseBonus = 0;
		intelligenceBonus = 0;
		dexerityBonus = 0;
		charismaBonus = 0;
	}
}
