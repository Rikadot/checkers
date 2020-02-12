
/**
 * Diese Klasse erstellt ein Objekt des Types "Figur". Sie enthält die Infomation, 
 * welche farbe sie ist.
 * 
 * @author (Sarah) 
 */
public class Figur
{
    public static final int BEATEN=0;
    public static final int LIGHTNORMAL=1;
    public static final int LIGHTPOWERFUL=2;
    public static final int DARKNORMAL=3;
    public static final int DARKPOWERFUL=4;
    
    
    private int x;
    private int y;
    private int state;
    Figur(int x, int y, int state)
    {
      this.x=x;
      this.y=y;
      this.state=state;
    }
    //getter Funktionen
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public int getState(){
        return state;
    }
    //setter Funktionen
    public void setX(int newX){
        x=newX;
    }
    
    public void setY(int newY){
        y=newY;
    }
    //positiver Stustand steht dafür, dass die Figur dame ist. Ein negativer dafür, dass sie es nicht ist.
    public void changeState(){
       if(state==LIGHTNORMAL || state==DARKNORMAL){
           state++;
        } else {
            System.out.println("ERROR! An impossible state change was tried!");
        }
    }
    
    public void setStateNull(){
        state=0;
    }
}
