package names;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	public void start(Stage stage){
		
		TextField namein = new TextField();
		Button go = new Button("Go");
		Label nameout = new Label();
		
		go.setOnAction(e -> lookup(namein.getText()));
		
		VBox layout = new VBox();
		HBox top = new HBox();
		
		top.getChildren().addAll(namein, go);
		layout.getChildren().addAll(top, nameout);
		
		Scene scene = new Scene(layout, 180, 60);
		stage.setMinWidth(200);
		stage.setMinHeight(100);
		stage.setScene(scene);
		stage.setTitle("Notorious Names");
		stage.show();
		
	}
	
	public static void lookup(String stagename){
		
		String id = "mw-content-text";
		

		
		stagename = stagename.replace(" ", "_");
		
		try {
			
			Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/" + stagename).get();
			
			Elements e = doc.select(id);
			//String title = doc.title();
			System.out.println(e);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
