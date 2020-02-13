
/**
 * This class creates objects from type "figure". It represents every figure on the checker field -
 * therefore it knows its position ion the "field". The field itself doesn't exist as an object. This object
 * contain following informations for the game logic:
 * -X and Y coordinates
 * -color of the figure
 * -queen or not
 * 
 * @author (Sarah) 
 */
public class Figure
{
    public static final int BEATEN=0;
    public static final int LIGHTNORMAL=1;
    public static final int LIGHTQUEEN=2;
    public static final int DARKNORMAL=3;
    public static final int DARKQUEEN=4;
    
    
    private int x;
    private int y;
    private int state;
    Figure(int x, int y, int state)
    {
      this.x=x;
      this.y=y;
      this.state=state;
    }
    //getter functions
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public int getState(){
        return state;
    }
    //setter functions
    public void setX(int newX){
        x=newX;
    }
    
    public void setY(int newY){
        y=newY;
    }

    public void changeState(){
       if(state==LIGHTNORMAL || state==DARKNORMAL){
           state++;
        } else {
           //making sure that a figure from a player can not change colors.
            System.out.println("ERROR! An impossible state change was tried!");
        }
    }
    //setting the state to "0" means that a figure got beaten.
    public void setStateNull(){
        state=0;
    }

}
