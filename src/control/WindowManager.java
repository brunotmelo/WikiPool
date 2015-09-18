package control;

import ui.TestScreen;

public class WindowManager {

	//has information about all windows.
	
	//will be static. When one window opens, it closes another.
	
	private static WindowManager instance;
	
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
		TestScreen.launch(TestScreen.class, args);
		//TestScreen test = new TestScreen(args);
	}
	
	public void openRevisionsScreen(String pageTitle){
		//TestScreen.
		//pool for information in the api. 
		//there will be a pagebuilderobject that will get all required information
		//Api.getPageRevisions
		
		
	}
	
	
}
