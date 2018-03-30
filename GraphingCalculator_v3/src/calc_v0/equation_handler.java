package calc_v0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



/* Equation Handler class */
public class equation_handler implements ActionListener{
	
	protected static JPanel graphPanel;
	
    // Values of x and y range entered through the box 
    protected static int xrange;
    protected static int yrange;
    
    // Selected color of graph 
    protected static Color color_selected;
   
    
    /* To keep track of multiple graphs
     * no_of_graphs=0 if we do not have multiple graphs i.e before the first graph is plotted
     * expressions_multigraph stores all the expressions entered till the panel is erased 
     * This array is to take care of multiple graphs and the new ranges 
     * */
    
    protected static int no_of_graphs=0;
    ArrayList<String> expressions_multigraph = new ArrayList<String>();
   
	/* Constructor for equation handler 
	 * Default color is set to black 
	 */
    equation_handler(JPanel graph) {
		this.graphPanel = graph;
		this.color_selected= Color.BLACK;
		
	    
	}
	
	DefaultListModel model = new DefaultListModel();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// Handling each event
		
		//System.out.println("----------------");
		
		/* When PLOT button is clicked
		 * The equation is validated first 
		 * The range of x and y is taken and checked if valid or not 
		 * Equation is added to the history box
		 * If equation is valid then : 
		 * Check if you are plotting the first graph or not
		 * If plotting first graph, the expression is added to the empty array of strings and no of graphs incremented 
		 * If multiple graphs are to be plotted hen new range is to be passed to the earlier expressions */
		if ( event.getActionCommand() == "PLOT" )
		{   

			// Validate the equation and return true only if the expression is valid
			validate_equation v= new validate_equation(GUI.enter_text.getText());
			
			// Get the user entered X and Y range values ( checking for errors too)
			xrange= getrange_x(GUI.xrange_text.getText());
			yrange= getrange_y(GUI.yrange_text.getText());
			
			// If expression is valid 
			if (v.getExpression_check() == true)
			{   
				
				// If the value of X range or y range entered is not equal to zero 
				if(xrange!=0 && yrange!=0)
				{
				  // Add element to the history box 
				  model.addElement("PLOT: y="+GUI.enter_text.getText());
				  GUI.list. setModel(model);
				  
				  // Graph panel graphics 
				 Graphics g = graphPanel.getGraphics();
				  
				  
				  // Plot the first graph 
				  if(no_of_graphs==0)
				  {
					 /*Number of previous graphs =0 
					  * Add the new valid expression to the array of expression strings */
					  expressions_multigraph.add(GUI.enter_text.getText());
					  
					 /* Plot the graph
					  * PlotGraph constructor takes expression, graphics and ranges as input */
					  plotGraph pg= new plotGraph(GUI.enter_text.getText(),g, xrange,yrange);
					  
					  //Number of graphs incremented 
					  no_of_graphs++;
				  }
				  
				  else
				  {   
					 
					  no_of_graphs++;
					 // Panel is cleared, earlier plotted graphs removed 
					  g.clearRect(0,0,800,800);
					  GraphPanel gp= new GraphPanel();
					  gp.paintComponent(g);
					  
					  // Expression is added to the array of expression strings 
					  expressions_multigraph.add(GUI.enter_text.getText());
					  for(int i=0;i<no_of_graphs;i++)
					  {   
						  // All the graphs are plotted for new range values 
						  plotGraph pg= new plotGraph(expressions_multigraph.get(i),g,xrange,yrange);
						 
					  }
					    
				  }
				
				  }
				  
	            /* Error message in case if wrong range is entered
	             */
				else {
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "ERROR: Wrong ranges");
				}
			   
			}
			
