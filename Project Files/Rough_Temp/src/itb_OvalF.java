import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class itb_OvalF {
	private int startX, startY; //used for saving one corner of the box
	
	public void startAt( int inX, int inY )  //used when the mouse is first pressed to save that corner position.
	{
		startX = inX;
		startY = inY;
	}
	
	/*
	 * Ok here is how I think this will work.
	 * In the first function that follows, "drawBounds," its going to be told where the mouse is at, and it's going to be given an image of the current canvas.
	 * This function will then draw the bounding box. The box can be a simple dotted line, or use the variable "outlineThickness" to make a more accurate representation.
	 * You cold even just copy everything in the function "finalize" that way it draws exactly how the box will look like.
	 * When the function is done drawing, it will return the altered painting back to the canvas.
	 * 
	 * Like I said, both function below could be the same, they just need to draw.
	 * That's Canvas will handle the data, what is and is not saved, and so all this functions need to do is return the image they altered.
	 */
	public void drawBounds(  BufferedImage painting, int inX, int inY,  int outlineThickness ) //A special function used when the mouse is being dragged to give a representation of the box
	{
		Graphics2D tool = (Graphics2D) painting.getGraphics();
		
		int recWidth;
		int recHeight;
		int tempX;
		int tempY;
		
		if (inX > startX)
		{
			recWidth = inX - startX; 
			tempX = startX;
		}
		else // need to do a switch
		{
			tempX = inX;
			recWidth = startX - inX;
		}
		
		if (inY > startY)
		{
			recHeight = inY - startY; 
			tempY = startY;
		}
		else // need to do a switch
		{
			tempY = inY;
			recHeight = startY - inY;
		}
		
		// draw the thing.
		tool.setColor(Color.BLUE);
		tool.fillOval(tempX, tempY, recWidth, recHeight);
		
		
	}
	
	public void finalize( BufferedImage painting, int inX, int inY,  int outlineThickness, Color cFill, Color cOutline, boolean isFilled, boolean isOutlined )  // This should provide an idea of what is needed in the final product. The ToolBox class will have these predefined as we will wait till we work on the real project to add the options menu to actually changes things.
	{
		Graphics2D tool = (Graphics2D) painting.getGraphics();
		
		int recWidth;
		int recHeight;
		int temp;
		
		if (inX > startX)
		{
			recWidth = inX - startX; 
		}
		else // need to do a switch
		{
			temp = inX;
			recWidth = startX - inX;
			startX = temp;
		}
		
		if (inY > startY)
		{
			recHeight = inY - startY; 
		}
		else // need to do a switch
		{
			temp = inY;
			recHeight = startY - inY;
			startY = temp;
		}
		
		// draw the thing.
		tool.setColor(Color.BLUE);
		tool.fillOval(startX, startY, recWidth, recHeight);
		
		
		
		// End here, because since we are changing things to painting with it graphics2D object, and painting is an object itself, than we are passing everything important by reference, so no data to return.
	}
}
