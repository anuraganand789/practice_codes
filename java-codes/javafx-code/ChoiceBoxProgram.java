import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ChoiceBoxProgram extends Application{

    private class Person{
        private final String name;
        private final String jobTitle;

        private Person(final String name, final String jobTitle){
            this.name = name;
            this.jobTitle = jobTitle;
        }

        @Override
        public String toString(){
            return String.format("%s, %s", name, jobTitle);
        }
    }

    @Override
    public void start(final Stage stage){
        final Person anurag = new Person("anurag", "engine");
        final Person anand  = new Person("anand"  , "wheel");

        final Label labelChoiceBox        = new Label("Select A Person");
        final ChoiceBox<Person> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().addAll(anurag, anand);
        labelChoiceBox.setLabelFor(choiceBox);

        final HBox hboxFirst = new HBox(8);
        hboxFirst.getChildren().addAll(labelChoiceBox, choiceBox);

        final Label labelPerson = new Label("Person");
        final Label labelEmpty  = new Label("");
        labelPerson.setLabelFor(labelEmpty);

        final Button buttonClear = new Button("Clear");
        buttonClear.setOnAction((event) -> labelEmpty.setText(""));

        final HBox hboxSecond = new HBox(8);
        hboxSecond.getChildren().addAll(labelPerson, labelEmpty, buttonClear);

        
        choiceBox.setOnAction((event) -> {
            labelEmpty.setText(((ChoiceBox) event.getTarget()).getValue().toString());
        });

        final VBox vbox = new VBox(8);
        vbox.getChildren().addAll(hboxFirst, hboxSecond);

        stage.setScene(new Scene(new Group(vbox)));
        stage.setTitle("Choice Box Program");
        stage.show();
    }
    
}
