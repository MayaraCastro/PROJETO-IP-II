package br.ufrpe.my_pigeon_study.gui.task;

import java.io.IOException;
import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;


import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;



public class TaskController {
	
	private Fachada fachada;
	
	private static Usuario user;
	
	private static Task task;
	
    @FXML
    private Label userName;
    
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


    public TaskController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
	public void setUser(Usuario u){
    	user = u;
    }
    public Usuario getUser(){
    	return(user);
    }
    
    @FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	ObservableList<String> tasks = FXCollections.observableArrayList(fachada.showTasks(user));
    	list.setItems(tasks);
    	list.setPrefWidth(528);
    	list.setPrefHeight(490);
		
    	userName.setText(user.getNome());
    	list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override//Quando selecionar no listview a task 
            public void handle(MouseEvent event) {
        		Task t = fachada.buscarTask(user, list.getSelectionModel().getSelectedItem());
        		task = t;

				chamarTask();
                
            }
        });
	}

	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {

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
    public void chamarTask(){
    	ScreenManager.getInstance().showCellTask();
    }
    @FXML
    void chamarTelaInicial(){
    	ScreenManager.getInstance().showLogin();
    }
    @FXML
    void chamarTelaProfile(){
    	ScreenManager.getInstance().showPerfil();
    }
    @FXML
    void chamarTelaCalendar(){
    	ScreenManager.getInstance().showCalendario();
    }
    
	public static Task getTask() {
		return task;
	}
	public static void setTask(Task task) {
		TaskController.task = task;
	}
    
}
