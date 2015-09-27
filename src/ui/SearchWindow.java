package ui;

import ui.widgets.PoolButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchWindow extends Application {

	private Scene searchScene;
	
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
        verticalLayout.getChildren().add(new PoolButton(inputField));
	     
	    searchScene = new Scene(verticalLayout, 200, 100);
	    searchScene.getStylesheets().add("ui/SearchWindowStyle.css");
	    
	}
	
	public void show(){
		Stage mainStage = new Stage();
	    mainStage.setTitle("WikiPool");
	    mainStage.setScene(searchScene);	
	    mainStage.show();
	}

}
