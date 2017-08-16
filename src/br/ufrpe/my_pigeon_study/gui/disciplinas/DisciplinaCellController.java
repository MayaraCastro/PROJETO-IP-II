package br.ufrpe.my_pigeon_study.gui.disciplinas;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> dueDay;

    private final String[] days ={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};

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
    	ScreenManager.getInstance().fecharInfoStage();
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
    	dueDay.setPromptText(days[this.getAtividades().getDia_da_semana()-1]);
		dueDay.getItems().addAll(days);
		
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
    	int dia=this.dayOfWeek();
    	Disciplina novaAtividade = new Disciplina( title.getText(), dia, time.getValue(), detail.getText());
		
    	try{
			fachada.alterarAtividade(user,novaAtividade, atvdd);
			ScreenManager.getInstance().fecharInfoStage();
			this.atualizarJanela();
		    
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    private void atualizarJanela() throws IOException{
    	ScreenManager.getInstance().showMainDisciplina();;
    }
    public int dayOfWeek(){
		
		String valor=dueDay.getValue();
		if(valor=="MONDAY"){
			return 1;
		}
		else if(valor=="TUESDAY"){
			return 2;
		}
		else if(valor=="WEDNESDAY"){
			return 3;
		}
		else if(valor=="THURSDAY"){
			return 4;
		}
		else if(valor=="FRIDAY"){
			return 5;
		}
		else if(valor=="SATURDAY"){
			return 6;
		}
		else if(valor=="SUNDAY"){
			return 7;
		}
		return -1;
	}
    
    @FXML
    private void fechar() {
    	ScreenManager.getInstance().fecharInfoStage();
    }
}
