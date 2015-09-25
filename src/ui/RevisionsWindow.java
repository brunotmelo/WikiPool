
package ui;

import ui.widgets.BarChartBuilder;
import ui.widgets.RevisionView;
import dataTypes.Revisions;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;



public class RevisionsWindow {
	
	
	//i will need title, if was redirected
	//revisions
	
	//vars required to run the window
	private Scene revisionsScene;
	private VBox layout;
	private Separator separator = new Separator();
	private HBox content;
	private Text redirected;

	//private Text 
	
	private String searchText;
	private String titleText;
	private Revisions revisions;
	
	ListView<String> list;
	
	private VBox chartBox;
	private Pane whitespace;
	private BarChart<String,Number> bc;
	
	public RevisionsWindow(Revisions revisions){
		populateScene();
	}
	
	//this constructor is only for testing purposes
	public RevisionsWindow(){
		searchText = "obama";
		redirected = new Text(" - redirected from: "+ searchText);
		redirected.setId("");
		titleText = "Barack Obama";
		populateScene();
	}
	
	private void populateScene(){
		Text secondLabel = new Text(titleText + ": Revisions History");
		secondLabel.setId("title");
		
		
	    layout = new VBox(8);
	    layout.setId("vboxe");
	    layout.getChildren().add(secondLabel);
	    layout.getChildren().add(separator);
	    
	    content = new HBox(10);
	    populateList();
	    buildChart();
	    HBox.setHgrow(list, Priority.ALWAYS);
	    //VBox.setVgrow(list, Priority.ALWAYS);
	    list.setMinHeight(1024);
	    content.getChildren().add(chartBox);
	    //layout.getChildren().add();
	    
	    
	    layout.getChildren().add(content);
	     
	    revisionsScene = new Scene(layout, 1024, 768);
	    revisionsScene.getStylesheets().add("ui/RevisionsWindowStyle.css");
	    
	    
	       

	}
	
	
	private void createRevisionLayout(){
		
	}
	
	private void buildChart(){
		BarChartBuilder builder = new BarChartBuilder();
		builder.build();
		bc = builder.getChart();
		
		chartBox = new VBox();
		whitespace = new Pane();
		chartBox.getChildren().add(bc);
		chartBox.getChildren().add(whitespace);
		VBox.setVgrow(whitespace, Priority.ALWAYS);
		
	}
	
	
	public void show(){
		Stage mainStage = new Stage();
	    mainStage.setTitle("WikiPool - "+ titleText);
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
        
        content.getChildren().add(list);
		
	}

	
	
	
	
	
}
