import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;

public class FlowPaneTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final FlowPane flowPane = new FlowPane(5, 10);

        var flowPaneChildren = flowPane.getChildren();
        for(int buttonNumber = 1; buttonNumber < 11; ++buttonNumber){
            flowPaneChildren.add(new Button("Button " + buttonNumber));
        }

        flowPane.setStyle("""
        -fx-padding : 10;
        -fx-border-style : solid inside;
        -fx-border-width : 2;
        -fx-border-insets : 5;
        -fx-border-radius : 5;
        -fx-border-color  : blue;
        """);

        stage.setScene(new Scene(flowPane));
        stage.setTitle("Flow Pane  : Horizontal Test");
        stage.show();
    }
}
