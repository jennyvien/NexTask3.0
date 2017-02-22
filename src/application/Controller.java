package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML private TextField textField;
	@FXML private Button button;
	@FXML private ListView<String> listView;
	public void processText() {
		if(listView.getItems() == null) {
			listView.setItems(FXCollections.observableArrayList());
		} else {
			listView.getItems().add(textField.getText());
		}
		textField.clear();
	}
}
