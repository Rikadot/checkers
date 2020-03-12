import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *The GUI of the game using javaFX
 * The GUI will be called by the main method in order to create the Application.
 * For practicing purpose, the GUI will call itself
 */
public class GUI  extends Application
{
    Main main = new Main();

    BorderPane primary_Layout = new BorderPane();
        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage)
        {
            primaryStage.setTitle("Hello World!");
            //adding buttons
            primary_Layout.setCenter(add_secondary_Layout());

            primaryStage.setScene(new Scene(primary_Layout, 600, 600));
            primaryStage.show();
        }

        public GridPane add_secondary_Layout(){
            GridPane secondary_Layout = new GridPane();
            secondary_Layout.setHgap(2);
            secondary_Layout.setVgap(2);
            //adding Buttons
            makeButtons(secondary_Layout);

            return secondary_Layout;
        }

        public void setButtonColor(Button b,int x,int y){
            if(!main.game.fieldIsEmpty(x, y)){
                if(main.game.isOnField(x, y).isLight()){
                   b.setStyle("-fx-background-color: #add8e6; ");
                }else{
                 if(main.game.isOnField(x, y).isDark()){
                      b.setStyle("-fx-background-color: #00008b; ");
                   }
                }
            }else{
                b.setStyle("-fx-background-color: #D3D3D3; ");
            }
        }

        public void makeButtons(GridPane grid)
        {
            for(int x=1; x<9; x++) {
                for(int y=1; y<9; y++){
                    Button b= new Button();
                    b.setPrefWidth(60);
                    b.setPrefHeight(60);
                    setButtonColor(b,x,y);
                    grid.add(b, x, y);
                    int finalX = x;
                    int finalY = y;

                    b.setOnAction(e -> {
                                main.handleTurn(finalX, finalY);
                            }
                    );
                }
            }
        }
    }
