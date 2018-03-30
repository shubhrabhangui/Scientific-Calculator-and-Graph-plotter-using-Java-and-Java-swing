package calc_v0;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.border.LineBorder;

// This class works when ERASE button is pressed
// This clears the graph panel to original state 

public class eraseGraph {
	Graphics g;
	

	public eraseGraph(Graphics g) {
		// Constructor of eraseGraph
		this.g = g;
		// Call the function to erase the graphs and redraw the graph panel 
		erase();
	}
    
	// Function to clear the graphs plotted and create the graph panel again
	private void erase() {
	    // To clear the graphs plotted 
		g.clearRect(0,0,800,800);
		
		//Create basic graph panel with x and y axis
		GraphPanel gp= new GraphPanel();
		gp.paintComponent(g);
		
		
	}
	

}

