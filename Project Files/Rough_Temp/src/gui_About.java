import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Toolkit;

public class gui_About extends JFrame {
	
	public Container contents;
	public AboutPage Me;
	public BufferedImage img;
	public int myWidth = 640;
	public int myHeight = 480;
	
	gui_About()
	{
		super("About");
		contents = getContentPane();
		
		Me = new AboutPage();
		
		try {
		    img = ImageIO.read(new File("oval 64.png"));
		} catch (IOException e) {
		}
		
		contents.add(Me);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screenSize.getWidth();
        int hScreen = (int) screenSize.getHeight();
		int myX = ( wScreen / 2 ) - ( myWidth / 2 );
		int myY = ( hScreen / 2 ) - ( myHeight / 2 );
	
		setLocation(myX, myY);
		setSize(myWidth, myHeight);
	}
	
	public class AboutPage extends JPanel{		
		protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(img, 0, 0, null);
	    }
	
	}
}
