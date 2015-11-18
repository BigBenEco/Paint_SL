import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui_ToolBarLayout extends JPanel {
	
	gui_Canvas canvas;
	ButtonListener ear;
	JCheckBox fill;

	gui_ToolBarLayout ( gui_Canvas canvus)
	{
		this.canvas = canvus;
		ear = new ButtonListener();
		
		setLayout( new BorderLayout( 5, 5 ) ); // 5 pixel gaps
		
		JButton box = new JButton("Box");
		JButton oval = new JButton("Oval");
		JButton line = new JButton("Line");
		
		JButton boxf = new JButton("Box Fill");
		JButton ovalf = new JButton("Oval Fill");

		
		JButton undo = new JButton("Undo");
	    JButton clear = new JButton("Clear");
	    
	    box.addActionListener(ear);
	    oval.addActionListener(ear);
	    
	    boxf.addActionListener(ear);
	    ovalf.addActionListener(ear);
	    
	    line.addActionListener(ear);
	    undo.addActionListener(ear);
	    clear.addActionListener(ear);
	    
	    setLayout(new GridLayout(7, 1));
	    
	    setBackground(Color.darkGray);
		add(box);
		add(boxf);
		add(oval);
		add(ovalf);
		add(line);
		
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
	       else if(command.equals("Oval"))
	       {
	    	   canvas.toolBox.myTool = Tool_Box.tool.Oval;
	       }
	       else if(command.equals("Line"))
	       {
	    	   canvas.toolBox.myTool = Tool_Box.tool.Line;
	    	   
	       }
	       else if(command.equals("Box Fill"))
	       {
	    	   canvas.toolBox.myTool = Tool_Box.tool.BoxF;
	       }
	       else if(command.equals("Oval Fill"))
	       {
	    	   canvas.toolBox.myTool = Tool_Box.tool.OvalF;
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
