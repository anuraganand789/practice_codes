import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.event.EventType;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;

public class EventTest extends Application{ 
    @Override
    public void start(final Stage stage){
        final Circle circle = new Circle(100, 100, 50);

        final EventHandler<MouseEvent> filterHandler = 
        new EventHandler<MouseEvent>(){
            @Override
            public void handle(final MouseEvent event){
                System.out.println("Filter mouse event " + event.getEventType());

            }
        };

        circle.addEventFilter(MouseEvent.MOUSE_CLICKED,  filterHandler);
        circle.setOnMouseClicked(
                new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(final MouseEvent event){
                    System.out.println("Handle mouse event " + event.getEventType());
                    System.out.println("removing filter ");
                    circle.<MouseEvent>removeEventFilter(MouseEvent.MOUSE_CLICKED, filterHandler);
                    }
                }
        );

        final Group rootNode = new Group(circle);

        stage.setScene(new Scene(rootNode, 500, 500));
        stage.show();
        stage.setTitle("Event Test");
    }
}
