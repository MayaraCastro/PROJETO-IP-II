package br.ufrpe.my_pigeon_study.gui.task;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TaskCellController {

	private static Stage stage;
	
	private Fachada fachada;
	
	private Usuario user;
	
	private  Task task;
	
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
    void deletar() throws IOException {
    	fachada.deletarTask( user, this.getTask().getNome());
    	stage.close();
    	this.atualizarJanela();
    }
    @FXML
    private void initialize() throws InformacaoInvalidaException{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	this.setTask(TaskController.getTask());
    	title.setText(this.getTask().getNome());
    	date.setValue(this.getTask().getData());
    	time.setValue(this.getTask().getHorario());
    	detail.setText(this.getTask().getObs());
    }
    public  TaskCellController(){
    	this.fachada = Fachada.getInstancia();
    }
    public static void setStage(Stage s){
        stage = s;
    }
    
    public void setUser(Usuario user){
    	this.user = user;
    }
    public Usuario getUser(){
    	return(user);
    }
    public  Task getTask(){
    	return task;
    }
    public  void setTask(Task t){
    	task = t;
    }
    
    
    @FXML
    private void save(){

    	Task novaTask = new Task(date.getValue(), title.getText(), 1, time.getValue(), detail.getText());
		try{
			fachada.alterarTask(user,novaTask, task);
			stage.close();
			this.atualizarJanela();
		    
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    private void atualizarJanela() throws IOException{
    	FXMLLoader loader = new FXMLLoader(Taskk.class.getResource("Task.fxml"));
		    		
		    AnchorPane root = (AnchorPane) loader.load();
		   	TaskController.getStage().setScene(new Scene(root));
    }
}
