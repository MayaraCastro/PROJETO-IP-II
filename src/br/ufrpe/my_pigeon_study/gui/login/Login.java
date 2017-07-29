package br.ufrpe.my_pigeon_study.gui.login;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException
	{
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader(Login.class.getResource("Login.fxml"));
		
		// Create the Pane and all Details
		AnchorPane root = (AnchorPane) loader.load();
        
		LoginController controller = (LoginController) loader.getController();
		controller.setStage(stage);
		   
		// Create the Scene
		Scene scene = new Scene(root);
		// Set the Scene to the Stage
		stage.setScene(scene);
		// Set the Title to the Stage
		stage.setTitle("My Study Life");
		// Display the Stage
		stage.show();
	}
}