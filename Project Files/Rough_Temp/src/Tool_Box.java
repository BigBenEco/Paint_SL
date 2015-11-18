import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Tool_Box {
	
	public static enum tool { Mouse, Box, Eclipse, Line };//this is were to add names to other tools here.
	
	public tool myTool;
	public boolean doingWork = false; // used to now if when the mouse is moving if we need to do something.
	
	private itb_Box BoxTool = new itb_Box(); // the actual tools
	//this is were to make other tools here.
	
	// Drawing Parameters, will be adjustable, but for now these will be fixed to these default values.
	public int outlineThickness = 1;
	public Color cOutline = new Color(0, 0, 0);
	public Color cFilling = new Color(255, 0, 0);
	public boolean isFilled = true;
	public boolean isOutlined = true;
	
	Tool_Box()
	{
		myTool = tool.Mouse; // sets the tool to nothing.
	}
	
	public void start( int startX, int startY)
	{
		doingWork = true;
		switch(myTool)
		{
			case Mouse:
			{
				// Nothing to do really.
			}	
			break;
			
			case Box:
			{
				BoxTool.startAt(startX, startY);  // Calls the special function for that particular tool
			}	
			break;
			
			//this is were to add the calls to other tools here.
			
			default:
			{
				// Nothing to do really.
			}	
		}
	}
	
	public void hold( BufferedImage painting, int endX, int endY)
	{
		if(doingWork){
			switch(myTool)
			{
				case Mouse:
				{
					// Nothing to do really.
				}	
				break;
				
				case Box:
				{
					BoxTool.drawBounds(painting, endX, endY, outlineThickness);  // Calls the special function for that particular tool, and gives it all the parameters it may need, pass by reference so we do not need to return anything.
				}	
				break;
				
				//this is were to add the calls to other tools here.
				
				default:
				{
					// Nothing to do really.
				}	
			}
		}
	}
	
	public void end( BufferedImage painting, int endX, int endY)
	{
		if (doingWork){
			doingWork = false;
			switch(myTool)
			{
				case Mouse:
				{
					// Nothing to do really.
				}	
				break;
				
				case Box:
				{
					BoxTool.finalize( painting, endX, endY, outlineThickness, cFilling, cOutline, isFilled, isOutlined );  // Calls the special function for that particular tool, and gives it all the parameters it may need, pass by reference so we do not need to return anything.
				}	
				break;
				
				//this is were to add the calls to other tools here.
				
				default:
				{
					// Nothing to do really.
				}	
			}
		}
	}
	
}
