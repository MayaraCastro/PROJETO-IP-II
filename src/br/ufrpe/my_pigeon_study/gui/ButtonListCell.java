package br.ufrpe.my_pigeon_study.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;

class ButtonListCell extends ListCell<Object> {
    @Override
    public void updateItem(Object obj, boolean empty) {
        super.updateItem(obj, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(obj.toString());
 
            Button butt = new Button();
            butt.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    System.out.println("clicked");
                }                            
            });
            setGraphic(butt);
        }
    }
}