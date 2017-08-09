package br.ufrpe.my_pigeon_study.gui.atividades;

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
import br.ufrpe.my_pigeon_study.negocio.beans.Atividade;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AtividadesCellController {

	private static Stage stage;
	
	private Fachada fachada;
	
	private Usuario user;
	
	private  Atividade atvdd;
	
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
    	this.setAtividades(AtividadesController.getAtividades());
    	title.setText(this.getAtividades().getNome());
    	time.setValue(this.getAtividades().getHorario());
    	detail.setText(this.getAtividades().getObs());
    }
    public  AtividadesCellController() throws IOException{
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
    public  Atividade getAtividades(){
    	return atvdd;
    }
    public  void setAtividades(Atividade t){
    	atvdd = t;
    }
    
    
    @FXML
    private void save(){

    	Atividade novaAtividade = new Atividade( title.getText(), 1, time.getValue(), detail.getText());
		try{
			fachada.alterarAtividade(user,novaAtividade, atvdd);
			stage.close();
			this.atualizarJanela();
		    
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    private void atualizarJanela() throws IOException{
    	FXMLLoader loader = new FXMLLoader(AtividadesCell.class.getResource("Atividades.fxml"));
		    		
		    AnchorPane root = (AnchorPane) loader.load();
		   	AtividadesController.getStage().setScene(new Scene(root));
    }
}
