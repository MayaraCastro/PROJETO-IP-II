package br.ufrpe.my_pigeon_study.gui.profile;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfileController {

	
	private Fachada fachada;
	
	private static Usuario user;

    @FXML
    private Label username;
    
    @FXML
    private Label userName;

    @FXML
    private JFXDatePicker birthday;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXButton save;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXComboBox<String> gender;


    @FXML
    private JFXTextField password;

    @FXML
    void deletar(){
    	ScreenManager.getInstance().showDelete();
    }
    
    public ProfileController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
    
    public static void setUser(Usuario useri){
    	user = useri;
    }
    public static Usuario getUser(){
    	return(user);
    }
    
    @FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	userName.setText(user.getNome());
    	username.setText(user.getUsuario());
    	name.setText(user.getNome());
    	email.setText(user.getEmail());
    	birthday.setValue(user.getDataNasc());
    	ObservableList<String> list = FXCollections.observableArrayList("Female","Male");
    	gender.setItems(list);
    	gender.setValue(user.getSexo());
    	gender.getSelectionModel().select(user.getSexo());
    	
	}
    @FXML
    void chamarTelaInicial(){
    	ScreenManager.getInstance().showLogin();
    }
    @FXML
    void chamarTelaTask(){
    	ScreenManager.getInstance().showMainTask();
    }
    
    @FXML
    void chamarTelaCalendar(){
    	ScreenManager.getInstance().showCalendario();
    }
    
    @FXML
    private void save(){	
    	String pass;
    	if(password.getText().isEmpty()){
    		pass = user.getSenha();
    	}
    	else{
    		pass = password.getText();
    	}
    	Usuario user = new Usuario( name.getText(), getUser().getUsuario(), pass , gender.getSelectionModel().getSelectedItem(), email.getText(), birthday.getValue());
		try{
			fachada.alterarUsuario(user);
			ScreenManager.getInstance().showPerfil();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
}

