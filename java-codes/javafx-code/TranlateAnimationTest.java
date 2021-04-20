import javafx.animation.TranslateTransition;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

import javafx.util.Duration;

public class TranslateTransition extends Application{
    
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

        stage.setScene(new Scene(new Group(rect)));
        stage.setTitle("Translate Transition");
        stage.setFullScreen(true);
        stage.show();

        animation.play();
    }
}
