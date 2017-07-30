package br.ufrpe.my_pigeon_study.gui.signUp;
import br.ufrpe.my_pigeon_study.gui.login.*;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SignUpController {
	
	private Stage stage;
	
	private Fachada fachada;
	
    @FXML
    private JFXButton back;
	
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXDatePicker birthday;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXButton register;
    

    public SignUpController(){
    	this.fachada = Fachada.getInstancia();
    }
    @FXML
	private void initialize() 
	{
    	ObservableList<String> list = FXCollections.observableArrayList("Female","Male");
    	gender.setItems(list);
	}
    @FXML
    void cadastrar() throws IOException,InformacaoEmBrancoException, InformacaoInvalidaException {

    	
		try{
	
			Usuario user = new Usuario(name.getText(), userName.getText(), password.getText(), gender.getValue(), email.getText(), birthday.getValue());
			fachada.cadastrarUsuario(user);
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
			this.chamarTelaInicial();
		}catch(InformacaoEmBrancoException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(InformacaoInvalidaException e1){
			
			System.out.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, e1.getMessage().toString() );
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
    	
    		
    }
    @FXML
    void chamarTelaInicial()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Login.class.getResource("Login.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	LoginController controller = (LoginController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

}
