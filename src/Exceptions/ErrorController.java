package Exceptions;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorController implements Initializable{
	
	private Stage stage;
	@FXML
	private Label lblmsg;
	@FXML
	private Button btnOk;
	
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setMsg(String msg){//seta a msg de erro 
		lblmsg.setText(msg);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnOk.setOnAction(this::handleButtonAction);
		
	}
	@FXML
	 private void handleButtonAction(ActionEvent event) {
		Stage stage = (Stage) btnOk.getScene().getWindow();
	    stage.close();
	 }

}
