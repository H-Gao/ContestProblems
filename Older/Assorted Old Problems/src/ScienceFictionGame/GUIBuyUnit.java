package ScienceFictionGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIBuyUnit extends JFrame
{
	JButton buyImperialMarine = new JButton("Buy Marine");
	
	public GUIBuyUnit(GameBase gameBase)
	{
		setTitle("Buy Units");
		setSize(600, 600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buyImperialMarine.setBounds(0, 50, 100, 50);
		buyImperialMarine.addActionListener(new BuyListener(1, gameBase));
		add(buyImperialMarine);
	}
	
	public class BuyListener implements ActionListener
	{
		GameBase gameBase;
		int buyID;
		
		public BuyListener(int BuyID, GameBase game)
		{
			buyID = BuyID;
			gameBase = game;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (buyID == 1)
			{
				gameBase.createImperialMarine();
			}
		}
	}
}
