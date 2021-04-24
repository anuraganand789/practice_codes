import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.control.Button;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Text;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlowPaneAlignment extends Application{

    @Override
    public void start(final Stage stage){
        final FlowPane fp1 = createFlowPane(Pos.BOTTOM_RIGHT);
        final FlowPane fp2 = createFlowPane(Pos.BOTTOM_LEFT);
        final FlowPane fp3 = createFlowPane(Pos.CENTER);

        final HBox root = new HBox(fp1,fp2,fp3); 

        stage.setScene(new Scene(root));
        stage.setTitle("FlowPane Alignment");
        stage.show();
    }

    private final FlowPane createFlowPane(Pos alignment){
        final FlowPane flowPane = new FlowPane(5, 5); 
        flowPane.setAlignment(alignment);
        flowPane.setPrefSize(200, 100);

        flowPane.getChildren()
        .addAll(
                    new Text(alignment.toString())
                    ,
                    new Button("Button 1")
                    ,
                    new Button("Button 2")
                    ,
                    new Button("Button 3")
                );
        flowPane.setStyle("""
                -fx-padding : 10;
                -fx-border-style : solid inside;
                -fx-border-insets : 5;
                -fx-border-radius : 5;
                -fx-border-width  : 2;
                -fx-border-color  : blue;
         """);
         return flowPane;
    }
      
}
