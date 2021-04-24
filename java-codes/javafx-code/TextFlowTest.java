import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextFlowTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final Text textOne = new Text("Text Flow Test");
        textOne.setFill(Color.RED);
        textOne.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        final Text textTwo = new Text("It supports rich text too");
        textTwo.setFill(Color.BLUE);
        
        final TextFlow textFlow = new TextFlow(textOne, textTwo);

        stage.setTitle("TextFlow Application");
        stage.setScene(new Scene(textFlow));
        stage.show();
    }
}
