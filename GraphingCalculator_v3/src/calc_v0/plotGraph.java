package calc_v0;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.border.StrokeBorder;

//import equation_value.y_values;

/*Class to Plot the graphs 
 * Proper scaling of x and y axis done here 
 * The values of x and y for the equation are saved in arrays and plotted */

public class plotGraph {
	
	// Expression to be plotted 
	protected String expression;
	Graphics g;
	// x and y range entered 
	protected int xrange;
	protected int yrange;
	
	// origin=(400,400)
	protected int x_origin=400;
	protected int y_origin=400;
	
	// After scaling according to range mentioned 
	protected double x_scale;
	protected double y_scale;
	
	// Array list 
	// X and y values to be plotted to be stored here 
	protected static ArrayList<Integer> x_array= new ArrayList<Integer>();
	protected static ArrayList<Integer> y_array= new ArrayList<Integer>();
	
	
    // Constructor 
	public plotGraph(String expression,Graphics g, int xrange, int yrange) {
		
		this.expression= expression;
		this.g=g;
		this.xrange=xrange;
		this.yrange=yrange;
		
		// scale is the total width divided by the range value 
		x_scale= 800/(2*xrange);
		y_scale= 800/(2*yrange);
		
		// plot() function is called 
		plot();
		
	}

	private void plot() {
		
		// Function to get the x and corresponding y coordinates 
		Get_x_y_coordinates(xrange);
		
		// plot the graph by using the values of coordinates obtained by using Get_x_y_coordinates 
	     plot_graph();
	    
		
		
	}
	
	// Function to plot the graph by using all the x and y values obtained 
	private void plot_graph() {
		// To plot the graph by using the arrays 
		
		// Get a better line stroke while plotting graph
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3) );
		
		// Draw line connecting all x and y values obtained 
		for(int i=0;i<x_array.size()-1;i++)
		{
			g2.drawLine(x_array.get(i), y_array.get(i), x_array.get(i+1), y_array.get(i+1));
		}
	// Remove all elements of x and y array after plotting 
	 x_array.clear();
	 y_array.clear();
	}

	// Function to get x and y coordinates 
	private void Get_x_y_coordinates(int xrange) {
		
		// For the range entered 
		for(double x = -xrange; x <= xrange; x=x+0.2)
		{   
			
			String value1= expression;
			double y_result;
			
			// Calling functions to get value of y for each x in the for loop 
			// The plotGraph class uses get_y() method of y_values class to get this value
			y_values y = new y_values(value1,x);
			y_result=y.get_y();
			
			
			// Set the color of graph to the selected color 
			g.setColor(equation_handler.color_selected);
			
			// Add values to the x and y array 
			x_array.add((int)(x_origin+x*x_scale));
			y_array.add((int)(y_origin-y_result*y_scale));
			
			
		}
		
		
		
	}

	

}
