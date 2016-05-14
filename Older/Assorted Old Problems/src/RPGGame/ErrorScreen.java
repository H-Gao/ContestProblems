package RPGGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorScreen extends JFrame
{
	public ErrorScreen()
	{
		setTitle("Error");
		setSize(1368, 735);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createBackground();
		repaint();
	}
	
	public void createBackground()
	{
		JLabel background = new JLabel(new ImageIcon("C:\\RPG\\ErrorScreen\\ErrorScreen.png"));
		background.setBounds(0, 0, 1368, 735);
		add(background);
	}
}
