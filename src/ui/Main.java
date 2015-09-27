package ui;

public class Main {

	//windowmanager will have a copy of all windows.
	//it will be able to 
	
	
	
	public static void main(String[] args) {
/*		WindowManager windowManager = WindowManager.getInstance();
		
		windowManager.loadUI(args);*/
		SearchWindow.launch(SearchWindow.class,args);

	}

}
