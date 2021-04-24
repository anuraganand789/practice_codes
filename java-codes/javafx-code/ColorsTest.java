import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;
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
public class ColorsTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Stop[] stops = new Stop[]{
                                       new Stop(0, Color.WHITE),
                                       new Stop(1, Color.BLACK)
                                       };
        final LinearGradient lg = new LinearGradient(0, 0, .5, 0, true, CycleMethod.NO_CYCLE, stops);
        final Rectangle rect = new Rectangle(100, 100);
        rect.setFill(lg);

        final LinearGradient lg2 = new LinearGradient(0, 0, .5, 0, true, CycleMethod.NO_CYCLE, stops);
        final Rectangle rect2 = new Rectangle(100, 100);
        rect2.setFill(lg2);

        final LinearGradient lg3 = new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, stops);
        final Rectangle rect3 = new Rectangle(100, 100);
        rect3.setFill(lg3);

        final Stop[] multiColorStops = 
        new Stop[] {
                      new Stop(0, Color.RED),   new Stop(.25, Color.GREEN),
                      new Stop(.5, Color.BLUE), new Stop(.75, Color.ORANGE),
                      new Stop(1, Color.YELLOW)
                    };
        final LinearGradient lgm = new LinearGradient(0, 0, .5, 0, true, CycleMethod.NO_CYCLE, multiColorStops);
        final Rectangle mrect = new Rectangle(100, 100);
        mrect.setFill(lgm);

        final LinearGradient lgm2 = new LinearGradient(0, 0, .5, 0, true, CycleMethod.NO_CYCLE, multiColorStops);
        final Rectangle mrect2 = new Rectangle(100, 100);
        mrect2.setFill(lgm2);

        final LinearGradient lgm3 = new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, multiColorStops);
        final Rectangle mrect3 = new Rectangle(100, 100);
        mrect3.setFill(lgm3);

        final Stop[] diagnoalStop = new Stop[]{ new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        final LinearGradient diaglg = new LinearGradient(0, 0, 0.1, 0.1, true, CycleMethod.REPEAT, diagnoalStop);

        final Rectangle rectDiag = new Rectangle(100, 100);
        rectDiag.setFill(diaglg);

        final HBox vbox = new HBox(10);
        vbox.getChildren().addAll(
                                    rect,  rect2,  rect3,
                                   mrect, mrect2, mrect3,
                                   rectDiag
                                  );
        final Scene scene = new Scene(vbox, 900, 700);

        stage.setTitle("Color Practice");
        stage.setScene(scene);
        stage.show();
    }
}
