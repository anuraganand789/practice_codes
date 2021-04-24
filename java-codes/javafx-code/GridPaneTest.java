import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GridPaneTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final GridPane gridPaneOne = new GridPane();
        gridPaneOne.setGridLinesVisible(true);
        gridPaneOne.add(new Button("One"),   0, 0);
        gridPaneOne.add(new Button("Two"),   1, 0);
        gridPaneOne.add(new Button("Three"), 0, 1);
        gridPaneOne.add(new Button("Four"),  1, 1 );

        final GridPane gridPaneTwo = new GridPane();
        gridPaneTwo.setGridLinesVisible(true);
        gridPaneTwo.addRow(0, new Button("One"),   new Button("Two"));
        gridPaneTwo.addRow(1, new Button("Three"), new Button("Four"));

        final GridPane gridPaneThree = new GridPane();
        gridPaneThree.setGridLinesVisible(true);
        gridPaneThree.addColumn(0, new Button("One"),   new Button("Two"));
        gridPaneThree.addColumn(1, new Button("Three"), new Button("Four"));

        final GridPane gridPaneFour = new GridPane();
        gridPaneFour.setHgap(10);
        gridPaneFour.setVgap(10);
        gridPaneFour.setGridLinesVisible(true);
        gridPaneFour.addRow(0, 
                             new Label("First Name : "), 
                             new TextField()
                             );
        gridPaneFour.addRow(0, 
                             new Label("Last Name : "), 
                             new TextField()
                             );

        final TextArea textArea = new TextArea();
        textArea.setPromptText("Enter your resume here");
        textArea.setPrefColumnCount(10);
        textArea.setPrefRowCount(3);

        gridPaneFour.add(textArea, 0, 1, GridPane.REMAINING, 1);

        final VBox root = new VBox(10, 
                                   gridPaneOne, 
                                   gridPaneTwo, 
                                   gridPaneThree,
                                   gridPaneFour
                                   );

        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Grid Pane");
        stage.show();
    }
}
