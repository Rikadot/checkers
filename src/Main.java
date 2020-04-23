/**
 * This class includes the actual
 */

public class Main {
    //this boolean checks who is at turn. if the boolean is true, then light is at turn, if the boolean is false, dark is at turn;
    private boolean LightAtTurn=true;
    public boolean fieldClicked =false;

    public Game game = new Game();

    public Main()
    {
      game.createFigures();
    }

    public void gameLoop()
    {
        do{

        }
        while(fieldClicked);
        if(LightAtTurn){
            LightAtTurn=false;
        }
    }

    public void handleTurn(int x, int y)
    {
        fieldIsClicked(x,y);
        //the order of checks needed:
        //checking if the player has to beat another figure.
        //needs to handle who's turn it is
        //needs to know which field is clicked
        //needs to define an order in which all necessary checks are done

    }
    public boolean fieldIsClicked(int x, int y)
    {
        fieldClicked=true;
        //field is marked now
        //game disables all fields
        //all fields are disabled beside the field the player can move the figure to
        //if there's no figure on the field, nothing happens
        System.out.println(x+" "+y);
        return false;
    }


    public boolean PlayerHasToBeat(boolean b)
    {
        for(int i=0;i<game.field.size(); i++){
            if (b) {
                if(game.field.get(i).isLight()){
                    if(game.hasToBeat(game.field.get(i))){
                        //entering what has to be done
                        //current plan: only enable the fields where this is true
                    }
                }
            }else{
                if(game.field.get(i).isDark()){
                    if(game.hasToBeat(game.field.get(i))){
                        //entering what has to be done
                    }
                }
            }

        }
        return false;
    }
    /**
        This function provides the GUI if a field need to be disabled
     */
    public boolean disableOtherPlayerField(int x, int y)
    {
        if(game.fieldIsEmpty(x,y)) {return true;}
        //cheling first if a figure has the beaten for PL
        if(game.PlayerHasToBeat(game.PL)){
            if(game.hasToBeat(game.returnFigure(x,y))){
                return false;
            }else{
                //cheking this is the field the given figure has to move to
            }
        }

        //doing the same as above for PD
        if(game.PlayerHasToBeat(game.PD)){
            if(game.hasToBeat(game.returnFigure(x,y))){
                return false;
            }else{
                //cheking this is the field the given figure has to move to
            }
        }

            return false;
    }


}
