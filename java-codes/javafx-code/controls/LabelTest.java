import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

public class LabelTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final var firstNameTextField = new TextField();
        final var firstNameLabel = new Label("_First Name");
        firstNameLabel.setLabelFor(firstNameTextField);
        firstNameLabel.setMnemonicParsing(true);

        final var lastNameTextField = new TextField();
        final var lastNameLabel = new Label("_Last Name");
        lastNameLabel.setLabelFor(lastNameTextField);
        lastNameLabel.setMnemonicParsing(true);

        final var gridPane = new GridPane();
        gridPane.addRow(0, firstNameLabel, firstNameTextField);
        gridPane.addRow(1, lastNameLabel,  lastNameTextField);
        gridPane.setStyle("""
        -fx-padding : 10;
        -fx-border-style : solid inside;
        -fx-border-width : 2;
        -fx-border-insets : 5;
        -fx-border-radius : 5;
        -fx-border-color  : blue;
        """);

        stage.setTitle("Label Test");
        stage.setScene(new Scene(gridPane, 500, 500));
        stage.show();
    }
}
