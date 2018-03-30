package calc_v0;

import java.util.Vector;

/*This class finds value of y for particular value of x
 * The array of tokens is one of the inputs to this class's constructor 
 * */
public class solve_for_y {
    Vector<String>token_elements;
    protected double constant= 0;
    protected double y_value;
    protected double sum;
    protected double x_value;
    protected Vector<Integer> number_check;
    
    // Constructor
	public solve_for_y(Vector<String> token_x, Vector<Integer> number_check, double x_value) {
		
		// Values assigned
		this.token_elements= token_x;
		this.number_check=number_check;
		this.x_value= x_value;
		
		// Call the function to get the constant term from the equation (if any)
		get_the_constant();

	}
	
	
	/* Function to get the constant term in the expression if any
	 * If there is no constant term, default value of 0 is assumed */
	
	private void get_the_constant() {
		for(int i=0;i<token_elements.size();i++)
		{ 
			// If its a constant value 
			/*If the term does not contain * or ^ or sin or cos or tan then it is a constant term
			 * Assumption: Just 1 constant present*/
			if (!token_elements.elementAt(i).contains("*")&&!token_elements.elementAt(i).contains("^") && 
			  !token_elements.elementAt(i).toLowerCase().contains("sin") &&
			  !token_elements.elementAt(i).toLowerCase().contains("cos") &&
			  !token_elements.elementAt(i).toLowerCase().contains("tan"))	
		  {   
				/*Constant string is converted into double and saved in constant variable*/
			    constant= Double.parseDouble(token_elements.elementAt(i));
			 
		  }
		}
		
		/*Function called to get the value of y 
		 * Value of constant is passed to the function */
		y_value= find_y_value(constant);
		
	}


    /* This function finds the value of y
     * The input to this function is the constant term of the expression
     * All the terms are added to the constant term after substituting for x in the expression */
	
	private double find_y_value(double constant2) {
		
		sum= constant;
		double multiple= 1;
		double power=1;
		int number_vector_check=0;
		for(int i=0;i<token_elements.size();i++)
		{   
			// If the token contains * and ^ both 
			if(number_check.elementAt(number_vector_check)==2)
			{
			if(token_elements.elementAt(i).contains("*"))
					{
				       multiple= Double.parseDouble(token_elements.elementAt(i).replace("*",""));
				       i++;
				       if(token_elements.elementAt(i).contains("^"))
				       {
				    	    power= Double.parseDouble(token_elements.elementAt(i).replace("^",""));
				       }
				      // System.out.println("The value of multiple is : "+multiple+" and value of power is "+power);
				       number_vector_check++;
				       sum= sum+multiple*Math.pow(x_value,power);
				      // System.out.println("Sum is : "+sum);
					}
			}
			// If token contains only * or only ^ or constant 
			else if(number_check.elementAt(number_vector_check)==1)
				
			{   
				//If its trignometric value 
				if(token_elements.elementAt(i).toLowerCase().contains("sin") ||
				  token_elements.elementAt(i).toLowerCase().contains("cos") ||
				  token_elements.elementAt(i).toLowerCase().contains("tan"))
				{
					double get_trignometric_value= Trigonometry_value(token_elements.elementAt(i));
				}
				
				// If it contains *
				else if(token_elements.elementAt(i).contains("*"))
				{
				  multiple= Double.parseDouble(token_elements.elementAt(i).replace("*",""));
				  power=1;
				  sum= sum+multiple*Math.pow(x_value,power);
			     // System.out.println("Sum is : "+sum);
				}
				
				// If it contains ^ 
				else if(token_elements.elementAt(i).contains("^"))
				{
					power= Double.parseDouble(token_elements.elementAt(i).replace("^",""));
					multiple=1;
					sum= sum+multiple*Math.pow(x_value,power);
				   // System.out.println("Sum is : "+sum);
				}
				
				// If its a constant 
				number_vector_check++;
				
			}
			
					
			
			
		}
		return sum;
	}
	
	
	
	
	
	
	
