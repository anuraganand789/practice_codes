import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.paint.RadialGradient;

import javafx.scene.paint.CycleMethod;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RadialGradientTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Stop[] stops = new Stop[] {
            new Stop(0, Color.WHITE),
            new Stop(1, Color.BLACK)
        };
        final RadialGradient 
        rg = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);
        final Circle circle = new Circle(50, 50, 50);
        circle.setFill(rg);

        final HBox hbox = new HBox(8);
        hbox.getChildren().addAll(circle);

        stage.setTitle("Radial Gradient Test");
        stage.setScene(new Scene(hbox, 500, 500));
        stage.show();
    }
}
