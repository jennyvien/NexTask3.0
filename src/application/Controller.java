package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements Initializable {
	
	@FXML private TextField textField;
	@FXML private Button button;
	@FXML private ListView<String> listView;
	@FXML private DialogPane dialogPane;

	ObservableList<String> list = FXCollections.observableArrayList(
			"Apply for Gap.",
			"Apply for Expedia.",
			"Apply for TripAdvisor.",
			"Apply for Fandango.",
			"Look for places to apply to."
			);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(list);
		
		dialogPane.setVisible(false);
	}
	
	public void processText(ActionEvent e) {
		if(listView.getItems() == null) {
			listView.setItems(FXCollections.observableArrayList());
		} else {
			listView.getItems().add(textField.getText());
		}
		textField.clear();
	}
	
	
	public void processKeyPressed(KeyEvent keyEvent) {
		if(keyEvent.getCode() == KeyCode.DELETE) {		
			if(!isListEmpty()) {
				int index = listView.getSelectionModel().getSelectedIndex();
				listView.getItems().remove(index);
			}
		} 
	}
	
	public boolean isListEmpty() {
		return listView.getItems().size() <= 0 ? true : false;
	}
	
	public void generateRandomTask() {
		int i = (int) (Math.random() * listView.getItems().size());
		Dialog.display("NexTask.", listView.getItems().get(i));
	}


	

	
}
