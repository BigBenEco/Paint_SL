import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.image.Image;

public class gui_ToolBarLayout extends JPanel {

	public gui_Canvas canvas;
	ButtonListener ear;
	public JCheckBox fill;
	
	public JColorChooser picker_f;
	public JColorChooser picker_o;
	public JSlider strokeSizer;
	public CCA filler_changer;
	public CCB outline_changer;
	public CCC stroke_reader;
	

	gui_ToolBarLayout ( gui_Canvas canvus)
	{
		this.canvas = canvus;
		filler_changer = new CCA();
		outline_changer = new CCB();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setBackground(Color.darkGray);
		setBorder(BorderFactory.createMatteBorder( 4, 4, 4, 4, Color.lightGray));
		
		ear = new ButtonListener();   //Create a wrapper class object ButtonListener

		Dimension size = new Dimension(45, 45);

        JLabel topNote = new JLabel("Control Options");
        topNote.setForeground(Color.lightGray);
        topNote.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel control = new JPanel();
        {
        	control.setLayout(new BoxLayout(control, BoxLayout.PAGE_AXIS));
	        //tools.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        	control.setBackground(Color.darkGray);
	        
        	JButton undo = new JButton("Undo");
    		undo.setMaximumSize( new Dimension (Short.MAX_VALUE, 50));
    		undo.addActionListener(ear);
    		
            JButton clear = new JButton("Clear");
            clear.setMaximumSize( new Dimension (Short.MAX_VALUE, 50));
            clear.addActionListener(ear);
            
            control.add(clear);
            control.add(Box.createRigidArea(new Dimension(5,5)));
            control.add(undo);
            
            //control.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        }

        
        JLabel midNote = new JLabel("Tools");
        midNote.setForeground(Color.lightGray);
        midNote.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel tools = new JPanel();
        {
	        tools.setLayout(new BoxLayout(tools, BoxLayout.LINE_AXIS));
	        tools.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        tools.setBackground(Color.darkGray);
	        
	        
	        
	        Icon img_box = new ImageIcon("box 32.png");
			JButton box = new JButton("Box" , img_box); //Create buttons
			box.setMinimumSize(size);
			box.setPreferredSize(size);
			box.setMaximumSize( new Dimension (Short.MAX_VALUE, (int) size.getHeight()));
			box.addActionListener(ear);  //Add action Listeners
			
			Icon img_oval = new ImageIcon("oval 32.png");
			JButton oval = new JButton("Oval", img_oval);
			oval.setMinimumSize(size);
			oval.setPreferredSize(size);
			oval.setMaximumSize( new Dimension (Short.MAX_VALUE, (int) size.getHeight()));
			oval.addActionListener(ear);
			
			Icon img_line = new ImageIcon("line 32.png");
			JButton line = new JButton("Line",img_line);
			line.setMinimumSize(size);
			line.setPreferredSize(size);
			line.setMaximumSize( new Dimension (Short.MAX_VALUE, (int) size.getHeight()));
			line.addActionListener(ear);
			
	        
			tools.add(box);  //Add the menu objects to the JPanel
			tools.add(Box.createRigidArea(new Dimension(5,5)));
			tools.add(oval);
			tools.add(Box.createRigidArea(new Dimension(5,5)));
			tools.add(line);
			//tools.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        }
        
        JLabel endNote = new JLabel("Tool Settings");  
        endNote.setForeground(Color.lightGray);
        endNote.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel options = new JPanel();
        {
        	options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
        	//options.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        	options.setBackground(Color.lightGray);
	        
        	JLabel Note = new JLabel("Coloring");
        	Note.setAlignmentX(CENTER_ALIGNMENT);
        	
        	JPanel buttonz = new JPanel();
        	{
        		buttonz.setLayout(new BoxLayout(buttonz, BoxLayout.LINE_AXIS));
        		//buttonz.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        		buttonz.setBackground(Color.lightGray);
    	        
    	        fill = new JCheckBox("Fill?");
                fill.addActionListener(ear);
                
    			JButton filler = new JButton("Fill"); //Create buttons
    			filler.setMinimumSize(size);
    			filler.setPreferredSize(size);
    			//filler.setMaximumSize( size);
    			filler.addActionListener(ear);  //Add action Listeners
    			
    			JButton stroke = new JButton("Stroke");
    			stroke.setMinimumSize(size);
    			stroke.setPreferredSize(size);
    			//stroke.setMaximumSize( size);
    			stroke.addActionListener(ear);
    			
    			//buttons.add(Box.createHorizontalGlue());
    			buttonz.add(fill);
    			buttonz.add(Box.createRigidArea(new Dimension(5,5)));
    			buttonz.add(filler);
    			buttonz.add(Box.createRigidArea(new Dimension(5,5)));
    			buttonz.add(stroke);
    			
        	}
        	//buttonz.setAlignmentX(LEFT_ALIGNMENT);
        	
        	JLabel slider = new JLabel("Stroke Size");
        	slider.setAlignmentX(CENTER_ALIGNMENT);
            
        	stroke_reader = new CCC();
        	
            strokeSizer = new JSlider(JSlider.HORIZONTAL, 1, 128, 32);
            strokeSizer.addChangeListener(stroke_reader);
            strokeSizer.setSnapToTicks(true);
            strokeSizer.setMajorTickSpacing(32);
            strokeSizer.setMinorTickSpacing(4);
            strokeSizer.setPaintTicks(true);
            strokeSizer.setPaintLabels(true);
            
            options.add(Note);
            options.add(Box.createRigidArea(new Dimension(5,5))); 
            options.add(buttonz);
            options.add(Box.createRigidArea(new Dimension(5,5)));
            options.add(slider);
            options.add(Box.createRigidArea(new Dimension(5,5)));
            options.add(strokeSizer);
        }
        
        add(topNote);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(control);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(midNote);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(tools);
		add(Box.createVerticalGlue());
		add(endNote);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(options); 

        
		

	}

	private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent ae)
	   {
               /*This foo executes when any added button is clicked.
               I need the tool to change from outlined to filled. It has to keep that state using the fill
               checkbox state.
               So it must change the tool and keep it whenever the fill checkbox changes states! --Jake
               */
	       String command = ae.getActionCommand();

	       if(command.equals("Box"))
	       {
                    canvas.toolBox.changeTool(itb_GenericShape.T_TYPES.BOX);

	       }
	       else if(command.equals("Oval"))
	       {
                    canvas.toolBox.changeTool(itb_GenericShape.T_TYPES.OVAL);

	       }
	       else if(command.equals("Line"))
	       {
	    	   canvas.toolBox.changeTool(itb_GenericShape.T_TYPES.LINE);
	       }
	       else if(command.equals("Undo"))
	       {
	    	   Driver.global.undo();
	       }
	       else if(command.equals("Clear"))
               {
	    	   canvas.clear();
	       }
	       else if(command.equals("Fill"))
           {
	    	   JFrame ello = new JFrame("Pick your fill");  // makes a new window, fills it with the color chooser, and tells the color chooser who to tell.
	           picker_f = new JColorChooser();
	    	   ello.add(picker_f);
	    	   ello.setVisible(true);
	    	   ello.pack();
	    	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	           ello.setLocation(50, screenSize.height - 400);
	           picker_f.getSelectionModel().addChangeListener( filler_changer);
	           picker_f.setColor(canvas.toolBox.genericTool.toolColor);
	       }
	       else if(command.equals("Stroke"))
           {
	    	   JFrame elloo = new JFrame("Pick your outline");  // makes a new window, fills it with the color chooser, and tells the color chooser who to tell.
	           picker_o = new JColorChooser();
	    	   elloo.add(picker_o);
	    	   elloo.setVisible(true);
	    	   elloo.pack();
	    	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	           elloo.setLocation(50, screenSize.height - 400);
	           picker_o.getSelectionModel().addChangeListener( outline_changer);
	           picker_o.setColor(canvas.toolBox.genericTool.outlineColor);
           }

             
       }
    }
	
	private class CCA implements ChangeListener
	{

		
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			Color der = picker_f.getColor();
			canvas.toolBox.genericTool.setColor(der);
			//Driver.global.programWindow.toolBar.setBackground(der);
		}
		
	}
	
	private class CCB implements ChangeListener
	{

		
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			canvas.toolBox.genericTool.setOutlineColor( picker_o.getColor() );
		}
		
	}
	
	private class CCC implements ChangeListener
	{

		
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			canvas.toolBox.genericTool.setOutline(strokeSizer.getValue());
		}
		
	}
}
