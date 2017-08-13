package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.negocio.beans.Disciplina;
import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DisciplinaInfoController {
	private  Disciplina disciplina;
    @FXML
    private AnchorPane cell;

    @FXML
    private AnchorPane cor;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXTimePicker time;

    @FXML
    private JFXTextArea detail;

    @FXML
    private JFXButton ok;

    @FXML
    private Label day;

    @FXML
    private Label hora;
    
    
    public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	@FXML
    private void initialize() throws InformacaoInvalidaException{
			
			this.setDisciplina(CalendarioController.getDisciplina());
	    	title.setText(this.getDisciplina().getNome());
			day.setText(this.dia_da_semana(this.getDisciplina().getDia_da_semana()));
			hora.setText(this.getDisciplina().getHorario().toString());
	    	detail.setText(this.getDisciplina().getObs());
    }
    public  DisciplinaInfoController() throws IOException{
    
    }
    private String dia_da_semana(int dia){
    	if(dia==1){
    		return "Monday";
    	}
    	else if(dia==2){
    		return "Tuesday";
    	}
    	else if(dia==3){
    		return "Wednesday";
    	}
    	else if(dia==4){
    		return "Thursday";
    	}
    	else if(dia==5){
    		return "Friday";
    	}
    	else if(dia==6){
    		return "Saturday";
    	}
    	else if(dia==7){
    		return "Sunday";
    	}
    	return null;    	
    }
    @FXML
    void fechar() {
    	ScreenManager.getInstance().fecharInfoStage();
    }
}
