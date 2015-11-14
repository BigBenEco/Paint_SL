
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class gui_WindowLayout extends JFrame 
{

	public Container contents;
	public gui_Canvas canvas;
	public gui_ToolBarLayout toolBar;
	

	
	
    gui_WindowLayout ( int width, int height)
    {
    	super("Paint SL");
        setSize(width, height);
        
        contents = getContentPane();
        //addMouseMotionListener(new MouseTracker());
      
        canvas = new gui_Canvas(width, height);
        toolBar = new gui_ToolBarLayout(canvas);
    	
    	contents.add(canvas, BorderLayout.CENTER);
    	contents.add(toolBar, BorderLayout.WEST);
    	//canvas.setLocation(0, 0);
    }

    public void run()
    {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setVisible( true );
    	
    }
    
    public class MouseComp implements MouseListener
	{
	   public void mouseClicked(MouseEvent e) {}
       public void mouseEntered(MouseEvent e) {}    
       public void mousePressed(MouseEvent e) 
       {
          System.out.println("mouse at "+e.getX()+" and "+e.getY() );
	   }
	   
       public void mouseReleased(MouseEvent e){} 
       public void mouseExited(MouseEvent evt){}
       
       
       
	} 
    
    public class MouseTracker implements MouseMotionListener
    {
    	
          
         public void mouseMoved(MouseEvent e) {
             if(e.getX() < 20){System.out.println("mouse at "+e.getX()+" and "+e.getY() ); toolBar.setSize(29, 29); toolBar.repaint(); }
             else{toolBar.setSize(293, 293); toolBar.repaint();}
         }
          
         public void mouseDragged(MouseEvent e) {
             
         }
    }
}
