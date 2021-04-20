
import javafx.animation.ScaleTransition;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

import javafx.util.Duration;

public class ScaleAnimationTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);

        final ScaleTransition animation = new ScaleTransition(
                                                  Duration.millis(3000),
                                                  rect
                                                  );

        animation.setByX(1.5f);
        animation.setByY(2.3f);
        animation.setCycleCount(-1);
        animation.setAutoReverse(true);

        stage.setScene(new Scene(new Group(rect)));
        stage.setTitle("FillTransition");
        stage.show();

        animation.play();
    }
}
