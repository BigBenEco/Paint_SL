// Made By Venancio (Ben) Zuniga. 

public class Driver 
{
	public static Program_Data global;
	
	public static void main( String args[] ) //Lays out initiation.
	{	
		global = new Program_Data();
		global.buildGUI();
		global.run();
	}
}


/*
 * Notes:
 * I think the way I am going to organize the code is by making a class for a 
 * Particular object I want, for example a panel for the Buttons, another class 
 * for the panel that holds the tool bar. In those classes will be the code for the layout.
 * 
 * */