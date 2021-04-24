import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class StackPaneTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Rectangle rectangle = new Rectangle(200, 50);
        rectangle.setStyle("""
        -fx-fill              : lavender;
        -fx-stroke            : black;
        -fx-stroke-type       : inside;
        -fx-stroke-dash-array : 5 5;
        -fx-stroke-width      : 1;
        -fx-stroke-radius     : 5;
        """);
        final StackPane stackPane = new StackPane(rectangle, new Text("A Rectangle"));
        stackPane
        .setStyle("""
        -fx-padding : 10;
        -fx-border-style   : solid inside;
        -fx-border-width   : 2;
        -fx-border-insets  : 5;
        -fx-border-radius  : 5;
        -fx-border-color   : blue;
        """);

        stage.setTitle("Stack Pane Test");
        stage.setScene(new Scene(stackPane));
        stage.show();
    }
}
