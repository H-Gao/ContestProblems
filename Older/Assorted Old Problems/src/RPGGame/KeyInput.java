package RPGGame;

import javax.swing.JButton;

public class KeyInput extends JButton
{
	String name;
	
	public KeyInput(int n)
	{
		if (n == 0)
			name = "Move Right";
		
		if (n == 1)
			name = "Move Left";
		
		if (n == 2)
			name = "Move Down";
		
		if (n == 3)
			name = "Move Up";
		
		if (n == 4)
			name = "Sprint";
		
		if (n == 5)
			name = "Inventory";
		
		if (n == 6)
			name = "Equipment";
		
		this.setText(name);
	}
}
