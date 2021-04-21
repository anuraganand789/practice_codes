import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;

public class ButtonProgram extends Application{
    
    @Override
    public void start(final Stage stage){
        final Label  labelMessage = new Label("");
        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> { 
            labelMessage.setText(((Button) event.getTarget()).getText());
        };

        final Button buttonNew    = new Button("New _N");
        buttonNew.setOnAction(eventHandler);

        final Button buttonSave   = new Button("Save _S");
        buttonSave.setOnAction(eventHandler);

        final Button buttonCancel = new Button("Cancel _C");
        buttonCancel.setOnAction(eventHandler);

        final VBox   vbox = new VBox(8);
        vbox.getChildren().addAll(buttonNew, buttonSave, buttonCancel, labelMessage);

        final Bounds bound = vbox.getBoundsInParent();
        final Rectangle2D rectangleBound = new Rectangle2D(
                                                           bound.getMinX(), 
                                                           bound.getMinY(),
                                                           bound.getWidth(),
                                                           bound.getHeight()
                                                          );


        final Group group = new Group(vbox);
        final Scene scene = new Scene(group, 500, 500);

        stage.setScene(scene);
        stage.setTitle("Button Program");
        stage.show();
    }
}
