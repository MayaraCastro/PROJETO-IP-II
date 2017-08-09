package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.gui.task.TaskController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TaskInfoController {

	private static Stage stage;
	
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
    private JFXButton ok;

    @FXML
    private Label data;

    @FXML
    private Label hora;
    
    
    public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	@FXML
    private void initialize() throws InformacaoInvalidaException{

    	this.setTask(CalendarioController.getTask());
    	title.setText(this.getTask().getNome());
    	data.setText(this.getTask().getData().toString());
    	hora.setText(this.getTask().getHorario().toString());
    	detail.setText(this.getTask().getObs());
    }
    public  TaskInfoController() throws IOException{
    
    }
    
    public static void setStage(Stage s){
        stage = s;
    }
    
    @FXML
    void fechar() {
    	stage.close();
    }
}

