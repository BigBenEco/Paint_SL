import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class gui_Canvas extends JPanel
{
	
	public int wWidth, wHeight, width, height;
	public Tool_Box toolBox = new Tool_Box();
	private BufferedImage painting;
	
	gui_Canvas( int wWidth, int wHeight)
	{
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		width = wWidth;
		height = wHeight;
		
		setBackground(Color.WHITE);
		addMouseListener(new MouseComp());
		addMouseMotionListener( new MouseTracker() );
		setPreferredSize(new Dimension(wWidth, wHeight));
		
	}
	
	public void clear()
 	{
		/*
 	    repaint();
 	    Graphics2D painting = (Graphics2D)getGraphics();  //goes through the logging process so that it can be part of the undo to.
 	    Driver.global.imageBuffer.push(painting);
	    paintComponent(painting);
	    
	    //*/
		
		Graphics2D g2 = (Graphics2D)getGraphics();
		painting = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//painting =  Driver.global.painting() ; // gets a safe copy 
    	super.paintComponent(g2);
    	Graphics2D gg = (Graphics2D) painting.getGraphics();
    	gg.setColor( Color.white );
    	gg.fillRect(0, 0, width, height);
    	// g2.drawImage(painting, 0, 1, null); // i think the two need to 
    	
    	Driver.global.log(painting);
    	
    	paint();
		
 	  }
    public void paint()
    {  
    	Graphics2D g2 = (Graphics2D)getGraphics();
    	super.paintComponent(g2);
    	g2.drawImage(painting, 0, 0, null);
    }
    
    public void refresh()
    {
        painting =  Driver.global.painting() ; // gets a safe copy 
	    Graphics2D g2 = (Graphics2D)getGraphics();
	    super.paintComponent(g2);
        g2.drawImage(painting, 0, 0, null);
    }
    
    public class MouseComp implements MouseListener
    {
            public void mouseExited(MouseEvent evt){}
	    public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}    
            public void mousePressed(MouseEvent e) {
                int startX = e.getX();
                int startY = e.getY();
                toolBox.onMouseDown(startX, startY);
            }
	   
              public void mouseReleased(MouseEvent e) {
                int endX = e.getX();
                int endY = e.getY();

                painting =  Driver.global.painting() ; // gets a safe copy 
                Graphics2D g2 = (Graphics2D)getGraphics();

                toolBox.onMouseRelease(painting, endX, endY);  // pass by reference so it will alter painting and wo do not need to wory about passing values.

                paint(); //paints what things look like.

                Driver.global.log(painting);
                //paint();//displays what is going on

              } 
   
    }
    public class MouseTracker implements MouseMotionListener
    {
    	
          
         public void mouseMoved(MouseEvent e) {
             
                painting =  Driver.global.painting() ; // gets a safe copy 
                Graphics2D g2 = (Graphics2D)painting.getGraphics();
    	      
    	     //toolBox.hold(painting, curX, curY);  // pass by reference so it will alter painting and wo do not need to wory about passing values.
    	     //g2.setColor(Color.BLACK);
    	     //g2.drawLine(0, 0, curX, curY);
    	      
    	     //paint(); //paints what things look like.
        	 
         }
          
         public void mouseDragged(MouseEvent e) {
        	 int curX = e.getX();
                int curY = e.getY();
    	     
                painting =  Driver.global.painting() ; // gets a safe copy 
                toolBox.onMouseHold(painting, curX, curY);  // pass by reference so it will alter painting and wo do not need to wory about passing values.


                paint(); //paints what things look like.
         }
    }
    
}
