import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;

import javafx.scene.layout.VBox;

public class MnemonicTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final var root = new VBox(10);
        root.setStyle("""
        -fx-padding : 10;
        -fx-border-style   : solid inside;
        -fx-border-insets  : 5;
        -fx-border-radius  : 5;
        -fx-border-width   : 2;
        -fx-border-color   : blue;
        """);
        final var rootChildren = root.getChildren();

        final var scene = new Scene(root, 500, 500);

        final var labelMessage = new Label("""
        Press Ctrl + X on windows
        and 
        Meta + X on Mac to close the window.
        """);

        rootChildren.add(labelMessage);

        final var labelPress = new Label("Press Alt + 1 or Alt + 2");
        rootChildren.add(labelPress);

        final var buttonOne = new Button("Button _1");
        buttonOne.setOnAction(actionEvent -> labelPress.setText("Button 1 Clicked"));

        final var buttonTwo = new Button("Button 2");
        buttonTwo.setOnAction(actionEvent -> labelPress.setText("Button 2 Clicked"));

        rootChildren.addAll(buttonOne, buttonTwo);
        final var keyCombination = new KeyCodeCombination(KeyCode.DIGIT2,
                                                    KeyCombination.ALT_DOWN);
        final var mnemonic = new Mnemonic(buttonTwo, keyCombination);
        scene.addMnemonic(mnemonic);

        final var keyCombinationForAccelerator =
        new KeyCodeCombination(KeyCode.X,
                               KeyCombination.ALT_DOWN);
        
        final Runnable task = () -> scene.getWindow().hide();
        scene.getAccelerators().put(keyCombinationForAccelerator, task);

        stage.setScene(scene);
        stage.setTitle("Using Mnemonics And Accelerator");

        stage.show();
    }
}
