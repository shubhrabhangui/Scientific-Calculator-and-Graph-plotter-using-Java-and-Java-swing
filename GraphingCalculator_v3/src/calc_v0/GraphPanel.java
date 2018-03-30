package calc_v0;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/* This class is for drawing the basic graph panel 
   This draws the basic components in the graph panel 
   Draws X axis, Y axis
   Marks (0,0)
   Labels X axis, Y axis and (0,0)
*/ 
class GraphPanel extends JPanel {
    
    protected int x_range,y_range;
    
    // Constructor 
    public GraphPanel()
    {
    	x_range=equation_handler.xrange;
    	y_range=equation_handler.yrange;
    
    }
    
    // Overriding the paint component 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Panel is of width 800 and height 800 
        
     	
        //Draw the gray background for panel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 800, 800);
        
      // Draw the borders 
       g.setColor(Color.black);
       g.drawLine(0,0,0,799);
       g.drawLine(0,0,799,0);
       g.drawLine(799,0,799,799);
       g.drawLine(0,799,799,799);
      
        
       // Draw X-axis 
        g.setColor(Color.black);
        g.drawLine(0, 400, 800,400);
       
       // Draw Y- axis  
        g.drawLine(400, 0, 400, 800);
       
        // Mark (0,0), X axis and Y axis
        g.drawString("Y axis", 408, 12);
        g.drawString("X axis", 12, 412);
        g.drawString("(0,0)", 408, 412);
        Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(2) );
	    g2.setColor(Color.BLUE);
        g.drawOval(400, 400, 2, 2);
        
       
        
         
    }
    
}

