package ui.widgets;


import ui.RevisionsWindow;
import dataTypes.PageRevisions;
import exceptions.WikipediaConnectionException;
import exceptions.XmlParsingException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import network.WikipediaPooler;

public class PoolButton extends Button {  	
	
	
	public PoolButton(TextField inputField) {
		super("Pool page revisions");
    		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				WikipediaPooler control = new WikipediaPooler();
				try{
					PageRevisions page = control.getPageRevisions(inputField.getText());
					openPageRevisionsWindow(page);
				}catch(WikipediaConnectionException e){
					new ConnectionErrorDialog();
				}catch(XmlParsingException e){
					new ParseErrorDialog();
				}
				
				
				
				//openWindow();

				//hideCurrentWindow(event);				
			}
		});
	}
   	
	private void hideCurrentWindow(ActionEvent clickEvent){
		((Node)(clickEvent.getSource())).getScene().getWindow().hide();;
	}
	
	private void openPageRevisionsWindow(PageRevisions page){
		RevisionsWindow searchScreen1 = new RevisionsWindow(page);
		searchScreen1.show();
	}
	
}
