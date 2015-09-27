package ui.widgets;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ParseErrorDialog {

	public ParseErrorDialog(){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Error while parsing wikipedia page");
		alert.setContentText("Try using a different search term");

		alert.showAndWait();
		
	}
	
}
