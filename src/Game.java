import java.util.ArrayList;
/**
 * This class manages the whole game. That includes the objects from type figure and a GUI object.
 * The gameLoop is where the game logic will run, supported by functions in this class.
 * 
 * @author (Sarah)
 */

/**
 * To do list:
 *  -"deleting" figures from the field.
 *  -finishing "has to beat"
 *  -writing "isRightDirection" done!
 *  -checking that x an y have both to be 1 and/or -1 done
 *  -writing if the player trys to make a valid move done
 *  -writing if a figure reaches the end, the state is changed to QUEEN
 *  -at the end: writing the game loop,maybe putting that in a new class
 * */
public class Game
{   
    ArrayList<Figure> field= new ArrayList<Figure>();
    public String PL = "Player 1"; //standard name for the player with the light figures
    public String PD = "Player 2"; //standard name for the player with the dark figures
    public Game()
    {
      createFigures();
    } 
    
    public void gameLoop()
    {
    	
     //folllowing are notes on the order of exeutions during one turn

     //load GUI
     //starting loop
     //check if the player has to beat another figure
     //waiting for player input
     //check if the move is in a allowed direction
     //check is the moves goes to an empty field
     //doing the move
     //restarting the loop but it is the other players turn

     //ending the loop if a player has won

    }
    
    /**
     * Creates the figures at the beginning of the game. The figures are positioned
     * in a 8*8 field. The "state" describes if a figure is "light", "dark" and if that figure is
     * a "queen" or not.
       */
      //done
    private void createFigures()
    {
        //1-3 in the Y-layer with DARKNORMAL (x 1-8)
        //6-8 in der Y-layer with LIGHTNORMAL

        //cleaning the array and making this function callable even after a played game
        field.clear();

        for(int y=1; y<=8;y++){
            for(int x=1; x<=8; x++){
               //if y is uneven, use only even x - also the opposite is true.
               //other positions are impossible!
                if(y%2==0 && x%2==0){
                   x++;
                }else{
                    if(y%2==1 && x%2==1){
                        x++;
                    }
                }
               if(x>8){
                   break;
                }
               switch(y){
                   case 1:
                   case 2:
                   case 3:
                	//dark figures are placed in the first 3 rows
                    field.add(new Figure(x,y, Figure.DARKNORMAL));
                    break;
                   case 6:
                   case 7:
                   case 8:
                	//light figures are placed in the last 3 rows   
                    field.add(new Figure(x,y, Figure.LIGHTNORMAL));
                    break;
                }
            }
       }
    }
    /**
     * This function removes a Figure out of the game logic
     * The state get set to BEATEN and 
     * @param f
     */
    private void removeFigure(Figure f)
    {
    	//figure objects are not removed
    	f.setStateNull();
    	f.setX(0);
    	f.setY(0);
    }
    /**
     *This function checks, if the given figure has to beat another one
     */
    private boolean hasToBeat(Figure temp)
    {
        //this function is not finished yet
        for(int i=0;i<field.size();i++){
            //figures with the state BEATEN are not in the game anymore
            //the figure which is tested can beat itself, therefore shall be ignored
            if(field.get(i).getState()!= Figure.BEATEN || field.get(i)!=temp){
                continue;
            }
            //only Figures of opposit color need to get checked 
            
            //only figures in diaginal reach needs to get checked
            //a NORMAL Figure cannot beat a figure behind it 
        }
        
        return false;
    }
    
    /**
     * This function checks which figure is on the given field.
     * @return the figure or null
    * */
    private Figure isOnField(int x, int y)
    {
        for(int i=0;i<field.size();i++) {
            //checking if that place in the array is not empty.
            if (field.get(i) != null) {
                //checking if the x and y coordinate are fitting.
                if (field.get(i).getX() == x && field.get(i).getY() == y) {
                    return field.get(i);
                }
            }
        }
        //it returns null if no figure is on the field
        return null;
    }

    /**
     * This function checks if there is a figure on the given coordinates
     *
     * @return true=leer or false
     */
    private boolean fieldIsEmpty(int x, int y)
    {
       if(isOnField(x,y)==null){
           return true;
       }else{
       	System.out.println("The player tried to move on an occupied field!");
           return false;
       }
    }

    /**
     * This function checks if the figure can move in the given direction. the check on the y coordinate
     * is not made for queens.
     * @return true or false
     */
    private boolean isRightDirection(Figure f, int y)
    {	
    	//QUEEN can move in y-growing and y-decreasing direction
    	if(f.isQueen()){
    			return true;
    	}
    	//DARK has to move in in y-growing direction
    	if(f.getState()==Figure.DARKNORMAL && f.getY()<=y){   		
    			return true;   		
    	}
    	//LIGHT has to move in y-decreasing direction
    	if(f.getState()==Figure.LIGHTNORMAL && f.getY()>=y){    		
    			return true;    		
    	}
    	System.out.println("The Player tried to move in the wrong direction!");
       return false;
    }
     
    /**
     * This function makes sure that a figure is only moving if x and y are 1/-1.
     * This method does not check if the Figure is Queen or not
     * @return
     */
    private boolean isMovingInRightDistanze(Figure f, int x, int y)
    {
    	if(f.getX()-x==1 || f.getX()-x==-1){
    		if(f.getY()-y==1 || f.getY()-y==-1){
    			return true;
    		}
    	}
    	System.out.println("The Player tried to move on a invalid field");
    	return false;
    } 
    
    /**
     * This method checks if the player trys to make a valid move
     * This includes:
     * -x and y are both 1 and/or -1
     * -is moving in the right direction
     * -is moving on an empty field
     * This function is not called if hasToBeat is true!
     * 
     * 
     * @return true  or false
     */
    private boolean isValidMove(Figure f, int x, int y)
    {
    	//checks are done in the same order as described above.
    	if(isMovingInRightDistanze(f, x, y)){
    		if(isRightDirection(f, y)){
    			if(fieldIsEmpty(x, y)){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /**
     * This function checks if the game is over and who has won.
     * @return true or false
     */
    private String hasWon()
    {
        int splight=0;
        int spdark=0;
        //counting how many figures are remaining for each player 
        for(int i=0;i<field.size();i++){
            if(field.get(i).isLight()){
                splight++;
            }else{
                if(field.get(i).isDark()){
                    spdark++;
                }
            }
        }
        //if there is no figure remaining from one player, that player has lost
        if(splight==0){
            return PD+" has won!";
        }else{
            if(spdark==0){
                return PL+" has won";
            }else{
                return null;
            }
        }
    }
    
}
