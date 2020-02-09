import java.awt.*;
import javax.swing.*;
/**
 *Diese Klasse erstellt ein Objekt des Types "Game". Die Klasse GUI ließt die User
 *Eingaben ein und gibt sie an "Game" weiter.
 */
public class GUI extends javax.swing.JFrame
{
    public GUI()
    {
        
    }
    
    public void createGUI(){
        //erstellt Ein Fenster mit swing
        GUI frame=new GUI();
        frame.setTitle("checkers");
        frame.setSize(1000, 620);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        frame.setVisible(true);
        //GridLayout für feld oder GridBagLayout
    }
}
