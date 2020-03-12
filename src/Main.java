/**
 * This class includes the actual
 */

public class Main {
    //this boolean checks who is at turn. if the boolean is true, then light is at turn, if the boolean is false, dark is at turn;
    private boolean LightAtTurn=true;

    public Game game = new Game();

    public Main()
    {
      game.createFigures();
    }

    public void handleTurn(int x, int y) {
        //the order of checks needed:
        //checking if the player has to beat another figure.
        //needs to handle who's turn it is
        //needs to know which field is clicked
        //needs to define an order in which all necessary checks are done
        System.out.println(x+" "+y);
    }
    public void fieldClicked(int x, int y){

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


}
