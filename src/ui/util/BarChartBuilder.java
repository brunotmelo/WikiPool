package ui.util;

import java.util.ArrayList;

import dataTypes.Author;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarChartBuilder{

	//it puts himself into the view
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
	private BarChart<String,Number> bc;
	private ArrayList<Author> authors;
	
	private XYChart.Series<String,Number> series1;

	public BarChartBuilder(ArrayList<Author> authors){
		this.authors = authors;
		initVariables();
        
		buildGraph();
	}
	
	private void initVariables(){
		xAxis = new CategoryAxis();
        xAxis.setLabel("Author");     
		yAxis = new NumberAxis();
        yAxis.setLabel("Changes made");
		
		bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Revisions per author");
        bc.setLegendVisible(false);
	}
	
	public BarChart<String,Number> getChart(){
		return bc;	
	}
	
	private void buildGraph(){
		series1 = new XYChart.Series();
		Author aux;
		for(int i=0; i<authors.size(); i++){
			aux = authors.get(i);
			if(aux.getNoOfRevisions()>1){
				addToGraph(aux);
			}
		}
		bc.getData().addAll(series1);
	}
	
	private void addToGraph(Author current){
		int changes = current.getNoOfRevisions();
		String name = current.getName();
		series1.getData().add(new XYChart.Data(name, changes));
	}
	
	
}
