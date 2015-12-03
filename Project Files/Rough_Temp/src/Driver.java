// Made By Venancio (Ben) Zuniga and Jacob Ziehli

public class Driver 
{
	public static Program_Data global;
	
	public static void main( String args[] ) //Lays out initiation.
	{	
		global = new Program_Data();
		global.buildGUI();
		//System.out.println("Test"); // update will yah?
		global.run();
	}
}