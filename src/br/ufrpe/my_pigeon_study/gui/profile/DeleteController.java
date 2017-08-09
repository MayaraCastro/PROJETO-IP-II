package br.ufrpe.my_pigeon_study.gui.profile;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class DeleteController {
	
	private static Stage stage;
	
	private static Stage mainStage;
	
	private Fachada fachada;
	
	private Usuario user;

    @FXML
    private JFXButton yes;

    @FXML
    private JFXButton no;

    @FXML
    void deletar() throws IOException {
    	
    	try {
			fachada.descadastrar(this.user.getUsuario());
			FXMLLoader loader = new FXMLLoader(Login.class.getResource("Login.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
	        
			LoginController controller = (LoginController) loader.getController();
			controller.setStage(stage);
	    	stage.close();
	    	mainStage.setScene(new Scene(root));
		} catch (InformacaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
	}
    public DeleteController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
    

    public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		DeleteController.stage = stage;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		DeleteController.mainStage = mainStage;
	}

	@FXML
    void fechar() {
    	stage.close();
    }

}

