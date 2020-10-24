import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javafx.scene.control.TreeView;

import javafx.scene.control.cell.CheckBoxTreeCell;

import javafx.scene.layout.VBox;

public class JavaFXControlsPractice_1 extends Application{ 
    @Override
    public void start(final Stage stage){
	ButtonBar buttonBar = new ButtonBar();
	CheckBox checkBox = new CheckBox("Occurred");
	checkBox.setSelected(true);

	CheckBoxTreeItem<String> mother     = new CheckBoxTreeItem<>("Shrimati Madhuri Devi");
	CheckBoxTreeItem<String> son        = new CheckBoxTreeItem<>("Shudhanshu");
	CheckBoxTreeItem<String> daughter_1 = new CheckBoxTreeItem<>("Shweta");
	CheckBoxTreeItem<String> daughter_2 = new CheckBoxTreeItem<>("Shudhiksha");

	mother.getChildren().addAll(son, daughter_1, daughter_2);
	mother.setExpanded(true);

	TreeView<String> familyTreeView  = new TreeView();
	familyTreeView.setRoot(mother);
	familyTreeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
        
	CheckMenuItem useAsDefault = new CheckMenuItem("Use As Default");
        Menu menu = new Menu("Favorites");
	menu.getItems().add(useAsDefault);

	MenuBar menuBar = new MenuBar(menu);

	ChoiceBox choiceBox = new ChoiceBox();
	choiceBox.getItems().addAll("Choice One", "Choice Two", "Choice Three");

	List<String> listOfColors = List.of("Yellow", "Red", "Green");
	ChoiceDialog choiceDialog = new ChoiceDialog<>("Yellow", listOfColors);
	choiceDialog.setX(300);
	choiceDialog.setY(400);

	Label hello = new Label("Hello");
	Button buttonYES = new Button("Yes");
	buttonYES.setOnAction((obsValue) -> { choiceDialog.showAndWait(); });
	ButtonBar.setButtonData(buttonYES, ButtonData.YES);

	Button buttonNO  = new Button("No");
	ButtonBar.setButtonData(buttonNO, ButtonData.NO);

	buttonBar.getButtons().addAll(buttonNO, buttonYES);

	ObservableList<String> names = FXCollections.observableArrayList("List Item 1", "List Item 2");
	ListView listView = new ListView(names);

	VBox vbox = new VBox(10);
        vbox.getChildren().addAll(menuBar, hello, choiceBox, buttonBar, checkBox, familyTreeView, listView);
        
        Scene scene = new Scene(vbox, 800, 800);
	stage.setTitle("Test Stage");
	stage.setScene(scene);
	stage.show();
    }
    public static void main(String ... args){
        launch(args);
    }
}
