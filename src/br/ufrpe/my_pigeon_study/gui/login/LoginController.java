package br.ufrpe.my_pigeon_study.gui.login;
import br.ufrpe.my_pigeon_study.dados.ManipuladorArquivo;
import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class LoginController{

	private Fachada fachada;
	
	private static Usuario user;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    
    public static void setUser(Usuario user) {
		LoginController.user = user;
	}
    public LoginController() throws IOException 
	{
    	this.fachada = Fachada.getInstancia();
    	
	
		if(ManipuladorArquivo.leitor("file.dat") == null) {
			LocalDate localDate = LocalDate.parse("02-02-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    		Usuario user= new Usuario("Maria", "maria", "maria", "Female", "maria@maria", localDate);
    		Usuario usera= new Usuario("mayara", "mayara", "mayara", "Female", "mayara@mayara", localDate);
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
		
		
	
    	    
	}
	
	@FXML
	private void initialize() 
	{
		
	}
	@FXML
	private void entra() throws IOException{
		
		user = new Usuario(userName.getText(),password.getText());
		try {
			user = this.fachada.logar(user);
			//JOptionPane.showMessageDialog(null,"Login com sucesso!" );
			
			this.chamarTelaPrincipal();
			
		} catch (InformacaoInvalidaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
    public void chamarTelaPrincipal()throws IOException{
    	ScreenManager.getInstance().showCalendario();
    }
	@FXML
	private void signUP(ActionEvent event){
		ScreenManager.getInstance().showSignUp();
		
	}
	public static Usuario getUser() {
		
		return LoginController.user;
	}
	@FXML
	public void fechar(){
		ScreenManager.getInstance().fecharMainStage();
	}
	@FXML
	public void minimizar(){
		ScreenManager.getInstance().minimizarMainStage();
	}
    @FXML
    void pressionar(KeyEvent e) throws IOException {
    	if (e.getCode() == KeyCode.ENTER) {
			this.entra();
		}
    }
}
