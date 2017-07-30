package br.ufrpe.my_pigeon_study.gui.task;

import java.io.IOException;


import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.gui.profile.Profile;
import br.ufrpe.my_pigeon_study.gui.profile.ProfileController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;


import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TaskController {

	private Stage stage;
	
	private Fachada fachada;
	
	private Usuario user;
	
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
    private ListView<String> list;

    @FXML
    private JFXDatePicker dueDate;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXTextArea detail;

    @FXML
    private JFXTimePicker dueTime;

    @FXML
    private JFXButton save; 
    
    @FXML
    private AnchorPane paneTask;

    public TaskController(){
    	this.fachada = Fachada.getInstancia();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public void setUser(Usuario user){
    	this.user = user;
    }
    public Usuario getUser(){
    	return(this.user);
    }
    
    @FXML
	private void initialize() 
	{
    	Usuario c = LoginController.getUser();
    	this.setUser(c);
    	ObservableList<String> tasks = FXCollections.observableArrayList();
    	list.setItems(tasks);
    	list.setPrefWidth(520);
    	list.setPrefHeight(485);
		
    	userName.setText(this.user.getNome());
    	list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + list.getSelectionModel().getSelectedItem());
            }
        });
	}

	@FXML //Quando selecionar no listview a task 
	public void handleMouseClick(MouseEvent arg0) throws IOException {
		Task task = fachada.buscarTask(user, list.getSelectionModel().getSelectedItem());
		
		this.chamarTask();
		
	    System.out.println("clicked on " + task);
	}
    
    @FXML
    private void cadastrar(){
    	try{
    		
	    	Task novaTask = new Task( dueDate.getValue(), title.getText(), dueDate.getValue().getDayOfWeek().getValue(), dueTime.getValue(), detail.getText() );
			
			fachada.cadastrarTask(user,novaTask);
			dueDate.setValue(null);
			title.clear();
			detail.clear();
			dueTime.setValue(null);
			
			list.getItems().add(novaTask.getNome());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    public void chamarTask()throws IOException{
    	FXMLLoader loader = new FXMLLoader(TaskCell.class.getResource("TaskCell.fxml"));
			
	    AnchorPane root = (AnchorPane) loader.load();
		Stage s = new Stage();
	    s.setScene(new Scene(root));
	    s.show();
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
    void chamarTelaProfile()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Profile.class.getResource("Profile.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	ProfileController controller = (ProfileController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    
}
