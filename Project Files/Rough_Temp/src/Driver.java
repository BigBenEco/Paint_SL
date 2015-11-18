// Made By Venancio (Ben) Zuniga and Jacob

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