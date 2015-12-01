
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class gui_WindowLayout extends JFrame implements ActionListener
{
	public gui_WindowLayout current;

	public Container contents;
	public gui_Canvas canvas;
	public gui_ToolBarLayout toolBar;
	
	public JMenuBar menuBar;
	public JMenu menu, submenu;
	public JMenuItem menuItem;
	public JCheckBoxMenuItem cbMenuItem;
	
	
	
	
    gui_WindowLayout ( int width, int height)
    {
    	super("Paint SL");
        setSize( width, height);
        
        contents = getContentPane();
        //addMouseMotionListener(new MouseTracker());
        
     // The two main panels.
        canvas = new gui_Canvas(width, height);
        toolBar = new gui_ToolBarLayout(canvas);
        
     // The menu bar
        menuBar = new JMenuBar();
        
     // First Menu Option: File
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        
     // Adds an item to the current menu
        menuItem = new JMenuItem("Nope");
		menu.add(menuItem);
       
        
     // Second Menu Option: Edit, we will reuse the menu object to make a new object.
        menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menu);
        
     // Adds an item to the current menu, we will reuse the menuItem object to make a new object.
        menuItem = new JMenuItem("Undo");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		menu.add(menuItem);
		
     // Adds an item to the current menu, we will reuse the menuItem object to make a new object.
        menuItem = new JMenuItem("Clear");
        menuItem.addActionListener(this);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        		(char) KeyEvent.VK_DELETE));
		menu.add(menuItem);
		
     // Third Menu Option: Choices
        menu = new JMenu("Choices");
        menu.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menu);
     
     // Adds an submenu as if an item   
        submenu = new JMenu("Draw Tools");
        submenu.setMnemonic(KeyEvent.VK_T);
        
     // Adds an item to the current menu
        menuItem = new JMenuItem("Box Tool", new ImageIcon("box 16.png") );
        menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Oval Tool", new ImageIcon("oval 16.png") );
        menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Line Tool", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Fill Tool NOT", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Free Hand", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Text Tool", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		menu.add(submenu);
		menu.addSeparator();
		
	 // Adds an submenu as if an item   
        submenu = new JMenu("Paint Style");
        submenu.setMnemonic(KeyEvent.VK_T);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Fill Select", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Stroke Select", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("Stroke alter", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		submenu.add(menuItem);
		
		menu.add(submenu);
		menu.addSeparator();
		
		
		 // Adds an item to the current menu
        menuItem = new JMenuItem("9", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		
	 
     // Final Forth Menu Option: Help
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menu);
        
        
     // Adds an item to the current menu
        menuItem = new JMenuItem("About", KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		
		
		/*
		menuItem = new JMenuItem("Both text and icon",
		                new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);
		
		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);*/
    	
		setJMenuBar(menuBar);
    	contents.add(canvas, BorderLayout.CENTER);
    	contents.add(toolBar, BorderLayout.WEST);
    	//canvas.setLocation(0, 0);
    }
    
    public gui_WindowLayout getInstance( int width, int height)
    {
    	if( current == null )
    	{
    		current = new gui_WindowLayout( width, height);
    	}
    	return current;
    }

    public void run()
    {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    	@Override
         public void mouseMoved(MouseEvent e) {
             if(e.getX() < 20){System.out.println("mouse at "+e.getX()+" and "+e.getY() ); toolBar.setSize(29, 29); toolBar.repaint(); }
             else{toolBar.setSize(293, 293); toolBar.repaint();}
         }
          
         @Override
         public void mouseDragged(MouseEvent e) {
             
         }
    }

    
    
		
		public void actionPerformed(ActionEvent e) {
			
			
			JMenuItem source = (JMenuItem)(e.getSource());
	        String command = source.getText();
	                   
			 //System.out.println( "hello: "+command);
		       if(command.equals("Box Tool"))
		       {
		    	   canvas.toolBox.myTool = Tool_Box.tool.Box;
		       }
		       else if(command.equals("Oval Tool"))
		       {
		    	   canvas.toolBox.myTool = Tool_Box.tool.Oval;
		       }
		       else if(command.equals("Line Tool"))
		       {
		    	   canvas.toolBox.myTool = Tool_Box.tool.Line;
		    	   
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
