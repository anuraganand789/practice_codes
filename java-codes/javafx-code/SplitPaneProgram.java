import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

public class SplitPaneProgram extends Application{
    
    @Override
    public void start(final Stage stage){
        final SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(new TextArea(), new TextArea());

        stage.setScene(new Scene(new Group(splitPane), 500, 500));
        stage.setTitle("Split Pane Program");
        stage.show();
    }
     
}

