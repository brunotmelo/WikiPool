package ui.widgets;

import dataTypes.Revision;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;



public class RevisionCell extends ListCell<Revision> {
		
	private VBox revisionBox = new VBox(15);
    private HBox tagsBox = new HBox(20);
    Text comment = new Text("");
    Label author = new Label("");
    Pane whitespace = new Pane();
    Text date = new Text("");
    Text time = new Text("");
    
    private Revision lastItemPointer;

    public RevisionCell(Revision revision){
    	super();
    	initCell();
    }
    
    public RevisionCell() {
        super();
        initCell();

    }
    
    private void initCell(){
        setIds();
        comment.setWrappingWidth(550);
        comment.setTextAlignment(TextAlignment.JUSTIFY);
        revisionBox.getChildren().add(comment);
        revisionBox.getChildren().add(tagsBox);
        tagsBox.getChildren().addAll(author, whitespace, date, time);
        HBox.setHgrow(whitespace, Priority.ALWAYS);
        revisionBox.getStylesheets().add("ui/RevisionCellStyle.css");
    }
    
    @Override
    protected void updateItem(Revision item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty) {
            lastItemPointer = null;
            setGraphic(null);
        } else {
            lastItemPointer = item;
            buildCell(item);
            setGraphic(revisionBox);
        }
    }
    
    private void buildCell(Revision revision){
    	author.setText(revision.getAuthor());
    	date.setText(revision.getFormattedDate());
    	time.setText(revision.getFormattedTime());
    	String commentText = revision.getComment();
    	if(commentText.isEmpty()){
    		comment.setText("No comment");
    	}else{
    		comment.setText(commentText);
    	}
    	
    }
    
    private void setIds(){
    	date.setId("dateText");
    	time.setId("timeText");
    	tagsBox.setId("downBar");
    	comment.setId("comment");
    }
    
}
