import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import javafx.scene.transform.Translate;

public class TranslateProgram extends Application{
   
   @Override
   public void start(final Stage stage){
       final Group root = new Group(
                                    rect(Color.BLUE, null),
                                    rect(Color.RED, new Translate(50, 50))
                                    );

        final Scene scene = new Scene(root, 350, 350);
        stage.setTitle("Translate");
        stage.setScene(scene);
        stage.show();
   }

   private Rectangle rect(final Color color, final Translate trans){
       final Rectangle rect = new Rectangle(20, 20, 200, 200);
       rect.setFill(color);
       if(trans != null) rect.getTransforms().add(trans);
       return rect;
   }
}
