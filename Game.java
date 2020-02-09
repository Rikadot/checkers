import java.util.ArrayList;
/**
 * Diese Klasse verwaltet die Klassen Figur und Feld. Das GUI erstellt nur noch diese
 * Klasse, um ein Spiel zu starten.
 * 
 * @author (Sarah) 
 * @version (1)
 */
public class Game
{   
    ArrayList<Figur> field= new ArrayList<Figur>();
    public Game()
    {
      erstelleFiguren(); 
      //geschlagene Fiuren aus dem "Feld entfernen"
    } 
    
    public void gameLoop()
    {
     //GUI lädt

     //GameLoop wird gestartet

     //Prüfen, ob Zug erforderlich ist
     //hasToBeat();
     //Warten auf Eingabe des Users
     //Prüfe, ob Zug in erlaubte Richtung geht
     //Prüfe, ob Zug auf ein leeres Feld führt
     //Zug wird ausgeführt
     //Nächste Spieler ist dran. Loop wird neu gestartet.

    }
    /**
     * Erstellt die Figuren im Array zu beginn des Spieles. Die Figuren sind In einem 8*8
     * Feld positioniert. In einer Schleife werden den Figuren die richtige Position, sowie 
     * der Status zugewiesen. Der Status beschreibt, ob die Figur hell/dunkel und Dame/nicht-Dame 
     * ist. Der Status 0 steht für eine Figur, welche nicht mehr im Spiel ist.
       */
    private void erstelleFiguren(){
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
     * Diese Funktion überprüft, ob der Spieler im gegenwärtigen Zug die Figur
     * des anderen Spieler schlagen muss. Wenn ja, dann wird die zu spielende
     * Figur makiert. Züge mit anderen Figuren sind ungültig. Es muss ein Zug
     * getätigt werden, der eine Figur eines anderen Spielers aus dem Spiel 
     * bringt.
     */
    private boolean hasToBeat()
    {
        for(int i=0;i<field.size();i++){
            if(field.get(i).getState()!=Figur.BEATEN){
                continue;
            }
            //checking state LIGHT
            if(field.get(i).getState()==Figur.LIGHTNORMAL || field.get(i).getState()==Figur.LIGHTPOWEFUL){
                
            }
            //checking state DARK
            if(field.get(i).getState()==Figur.DARKNORMAL || field.get(i).getState()==Figur.DARKPOWEFUL){
                
            }
        }
        
        return false;
    }
    
    private Figur IsOnField(){
        for(int i=0;i<field.size();i++){
            
        }
        return null;
    }

    /**
     * Diese Funktion prüft, ob das Feld, wo sich die Figur hinbewegen soll, leer ist.
     *
     * @return true or false
     */
    private boolean fieldIsEmpty()
    {
       return false; 
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
     * Diese Funktion prüft ob das Spiel zuende ist. Sie prüft, ob der Gegner noch
     * Figuren zur verfügung hat oder
     * @return true or false
     */
    private boolean hasWon()
    {
    return false;
    }
    
}