			// If equation/ expression is invalid
			else
			{
				// Add to the history box
				model.addElement("PLOT: y="+GUI.enter_text.getText());
				// Give out error
				GUI.enter_text.setText("ERROR");
				GUI.list. setModel(model);
			}
			
			
		}
		
		//If load button is clicked
		if(event.getActionCommand()== "LOAD") {
			try{
			String equation_without_plot="";
		
			//GUI.enter_text.setText(GUI.list.getSelectedValue());
			// In this the selected equation in the history box is loaded back into the equation field without the PLOT: or ERASE: Part 
			String temp= GUI.list.getSelectedValue();
			if(temp.startsWith("P"))
			{
				for(int i=8;i<temp.length();i++)
				{
					equation_without_plot= equation_without_plot+temp.charAt(i);
				}
			}
			else if(temp.startsWith("E"))
			{
			   for(int i=9;i<temp.length();i++)
			  {
				equation_without_plot= equation_without_plot+temp.charAt(i);
			  }
			}
			GUI.enter_text.setText(equation_without_plot);
			}catch(Exception e) {JFrame frame=new JFrame();
			                    JOptionPane.showMessageDialog(frame, "Nothing selected");}	
		}
		
		// If Erase button is clicked
		if(event.getActionCommand()== "ERASE") {
			
			
			
			model.addElement("ERASE: y=" + GUI.enter_text.getText());
			
			// Graph panel erased 
			Graphics g = graphPanel.getGraphics();
			eraseGraph eg = new eraseGraph(g);
			
			/*Number of graphs=0 and the array is expression strings is cleared*/
			no_of_graphs=0;
			expressions_multigraph.clear();
			  
			  
		 }
		
		// If particular color is selected from the box 
		// Updated the color_selected variable 
		// Used to color the plotted graphs 
		if(event.getSource()==GUI.color) {
		if ( GUI.color.getSelectedIndex() == 0)
		{
			//GUI.enter_text.setForeground(Color.BLACK);
			color_selected= Color.BLACK;
		}
		
		
		if ( GUI.color.getSelectedIndex() == 1)
		{
			//GUI.enter_text.setForeground(Color.RED);
			color_selected= Color.RED;
		}
		
		
		if ( GUI.color.getSelectedIndex() == 2)
		{
			//GUI.enter_text.setForeground(Color.GREEN);
			color_selected= Color.GREEN;
		}
		
		if ( GUI.color.getSelectedIndex() == 3)
		{
			//GUI.enter_text.setForeground(Color.BLUE);
			color_selected= Color.BLUE;
		}
		
		}
		
			
		}
	
		

		
	
    
	/*Function to get the range value 
	 * Check if the entered value of range is correct and symmetric or not 
	 * Checks for x values 
	 * Give out error message in case if error is encountered */
	private int getrange_x(String text) {
		// TODO Auto-generated method stub
		String input= text;
		String lower="";
		String upper="";
		//static int range=0;
		if(text.length()<=5|| !text.contains(",")||!text.contains("[")||!text.contains("]"))
		{
			GUI.xrange_text.setText("ERROR");
		}
		
		else 
		{
		int i=2; // ignore bracket and - sign 
		while (input.charAt(i)!=',')
		{
			lower= lower+input.charAt(i);
			i++;
		}
		i++;
		while(input.charAt(i)!=']')
		{
			upper=upper+ input.charAt(i);
			i++;
		}
		if(Integer.parseInt(lower)==Integer.parseInt(upper))
		{   if((Integer.parseInt(upper)>400))
		    {
			  GUI.xrange_text.setText("ERROR: Range exceeded ");
		    }
		    else return Integer.parseInt(upper);
		}
		else if (Integer.parseInt(lower)!=Integer.parseInt(upper))
		{
			GUI.xrange_text.setText("ERROR: SYMMETRIC INPUTS ONLY");
		}
		
		
		else 
		{
			GUI.xrange_text.setText("ERROR");
		}
		}
		 return 0;
	}
    
	/*Function to get the range value 
	 * Check if the entered value of range is correct and symmetric or not 
	 * Checks for  y values
	 * Give out error message in case if error is encountered 
	 * Values above 400 not accepted */
	private int getrange_y(String text) {
		// TODO Auto-generated method stub
		String input= text;
		String lower="";
		String upper="";
		//static int range=0;
		if(text.length()<=5|| !text.contains(",")||!text.contains("[")||!text.contains("]"))
		{
			GUI.yrange_text.setText("ERROR");
		}
		
		else 
		{
		int i=2; // ignore bracket and - sign 
		while (input.charAt(i)!=',')
		{
			lower= lower+input.charAt(i);
			i++;
		}
		i++;
		while(input.charAt(i)!=']')
		{
			upper=upper+ input.charAt(i);
			i++;
		}
		if(Integer.parseInt(lower)==Integer.parseInt(upper))
		{
			if((Integer.parseInt(upper)>400))
		    {
			  GUI.yrange_text.setText("ERROR: Range exceeded ");
		    }
		    else return Integer.parseInt(upper);
		}
		else if (Integer.parseInt(lower)!=Integer.parseInt(upper))
		{
			GUI.yrange_text.setText("ERROR: SYMMETRIC INPUTS ONLY");
		}
		
		
		else 
		{
			GUI.yrange_text.setText("ERROR");
		}
		}
		 return 0;
	}

	
		}
