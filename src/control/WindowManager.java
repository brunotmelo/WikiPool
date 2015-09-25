package control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.SearchWindow;
import ui.TestScreen;

public class WindowManager{

	//has information about all windows.
	//will be static. When one window opens, it closes another.
	
	private static WindowManager instance;
	
	//this method is required for javafx to run
/*	public static void Main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {        
        SearchWindow screen = new SearchWindow(primaryStage);
		screen.show();
	}*/
	
	
	
	
	
	private WindowManager() {
		//instance = new WindowManager();
	}
	
	public static WindowManager getInstance(){
		if(instance == null){
			instance = new WindowManager();
		}
		return instance;
	}
	
	public void loadUI(String[] args){
		
		//TestScreen.launch(TestScreen.class, args);
		SearchWindow.launch(SearchWindow.class,args);
	}
	
	public void openRevisionsScreen(String pageTitle){
		//TestScreen.
		//pool for information in the api. 
		//there will be a pagebuilderobject that will get all required information
		//Api.getPageRevisions
		
		
	}
	
	
}
