import javafx.application.Application;

import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SVG extends Application{
    
    @Override
    public void start(final Stage stage){
        
        final Group root = new Group();
        root.getChildren()
        .addAll(
           svg(
              "M 220 120 L 270 20 320 120 A 100 100 0 0 1 220 120", 
              Color.BLUE, 
              3, 
              Color.YELLOW
              ), 
            svg("M 20 120 L 70 20 120 120 A 100 100 0 0 0 20 120", 
                  Color.BLUE, 
                  3, 
                  null
                  )
              );
        
        stage.setScene(new Scene(root, 500, 150));
        stage.setTitle("SVG Test");
        stage.show();
    }

    private static SVGPath svg(
        final String content,
        final Color  stroke,
        final double strokeWidth,
        final Color  fill
     ){

        final SVGPath svg = new SVGPath();
        svg.setContent(content);
        svg.setStroke(stroke);
        svg.setStrokeWidth(strokeWidth);
        svg.setFill(fill);

        return svg;
    }
}