	//Function  to get value of trigonometric functions 
		private double Trigonometry_value(String trignometric_string) {
			// TODO Auto-generated method stub
		 //System.out.println("Contains trigonometric value");	
		// If it contains Sin
		//	if(trignometric_string.toLowerCase().contains("sin"))
			{ //---*----------------------------*------------------------*-----------------*-  
				//System.out.println("Contains Sin");	
				double multiple_outer=1;
				double multiple_inner=1;
				double power_inner=1;
				String power="";
				String multiple_i="";
				String multiple_o="";
				
				// if no outer multiply 
				//------------------------------------------------------------------------- Sin(2*x^2)
				if(trignometric_string.startsWith("s")||trignometric_string.startsWith("S") ||
						trignometric_string.startsWith("c")||trignometric_string.startsWith("C")||
						trignometric_string.startsWith("t")||trignometric_string.startsWith("T"))
				
				{   
					// System.out.println("No outer multiply");
					 // No outer multiply or inner multiply ------- Sin(x)
					 if(trignometric_string.charAt(4)=='x')
					    {   
						    // if there is inner power ----- Sin(x^2) 
						    if(trignometric_string.charAt(5)=='^')
						    {   
							   // System.out.println("Inner Power");
							    int s=6;
							    while(trignometric_string.charAt(s)!=')')
							    {
								   power= power+trignometric_string.charAt(s);
								    s++;
							    }
							    power_inner=Double.parseDouble(power);
							  //  System.out.println("Inner_power is"+power_inner);
						    }// if closed 
						
					     } // if closed
					 
					    // no outer multiply but there is inner multiply -----Sin(2*x) / Sin(2*x^2)
					    else
					    {   
						   // System.out.println("No outer multiply but inner multiply present ");
						    int s=4;
						    String temp_sum="";
						    if(!trignometric_string.contains("*")) {
						    	  while(trignometric_string.charAt(s)!=')')
						    	  {
						    		  temp_sum=temp_sum+trignometric_string.charAt(s);
						    		  s++;
						    	  }
						    	  double temp= Double.parseDouble(temp_sum);
						    	  
						    	  if(trignometric_string.toLowerCase().contains("sin"))
									{
									sum= multiple_outer*Math.sin(Math.toRadians(temp));
									return sum;
									}
									else if (trignometric_string.toLowerCase().contains("cos"))
									{
									sum= multiple_outer*Math.cos(Math.toRadians(temp));
									return sum;
									}
									else if(trignometric_string.toLowerCase().contains("tan"))
									{
									sum= multiple_outer*Math.tan(Math.toRadians(temp));
									return sum;
									}
						    }
						    else
						    {
						    while (trignometric_string.charAt(s)!='*')
						    {
							   multiple_i=multiple_i+trignometric_string.charAt(s);
							    s++;
						    }
						    multiple_inner=Double.parseDouble(multiple_i);
						   // System.out.println("Inner multiplier is "+multiple_inner);
						    //x value
						    s=s+2;
						   // System.out.println("---The char at s is = "+trignometric_string.charAt(s));
						    if(trignometric_string.charAt(s)=='^')
						    {
							    s++;
							    while(trignometric_string.charAt(s)!=')')
							    {
								    power= power+trignometric_string.charAt(s);
								    s++;
							    }
							    power_inner=Double.parseDouble(power);
							    //System.out.println("Inner power is "+power_inner);
						    }
						    }
						  
						  
						 }// else closed 
				  }// outer if closed -- if 1st char is Sin 
				
				// There is outer multiply too
				//----------------------------------------------------------------------
				else
				  {   
					 // System.out.println("There is outer multiply");
					  int s=0; 
					  while (trignometric_string.charAt(s)!='*')
					    {
						   multiple_o=multiple_o+trignometric_string.charAt(s);
						    s++;
					    }
					    multiple_outer=Double.parseDouble(multiple_o);
					    s=s+5;
					    // Inside the Sin function 
					    if(trignometric_string.charAt(s)=='x')
					    {   
						    s++;
						    // if there is inner power ----- Sin(x^2) 
						    if(trignometric_string.charAt(s)=='^')
						    {
							    s++;
							    while(trignometric_string.charAt(s)!=')')
							    {
								    power= power+trignometric_string.charAt(s);
								    s++;
							    }
							    power_inner=Double.parseDouble(power);
						    }
						
					     }
					    //there is inner multiply -----2*Sin(2*x) / 2*Sin(2*x^2)
					    else
					    {
						  
						    while (trignometric_string.charAt(s)!='*')
						    {
							   multiple_i=multiple_i+trignometric_string.charAt(s);
							   s++;
						    }
						    multiple_inner=Double.parseDouble(multiple_i);
						    //x value
						    s=s+2;
						    if(trignometric_string.charAt(s)=='^')
						    {
							    s++;
							    while(trignometric_string.charAt(s)!=')')
							    {
								    power= power+trignometric_string.charAt(s);
								    s++;
							    }
							    power_inner=Double.parseDouble(power);
						     }
						    
					      }// else closed 
						  
				} // outer else closed 
				/*
				System.out.println("The value of outer multiplier= "+multiple_outer);
				System.out.println("The value of inner multiplier= "+multiple_inner);
				System.out.println("The value of inner power= "+power_inner); */
				double temp= multiple_inner*Math.pow(x_value,power_inner);
				if(trignometric_string.toLowerCase().contains("sin"))
				{
				sum= multiple_outer*Math.sin(Math.toRadians(temp));
				//System.out.println("The value is= "+sum);
				}
				else if (trignometric_string.toLowerCase().contains("cos"))
				{
				sum= multiple_outer*Math.cos(Math.toRadians(temp));
				//System.out.println("The value is= "+sum);
				}
				else if(trignometric_string.toLowerCase().contains("tan"))
				{
				sum= multiple_outer*Math.tan(Math.toRadians(temp));
				//System.out.println("The value is= "+sum);
				}
				//int temp= multiple_i*Math.pow(x_value,power_inner);
				//sum= multiple_o*Math.sin();
				
			//----*------------------*---------------------------------*-------
			}
			return sum;
		}
	
	// Function to return the sum i.e y value 
	double getSum()
	{
		return sum;
	}
	
	
}

