package br.ufrpe.my_pigeon_study.gui.login;
import br.ufrpe.my_pigeon_study.gui.signUp.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Data;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.*;
public class LoginController{
	
	private Stage stage;
	
	private Fachada fachada;
	
    @FXML
    private Button signIn;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Button signUp;

    @FXML
    private Label sair;
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public LoginController() 
	{
    	this.fachada = Fachada.getInstancia();
    	//USUARIO JA PRONTO PRA TESTES
    		Data dataNasc= new Data(2,2,1999);
    		Usuario user= new Usuario("Maria", "maria", "maria", "female", "maria@maria",dataNasc);
    		Usuario usera= new Usuario("mayara", "mayara", "mayara", "female", "mayara@mayara",dataNasc);
   			try{
    			fachada.cadastrarUsuario(user);
   				fachada.cadastrarUsuario(usera);
   			}catch(InformacaoEmBrancoException e){
   				JOptionPane.showMessageDialog(null, e.getMessage());
   			}
   			catch (InformacaoInvalidaException e) {
    			JOptionPane.showMessageDialog(null, e.getMessage());
    		}
	}
	
	@FXML
	private void initialize() 
	{
	}
	@FXML
	private void entra(){
		
		Usuario user = new Usuario(userName.getText(),password.getText());
		try {
			user=this.fachada.logar(user);
			JOptionPane.showMessageDialog(null,"Login com sucesso!" );
			//TODO ABRIR A GUI PRINCIPAL
		} catch (InformacaoInvalidaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
	}
	@FXML
	private void signUP(ActionEvent event)throws IOException{

		FXMLLoader loader = new FXMLLoader(SignUP.class.getResource("SignUP.fxml"));
		
		AnchorPane root = (AnchorPane) loader.load();
		SignUpController controller = (SignUpController) loader.getController();
		controller.setStage(stage);
		stage.setScene(new Scene(root));
		
	}
}
