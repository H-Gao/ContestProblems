package RPGGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GUIKeyBinding extends JFrame
{
	JButton keys[] = new JButton[36];
	KeyInput keyBinding[] = new KeyInput[6];
	
	JTextField input[] = new JTextField[2];
	
	JButton confirm = new JButton("Confirm");
	
	public GUIKeyBinding(GameBase gameBase)
	{
		this.setTitle("Key Binding");
		this.setSize(900, 400);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		createKeys(gameBase);
	}
	
	public void createKeys(GameBase gameBase)
	{
		int keySize = 48;
		
		for (int n = 0;n != 36;++n)
		{
			keys[n] = new JButton(createString(n));
			keys[n].addActionListener(new mouseListener(gameBase, 1, n));
			keys[n].setBounds(keySize*(n%6)+(6*keySize), keySize*(n/6), keySize, keySize);
			add(keys[n]);
		}
		
		for (int n = 0;n != 6;++n)
		{
			keyBinding[n] = new KeyInput(n);
			keyBinding[n].addActionListener(new mouseListener(gameBase, 0, n));
			keyBinding[n].setBounds(0, keySize*n, keySize*6, keySize);
			add(keyBinding[n]);
		}
		
		for (int n = 0;n != 2;++n)
		{
			input[n] = new JTextField();
			input[n].setBounds((6*2)*keySize, keySize*n, keySize*6, keySize);
			add(input[n]);
		}
		
		confirm.setBounds((6*2)*keySize, keySize*2, keySize*6, keySize);
		confirm.addActionListener(new mouseListener(gameBase, 2, 0));
		add(confirm);
	}
	
	public String createString(int n)
	{
		if (n < 10)
			return (""+(char)(48+n));
		else
			return (""+(char)(87+n));
	}
	
	public class mouseListener implements ActionListener
	{
		GameBase gameBase;
		int type;
		int key;
		
		public mouseListener(GameBase g, int t, int n)
		{
			gameBase = g;
			type = t;
			key = n;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if (type == 0)
				input[0].setText(keyBinding[key].name);
			
			else if (type == 2)
			{
				if (input[0].getText().equals("Move Right"))
					gameBase.move_Right = input[0].getText().charAt(0);
				
				if (input[0].getText().equals("Move Left"))
					gameBase.move_Left = input[0].getText().charAt(0);
				
				if (input[0].getText().equals("Move Up"))
					gameBase.move_Up = input[0].getText().charAt(0);
				
				if (input[0].getText().equals("Move Down"))
					gameBase.move_Down = input[0].getText().charAt(0);
				
				if (input[0].getText().equals("Sprint"))
					gameBase.sprint = ""+input[0].getText().charAt(0);
				
				if (input[0].getText().equals("Inventory"))
					gameBase.view_Inventory = input[0].getText().charAt(0);
			}
			
			else
				input[1].setText(keys[key].getText());
		}
	}
	
	public void changeBinding()
	{
		
	}
}
