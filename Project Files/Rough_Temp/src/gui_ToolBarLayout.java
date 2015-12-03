import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.scene.image.Image;

public class gui_ToolBarLayout extends JPanel {

	public gui_Canvas canvas;
	ButtonListener ear;
	public JCheckBox fill;

	gui_ToolBarLayout ( gui_Canvas canvus)
	{
		this.canvas = canvus;
		ear = new ButtonListener();   //Create a wrapper class object ButtonListener

		setLayout( new BorderLayout( 5, 5 ) ); // 5 pixel gaps


        fill = new JCheckBox("Fill?");
        
        Icon img_box = new ImageIcon("box 64.png");
		JButton box = new JButton(img_box); //Create buttons
		Icon img_oval = new ImageIcon("oval 64.png");
		JButton oval = new JButton(img_oval);
		JButton line = new JButton("Line");
		JButton undo = new JButton("Undo");
                JButton clear = new JButton("Clear");

                box.addActionListener(ear);  //Add action Listeners
                oval.addActionListener(ear);

                line.addActionListener(ear);
                undo.addActionListener(ear);
                clear.addActionListener(ear);
                fill.addActionListener(ear);


                setLayout(new GridLayout(7, 1));

                setBackground(Color.darkGray);
		this.add(box);  //Add the menu objects to the JPanel
		this.add(oval);
		this.add(line);

		this.add(undo);
		this.add(clear);

		this.add(fill);

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

             
           }
        }
}
