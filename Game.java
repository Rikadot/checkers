import java.util.ArrayList;
/**
 * Diese Klasse verwaltet die Klassen Figur und GUI. Innerhalb des gameloops finden alle Prozesse wärend des Spiels statt.
 * 
 * @author (Sarah) 
 * @version (1)
 */
public class Game
{   
    ArrayList<Figur> field= new ArrayList<Figur>();
    public String SPL = "Spieler 1";
    public String SPD = "Spieler 2";
    public Game()
    {
      createFigures(); 
      //geschlagene Fiuren aus dem "Feld entfernen"
    } 
    
    public void gameLoop()
    {
     //GUI lädt

     //GameLoop wird gestartet

     //Prüfen, ob Zug erforderlich ist
     //Warten auf Eingabe des Users
     //Prüfe, ob Zug in erlaubte Richtung geht
     //Prüfe, ob Zug auf ein leeres Feld führt
     //Zug wird ausgeführt
     //Nächste Spieler ist dran. Loop wird neu gestartet.
     //loop wird beendet, sobald ein Spieler gewonnen bzw verloren hat.

    }
    
    /**
     * Erstellt die Figuren im Array zu beginn des Spieles. Die Figuren sind In einem 8*8
     * Feld positioniert. In einer Schleife werden den Figuren die richtige Position, sowie 
     * der Status zugewiesen. Der Status beschreibt, ob die Figur hell/dunkel und Dame/nicht-Dame 
     * ist. Der Status 0 steht für eine Figur, welche nicht mehr im Spiel ist.
       */
      //fertig
    private void createFigures(){
        //1-3 in der Y-Ebene zu belegen mit DARKNORMAL (x 1-8)
        //6-8 in der Y-Ebene mit LIGHTNORMAL belegen
        field.clear();
        for(int y=1; y<=8;y++){
            for(int x=1; x<=8; x++){
               //wenn y ungerade ist, werden nur gerade x verwendet- genauso anderherum.
               //andere Positionen sind illegal!
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
                    field.add(new Figur(x,y,Figur.DARKNORMAL));
                    break;
                   case 6:
                   case 7:
                   case 8:
                    field.add(new Figur(x,y,Figur.LIGHTNORMAL));
                    break;
                }
               
        }
       }
    }
    
    /**
     *
     * Diese Funktion überprüft, ob eine einzelne, ihr übergebene, Figur einen Zug tätigen muss.
     * 
     */
    private boolean hasToBeat(Figur temp)
    {
        //this function is not finished yer
        for(int i=0;i<field.size();i++){
            //figures with the state BEATEN are not in the game anymore
            //the figure which is tested can beat ifself, therefore shall be ignored
            if(field.get(i).getState()!=Figur.BEATEN || field.get(i)!=temp){
                continue;
            }
            //only Figures of opposit color need to get checked 
            //only figures in dioginal reach needs to get checked
        }
        
        return false;
    }
    
    /**
    *Diese Funktion gibt zurück, welche Figur sich auf dem Ausgewählzen feld befindet.
     *
     * @retun the figure or null
    * */
    private Figur isOnField(int x, int y){
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
     * Diese Funktion prüft, ob das Feld, wo sich die Figur hinbewegen soll, leer ist.
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
     * Diese funktion prüft, ob sich die Figur in die Richtige Richtung
     * bewegen soll. Für Damen entfällt diese Prüfung.
     * @return true or false
     */
    private boolean isRightDirection()
    {
       return false;
    }

    /**
     * Diese Funktion prüft ob das Spiel zuende ist. Sie prüft, wer gewonnen hat.
     * @return true or false
     */
    private String hasWon()
    {
        int splight=0;
        int spdark=0;
        //counting how many figures are remaining for each player 
        for(int i=0;i<field.size();i++){
            if(field.get(i).getState()==Figur.LIGHTNORMAL || field.get(i).getState()==Figur.LIGHTPOWERFUL){
                splight++;
            }else{
                if(field.get(i).getState()==Figur.DARKNORMAL || field.get(i).getState()==Figur.DARKPOWERFUL){
                    spdark++;
                }
            }
        }
        //if there is no figure remaining from one player, that player has lost
        if(splight==0){
            return SPD;
        }else{
            if(spdark==0){
                return SPL;
            }else{
                return null;
            }
        }
    }
    
}
