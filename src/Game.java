import java.util.ArrayList;

/**
 * This class manages the whole game. That includes the objects from type Figure and a GUI object.
 * The gameLoop is where the game logic will run, supported by functions in this class.
 *
 * @author (Sarah)
 */

public class Game {
    public ArrayList<Figure> field = new ArrayList<Figure>();
    public String PL = "Player Light", //standard name for the player with the light figures
            PD = "Player Dark"; //standard name for the player with the dark figures

    public Game() {
    }

    public void gameLoop() {
        //folllowing are notes on the order of exeutions during one turn
        //load GUI
        //starting loop
        //check if the player has to beat another Figure
        //waiting for player input
        //check if the move is in a allowed direction
        //check is the moves goes to an empty field
        //doing the move
        //restarting the loop but it is the other players turn
        //ending the loop if a player has won
    }

    /**
     * Creates the figures at the beginning of the game. The figures are positioned
     * in a 8*8 field. The "state" describes if a Figure is "light", "dark" and if that Figure is
     * a "queen" or not.
     ***/

    public void createFigures() {
        //1-3 in the Y-layer with DARKNORMAL
        //6-8 in der Y-layer with LIGHTNORMAL

        //making sure the field is empty when the function gets called
        field.clear();

        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                //making sure that only every second field gets a figure
                //this comes down to that x and y may never be even or uneven numbers at the same time
                if (x % 2 == 0 && y % 2 == 1 || x % 2 == 1 && y % 2 == 0) {
                    //filling the first 3 rows with DARKNORMAL

                    if (y <= 3) {
                        field.add(new Figure(x, y, Figure.DARKNORMAL));
                    } else {
                        //filling the last 3 rows with LIGHTNORMAL
                        if (y >= 6 && y <= 8) {
                            field.add(new Figure(x, y, Figure.LIGHTNORMAL));
                        }
                    }

                }
            }
        }
        System.out.println("Figures were created!");
    }


    /**
     * This function removes a Figure out of the game logic
     * The state get set to BEATEN and
     *
     * @param f
     */
    public void removeFigure(Figure f) {
        //Figure objects are not removed from array list but out of sign for the gamelogic
        f.setStateNull();
        f.setX(0);
        f.setY(0);
    }

    /**
     * Tis method moves a figure to another field. This method is not checking if a move was valid or not
     *
     * @param f = a figure
     * @param x = the x-coordinate of the field the figure wants to move to
     * @param y = zehe y-coordinate of the fiel the figure wants to move to
     */
    public void moveFigure(Figure f, int x, int y) {
        f.setX(x);
        f.setY(y);
    }

    /**
     * This function checks if the player has to beat a Figure during their turn. The Player is given with the String
     * @param Player == name of the Player
     * @return
     */
    public boolean PlayerHasToBeat(String Player) {
        //only cheking light ot dark figures during the move of the given player
        if (Player.equals(PD)) {
            for (int i = 0; i < field.size(); i++) {
                if (field.get(i).isLight() && hasToBeat(field.get(i)) ) {
                    return true;
                }
            }
        } else {
            if (Player.equals(PL)) {
                for (int i = 0; i < field.size(); i++) {
                    if (field.get(i).isDark() && hasToBeat(field.get(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
            /**
             *This function checks, if the given Figure has to beat another one
             */
            public boolean hasToBeat(Figure f)
            {

                for (int i = 0; i < field.size(); i++) {
                    //figures with the state BEATEN are not in the game anymore
                    //the Figure which is tested can beat itself, therefore shall be ignore
                    if (field.get(i).getState() == Figure.BEATEN || field.get(i) == f) {
                        break;
                    }
                    //only figures in diaginal reach needs to get checked
                    //a NORMAL Figure cannot beat a Figure behind it
                    if (!isInReach(f, field.get(i))) {
                        break;
                    }
                    //only Figures of opposit color need to get checked
                    if (f.isLight() && field.get(i).isLight()) {
                        break;
                    }
                    if (f.isDark() && field.get(i).isDark()) {
                        break;
                    }
                    //making sure that the field behind the figure is empty
                    int x = f.getX() - field.get(i).getX();
                    int y = f.getY() - field.get(i).getY();
                    //checking if the field figure temp would have to jump on is empty
                    if (fieldIsEmpty(field.get(i).getX() - x, field.get(i).getY() - y)) {
                        return true;
                        //only allowing moves that is beating another figures.
                    }
                }
                return false;
            }
            /**
             * This function lets the figure f beat the figure b. As long there's a figure that needs to be beaten,
             * the progress takes place. If hasToBeat() returns false, the player can't beat a figure
             * @param f beating figure
             * @param b beaten figure
             */
            public void jumpFigure (Figure f, Figure b)
            {
                if (hasToBeat(f)) {
                    int x = f.getX() - b.getX();
                    int y = f.getY() - b.getY();
                    moveFigure(f, b.getX() - x, b.getY() - y);
                    removeFigure(b);
                }
            }
            /**
             * This fuction checks if Figure b is in diagonal reach of Figure a
             * Figure a is the Figure of the player who is at turn
             * @return true or false
             */
            private boolean isInReach (Figure a, Figure b)
            {
                //includes a checking if the figure is QUEEN or not
                if (isRightDirection(a, b.getY()) && isMovingInRightDistanze(a, b.getX(), b.getY())) {
                    return true;
                }
                return false;
            }


            /**
             * This function checks if the Figure can move in the given direction. the check on the y coordinate
             * is not made for queens.
             * @return true or false
             */
            public boolean isRightDirection (Figure f,int y)
            {
                //QUEEN can move in y-growing and y-decreasing direction
                if (f.isQueen()) {
                    return true;
                }
                //DARK has to move in in y-growing direction
                if (f.getState() == Figure.DARKNORMAL && f.getY() <= y) {
                    return true;
                }
                //LIGHT has to move in y-decreasing direction
                if (f.getState() == Figure.LIGHTNORMAL && f.getY() >= y) {
                    return true;
                }
                System.out.println("The Player tried to move in the wrong direction!");
                return false;
            }

            /**
             * This function checks if there is a Figure on the given coordinates
             *
             * @return true=leer or false
             */
            public boolean fieldIsEmpty ( int x, int y)
            {
                if (isOnField(x, y) == null) {
                    return true;
                } else {
                    //System.out.println("The player tried to move on an occupied field!");
                    return false;
                }
            }

            /**
             * This function checks which Figure is on the given field.
             * @return the Figure or null
             * */
            public Figure isOnField ( int x, int y)
            {
                for (int i = 0; i < field.size(); i++) {
                    //checking if that place in the array is not empty.
                    if (field.get(i) != null) {
                        //checking if the x and y coordinate are fitting.
                        if (field.get(i).getX() == x && field.get(i).getY() == y) {
                            return field.get(i);
                        }
                    }
                }
                //it returns null if no Figure is on the field
                return null;
            }

            /**
             * This function makes sure that a Figure is only moving if x and y are 1/-1.
             * This method does not check if the Figure is Queen or not
             * @return
             */
            private boolean isMovingInRightDistanze (Figure f,int x, int y)
            {
                if (f.getX() - x == 1 || f.getX() - x == -1) {
                    if (f.getY() - y == 1 || f.getY() - y == -1) {
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
            public boolean isValidMove (Figure f,int x, int y)
            {
                //checks are done in the same order as described above.
                if (isMovingInRightDistanze(f, x, y)) {
                    if (isRightDirection(f, y)) {
                        if (fieldIsEmpty(x, y)) {
                            return true;
                        }
                    }
                }
                if(hasToBeat(f)){

                }
                return false;
            }

    /**
     * This function sets x and y to 1 or -1 in order to display the direction of the Figure
     * @param f The primary Figure
     * @param b The secondary Figure
     * @param x
     * @param y
     */

    public void directionOfFigure(Figure f, Figure b, int x, int y)
             {
                 x = f.getX()-b.getX();
                 y = f.getY()-b.getY();

                 while(x>1){
                     x--;
                 }
                 while(x<-1){
                     x++;
                 }
                 while(y>1){
                     y--;
                 }
                 while(y<-1){
                     y++;
                 }

             }

            /**
             * This function changes a Figure which has the state NORMAL to QUEEN
             * if that Figure reaches the opposite end od the field
             */
            public void toQueen (Figure f,int y)
            {
                if (f.isQueen()) {
                    return;
                }
                //dark figures start at the rows 1-3, so row 8 is the opposite row
                //light figures start at row 6-9, so row 1 is the opposite row
                if ((f.isDark() && y == 8) || (f.isLight() && y == 1)) {
                    f.changeState();
                }
            }

            /**
             * This function checks if the game is over and who has won.
             * @return true or false
             */
            public String hasWon ()
            {
                int splight = 0;
                int spdark = 0;
                //counting how many figures are remaining for each player
                for (int i = 0; i < field.size(); i++) {
                    if (field.get(i).isLight()) {
                        splight++;
                    } else {
                        if (field.get(i).isDark()) {
                            spdark++;
                        }
                    }
                }
                //if there is no Figure remaining from one player, that player has lost
                if (splight == 0) {
                    return PD + " has won!";
                } else {
                    if (spdark == 0) {
                        return PL + " has won";
                    } else {
                        return null;
                    }
                }
            }
        }
