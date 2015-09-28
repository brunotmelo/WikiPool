package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.widgets.PoolButton;

public class SearchWindow extends Application {

	private Scene searchScene;
	private PoolButton button;
	
	private TextField inputField =  new TextField();
	
	public static void Main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {        
		populateScene();
		show();
	}
	
	private void populateScene(){
   		VBox verticalLayout = new VBox();
   		verticalLayout.setId("vbox");
        verticalLayout.getChildren().add(inputField);
        verticalLayout.setMinSize(320, 240);
        button = new PoolButton(inputField);    
        verticalLayout.getChildren().add(button);
	    addEnterClickListener();
	    searchScene = new Scene(verticalLayout, 200, 100);
	    searchScene.getStylesheets().add("ui/SearchWindowStyle.css");
	}
	
	private void addEnterClickListener(){
		searchScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
	        if(key.getCode()==KeyCode.ENTER) {
	        	button.requestFocus();
	        	button.fire();
	        }
		});
	}
	
	public void show(){
		Stage mainStage = new Stage();
	    mainStage.setTitle("WikiPool");
	    mainStage.setScene(searchScene);	
	    mainStage.show();
	}
	
	
}
