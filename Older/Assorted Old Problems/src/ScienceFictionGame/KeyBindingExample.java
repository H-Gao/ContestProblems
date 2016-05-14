package ScienceFictionGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class KeyBindingExample
{
    private static JFrame mainFrame;
    private static JTextField dataField;
    private static JButton enterButton;
    private static JPanel mainPanel;
    private static Action enterAction;
    private static ButtonListener buttonListener;
    
    public static void main( String[] args )
    {
        mainFrame = new JFrame( "Key Binding Example" );

        mainFrame.add( makePanel() );
        mainFrame.setLocationRelativeTo( null );
        mainFrame.setSize( 200, 100 );
        mainFrame.setResizable( false );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        mainFrame.setVisible( true );

    }
    
    static JPanel makePanel()
    {
        mainPanel = new JPanel();
        buttonListener = new ButtonListener();
        dataField = new JTextField( 15 );
        enterButton = new JButton( "Enter" );
        enterButton.addActionListener( buttonListener );
        
        enterAction = new EnterAction();

        dataField.getInputMap().put( KeyStroke.getKeyStroke( "2" ),
                "doEnterAction" );

        dataField.getActionMap().put( "doEnterAction", enterAction );
        
        mainPanel.add( dataField );
        mainPanel.add( enterButton );
        
        return mainPanel;
    }

    static class EnterAction extends AbstractAction
    {
        public void actionPerformed( ActionEvent tf )
        {
            System.out.println( "The Enter key has been pressed." );
            
            enterButton.doClick();
        }
    }
    
    static class ButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent bp )
        {
            System.out.println( "The enter button was pressed." );

            dataField.requestFocusInWindow();
            dataField.selectAll();
            
        }
        
    }

}


