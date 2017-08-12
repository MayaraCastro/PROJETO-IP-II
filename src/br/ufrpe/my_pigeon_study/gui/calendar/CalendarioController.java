package br.ufrpe.my_pigeon_study.gui.calendar;

import java.io.IOException;

import com.jfoenix.controls.JFXDatePicker;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.gui.ScreenManager;
import br.ufrpe.my_pigeon_study.gui.login.LoginController;

import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Disciplina;
import br.ufrpe.my_pigeon_study.negocio.beans.Task;
import br.ufrpe.my_pigeon_study.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;


public class CalendarioController {
	
	private Fachada fachada;
	
	private static Usuario user;
	
	private static Task task;
	
	private static Disciplina classe;
	
	@FXML
    private Label userName;

    @FXML
    private JFXDatePicker date;

    @FXML
    private ListView<String> classesList;

    @FXML
    private ListView<String> taskList;
    
    @FXML
    private Label nClass;

    @FXML
    private Label nTask;
    
    public static Task getTask() {
    	return task;
    }
    public static void setTask(Task task) {
    	CalendarioController.task = task;
    }
    public CalendarioController() throws IOException{
    	this.fachada = Fachada.getInstancia();
    }
    
    public void setUser(Usuario useri){
    	user = useri;
    }
    public static Usuario getUser(){
    	return(user);
    }
    
    
    @FXML
	private void initialize() throws InformacaoInvalidaException 
	{
    	Usuario c = this.fachada.buscar(LoginController.getUser().getUsuario());
    	this.setUser(c);
    	userName.setText(c.getNome());
    	
    	taskList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override//Quando selecionar no listview a task 
            public void handle(MouseEvent event) {
        		Task t = fachada.buscarTask(user, taskList.getSelectionModel().getSelectedItem());
        		task = t;
        		try {
					chamarTaskInfo();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }

			private void chamarTaskInfo() throws IOException {
				ScreenManager.getInstance().showInfoTask();
				
			}
        });
    	
	}
    @FXML
    void editTask() throws IOException{
        	//TODO
        
    }
    @FXML
    private void listar() {
    	ObservableList<String> classes = FXCollections.observableArrayList(fachada.calendarioAtividades(user, date.getValue().getDayOfWeek().getValue()));
    	classesList.setItems(classes);
    	nClass.setText("(" + classes.size() + ")");
    	
    	ObservableList<String> tasks = FXCollections.observableArrayList(fachada.calendarioTasks(user, date.getValue()));
    	taskList.setItems(tasks);
    	nTask.setText("("+ tasks.size() +")");
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
    void chamarTelaProfile(){
    	ScreenManager.getInstance().showPerfil();
    }
}

