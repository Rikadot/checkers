package src;

import java.awt.*;
import javax.swing.*;
/**
 *The GUI of the game
 */
public class GUI extends javax.swing.JFrame
{
    public GUI()
    {
        
    }
    //following is a test I did for creating a gui
    public void createGUI()
    {
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
