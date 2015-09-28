package ui.widgets;


import dataTypes.PageRevisions;
import exceptions.WikipediaConnectionException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import network.WikipediaPooler;
import ui.RevisionsWindow;

public class PoolButton extends Button {  	
	
	
	public PoolButton(TextField inputField) {
		super("Pool page revisions");
    		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	
				disableButton();
				PageRevisions page = getPageRevisions(inputField.getText());
				openPageRevisionsWindow(page);
				//hideCurrentWindow(event);				
			}
		});
	}
	
	private PageRevisions getPageRevisions(String searchTerm){
		WikipediaPooler control = new WikipediaPooler();
		try{
			return control.getPageRevisions(searchTerm);
		}catch(WikipediaConnectionException e){
			new ConnectionErrorDialog();
		}catch(Exception e){
			new ParseErrorDialog();
		}finally{
			enableButton();
		}
		//code to make the compiler happy.
		//this is unreachable code
		return null;
	}
		
	private void openPageRevisionsWindow(PageRevisions page){
		RevisionsWindow searchScreen1 = new RevisionsWindow(page);
		searchScreen1.show();
	}
	
	private void hideCurrentWindow(ActionEvent clickEvent){
		((Node)(clickEvent.getSource())).getScene().getWindow().hide();;
	}
	
	private void disableButton(){
		this.setDisable(true);
	}
	
	private void enableButton(){
		this.setDisable(false);
	}
}
