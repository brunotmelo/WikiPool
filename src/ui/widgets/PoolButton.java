package ui.widgets;


import java.io.IOException;

import ui.PageRevisionsScreen;
import ui.TestScreen;
import control.WindowManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PoolButton extends Button {  	
	
	
	public PoolButton(TextField inputField) {
		super("Pool");
    		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Parent root;
		        root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
		            
				//TODO:
				// lock current screen || close it
				//when next window opens unlock it
				
		        //Stage stage = new Stage(); stage.setScene(new Scene(new Group(new Text(10,10, "my second window"))));
		        Stage stage= new Stage();
		        PageRevisionsScreen.launch(PageRevisionsScreen.class, null);
		        
		            		
		            		//
	            //Stage stage = new Stage();
	            //stage.setTitle("My New Stage Title");
	            //stage.setScene(new Scene(root, 450, 450));
	            //stage.show();

	            //hide this current window (if this is whant you want
	            ((Node)(event.getSource())).getScene().getWindow().hide();;
										
			}
		});
	}
   	

	private void poolWikipediaPage(String pageTitle){
		//Chama api pra receber resposta, quando receber resposta manda windowmanager abrir outra janela
		WindowManager windowManager = WindowManager.getInstance();
		//windowManager.openPageChangesScreen(pageTitle);
		
	}
	
}
