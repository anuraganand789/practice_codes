import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;

import javafx.scene.web.HTMLEditor;


public class HtmlEditorProgram extends Application{
    
    @Override
    public void start(final Stage stage){
        stage.setTitle("Html Editor Program");
        stage.setScene(new Scene(new Group(new HTMLEditor()), 500, 500));
        stage.show();
    }
}
