import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui_ToolBarLayout extends JPanel {
	
	gui_Canvas canvas;

	gui_ToolBarLayout ( gui_Canvas canvus)
	{
		this.canvas = canvus;
		
		setLayout( new BorderLayout( 5, 5 ) ); // 5 pixel gaps
		
		JButton box = new JButton("Box");
		JButton undo = new JButton("Undo");
	    JButton clear = new JButton("Clear");
	    
	    box.addActionListener(new ButtonListener());
	    undo.addActionListener(new ButtonListener());
	    clear.addActionListener(new ButtonListener());
	    
	    setLayout(new GridLayout(7, 1));
	    
	    setBackground(Color.RED);
		add(box);
		add(undo);
		add(clear);
		
		setPreferredSize(new Dimension(450, 50));
	    
        setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(
                                                1,1,2,2,Color.black),
                                BorderFactory.createEmptyBorder(5,5,5,5)));//*/
	    
	}
	
	private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent ae)
	   {
		   //need oval and line as well as a means to toggle fill.
	       String command = ae.getActionCommand();
	       if(command.equals("Box"))
	       {
	    	   canvas.toolBox.myTool = Tool_Box.tool.Box;
	       }
	       else if(command.equals("Undo"))
	       {
	    	   Driver.global.undo();
	    	   //canvas.toolBox.myTool = Tool_Box.tool.Mouse;
	       }
	       else if(command.equals("Clear"))
	       {
	    	   //canvas.toolBox.myTool = Tool_Box.tool.Mouse;
	    	   canvas.clear();
	       }
	   }
	 }
}
