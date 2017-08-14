package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;

import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TaskInfoController {

	
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
    	hora.setText(this.getTask().getHorario().toString());// erro nessa linha
    	detail.setText(this.getTask().getObs());

    }
    public  TaskInfoController() throws IOException{
    
    }
    
    @FXML
    void fechar() {
    	ScreenManager.getInstance().fecharInfoStage();
    }
}

