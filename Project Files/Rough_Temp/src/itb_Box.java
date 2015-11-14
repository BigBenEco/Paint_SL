import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class itb_Box {

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
		/*now you us the tool to draw with, then you send into painting with the setGraphics() method.
		* Note, I am not sure getting the Graphics2D object includes what ever is already been painted.
		* but considering that everything so far has been passed by reference, and that its the raster
		* that is passed by valued directly to the data handling, I think it will work just fine.
		*/
		
		// Code Here
		
		//float dash1[] = {10.0f};
		//BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
		//tool.setStroke(dashed);
		//tool.draw(new RoundRectangle2D.Double(x, y, rectWidth, rectHeight, 10, 10));
		
		//make sizing parameters
		int recWidth = inX - startX; 
		int recHeight = inY - startY;
		// draw the thing.
		//tool.drawRect(startX, startY, recWidth, recHeight);
		
		// End here, because since we are changing things to painting with it graphics2D object, and painting is an object itself, than we are passing everything important by reference, so no data to return.
	}
	
	public void finalize( BufferedImage painting, int inX, int inY,  int outlineThickness, Color cFill, Color cOutline, boolean isFilled, boolean isOutlined )  // This should provide an idea of what is needed in the final product. The ToolBox class will have these predefined as we will wait till we work on the real project to add the options menu to actually changes things.
	{
		Graphics2D tool = (Graphics2D) painting.getGraphics();
		/*now you use "tool" to draw with, then you send into painting with the setGraphics() method.
		* Note, I am not sure getting the Graphics2D object includes what ever is already been painted.
		* but considering that everything so far has been passed by reference, and that its the raster
		* that is passed by valued directly in the final image saving methods higher up, I think it will work just fine.
		*/
		
		// Code Here
		
		//make sizing parameters
		int recWidth = inX - startX; 
		int recHeight = inY - startY;
		// draw the thing.
		tool.setBackground( Color.RED );
		tool.setColor(Color.BLUE);
		tool.drawRect(startX, startY, recWidth, recHeight);
		
		
		
		// End here, because since we are changing things to painting with it graphics2D object, and painting is an object itself, than we are passing everything important by reference, so no data to return.
	}
}
