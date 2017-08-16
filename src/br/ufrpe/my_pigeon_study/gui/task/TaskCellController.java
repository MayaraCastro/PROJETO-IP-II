package br.ufrpe.my_pigeon_study.gui.task;

import java.io.IOException;
import java.time.LocalDate;

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
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TaskCellController {
	
	private Fachada fachada;
	
	private Usuario user;
	
	private  Task task;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTimePicker time;

    @FXML
    private JFXTextArea detail;
    
    @FXML
    private Label overdue;

    @FXML
    void deletar() throws IOException {
    	fachada.deletarTask( user, this.getTask().getNome());
    	ScreenManager.getInstance().fecharInfoStage();
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
    	if(this.getTask().getData().compareTo(LocalDate.now())<0) {
    		overdue.setVisible(true);
    	}
    }
    public  TaskCellController() throws IOException{
    	this.fachada = Fachada.getInstancia();
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

    	Task novaTask = new Task(date.getValue(), title.getText(), time.getValue(), detail.getText());
		try{
			fachada.alterarTask(user,novaTask, task);
			ScreenManager.getInstance().fecharInfoStage();
			this.atualizarJanela();
		    
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    private void atualizarJanela() throws IOException{
    	ScreenManager.getInstance().showMainTask();
    }
    
    @FXML
    private void fechar() {
    	ScreenManager.getInstance().fecharInfoStage();
    }
}
