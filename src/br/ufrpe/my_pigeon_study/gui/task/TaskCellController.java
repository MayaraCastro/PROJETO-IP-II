package br.ufrpe.my_pigeon_study.gui.task;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TaskCellController {

	private Stage stage;
	
	private Fachada fachada;
	
	private Usuario user;
	
	private Task task;
	
    @FXML
    private AnchorPane cell;

    @FXML
    private AnchorPane cor;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTimePicker time;

    @FXML
    private JFXTextArea detail;

    @FXML
    private JFXButton save;

    @FXML
    private JFXButton delete;

    @FXML
    void alterar() {

    }

    @FXML
    void deletar() {

    }
    @FXML
    private void initialize(){
    	
    }
    public void TaskCellController(){
    	this.fachada = Fachada.getInstancia();
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public void setUser(Usuario user){
    	this.user = user;
    }
    public Usuario getUser(){
    	return(user);
    }
    public Task getTask(){
    	return task;
    }
    public void setTask(Task t){
    	this.task = t;
    }
    
}
