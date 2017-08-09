package br.ufrpe.my_pigeon_study.gui.atividades;

import java.io.IOException;


import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.calendar.Calendario;
import br.ufrpe.my_pigeon_study.gui.calendar.CalendarioController;
import br.ufrpe.my_pigeon_study.gui.login.Login;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;
import br.ufrpe.my_pigeon_study.gui.profile.Profile;
import br.ufrpe.my_pigeon_study.gui.profile.ProfileController;
import br.ufrpe.my_pigeon_study.negocio.Fachada;


import br.ufrpe.my_pigeon_study.negocio.beans.Atividade;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AtividadesController {

	private static Stage stage;
	
	private Fachada fachada;
	
	private static Usuario user;
	
	private static Atividade activit;
	
    @FXML
    private Label userName;

    @FXML
    private JFXButton profile;

    @FXML
    private JFXButton calendar;

    @FXML
    private JFXButton Atividadess;

    @FXML
    private JFXButton activities;

    @FXML
    private JFXButton logOut;

    @FXML
    private ListView<String> list;

    @FXML
    private JFXDatePicker dueDate;

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

    public AtividadesController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
    public void setStage(Stage s){
        stage = s;
    }
    
    public static Stage getStage() {
		return stage;
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
		
    	userName.setText(user.getNome());
    	list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override//Quando selecionar no listview a Atividades 
            public void handle(MouseEvent event) {
        		Atividade t = fachada.buscarAtividade(user, list.getSelectionModel().getSelectedItem());
        		activit = t;
        		try {
					chamarAtividades();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        });
	}

	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {

	}
    
    @FXML
    private void cadastrar(){
    	try{
    		
	    	Atividade novaAtividades = new Atividade(title.getText(), dueDate.getValue().getDayOfWeek().getValue(), dueTime.getValue(), detail.getText() );
			
			fachada.cadastrarAtividade(user,novaAtividades);
			dueDate.setValue(null);
			title.clear();
			detail.clear();
			dueTime.setValue(null);

			list.getItems().add(novaAtividades.getNome());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    public void chamarAtividades()throws IOException{
    	FXMLLoader loader = new FXMLLoader(AtividadesCell.class.getResource("AtividadesCell.fxml"));
			
	    AnchorPane root = (AnchorPane) loader.load();

		Stage s = new Stage();
	    s.setScene(new Scene(root));
	    AtividadesCellController.setStage(s);
	    s.show();
    }
    @FXML
    void chamarTelaInicial()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Login.class.getResource("Login.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	LoginController controller = (LoginController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    @FXML
    void chamarTelaProfile()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Profile.class.getResource("Profile.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	ProfileController controller = (ProfileController) loader.getController();
    	ProfileController.setUser(user);
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    @FXML
    void chamarTelaCalendar()throws IOException{
    	FXMLLoader loader = new FXMLLoader(Calendario.class.getResource("Calendario.fxml"));
    		
    	AnchorPane root = (AnchorPane) loader.load();
    	CalendarioController controller = (CalendarioController) loader.getController();
		controller.setStage(stage);
    	stage.setScene(new Scene(root));
    }
    
	public static Atividade getAtividades() {
		return activit;
	}
	public static void setAtividades(Atividade Atividades) {
		AtividadesController.activit = Atividades;
	}
    
}
