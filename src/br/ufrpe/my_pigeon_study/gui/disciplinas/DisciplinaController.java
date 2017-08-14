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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class DisciplinaController {


	private Fachada fachada;
	
	private static Usuario user;
	
	private static Disciplina activit;
	
    @FXML
    private Label userName;

    @FXML
    private JFXButton profile;

    @FXML
    private JFXButton activities;

    @FXML
    private JFXButton logOut;

    @FXML
    private ListView<String> list;
    
    private final String[] days ={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    
    @FXML
    private ComboBox<String> dueDay;

    @FXML
    private JFXTextField title;

    @FXML
    private JFXTextArea detail;

    @FXML
    private JFXTimePicker dueTime;

    @FXML
    private JFXButton save; 
    
    @FXML
    private AnchorPane paneAtividades;

    public DisciplinaController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
   
	public void setUser(Usuario u){
    	user = u;
    }
    public Usuario getUser(){
    	return(user);
    }
    
	@FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = fachada.buscar(LoginController.getUser().getUsuario());
    	setUser(c);
    	ObservableList<String> activities = FXCollections.observableArrayList(fachada.showAtividades(user));
    	list.setItems(activities);
    	list.setPrefWidth(528);
    	list.setPrefHeight(490);
    	dueDay.setPromptText("Day of Week");
		dueDay.getItems().addAll(days);
    	userName.setText(user.getNome());
  
    	list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override//Quando selecionar no listview a Atividades 
            public void handle(MouseEvent event) {
        		Disciplina t = fachada.buscarAtividade(user, list.getSelectionModel().getSelectedItem());
        		activit = t;
        		chamarAtividades();
                
            }
        });
	}

	
	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {

	}
    
    @FXML
    private void cadastrar(){
    	try{
    		
	    	int dia=this.dayOfWeek();
	    	Disciplina novaAtividades = new Disciplina(title.getText(),dia , dueTime.getValue(), detail.getText() );
			
			fachada.cadastrarAtividade(user,novaAtividades);
			title.clear();
			detail.clear();
			dueTime.setValue(null);

			list.getItems().add(novaAtividades.getNome());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    public void chamarAtividades(){
    	ScreenManager.getInstance().showCellDisciplina();
    }
    @FXML
    void chamarTelaInicial(){
    	ScreenManager.getInstance().showLogin();
    }
    @FXML
    void chamarTelaProfile(){
    	ScreenManager.getInstance().showPerfil();
    }
    @FXML
    void chamarTelaCalendar(){
    	ScreenManager.getInstance().showCalendario();
    }
    @FXML
    public void chamarTask(){
    	ScreenManager.getInstance().showMainTask();
    }
	public static Disciplina getAtividades() {
		return activit;
	}
	public static void setAtividades(Disciplina Atividades) {
		DisciplinaController.activit = Atividades;
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
    
}
