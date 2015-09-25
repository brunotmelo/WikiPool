package ui.widgets;


import ui.RevisionsWindow;
import control.WindowManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PoolButton extends Button {  	
	
	
	public PoolButton(TextField inputField) {
		super("Pool page revisions");
    		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				
				RevisionsWindow searchScreen1 = new RevisionsWindow();
				searchScreen1.show();
				
				//openWindow();

				hideCurrentWindow(event);				
			}
		});
	}
   	

	private void hideCurrentWindow(ActionEvent clickEvent){
		((Node)(clickEvent.getSource())).getScene().getWindow().hide();;
	}
	
	
	private void openWindow(){
		Label secondLabel = new Label("Obama");
        
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);
         
        Scene secondScene = new Scene(secondaryLayout, 200, 100);

        Stage secondStage = new Stage();
        secondStage.setTitle("Second Stage");
        secondStage.setScene(secondScene);

        secondStage.show();
	}
	
	private void poolWikipediaPage(String pageTitle){
		//Chama api pra receber resposta, quando receber resposta manda windowmanager abrir outra janela
		WindowManager windowManager = WindowManager.getInstance();
		//windowManager.openPageRevisionsWindow(pageTitle);
		
	}
	
	
}
