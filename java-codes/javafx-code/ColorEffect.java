import javafx.application.Application;

import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.effect.ColorAdjust;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.ScrollEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class ColorEffect extends Application{
    
    @Override
    public void start(final Stage stage){
        final ColorAdjust colorAdjust = new ColorAdjust(0.0, 0.0, 0.0, 0.0);
        
        final String imageLocation = "file:/home/anuraganand/Pictures/RamJeehanumanJee.jpeg";
        final ImageView imageView = new ImageView(imageLocation);
        imageView.setX(300);
        imageView.setY(30);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        imageView.setEffect(colorAdjust);

        final Label  labelLightness  = new Label("Lightness");
        final Slider sliderLightness = new Slider(-1, 1, 0.2);

        labelLightness.setLabelFor(sliderLightness);

        final HBox hboxLightness = new HBox(8, labelLightness, sliderLightness);

        final Label  labelContrast  = new Label("Contrast");
        final Slider sliderContrast = new Slider(-1, 1, 0.2);

        labelContrast.setLabelFor(sliderContrast);

        final HBox hboxContrast = new HBox(8, labelContrast, sliderContrast);

        final Label  labelHue  = new Label("Hue");
        final Slider sliderHue = new Slider(-1, 1, 0.2);

        labelHue.setLabelFor(sliderHue);

        final HBox hboxHue = new HBox(8, labelHue, sliderHue);

        final Label  labelSaturation  = new Label("Saturation");
        final Slider sliderSaturation = new Slider(-1, 1, 0.2);

        labelSaturation.setLabelFor(sliderSaturation);

        final HBox hboxSaturation = new HBox(8, labelSaturation, sliderSaturation);

        final VBox vbox = new VBox(10, hboxLightness, hboxContrast, hboxHue, hboxSaturation, imageView); 

        sliderHue        .setOnMouseDragged((event) -> colorAdjust.setHue(       sliderHue       .getValue()));
        sliderContrast   .setOnMouseDragged((event) -> colorAdjust.setContrast(  sliderContrast  .getValue()));
        sliderLightness  .setOnMouseDragged((event) -> colorAdjust.setBrightness(sliderLightness .getValue()));
        sliderSaturation .setOnMouseDragged((event) -> colorAdjust.setSaturation(sliderSaturation.getValue()));
        

        stage.setScene(new Scene(new Group(vbox), 700, 700));
        stage.setTitle("The Image Modifier");
        stage.show();
    }
}
