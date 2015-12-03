
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class itb_GenericShape { 
	/*This class is just to replace the itb's... I feel like their functionality could be simpler.
	 * Instead of six different classes for different shapes which all do the same thing I think 
	 * this one class could do basically all of that for all of the shapes.
	 * */
	private int point1X, point1Y; //used for saving one corner of the box
        
        private static JCheckBox localFillBox; //Local reference for the fill box
	
        public enum T_TYPES { LINE, BOX, BOXFILL, OVAL, OVALFILL }; //ENUM for the tool types. These let us know what tool to draw with.
        
	public T_TYPES toolType; //An object to hold the type of tool.
	private Color toolColor;
        private Color outlineColor;
        private boolean fillState = false;
	
        private void setState (boolean newState)
        {
            /*Sets the tool based on the state passed to it.*/
            if(this.toolType == T_TYPES.BOX && newState == true ) {
                toolType = T_TYPES.BOXFILL;
            } else if(this.toolType == T_TYPES.OVAL&& newState == true ) {
                toolType = T_TYPES.OVALFILL;
            } else { //If not to be filled OR is a LINE, we can set the tool directly
                this.fillState = newState;
              }
        }
        
	public itb_GenericShape (T_TYPES type, Color newColor, Color outlineColor) {
		this.toolType = type;
		this.toolColor = newColor;
                this.outlineColor = outlineColor;
		
	}
	public void firstMouseDwnPos(int x, int y) {   
            /*This foo tells the program where the first mouse down was. 
            These values will be used to draw the object. 
            */
		this.point1X = x;
		this.point1Y = y;
	}
	
	public void setColor (Color newColor) {
		this.toolColor = newColor;
	}
        public void setOutlineColor (Color newColor) {
		this.outlineColor = newColor;
	}
	public void setTool (T_TYPES newType) {
              this.toolType = newType;
  
	}
	
	
	public void drawBounds(  BufferedImage painting, int currentX, int currentY,  int outlineThickness) //A special function used when the mouse is being dragged to give a representation of the box
	{
		Graphics2D tool = (Graphics2D) painting.getGraphics();
               
                localFillBox = Driver.global.programWindow.toolBar.fill;
                
		int recWidth = 0;
		int recHeight = 0;
		int tempX = 0;
		int tempY = 0;
                
		this.setState(localFillBox.isSelected());
                
		if (currentX > point1X)
		{
			recWidth = currentX - point1X; 
			tempX = point1X;
		}
		else // need to do a switch
		{
			tempX = currentX;
			recWidth = point1X - currentX;
		}
		
		if (currentY > point1Y)
		{
			recHeight = currentY - point1Y; 
			tempY = point1Y;
		}
		else // need to do a switch
		{
			tempY = currentY;
			recHeight = point1Y - currentY;
                }
                
		tool.setColor(this.toolColor);
                
                switch(this.toolType) {
		
                    case LINE:
                            tool.drawLine(point1X, point1Y, currentX, currentY);
                            break;
                    case BOX:
                            tool.drawRect(tempX, tempY, recWidth, recHeight);
                            break;
                    case OVAL:
                            tool.drawOval(tempX, tempY, recWidth, recHeight);
                            break;
                    case BOXFILL:
                            tool.setColor(this.outlineColor); //Set the color TEMPORARILY to create a border!

                            tool.fillRect(tempX, tempY, recWidth, recHeight); //Draw the border shape!
                            tool.setColor(this.toolColor); //Set the inside color to draw over the top of the corder

                            tool.fillRect (tempX + outlineThickness,tempY + outlineThickness,
                                     recWidth - (outlineThickness * 2), recHeight - (outlineThickness * 2) );//FILL the INSIDE shape!
                            break;
                    case OVALFILL:
                            tool.setColor(this.outlineColor);

                            tool.fillOval(tempX, tempY, recWidth, recHeight); 

                            tool.setColor(this.toolColor);

                            tool.fillOval(tempX + outlineThickness,tempY + outlineThickness,
                                    recWidth - (outlineThickness * 2), recHeight - (outlineThickness * 2) );
                            break;

                            default: 

                                    System.out.println("NO SUCH TOOL EXISTS!");	

                            break;
			
		}
		
		
	}
	
}
