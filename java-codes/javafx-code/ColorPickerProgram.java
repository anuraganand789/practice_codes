import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

import javafx.scene.shape.Rectangle;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class ColorPickerProgram extends Application{
    
    @Override
    public void start(final Stage stage){
        final Label labelColorPicker = new Label("Color : ");
        final ColorPicker colorPicker = new ColorPicker();
        final Rectangle rectangle = new Rectangle(150, 150, 200, 200);

        labelColorPicker.setLabelFor(colorPicker);
        colorPicker.setOnAction(event -> rectangle.setFill(colorPicker.getValue()));


        final HBox hbox = new HBox(8);
        hbox.getChildren().addAll(labelColorPicker, colorPicker);

        final VBox vbox = new VBox(8);
        vbox.getChildren().addAll(hbox, rectangle);
        stage.setTitle("Color Picker Program");
        stage.setScene(new Scene(new Group(vbox), 700, 700));
        stage.show();
    }
}
