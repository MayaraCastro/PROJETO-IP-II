package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.negocio.beans.Disciplina;
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
    
    private final String[] days ={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};

    
    public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	@FXML
    private void initialize() throws InformacaoInvalidaException{
			
			this.setDisciplina(CalendarioController.getDisciplina());//erro nessa linha nao recebe a disciplina
	    	title.setText(this.getDisciplina().getNome());
			day.setText(days[this.getDisciplina().getDia_da_semana()-1]);
			hora.setText(this.getDisciplina().getHorario().toString());
	    	detail.setText(this.getDisciplina().getObs());
    }
    public  DisciplinaInfoController() throws IOException{
    
    }
    
    @FXML
    void fechar() {
    	ScreenManager.getInstance().fecharInfoStage();
    }
}
