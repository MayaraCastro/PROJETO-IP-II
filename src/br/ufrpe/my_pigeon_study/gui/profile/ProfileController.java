package br.ufrpe.my_pigeon_study.gui.profile;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.calendar.Calendario;
import br.ufrpe.my_pigeon_study.gui.calendar.CalendarioController;
import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.gui.task.Taskk;
import br.ufrpe.my_pigeon_study.gui.task.TaskCell;
import br.ufrpe.my_pigeon_study.gui.task.TaskCellController;
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

public class ProfileController {
	
	private Stage stage;
	
	private Fachada fachada;
	
	private static Usuario user;

    @FXML
    private Label username;
    
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
    private JFXTextField password;

    @FXML
    private Hyperlink delete;


    @FXML
    void deletar() throws IOException {
    	FXMLLoader loader = new FXMLLoader(Delete.class.getResource("Delete.fxml"));
		
	    AnchorPane root = (AnchorPane) loader.load();

		Stage s = new Stage();
	    s.setScene(new Scene(root));
	    s.setResizable(false);
	    DeleteController.setStage(s);
	    DeleteController.setMainStage(stage);
	    s.show();
    }
    
    public ProfileController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public static void setUser(Usuario useri){
    	user = useri;
    }
    public static Usuario getUser(){
    	return(user);
    }
    
    @FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	userName.setText(user.getNome());
    	username.setText(user.getUsuario());
    	name.setText(user.getNome());
    	email.setText(user.getEmail());
    	birthday.setValue(user.getDataNasc());
    	ObservableList<String> list = FXCollections.observableArrayList("Female","Male");
    	gender.setItems(list);
    	gender.setValue(user.getSexo());
    	gender.getSelectionModel().select(user.getSexo());
    	
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
    private void save(){	
    	String pass;
    	if(password.getText().isEmpty()){
    		pass = user.getSenha();
    	}
    	else{
    		pass = password.getText();
    	}
    	Usuario user = new Usuario( name.getText(), getUser().getUsuario(), pass , gender.getSelectionModel().getSelectedItem(), email.getText(), birthday.getValue());
		try{
			fachada.alterarUsuario(user);
			//LoginController.setUser(this.getUser());
			//this.setUser(user);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
}

