package ui.util;

import java.util.ArrayList;

import dataTypes.Revision;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import ui.widgets.RevisionCell;

public class ListBuilder {

	private ListView<Revision> list;
	private ArrayList<Revision> revisions;
	
	public ListBuilder(ArrayList<Revision> revisions){
		this.revisions = revisions;
	}
	
	public ListView<Revision> build(){
        createListWithRevisions();
        buildCells();
        disableCellSelection();
        return list;
	}
	
	private void createListWithRevisions(){
		ObservableList<Revision> data = FXCollections.observableArrayList(revisions);
        list = new ListView<>(data);
	}
	
	
	private void buildCells(){
		list.setCellFactory(new Callback<ListView<Revision>, ListCell<Revision>>() {
            @Override
            public ListCell<Revision> call(ListView<Revision> param) {
                return new RevisionCell();
            }
        });
	}
	
	private void disableCellSelection(){
        list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {
                Platform.runLater(new Runnable() {
                    public void run() {
                        list.getSelectionModel().select(-1);
                    }
                });
            }
        });	
	}
	
	
}
