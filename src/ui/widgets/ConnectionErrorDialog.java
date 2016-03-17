package ui.widgets;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConnectionErrorDialog {

	public ConnectionErrorDialog(){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Could not connect to wikipedia.");
		alert.setContentText("Try checking your internet and try again.");

		alert.showAndWait();
		
	}
	
}
