import javafx.animation.TranslateTransition;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

import javafx.util.Duration;

public class TranslateTransitionTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);

        final TranslateTransition animation = new TranslateTransition(
                                                  Duration.millis(3000),
                                                  rect
                                                  );

        animation.setByY(200f);
        animation.setCycleCount(-1);
        animation.setAutoReverse(true);

        final Rectangle rectZ = new Rectangle(100, 40, 100, 100);
        rectZ.setArcHeight(50);
        rectZ.setArcWidth(50);

        final TranslateTransition animationZ = new TranslateTransition(
                                                  Duration.millis(3000),
                                                  rectZ
                                                  );

        animationZ.setByX(200f);
        animationZ.setByY(200f);
        animationZ.setCycleCount(-1);
        animationZ.setAutoReverse(true);

        stage.setScene(new Scene(new Group(rect, rectZ), 700, 700));
        stage.setTitle("Translate Transition");
        stage.show();

        animation.play();
        animationZ.play();
    }
}
