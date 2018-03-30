package calc_v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

// This class is used to split the string (equation) into various tokens if + sign is encountered and then splitting on x 
// This class returns the value of y after calculations to the plot graph class. This value of y is got from the solve_for_y class.

public class y_values {
	
	
	String equation_string;
	Vector<Integer> number_check= new Vector<Integer>();
	
	protected static String[] token_temp;
	protected static ArrayList<String> token_temp_array=new ArrayList<String>();
	protected static double y_answer;
	protected double x_value;
    
	// Constructor 
	public y_values(String value1, double x) {
		this.x_value=x;
		equation_string= value1;
		
		// The expression is split over signs by calling this function 
		split_over_signs(equation_string);
		
	}
   
	// This function will split the string into various tokens 
	// The tokens will then be passed to other class so as to receive the value of y 
	
	private void split_over_signs(String equation_string) {
		String[] tokens=equation_string.split("\\+");
		Vector<String> token_x= new Vector<String>();
		for(int i=0;i<tokens.length;i++)
		{   token_temp_array.clear();
			//System.out.println("Token after splitting at + is " +tokens[i]);
			
			{     
				  if(tokens[i].toLowerCase().contains("sin")||tokens[i].toLowerCase().contains("cos")||tokens[i].toLowerCase().contains("tan"))
				  {
					  token_temp_array.add(tokens[i]);
					  number_check.add(token_temp_array.size());
				  }
				  // if the equation contains x 
				  else  if(tokens[i].contains("x"))
			       {  
			    	      // if it is just x 
			    	       if(tokens[i].equals("x"))
			    	       {
			    	    	 
			    	    	    //System.out.println(" Just x");
			    	    	    token_temp_array.add("1*");
			    	    	    token_temp_array.add("^1");
			    	    	    number_check.add(token_temp_array.size());
			    	       }
			    	    // Else
				    // Split at x 
			    	        else 
			    	        {
				            token_temp=(tokens[i].split("x"));
				           // System.out.println(" Size of token_temp"+token_temp.length);
				            // Copying into arraylist just to take care of null value at first position due to split if the equation is  x^3 
				            Collections.addAll(token_temp_array, token_temp);
				           for(int p=0;p<token_temp_array.size();p++)
			                {   
				              if(token_temp_array.size()!=1)
				               {
				                 if(token_temp_array.get(p)==(null)||token_temp_array.get(p).equals("") ) 
				                 {
					             // System.out.println(" NULL PRESENT");
					              //token_temp_array.set(p,"1*");
					              token_temp_array.remove(p);
					             }// if closed 
				               }// if closed 
			                }// for closed 
				           number_check.add(token_temp_array.size());
			            }// else closed 
			      }// if closed 
			       
			       // else if it is a constant
			       else
			       {
			    	   token_temp_array.add(tokens[i]);
			    	   number_check.add(token_temp_array.size());
			       }
			      
			     
			  //number_check.add(token_temp_array.size());
			}
			for ( int j=0;j<token_temp_array.size();j++)
			{
			  token_x.add(token_temp_array.get(j));
			 //System.out.println("token_temp_array.get(j)"+token_temp_array.get(j));
			}
			
		}
	
		
		 // After splitting over + and x the tokens are sent to solve_for_y class to get the result ( i.e the sum)
		 // The sum is calculated in solve_for_y class as to to find the y value 
		 // The result is obtained using getSum method of solve_for_y class
		 
		
		 solve_for_y elements= new solve_for_y(token_x, number_check,x_value);
		 y_answer= elements.getSum();
		 // This result of y is sent back to the plotGraph class 
		 // The plotGraph class uses get_y method of y_values class to get this value
	
		
	}
    
	// Function to return the y value 
	public double get_y()
    {
    	return y_answer;
    }

}
