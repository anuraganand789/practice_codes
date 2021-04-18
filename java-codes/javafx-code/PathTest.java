import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.scene.paint.Color;

import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.ArcTo;

import javafx.collections.ObservableList;

public class PathTest extends Application{
    
    @Override
    public void start(final Stage stage){
        
        final Group root = new Group();
        root
        .getChildren()
        .addAll(
            path(
                Color.BLUE,
                null,
                3,
                new MoveTo(20, 120),
                new LineTo(70, 120),
                new LineTo(120, 120),
                new ArcTo(100, 100, 0, 20, 120, false, false)
            ),
            path(
                Color.BLUE,
                Color.YELLOW,
                3,
                new MoveTo(220, 120),
                new LineTo(270, 20),
                new LineTo(320, 120),
                new ArcTo(100, 100, 0, 220, 120, false, true)
            )
        );
        
        stage.setScene(new Scene(root, 500, 150));
        stage.setTitle("Path Test");
        stage.show();
    }

    private static Path path(
        final Color    strokeColor,
        final Color    fillColor,
        final double   strokeWidth,
        PathElement... elements
    ){
        final Path path = new Path();
        path.setStroke(strokeColor);
        path.setFill(fillColor);
        path.setStrokeWidth(strokeWidth);

        final ObservableList<PathElement> pathElementList = path.getElements();

        for(final PathElement pathElement : elements){
            pathElementList.add(pathElement);
        }

        return path;
    }
}
