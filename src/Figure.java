
/**
 * This class creates objects from type "Figure". It represents every Figure on the checker field -
 * therefore it knows its position ion the "field". The field itself doesn't exist as an object. This object
 * contain following informations for the game logic:
 * -X and Y coordinates
 * -color of the Figure
 * -queen or not
 * 
 * @author (Sarah) 
 */
public class Figure
{
    public static final int BEATEN=0, LIGHTNORMAL=1, LIGHTQUEEN=2, DARKNORMAL=3, DARKQUEEN=4;

    private int x, y, state;
    public Figure(int x, int y, int state)
    {
      this.x=x;
      this.y=y;
      this.state=state;
    }
    //getter functions
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    public int getState()
    {
        return state;
    }
    //setter functions
    public void setX(int newX)
    {
        x=newX;
    }
    
    public void setY(int newY)
    {
        y=newY;
    }
    //checking if a Figure is QUEEN or not
    public boolean isQueen()
    {
    	if(state==LIGHTQUEEN || state==DARKQUEEN){
    		return true;
    	}
    	return false;
    }
    //checking if a Figure is LIGHT or DARK
    public boolean isLight()
    {
    	if(state==LIGHTNORMAL || state==LIGHTQUEEN){
    		return true;
    	}
    	return false;
    }
    
    public boolean isDark()
    {
    	if(state==DARKNORMAL || state==DARKQUEEN){
    		return true;
    	}
    	return false;
    }
    
    public void changeState(){
       if(!isQueen()){
           state++;
        } else {
           //making sure that a Figure from a player can not change colors.
            System.out.println("ERROR! An impossible state change was tried! Figure is already QUEEN");
        }
    }
    //setting the state to "0" means that a Figure got beaten.
    public void setStateNull(){
        state=BEATEN;
    }

}
