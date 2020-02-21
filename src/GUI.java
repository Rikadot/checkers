import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *The GUI of the game using javaFX
 * The GUI will be called by the main method in order to create the Application.
 * For practicing purpose, the GUI will call itself
 */
public class GUI  extends Application implements EventHandler<ActionEvent>
{
        Button button1;

    public static void main(String[] args)
        {
            //launch starts the Application.
            launch(args);
        }

    @Override
    public void start(Stage primaryStage) throws Exception
        {
            //a stage is the window
             primaryStage.setTitle("Title of the window");

            button1= new Button();
            button1. setText("Click me");

            button1.setOnAction(this);

            StackPane layout = new StackPane();
            layout.getChildren(). add(button1);
            Scene scene = new Scene(layout, 300, 250);

            primaryStage.setScene(scene);
            primaryStage.show();
        }

    @Override
    public void handle(ActionEvent event)
        {
        if(event.getSource()==button1){
        System.out.println("Button was clicked");
        }
        }

}
