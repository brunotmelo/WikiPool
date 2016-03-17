
package ui;

import dataTypes.PageRevisions;
import dataTypes.Revision;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.util.BarChartBuilder;
import ui.util.ListBuilder;

public class RevisionsWindow {
	
	private Scene revisionsScene;

	private String redirectedFrom;
	private String titleText;
	private PageRevisions revisions;
	
	public RevisionsWindow(PageRevisions revisions){
		this.revisions = revisions;
		redirectedFrom = revisions.getRedirectedFrom();
		titleText = revisions.getPageTitle();
		buildScene();
	}
	
	private void buildScene(){
	    VBox mainLayout = new VBox(8);
		addTitleBar(mainLayout);
		addContentPane(mainLayout);
		mainLayout.setId("vboxe");
		createScene(mainLayout);    
	}
	
	private void addTitleBar(VBox mainLayout){
		Text title = new Text(titleText + ": Revisions History");
		title.setId("title");
	    mainLayout.getChildren().add(title);
	    Separator separator = new Separator();
	    mainLayout.getChildren().add(separator);
	}
	
	private void addContentPane(VBox mainLayout){
	    HBox contentBox = new HBox(10);
	    buildAndAddList(contentBox);
	    buildAndAddChart(contentBox);
	    mainLayout.getChildren().add(contentBox);
	}
	
	private void buildAndAddList(HBox contentBox){
		ListBuilder builder = new ListBuilder(revisions.getAllRevisions());
        ListView<Revision> revisionsList = builder.build();
        contentBox.getChildren().add(revisionsList);
        setListProprieties(revisionsList);
	}
	
	private void setListProprieties(ListView<Revision> revisionsList){
		HBox.setHgrow(revisionsList, Priority.ALWAYS);
	    revisionsList.setMinHeight(680);
	    revisionsList.setMinWidth(600);
	}
	
	private void buildAndAddChart(HBox contentBox){
		BarChartBuilder builder = new BarChartBuilder(revisions.getAuthors());
		BarChart<String,Number> bc = builder.getChart();
		VBox chartBox = buildChartBox(bc);
		contentBox.getChildren().add(chartBox);
	}
	
	private VBox buildChartBox(BarChart<String,Number> bc){
		VBox chartBox = new VBox();
		Pane whitespace = new Pane();
		chartBox.getChildren().add(bc);
		chartBox.getChildren().add(whitespace);
		VBox.setVgrow(bc, Priority.ALWAYS);
		
		return chartBox;
	}
	
	private void createScene(VBox mainLayout) {
		 revisionsScene = new Scene(mainLayout, 1024, 768);
		 revisionsScene.getStylesheets().add("ui/RevisionsWindowStyle.css");   
	}
	
	public void show(){
		Stage mainStage = new Stage();
		setPageTitle(mainStage);
	    mainStage.setScene(revisionsScene);
	    mainStage.show();
	}
	
	private void setPageTitle(Stage mainStage){
		if(redirectedFrom!=null){
			mainStage.setTitle("WikiPool - Redirected from " +redirectedFrom );
		}else{
			mainStage.setTitle("WikiPool - "+ titleText);
		}
	}
}
