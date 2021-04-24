import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;

public class HBoxFillHeight extends Application{
    
    @Override
    public void start(final Stage stage){
        final Label descLabel = new Label("Description : ");
        final TextArea description = new TextArea();
        description.setPrefRowCount(3);
        description.setPrefColumnCount(10);

        final Button okButton = new Button("Ok");

        final Button cancelButton = new Button("Cancel");
        cancelButton.setMaxHeight(Double.MAX_VALUE);

        final CheckBox fillHeightCheckBox = new CheckBox("Fill Height");
        fillHeightCheckBox.setSelected(true);



        final HBox hbox = new HBox(10, descLabel, description, 
                                       fillHeightCheckBox,
                                       okButton, cancelButton);
        hbox.setStyle("""
        -fx-padding : 10;
        -fx-border-style : solid inside;
        -fx-border-width : 2;
        -fx-border-insets : 5;
        -fx-border-radius : 5;
        -fx-border-color  : blue;
        """);

        fillHeightCheckBox
        .setOnAction(event -> hbox.setFillHeight(fillHeightCheckBox.isSelected()));
        stage.setScene(new Scene(hbox));
        stage.setTitle("HBox Test");
        stage.show();
    }
}
