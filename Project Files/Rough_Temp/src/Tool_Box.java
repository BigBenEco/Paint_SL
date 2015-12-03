import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Tool_Box {
	

	public boolean doingWork = false; // used to now if when the mouse is moving if we need to do something.
	
        public itb_GenericShape genericTool  = new itb_GenericShape( itb_GenericShape.T_TYPES.BOX, Color.BLUE, Color.RED); // the actual tools
	
	// Drawing Parameters, will be adjustable, but for now these will be fixed to these default values.
	public int outlineThickness = 6;
	public Color cOutline = new Color(0, 0, 0);
	public Color cFilling = new Color(255, 0, 0);
	public boolean isOutlined = true;
	public void changeTool (itb_GenericShape.T_TYPES newTool) { /*This foo changes the tool to be used.*/
            genericTool.setTool(newTool);
	}

	public void onMouseDown (int startX, int startY) {
		doingWork = true;
		genericTool.firstMouseDwnPos(startX, startY);
	}
	
	public void onMouseHold (BufferedImage painting, int endX, int endY) {
		doingWork = true;
		
		genericTool.drawBounds(painting, endX, endY, outlineThickness);
	}
	
	public void onMouseRelease (BufferedImage painting, int endX, int endY) {
		doingWork = true;
		genericTool.drawBounds(painting, endX, endY, outlineThickness);
		
        }
	
}
