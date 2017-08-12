package br.ufrpe.my_pigeon_study.gui.atividades;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Disciplina;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DisciplinaCellController {

	private static Stage stage;
	
	private Fachada fachada;
	
	private Usuario user;
	
	private  Disciplina atvdd;
	
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
    	fachada.deletarAtividade( user, this.getAtividades().getNome());
    	stage.close();
    	this.atualizarJanela();
    }
    @FXML
    private void initialize() throws InformacaoInvalidaException{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	this.setAtividades(DisciplinaController.getAtividades());
    	title.setText(this.getAtividades().getNome());
    	time.setValue(this.getAtividades().getHorario());
    	detail.setText(this.getAtividades().getObs());
    }
    public  DisciplinaCellController() throws IOException{
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
    public  Disciplina getAtividades(){
    	return atvdd;
    }
    public  void setAtividades(Disciplina t){
    	atvdd = t;
    }
    
    
    @FXML
    private void save(){

    	Disciplina novaAtividade = new Disciplina( title.getText(), 1, time.getValue(), detail.getText());
		try{
			fachada.alterarAtividade(user,novaAtividade, atvdd);
			stage.close();
			this.atualizarJanela();
		    
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    private void atualizarJanela() throws IOException{
    	ScreenManager.getInstance().showMainTask();
    }
}
