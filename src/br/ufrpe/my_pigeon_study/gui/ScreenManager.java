package br.ufrpe.my_pigeon_study.gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScreenManager {
	
	private static ScreenManager instance;
	private Stage mainStage;
	private Stage infoStage;
	
	//private FXMLLoader classes,classeCell, calendario, taskInfo,  login, signUp, task, taskCell;
	private Scene mainDisciplina, cellDisciplina;
	private Scene mainTask, cellTask;
	private Scene mainCalendario, infoTask;
	private Scene mainLogin;
	private Scene mainSignUp;
	private Scene mainPerfil, delete;
	
	
	
	public static ScreenManager getInstance()  {
		if(instance == null){
			instance = new ScreenManager();
		}
		return instance;
	}
	
	private ScreenManager() {
		this.setInfoStage(new Stage());
		
	}
	
	//Load scenes
	public void loadMainCalendar(){
		try {
			AnchorPane telaCalendario = FXMLLoader.load(this.getClass().getResource("calendar/Calendario.fxml"));
			this.mainCalendario = new Scene(telaCalendario);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void loadInfoTask(){
		try {
			AnchorPane telaTaskInfo = FXMLLoader.load(this.getClass().getResource("calendar/TaskInfo.fxml"));
			this.infoTask = new Scene(telaTaskInfo);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	//TODO info classe
	
	public void loadMainTask(){
		try {
			AnchorPane telaTask = FXMLLoader.load(this.getClass().getResource("task/Task.fxml"));
			this.mainTask = new Scene(telaTask);

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void loadCellTask(){
		try {
			AnchorPane telaCellTask = FXMLLoader.load(this.getClass().getResource("task/TaskCell.fxml"));
			this.cellTask = new Scene(telaCellTask);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void loadPerfil(){
		try {
			AnchorPane telaPerfil = FXMLLoader.load(this.getClass().getResource("profile/Profile.fxml"));
			this.mainPerfil = new Scene(telaPerfil);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void loadDelete(){
		try {
			AnchorPane teladelete = FXMLLoader.load(this.getClass().getResource("profile/Delete.fxml"));
			this.delete = new Scene(teladelete);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void loadLogin(){
		try {
			AnchorPane telaLogin = FXMLLoader.load(this.getClass().getResource("login/Login.fxml"));
			this.mainLogin = new Scene(telaLogin);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void loadSignUp(){
		try {
			AnchorPane telaSignUp = FXMLLoader.load(this.getClass().getResource("signUp/SignUP.fxml"));
			this.mainSignUp = new Scene(telaSignUp);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void loadMainDisciplina(){
		try {

			AnchorPane telaDisciplina = FXMLLoader.load(this.getClass().getResource("disciplinas/Disciplina.fxml"));
			this.mainDisciplina = new Scene(telaDisciplina);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadCellDisciplina(){
		try {
			AnchorPane telaCellDisciplina = FXMLLoader.load(this.getClass().getResource("disciplinas/DisciplinaCell.fxml"));
			this.cellDisciplina = new Scene(telaCellDisciplina);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Stage getMainStage(){
		return mainStage;
	}
	
	public void setMainStage(Stage mainStage){
		this.mainStage = mainStage;
		this.mainStage.setTitle("My Study Life");
		this.mainStage.setResizable(false);
		this.mainStage.initStyle(StageStyle.UNDECORATED);
	}
	public void setInfoStage(Stage stage){
		this.infoStage = stage;
		this.infoStage.setResizable(false);
		this.infoStage.initStyle(StageStyle.UNDECORATED);
	}

	// CHAMADA DE TELAS
	
	public void showLogin(){
		this.loadLogin();
		this.mainStage.setScene(mainLogin);
		this.mainStage.show();
	}
	public void showSignUp(){
		this.loadSignUp();
		this.mainStage.setScene(mainSignUp);
	}
	public void showMainTask(){
		this.loadMainTask();
		this.mainStage.setScene(mainTask);
	}
	public void showCellTask(){
		this.loadCellTask();
		this.infoStage.setScene(this.cellTask);
		this.showInfoStage();
	}
	public void showMainDisciplina(){
		this.loadMainDisciplina();
		this.mainStage.setScene(mainDisciplina);
	}
	public void showCellDisciplina(){
		this.loadCellDisciplina();
		this.infoStage.setScene(this.cellDisciplina);
		this.showInfoStage();
	}
	public void showPerfil(){
		this.loadPerfil();
		this.mainStage.setScene(mainPerfil);
	}
	public void showDelete(){
		this.loadDelete();
		this.infoStage.setScene(this.delete);
		this.showInfoStage();
	}
	public void showCalendario(){
		this.loadMainCalendar();
		this.mainStage.setScene(mainCalendario);
	}
	public void showInfoTask(){
		this.loadInfoTask();
		this.infoStage.setScene(infoTask);
		this.showInfoStage();
	}
	
	//show stages
	public void showMainStage(){
		this.mainStage.show();
	}
	public void showInfoStage(){
		this.infoStage.show();
	}
	
	//close stages
	public void fecharMainStage(){
		this.mainStage.close();
	}
	public void fecharInfoStage(){
		this.infoStage.close();
		
	}
	public void minimizarMainStage(){
		this.mainStage.setIconified(true);
	}
	
}
