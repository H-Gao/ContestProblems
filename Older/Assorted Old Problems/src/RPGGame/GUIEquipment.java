package RPGGame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class GUIEquipment extends JFrame
{
	InventorySlot squares[] = new InventorySlot[9];
	JTextField textInfo[] = new JTextField[9];
	
	public GUIEquipment(Player player)
	{
		this.setTitle("Equipment");
		this.setLayout(null);
		this.setBounds(100, 100, 48*9 + 200, 48*4);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		setBackground();
		setSquares(player);
	}
	
	public void setBackground()
	{
		Background background = new Background(0, this);
	}
	
	public void setSquares(Player player)
	{
		for (int n = 0;n != 9;++n)
		{	
			if (player.weaponSlot != null)
			{
				if (n == 0)
					this.squares[n].setIcon(player.weaponSlot.getIcon());
			}
			
			else
			{
				this.squares[n] = new InventorySlot(this, 48, n, n*48, 48*(n%3));
			}
			
			textInfo[n] = new JTextField(setString(n));
			textInfo[n].setBounds(squares[n].getX()+48, squares[n].getY(), 2*48, 48);
			add(textInfo[n]);
		}
	}
	
	public String setString(int n)
	{
		if (n == 0)
			return "Weapon";
		
		else if (n == 1)
			return "Head Gear";
		
		else if (n == 2)
			return "Chest Gear";
		
		else if (n == 3)
			return "Leg Gear";
		
		else if (n == 4)
			return "Footwear";
		
		else if (n == 6)
			return "Amulet";
		
		else if (n == 7)
			return "Charm";
		
		else if (n == 8)
			return "Necklace";
		
		else
			return "Face Gear";
	}
}
