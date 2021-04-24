import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HBoxTest extends Application{
    
    @Override
    public void start(final Stage stage){
        
        final Label nameLbl = new Label("Name : ");
        final TextField nameField = new TextField(); 
        final Button okButton = new Button("Ok");
        final Button cancelButton = new Button("Cancel");

        final HBox hbox = new HBox(10, nameLbl, nameField, okButton, cancelButton);

        HBox.setHgrow(nameField, Priority.ALWAYS);
        hbox.setStyle("""
        -fx-padding : 10;
        -fx-border-style : solid inside;
        -fx-border-width : 2;
        -fx-border-insets : 5;
        -fx-border-radius : 5;
        -fx-border-color  : blue;
        """);

        stage.setScene(new Scene(hbox));
        stage.setTitle("HBox Test");
        stage.show();
    }
}
