
package ui;

import dataTypes.PageRevisions;
import dataTypes.Revision;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import ui.widgets.BarChartBuilder;
import ui.widgets.RevisionCell;



public class RevisionsWindow {
	
	
	//i will need title, if was redirected
	//revisions
	
	//vars required to run the window
	private Scene revisionsScene;
	private VBox layout;
	private Separator separator = new Separator();
	private HBox content;

	//private Text 
	
	private String redirectedFrom;
	private String titleText;
	private PageRevisions revisions;
	
	ListView<Revision> list;
	
	private VBox chartBox;
	private Pane whitespace;
	private BarChart<String,Number> bc;
	
	public RevisionsWindow(PageRevisions revisions){
		this.revisions = revisions;
		redirectedFrom = revisions.getRedirectedFrom();
		titleText = revisions.getPageTitle();
		buildScene();
	}
	
	//this constructor is only for testing purposes
	public RevisionsWindow(){
		redirectedFrom = "obama";
		titleText = "Barack Obama";
		buildScene();
	}
	
	private void buildScene(){
	    layout = new VBox(8);
	    layout.setId("vboxe");
		
		addTitleBar();
		addContentPane();

	    revisionsScene = new Scene(layout, 1024, 768);
	    revisionsScene.getStylesheets().add("ui/RevisionsWindowStyle.css");       

	}
	
	private void addTitleBar(){
		Text title = new Text(titleText + ": Revisions History");
		title.setId("title");
	    layout.getChildren().add(title);
	    layout.getChildren().add(separator);
	}
	
	private void addContentPane(){
	    content = new HBox(10);
	    populateList();
	    buildChart();
	    setContentProprieties();
	    layout.getChildren().add(content);
	}
	
	private void populateList(){
        /*ObservableList<String> data = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4");*/
		ObservableList<Revision> data = FXCollections.observableArrayList(revisions.getAllRevisions());
        list = new ListView<>(data);
        list.setCellFactory(new Callback<ListView<Revision>, ListCell<Revision>>() {
            @Override
            public ListCell<Revision> call(ListView<Revision> param) {
                return new RevisionCell();
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
	
	private void buildChart(){
		BarChartBuilder builder = new BarChartBuilder(revisions.getAuthors());
		bc = builder.getChart();
		
		chartBox = new VBox();
		whitespace = new Pane();
		chartBox.getChildren().add(bc);
		chartBox.getChildren().add(whitespace);
		//VBox.setVgrow(whitespace, Priority.ALWAYS);
	}
	
	private void setContentProprieties(){
	    HBox.setHgrow(list, Priority.ALWAYS);
	    //VBox.setVgrow(list, Priority.ALWAYS);
	    list.setMinHeight(680);
	    list.setMinWidth(600);
	    content.getChildren().add(chartBox);
	    //layout.getChildren().add();
	}
	
	public void show(){
		Stage mainStage = new Stage();
		if(redirectedFrom!=null){
			mainStage.setTitle("WikiPool - Redirected from " +redirectedFrom );
		}else{
			System.out.println(redirectedFrom);
			mainStage.setTitle("WikiPool - "+ titleText);
		}
		
	    
	    mainStage.setScene(revisionsScene);
	    
	    mainStage.show();
	}

	
	
	
	
	
}
