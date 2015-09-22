
package ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class RevisionsScreen {
	
	
	//i will need title, if was redirected
	//revisions 
	
	private Scene revisionsScene;
	private String searchText;
	
	
	public RevisionsScreen(){
		populateScene();
	}
	
	private void populateScene(){
		Label secondLabel = new Label("Hello");
	    
	    StackPane layout = new StackPane();
	    layout.getChildren().add(secondLabel);
	     
	    revisionsScene = new Scene(layout, 200, 100);
	}
	
	private void createRevisionLayout(){
		
	}
	
	
	
	public void show(){
		Stage mainStage = new Stage();
	    mainStage.setTitle("WikiPool - "+ searchText);
	    mainStage.setScene(revisionsScene);	
	    mainStage.show();
	}

	
	
	
	
	
}
