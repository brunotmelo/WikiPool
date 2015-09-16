package ui.widgets;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PoolButton extends Button {  	
	
	
	public PoolButton(TextField inputField) {
		super("Pool");
    		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//opennewScreen with the search parameters
				System.out.println("Ima working!");
										
			}
		});
	}
   	

}
