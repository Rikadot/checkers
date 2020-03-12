        Before launching
-library for Junit4 is included
-library for JavaFX is needed if a newer version than Java 8 is used!
    settings for the JavaFX SDK in your IDE
projectstructure --> including the lib in the JavaFX file as library
edit settings for running the program
following needs to be included in VM settings:
    --module-path /Path/to/javafx-sdk-13.0.2/lib
    --add-modules javafx.controls,javafx.fxml

-------------------------------------------------------------------------------

TO DO
   -checking ig game game includes all needed functions
        -isValidMove() for if the player has to jump a figure


   -sole problems described in the main class

   -finishing the UI

   -writing UnitTests for remaining functions of Game

-----------------------------------------------------------------------------
DARK = hex #00008b
LIGHT = hex #add8e6