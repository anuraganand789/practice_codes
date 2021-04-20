import javafx.animation.PathTransition;
import javafx.animation.FillTransition;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.CubicCurveTo;

import javafx.scene.paint.Color;

import javafx.util.Duration;

public class PathTransitionTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Rectangle rect = new Rectangle(100, 40, 100, 100);
        rect.setArcHeight(50);
        rect.setArcWidth(50);
        rect.setFill(Color.VIOLET);

        final FillTransition fillTransition = new FillTransition(
                Duration.millis(3000),
                rect,
                Color.RED, 
                Color.VIOLET
        );
        fillTransition.setCycleCount(-1);
        fillTransition.setAutoReverse(true);

        final Path path = new Path();
        path.getElements().add(new MoveTo(0f, 50f));
        path.getElements().add(new CubicCurveTo(40f, 10f, 390f, 240f, 500f, 500f));

        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(rect);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(-1);
        pathTransition.setAutoReverse(true);

        stage.setScene(new Scene(new Group(rect), 700, 700));
        stage.setTitle("Translate Transition");
        stage.show();

        pathTransition.play();
        fillTransition.play();
    }
}
