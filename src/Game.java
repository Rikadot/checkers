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
 *  -writing "isRightDirection"
 *  -at the end: witing the game loop
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
     //restanrting the loop but it is the other players turn

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
                    field.add(new Figure(x,y, Figure.DARKNORMAL));
                    break;
                   case 6:
                   case 7:
                   case 8:
                    field.add(new Figure(x,y, Figure.LIGHTNORMAL));
                    break;
                }
            }
       }
    }
    
    /**
     *
     *This function checks, if the given figure has to beat another one
     * 
     */
    private boolean hasToBeat(Figure temp)
    {
        //this function is not finished yet
        for(int i=0;i<field.size();i++){
            //figures with the state BEATEN are not in the game anymore
            //the figure which is tested can beat ifself, therefore shall be ignored
            if(field.get(i).getState()!= Figure.BEATEN || field.get(i)!=temp){
                continue;
            }
            //only Figures of opposit color need to get checked 
            //only figures in dioginal reach needs to get checked
        }
        
        return false;
    }
    
    /**
     * This funtion checks which figure is on the given field.
     * @retun the figure or null
    * */
    private Figure isOnField(int x, int y)
    {
        for(int i=0;i<field.size();i++) {
            //checking if that place in the array is not empthy.
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
     * @return true=leer or false=besetzt
     */
    private boolean fieldIsEmpty(int x, int y)
    {
       if(isOnField(x,y)==null){
           return true;
       }else{
           return false;
       }
    }

    /**
     * This function checks if the figure can move in the given direction. the check on the y coordinate
     * is not made for queens
     * @return true or false
     */
    private boolean isRightDirection()
    {
       return false;
    }

    /**
     * This function checks if the game is over and wno has won.
     * @return true or false
     */
    private String hasWon()
    {
        int splight=0;
        int spdark=0;
        //counting how many figures are remaining for each player 
        for(int i=0;i<field.size();i++){
            if(field.get(i).getState()== Figure.LIGHTNORMAL || field.get(i).getState()== Figure.LIGHTQUEEN){
                splight++;
            }else{
                if(field.get(i).getState()== Figure.DARKNORMAL || field.get(i).getState()== Figure.DARKQUEEN){
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
