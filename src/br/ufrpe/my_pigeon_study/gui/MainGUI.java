package br.ufrpe.my_pigeon_study.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI extends Application{
		
		@Override
		public void start(Stage primaryStage) {
			ScreenManager.getInstance().setMainStage(primaryStage);
			ScreenManager.getInstance().showLogin();
		}
		public static void main(String[] args) {
			launch(args);
		} 
	}