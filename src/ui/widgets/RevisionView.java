package ui.widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;



public class RevisionView extends ListCell<String> {
	private VBox vbox = new VBox(15);
    private HBox hbox = new HBox(20);
    Text comment = new Text("/* Infobox */ We should not predict when Obama will cease "
    		+ "being President, even in a very subtle way");
    Label author = new Label("Boccobrock");
    Pane pane = new Pane();
    Text date = new Text("09-02-2015");
    Text time = new Text("04:06AM");
    String lastItem;

    public RevisionView() {
        super();
        setIds();
        comment.setWrappingWidth(450);
        comment.setTextAlignment(TextAlignment.JUSTIFY);
        vbox.getChildren().add(comment);
        vbox.getChildren().add(hbox);
        hbox.getChildren().addAll(author, pane, date, time);
        HBox.setHgrow(pane, Priority.ALWAYS);
        vbox.getStylesheets().add("ui/RevisionCellStyle.css");
    }
    
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            lastItem = null;
            setGraphic(null);
        } else {
            lastItem = item;
            author.setText(item!=null ? item : "<null>");
            setGraphic(vbox);
        }
    }
    
    private void setIds(){
    	date.setId("dateText");
    	time.setId("timeText");
    	hbox.setId("downBar");
    }
    
}
