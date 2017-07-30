package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;
import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.gui.profile.Profile;
import br.ufrpe.my_pigeon_study.gui.profile.ProfileController;
import br.ufrpe.my_pigeon_study.gui.task.Taskk;
import br.ufrpe.my_pigeon_study.gui.task.TaskController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CalendarioController {
	
	private Stage stage;
	
	private Fachada fachada;
	
	private static Usuario user;

    @FXML
    private Label userName;

    @FXML
    private JFXButton profile;

    @FXML
    private JFXButton calendar;

    @FXML
    private JFXButton tasks;

    @FXML
    private JFXButton activities;

    @FXML
    private JFXButton logOut;

    @FXML
    private AnchorPane paneTask;

    @FXML
    private JFXDatePicker birthday;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXButton save;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private Hyperlink delete;

    @FXML
    void atualizar() {

    }

    @FXML
    void deletar() {

    }
    
    public CalendarioController(){
    	this.fachada = Fachada.getInstancia();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public void setUser(Usuario useri){
    	user = useri;
    }
    public static Usuario getUser(){
    	return(user);
    }
    
    @FXML
	private void initialize() 
	{
    	Usuario c = LoginController.getUser();
    	this.setUser(c);
    	username.setEditable(true);
    	userName.setText(user.getNome());
    	username.setEditable(false);
    	name.setText(user.getNome());
    	email.setText(user.getEmail());
    	birthday.setValue(user.getDataNasc());
    	ObservableList<String> list = FXCollections.observableArrayList("Female","Male");
    	gender.setItems(list);
    	gender.setValue(user.getSexo());
    	
	}
    @FXML
    void chamarTelaInicial()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Login.class.getResource("Login.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	LoginController controller = (LoginController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    @FXML
    void chamarTelaTask()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Taskk.class.getResource("Task.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	TaskController controller = (TaskController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    
    @FXML
    void chamarTelaCalendar()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Calendario.class.getResource("Calendario.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	CalendarioController controller = (CalendarioController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    @FXML
    void chamarTelaProfile()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Profile.class.getResource("Profile.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	ProfileController controller = (ProfileController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
}

