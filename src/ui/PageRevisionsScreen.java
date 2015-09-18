
package ui;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.widgets.PoolButton;

public class PageRevisionsScreen {
	
	
	//i will need title, if was redirected
	//revisions 
	
	
	//wikiInfoPackage
	private TextField inputField =  new TextField();
	
	public static void Main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {        
        configure(primaryStage);
		
	}

	private void configure(Stage stage) {
    	stage.setTitle("WikiPool");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();		
	}
	
	private Pane createRoot() {
    	VBox root = new VBox();
        root.getChildren().add(inputField);
        root.setMinSize(320, 240);
        root.getChildren().add(new PoolButton(inputField));

        return root;
	}
	
	
	
	
	
}
