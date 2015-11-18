import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Tool_Box {
	
	public static enum tool { Mouse, Box, Oval, Line, BoxF, OvalF };//this is were to add names to other tools here.
	
	public tool myTool;
	public boolean doingWork = false; // used to now if when the mouse is moving if we need to do something.
	
	private itb_Box  BoxTool  = new itb_Box(); // the actual tools
	private itb_Oval OvalTool = new itb_Oval();
	private itb_Line LineTool = new itb_Line();
	private itb_BoxF  BoxFTool  = new itb_BoxF(); // the actual tools
	private itb_OvalF OvalFTool = new itb_OvalF();
	
	
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
			
			case Oval:
			{
				OvalTool.startAt(startX, startY);  // Calls the special function for that particular tool
			}	
			break;
			
			case Line:
			{
				LineTool.startAt(startX, startY);  // Calls the special function for that particular tool
			}	
			break;
			
			case BoxF:
			{
				BoxFTool.startAt(startX, startY);  // Calls the special function for that particular tool
			}	
			break;
			
			case OvalF:
			{
				OvalFTool.startAt(startX, startY);  // Calls the special function for that particular tool
			}	
			break;
			
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
				
				case Oval:
				{
					OvalTool.drawBounds(painting, endX, endY, outlineThickness);  // Calls the special function for that particular tool
				}	
				break;
				
				case BoxF:
				{
					BoxFTool.drawBounds(painting, endX, endY, outlineThickness);  // Calls the special function for that particular tool, and gives it all the parameters it may need, pass by reference so we do not need to return anything.
				}	
				break;
				
				case OvalF:
				{
					OvalFTool.drawBounds(painting, endX, endY, outlineThickness);  // Calls the special function for that particular tool
				}	
				break;
				case Line:
				{
					LineTool.drawBounds(painting, endX, endY, outlineThickness);  // Calls the special function for that particular tool
				}	
				break;
				
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
				
				case Oval:
				{
					OvalTool.finalize( painting, endX, endY, outlineThickness, cFilling, cOutline, isFilled, isOutlined );  // Calls the special function for that particular tool
				}	
				break;
				
				case BoxF:
				{
					BoxFTool.finalize( painting, endX, endY, outlineThickness, cFilling, cOutline, isFilled, isOutlined );  // Calls the special function for that particular tool, and gives it all the parameters it may need, pass by reference so we do not need to return anything.
				}	
				break;
				
				case OvalF:
				{
					OvalFTool.finalize( painting, endX, endY, outlineThickness, cFilling, cOutline, isFilled, isOutlined );  // Calls the special function for that particular tool
				}	
				break;
				
				case Line:
				{
					LineTool.finalize( painting, endX, endY, outlineThickness, cFilling, cOutline, isFilled, isOutlined );  // Calls the special function for that particular tool
				}	
				break;
				
				default:
				{
					// Nothing to do really.
				}	
			}
		}
	}
	
}
