package Exceptions;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Errorr extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) throws IOException {
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("erros.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
	
			ErrorController controller = (ErrorController) loader.getController();
			
			controller.setStage(stage);
			
			
			Scene scene= new Scene(root);	
			// Set the Scene to the Stage
			stage.setScene(scene);
			// Set the Title to the Stage
			stage.setTitle("My_Study_Life_MenssageError");
			//impedir Resize
			stage.setResizable(false);
			// Display the Stage
			stage.show();
	
	}
		
}
