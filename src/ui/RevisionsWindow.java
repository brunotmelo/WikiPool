
package ui;

import ui.widgets.RevisionView;
import dataTypes.PageRevisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;



public class RevisionsWindow {
	
	
	//i will need title, if was redirected
	//revisions
	
	//vars required to run the window
	private Scene revisionsScene;
	private StackPane layout;
	
	private String searchText;
	private PageRevisions revisions;
	
	ListView<String> list;
	
	
	public RevisionsWindow(PageRevisions revisions){
		populateScene();
	}
	
	//this constructor is only for testing purposes
	public RevisionsWindow(){
		searchText = "Obama";
		populateScene();
	}
	
	private void populateScene(){
		Label secondLabel = new Label("Hello");
		
		
	    layout = new StackPane();
	    layout.getChildren().add(secondLabel);
	    populateList();
	     
	    revisionsScene = new Scene(layout, 1024, 768);
	    
	    
	       

	}
	
	private void createRevisionLayout(){
		
	}
	
	
	
	public void show(){
		Stage mainStage = new Stage();
	    mainStage.setTitle("WikiPool - "+ searchText);
	    mainStage.setScene(revisionsScene);
	    
	    mainStage.show();
	}
	
	private void populateList(){
        ObservableList<String> data = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4");
        list = new ListView<>(data);
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new RevisionView();
            }
        });
        
        layout.getChildren().add(list);
		
	}

	
	
	
	
	
}
