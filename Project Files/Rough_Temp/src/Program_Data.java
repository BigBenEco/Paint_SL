import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Program_Data {

	public gui_WindowLayout programWindow;
	
	public int width;
	public int height;

	public data_ImageBuffer imageBuffer;
	public BufferedImage currentPainting = null;
	
	Program_Data()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	width = (int) screenSize.getWidth();
    	height = (int) screenSize.getHeight();
    	
    	imageBuffer = new data_ImageBuffer(5); //thats all that's needed to be noticeable for the score of the undo feature.
    	
 	}
	
	public void buildGUI()
	{
		programWindow = new gui_WindowLayout(width, height);
		currentPainting = new BufferedImage(programWindow.canvas.width,programWindow.canvas.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)currentPainting.getGraphics();
		g2.setColor( Color.LIGHT_GRAY );
    	g2.fillRect(0, 0, width, height);
	}
	
	public void run()
	{
		programWindow.run();
	}
	
	public void log(BufferedImage newFrame)
	{
		imageBuffer.push(currentPainting); //currently I do not think this will work, I think it is passing by reference, but I want to pass by value, so I need to some how generate new images, but I don't see any method to get the raw images, so maybe this will work, but it gives you the idea atleast.
		currentPainting = newFrame; //changes out the object and it's data.
	}
	
	public BufferedImage painting()
	{
		//BufferedImage cool; this may be of some use to me as this is were I am going to no
	     //Graphics2D painting = (Graphics2D)getGraphics();
		BufferedImage painting = new BufferedImage(programWindow.canvas.width,programWindow.canvas.height, BufferedImage.TYPE_INT_RGB);
		painting.createGraphics();
		//painting.setData( currentPainting.getData() );  //this is the pass by value that I am hoping makes a copy of the current image so that it is safe to mess with in the canvas class.
		Graphics2D g2 = (Graphics2D)painting.getGraphics();
		g2.drawImage(currentPainting, 0, 0, null);
		return painting;
	}
	
	public void undo()
	{
		try
		{
			currentPainting = imageBuffer.pop();
		}
		catch(CanNotUndoException e)
		{
			//no worries, we will just not change the current painting.
		}
		finally
		{
			programWindow.canvas.refresh();
		}
	}
}
