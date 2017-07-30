package br.ufrpe.my_pigeon_study.gui.task;

import java.io.IOException;

import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TaskCell extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException
	{
		// Create the FXMLLoader 
		FXMLLoader loader = new FXMLLoader(TaskCell.class.getResource("TaskCell.fxml"));
		
		// Create the Pane and all Details
		AnchorPane root = (AnchorPane) loader.load();
		   
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
