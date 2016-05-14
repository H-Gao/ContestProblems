package RPGGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUIInventory extends JFrame
{
	JLabel background = new JLabel();
	
	int inventorySlots = 32;
	
	InventorySlot square[] = new InventorySlot[inventorySlots];
	
	JTextArea textArea = new JTextArea();
	
	public GUIInventory(Player player, int inventorySlots)
	{
		this.setTitle("Inventory");
		this.setLayout(null);
		this.setBounds(100, 100, 480 + 200, 326);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground();
		setTextArea();
		setSquares(player);
	}
	
	public void setBackground()
	{
		background.setBounds(0,0, 480, 288);
		background.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\Inventory.png"));
		add(background);
	}
	
	public void setTextArea()
	{
		textArea.setBounds(480, 0, 200, 288);
		add(textArea);
	}
	
	public void setSquares(Player player)
	{
		int squareSize = 48;
		
		for (int n = 0;n != inventorySlots;++n)
		{
			this.square[n] = new InventorySlot(this, player, squareSize, n);
			this.square[n].addMouseListener(new squareListener(player, n));
		}
	}
	
	public class squareListener implements MouseListener
	{
		Player player;
		int n;
		
		public squareListener(Player p, int x)
		{
			player = p;
			n = x;
		}
		
		public void mouseClicked(MouseEvent e) 
		{
			if (square[n].type == 1 && player.inventory[n] != null && player.weaponSlot == null)
			{
				player.weaponSlot = player.inventory[n];
				square[n].resetSlot();
			}
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) 
		{
			createBonuses(n);
		}

		public void mouseExited(MouseEvent e) 
		{
			textArea.setText("");
		}
	}
	
	public void createBonuses(int n)
	{
		if (this.square[n].name != null)
			textArea.setText(textArea.getText() + "Name: " + this.square[n].name + "\n");
		
		if (this.square[n].healthBonus > 0)
			textArea.setText(textArea.getText() + "Health: " + this.square[n].healthBonus + "+\n");
		
		if (this.square[n].meleeDamageBonus > 0)
			textArea.setText(textArea.getText() + "Damage(M): " + this.square[n].meleeDamageBonus + "+\n");
		
		if (this.square[n].meleeSpeedBonus > 0)
			textArea.setText(textArea.getText() + "Speed(M): " + this.square[n].meleeSpeedBonus + "+\n");
		
		if (this.square[n].spellDamageBonus > 0)
			textArea.setText(textArea.getText() + "Damage(S): " + this.square[n].spellDamageBonus + "+\n");
		
		if (this.square[n].spellSpeedBonus > 0)
			textArea.setText(textArea.getText() + "Speed(S): " + this.square[n].spellSpeedBonus + "+\n");
		
		if (this.square[n].movementSpeedBonus > 0)
			textArea.setText(textArea.getText() + "Movement Speed: " + this.square[n].movementSpeedBonus + "+\n");
		
		if (this.square[n].defenseBonus > 0)
			textArea.setText(textArea.getText() + "Intelligence: " + this.square[n].defenseBonus + "+\n");
		
		if (this.square[n].strengthBonus > 0)
			textArea.setText(textArea.getText() + "Stength: " + this.square[n].strengthBonus + "+\n");
		
		if (this.square[n].intelligenceBonus > 0)
			textArea.setText(textArea.getText() + "Intelligence: " + this.square[n].intelligenceBonus + "+\n");
		
		if (this.square[n].dexerityBonus > 0)
			textArea.setText(textArea.getText() + "Dexterity: " + this.square[n].dexerityBonus + "+\n");
		
		if (this.square[n].charismaBonus > 0)
			textArea.setText(textArea.getText() + "Charisma: " + this.square[n].charismaBonus + "+\n");
		
		if (this.square[n].equipmentType > 1)
		{
			if (this.square[n].meleeDefenseBonus > 0)
				textArea.setText(textArea.getText() + "Melee Defense: " + this.square[n].meleeDefenseBonus + "+\n");
			
			if (this.square[n].magicDefenseBonus > 0)
				textArea.setText(textArea.getText() + "Magic Defense: " + this.square[n].magicDefenseBonus + "+\n");
		}
		
		
	}
}
