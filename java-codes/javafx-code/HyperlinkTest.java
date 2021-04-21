import javafx.application.Application;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import javafx.scene.control.Hyperlink;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


public class HyperlinkTest extends Application{
    
    @Override
    public void start(final Stage stage){
        final WebView   webView   = new WebView();
        final WebEngine webEngine = webView.getEngine();

        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            final Hyperlink hyperLink = (Hyperlink) event.getTarget();
            final String url =  hyperLink.getText();
            System.out.println(url);
            webEngine.load(url);
        };

        final Hyperlink google  = new Hyperlink("https://www.google.com");
        google.setOnAction(eventHandler);

        final Hyperlink youtube = new Hyperlink("https://www.youtube.com");
        youtube.setOnAction(eventHandler);

        final Hyperlink yahoo   = new Hyperlink("https://www.yahoo.com");
        yahoo.setOnAction(eventHandler);


        final HBox hbox = new HBox();
        hbox.getChildren().addAll(google, youtube, yahoo);

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, webView);

        stage.setScene(new Scene(new Group(vbox), 700, 700));
        stage.setTitle("Hypelink Test");
        stage.show();
    }
}
