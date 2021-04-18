import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Persons extends Application{
    
    @Override
    public void start(final Stage stage){
       final Label labelName  = new Label("Name");
       final Label labelTitle = new Label("Title");

       final TextField textFieldName  = new TextField();
       final TextField textFieldTitle = new TextField();

       final Button buttonAdd   = new Button("Add");
       final Button buttonClear = new Button("Clear");

       final ObservableList<String> observableList = FXCollections.observableArrayList();
       final ListView<String> listView = new ListView<String>(observableList);

       final HBox nameHBox = new HBox(8);
       nameHBox.getChildren().addAll(labelName, textFieldName);

       final HBox titleHBox = new HBox(8);
       titleHBox.getChildren().addAll(labelTitle, textFieldTitle);

       final HBox buttonHBox = new HBox(8);
       buttonHBox.getChildren().addAll(buttonAdd, buttonClear);

       final VBox vBox = new VBox(8);
       vBox.getChildren().addAll(nameHBox, titleHBox, buttonHBox, listView);

       final Group group = new Group();
       group.getChildren().add(vBox);

       buttonClear.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(final ActionEvent event){
               textFieldName.clear();
               textFieldTitle.clear();
               observableList.clear();
           }
       });

       buttonAdd.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(final ActionEvent event){
               final String name  = textFieldName.getText();
               final String title = textFieldTitle.getText();
               observableList.add(String.format("%s,%s", name, title));
               textFieldName.clear();
               textFieldTitle.clear();
           }
       });
       stage.setTitle("Persons");
       stage.setScene(new Scene(group, 500, 500));
       stage.show();
    }
}
