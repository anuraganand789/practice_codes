import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.Button;

public class AnchorPaneTest extends Application{
    
    @Override
    public void start(final Stage stage){
       final AnchorPane anchorPane = new AnchorPane();
       final Button topLeft = new Button("Ok"); 
       AnchorPane.setTopAnchor(topLeft, 10.0);
       AnchorPane.setLeftAnchor(topLeft, 10.0);

       final Button bottomRight = new Button("Cancel");
       AnchorPane.setBottomAnchor(bottomRight, 10.0);
       AnchorPane.setRightAnchor(bottomRight, 10.0);

       anchorPane.getChildren().addAll(topLeft, bottomRight);
       stage.setScene(new Scene(anchorPane, 400, 100));
       stage.setTitle("Anchor Pane Test");
       stage.show();
    }
}
