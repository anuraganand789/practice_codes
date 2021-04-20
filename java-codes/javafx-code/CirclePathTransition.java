import javafx.animation.PathTransition;
import javafx.animation.FillTransition;

import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.Button;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.CubicCurveTo;

import javafx.scene.paint.Color;

import javafx.util.Duration;

public class CirclePathTransition extends Application{
    
    @Override
    public void start(final Stage stage){
        final Circle circle = new Circle();
        circle.setCenterX(40f);
        circle.setCenterY(80f);
        circle.setRadius(20f);
        circle.setFill(Color.RED);
        circle.setStrokeWidth(20);

        final Path path = new Path();
        path.setStroke(Color.DARKGREEN);
        path.setStrokeWidth(3);
        path.getElements().addAll(
            new MoveTo(40f, 80f),
            new CubicCurveTo(40f, 10f, 390f, 240f, 500f, 500f)
        );

        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(circle);
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(-1);
        pathTransition.setAutoReverse(true);

        final Button start = new Button("Start");
        start.setLayoutX(20f);
        start.setLayoutY(20f);
        start.setPrefSize(80, 25);
        start.setOnAction(event -> pathTransition.play());

        final Button end = new Button("End");
        end.setLayoutX(120f);
        end.setLayoutY(20f);
        end.setPrefSize(80, 25);
        end.setOnAction(event -> pathTransition.stop());

        stage.setScene(new Scene(new Group(start, end, path, circle), 700, 700));
        stage.setTitle("Translate Transition");
        stage.show();
    }
}
