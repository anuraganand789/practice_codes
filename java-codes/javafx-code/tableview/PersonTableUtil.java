import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;

public class PersonTableUtil extends Application {
    @Override
    public void start(final Stage stage){
        final TableView<Person> tableView = new TableView<>(getPersonList());

        final TableColumn<Person, String> fullNameColumn = new TableColumn<>("Full Name");
        fullNameColumn.getColumns().addAll(getFirstNameColumn(), getLastNameColumn());

        tableView.getColumns().addAll(
                                    getIdColumn(), 
                                    fullNameColumn
                                   );

        stage.setScene(new Scene(tableView, 400, 400));
        stage.show();
    }
    public static ObservableList<Person> getPersonList(){
        final Person p1 = new Person(1, "Anurag", "Anand");
        final Person p2 = new Person(2, "Anurag", "Anand");
        final Person p3 = new Person(3, "Anurag", "Anand");
        final Person p4 = new Person(4, "Anurag", "Anand");
        final Person p5 = new Person(5, "Anurag", "Anand");
        
        return FXCollections.<Person>observableArrayList(p1, p2, p3, p4, p5);
    }

    public static TableColumn<Person, Integer> getIdColumn(){
        final TableColumn<Person, Integer> personIdColumn = new TableColumn<>("Id");
        personIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        return personIdColumn;
    }

    public static TableColumn<Person, String> getFirstNameColumn(){
        final TableColumn<Person, String> personFirstNameColumn = new TableColumn<>("First Name");
        personFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return personFirstNameColumn;
    }

    public static TableColumn<Person, String> getLastNameColumn(){
        final TableColumn<Person, String> personLastNameColumn = new TableColumn<>("First Name");
        personLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return personLastNameColumn;
    }
}
