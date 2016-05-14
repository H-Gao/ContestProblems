package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background extends JLabel
{
	public Background(int ID, GameBase gameBase)
	{
		super(new ImageIcon("C:\\RPG\\Background\\GrassyLand.png"));
		
		doBackground(ID, gameBase);
	}
	
	public Background(int ID, GUIEquipment gameBase)
	{
		super(new ImageIcon("C:\\RPG\\Background\\GrassyLand.png"));
		
		doBackground(ID, gameBase);
	}
	
	public Background(int ID, RunWindows gameBase)
	{
		super(new ImageIcon("C:\\RPG\\Background\\GrassyLand.png"));
		
		doBackground(ID, gameBase);
	}
	
	public void doBackground(int ID, GameBase gameBase)
	{
		this.setBounds(0, 0, gameBase.getWidth(), gameBase.getHeight());
		gameBase.add(this);
		
		if (ID == 0)
			this.setIcon(new ImageIcon("C:\\RPG\\Background\\GrassyLand.png"));
	}
	
	public void doBackground(int ID, GUIEquipment gameBase)
	{
		this.setBounds(0, 0, gameBase.getWidth(), gameBase.getHeight());
		gameBase.add(this);
		
		if (ID == 0)
			this.setIcon(new ImageIcon("C:\\RPG\\GUI\\Inventory\\Inventory.png"));
	}
	
	public void doBackground(int ID, RunWindows gameBase)
	{
		this.setBounds(0, 0, gameBase.getWidth(), gameBase.getHeight());
		gameBase.add(this);
		
		if (ID == 0)
			this.setIcon(new ImageIcon("C:\\RPG\\Background\\RPGGameBackground.png"));
	}
}
