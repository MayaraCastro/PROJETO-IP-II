package br.ufrpe.my_pigeon_study.gui.profile;

import java.io.IOException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;

public class DeleteController {
	private Fachada fachada;
	
	private Usuario user;


    @FXML
    void deletar() throws IOException {
    	
    	try {
			fachada.descadastrar(this.user.getUsuario());
			ScreenManager.getInstance().showLogin();
			this.fechar();
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
    
	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	@FXML
    void fechar() {
		ScreenManager.getInstance().fecharInfoStage();
    }

}

