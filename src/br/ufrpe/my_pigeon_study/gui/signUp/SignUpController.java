package br.ufrpe.my_pigeon_study.gui.signUp;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;

import java.io.IOException;

import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class SignUpController {
	
	
	private Fachada fachada;
	
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

    public SignUpController() throws IOException{
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
    	ScreenManager.getInstance().showLogin();
    }
    
	@FXML
	public void fechar(){
		ScreenManager.getInstance().fecharMainStage();
	}
	@FXML
	public void minimizar(){
		ScreenManager.getInstance().minimizarMainStage();
	}

}
