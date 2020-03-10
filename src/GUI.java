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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *The GUI of the game using javaFX
 * The GUI will be called by the main method in order to create the Application.
 * For practicing purpose, the GUI will call itself
 */
public class GUI  extends Application
{

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

            primaryStage.setScene(new Scene(primary_Layout, 500, 350));
            primaryStage.show();
        }





        public GridPane add_secondary_Layout(){
            GridPane secondary_Layout = new GridPane();
            secondary_Layout.setHgap(1);
            secondary_Layout.setVgap(1);
            //adding Buttons
            for(int x=0; x<8; x++) {
                for(int y=0; y<8; y++){
                    Button b= new Button(x+" x "+y);
                    b.setPadding(new Insets(14));
                    secondary_Layout.add(b, x, y);
                    int finalX = x;
                    int finalY = y;
                    b.setOnAction(e ->  ));
                }
            }

            return secondary_Layout;
        }
    }
