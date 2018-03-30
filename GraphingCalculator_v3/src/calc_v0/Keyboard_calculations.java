package calc_v0;

import java.util.ArrayDeque;
/*
math.config({
	  number: 'BigNumber', // Default type of number:
	                       // 'number' (default), 'BigNumber', or 'Fraction'
	  precision: 64        // Number of significant digits for BigNumbers
	});*/
import java.util.Deque;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Keyboard_calculations {
	
	String postfix_string;
	int j=0;
	char ch;
	String number="";
	Stack <Double> number_stack = new Stack <Double>();
	double temp1, temp2;
	double answer;
	int number_of_items;
	static int if_radian;
	
	// To check if there are any error and display message if there is an exception 
	int ERROR= 0;
	int ERROR_bracket=0;
	
	
	/*
	 * 1) number_stack is used to keep the numbers in the postfix in stack of doubles 
	 * 2) temp1 and temp2 are temporary variables used for the numbers which are popped out of 
	 * number_stack on which operations are performed 
	 * 3)if_radian is used to keep a check whether the expression contains pi value 
	 * 4) answer is the final answer of the operations
	 * 5) ch is each character of the postfix string 
	 * 6) number string is used to get number as a string out of the postfix string 
	 */
	
	/* This code will use the postfix expression and find the final answer*/
	Keyboard_calculations(String postfix)
	{   
		
	
		postfix_string= postfix;
		postfix_string= postfix+'=';
		
		// Check if number of opening brackets= number of closing brackets 
		// Check if there are any error due to brackets and continue if false 
		if(!check_for_brackets(postfix_string))
		{
		
		try  // Exception handling to give error in case if any found 
		{
		
		while (!postfix_string.isEmpty() && j<postfix_string.length())
		{   
			
			
			ch= postfix_string.charAt(j);
			
		    //If postfix consists of hash then create the number 
			
			number_of_items=1;
			if (ch== '#')
			{   
				number_of_items=create_number();
				if_radian=0;
				
			}
			// For Pi 
			else if(ch=='p')
			{   
				
				number_stack.push(Math.PI);
				number_of_items=1;
				if_radian=1;
			}
			
			// For addition 
			else if(ch=='+')
			{
				
				temp1= number_stack.pop();
				temp2= number_stack.pop();
				number_stack.push(temp1+temp2);
				
				number_of_items= 1;
				if (temp1== Math.PI || temp2==Math.PI)
				{
					if_radian=1;
				}
				else if_radian=0;
			}
			
			// Subtract 
			else if(ch=='-')
			{
				
				temp1= number_stack.pop();
				temp2= number_stack.pop();
				number_stack.push(temp2-temp1);
				
				number_of_items= 1;
				if (temp1== Math.PI || temp2==Math.PI)
				{
					if_radian=1;
				}
				else if_radian=0;
			}
			// Multiply 
			else if(ch=='*')
			{
				
				temp1= number_stack.pop();
				temp2= number_stack.pop();
				number_stack.push(temp1* temp2);
				
				number_of_items= 1;
				if (temp1== Math.PI || temp2==Math.PI)
				{
					if_radian=1;
				}
				else if_radian=0;
			}
			
			// Divide 
			else if(ch=='/')
			{
				
				temp1= number_stack.pop();
				temp2= number_stack.pop();
				number_stack.push(temp2/ temp1);
				
				number_of_items= 1;
				if (temp1== Math.PI || temp2==Math.PI)
				{
					if_radian=1;
					
				}
				else if_radian=0;
			}
			
			// Equal to 
			else if(ch=='=')
			{
				try
				{
				answer= number_stack.pop();
				}
				catch(Exception e ) {ERROR++;}
				/*System.out.println("Final Answer is : "+answer);*/
		        
			
				
				
			}
			// For Sin function 
			else if(ch=='s')
			{             
				          //System.out.println(" is_radian for sin "+if_radian);
				          //System.out.println("Inside sin function ");
				          temp1= number_stack.pop();
				          if (if_radian==1)
				          {
				          number_stack.push(Math.sin((temp1)));
				          }
				          else 
				          {
				        	  number_stack.push(Math.sin(Math.toRadians(temp1)));
				          }
				          number_of_items=1;
				
				
				
			}
			
			// For Cos function 
			else if(ch=='c')
			{   
				
				//System.out.println("Inside cos function ");
				         // System.out.println(" Is radian"+if_radian);
				          temp1= number_stack.pop();
				          if (if_radian==1)
				          { 
				        	    if (temp1==(Math.PI/2))
				        	    {  
				        	    	
				        	    	   //System.out.println(" Is pi/2");
				        		    number_stack.push(0.0) ; 
				        	    }
				        	    else
				        	    {
				        	    //System.out.println("test: ");
				            number_stack.push(Math.cos((temp1)));
				        	    }
				          }
				          else 
				          {
				        	    if (temp1==(90))
				        	    {
				        		    number_stack.push(0.0) ; 
				        	    }
				        	    else
				        	    {
				        	    number_stack.push(Math.cos(Math.toRadians(temp1)));
				        	  
				            }
				          
				          //System.out.println("temp1="+temp1);
				          //System.out.println("Value of cos: " + Math.cos(Math.toRadians(temp1)));
				          number_of_items=1;
				
				          }
				
			}
			// For tan function 
			else if(ch=='t')
			{
				
				
				temp1= number_stack.pop();
				if (if_radian==1)
		          {
					if ((temp1==Math.PI))
	        	        {
	        		    number_stack.push(1.0/0) ; 
	        	        }
	        	        else
				    {
		            number_stack.push(Math.tan((temp1)));}
		          }
		          else 
		          {
		        	  if (temp1==90)
	        	        {
	        		      number_stack.push(1.0/0) ; 
	        	        }
	        	        else
		        	    number_stack.push(Math.tan(Math.toRadians(temp1)));
		          }
				
			    //System.out.println("temp1="+temp1);
				
				         
				
				
				
			}
			
			//For log function 
			else if(ch=='l')
			{
				
				
				temp1= number_stack.pop();
				number_stack.push(Math.log(temp1));
				/*System.out.println("temp1="+temp1);
			    System.out.println("Value of ln: "+ Math.log(temp1));*/
				         
				
				
				
			}
			
			else if(ch=='^')
			{   
				//java.lang.Math.pow(3,4)
				temp1= number_stack.pop();
				temp2= number_stack.pop();
				number_stack.push(java.lang.Math.pow(temp2,temp1));
				number_of_items= 1;
				
			}
			
			else if(ch=='r')
			{
				temp1= number_stack.pop();
				
				number_stack.push(java.lang.Math.pow(temp1,0.5));
				number_of_items= 1;
				
				
			}
			j= j+number_of_items;
			
		} } catch(Exception e) {ERROR++;}
		}
		
		if(ERROR!=0)
		{
			JFrame frame=new JFrame();
			JOptionPane.showMessageDialog(frame, "ERROR");
		}
	}


// To check and return true if there is an error due to brackets 
private boolean check_for_brackets(String postfix_string) {
	int opening_brackets=0;
	int closing_brackets=0;
	for(int b=0;b<postfix_string.length();b++)
	{
		if(postfix_string.charAt(b)==')')
		{   
			if(closing_brackets> opening_brackets)
			{
				ERROR_bracket++;
			}
			else
			closing_brackets++;
		}
		if(postfix_string.charAt(b)=='(')
		{
			opening_brackets++;
		}
	}
	if(closing_brackets!=opening_brackets)
	{
		ERROR_bracket++;
	}
	if(postfix_string.charAt(postfix_string.length()-1)=='(')
	{
		ERROR_bracket++;
	}
	
	if(ERROR_bracket	>0) { 
	JFrame frame1=new JFrame();
	JOptionPane.showMessageDialog(frame1, "ERROR");
	return true;
	} // There is error 
	else return false; 
	}



public int create_number() {
		
	number= "";
	number_of_items=1;
	ch= postfix_string.charAt(j+number_of_items);
	
	// Till you find operator or #( next number) or = or pi 
	while(!check_if_operator(ch)&& ch!='#'  && ch!='=' && ch!='p')
	{   
		
		
		number= number+ch;
		number_of_items++;
		ch= postfix_string.charAt(j+number_of_items); 
		//System.out.println("value of ch "+ch);
		
	}
	number_stack.push(Double.parseDouble(number));
	/*System.out.println(" Number is "+ Double.parseDouble(number));
	System.out.println("value of j "+j);*/
	//number= "";
	/*System.out.println("number "+number);*/
	number_of_items= number_of_items-1;
	//System.out.println("number of items "+number_of_items);
	
	return number_of_items;	
	}


// To check if the character is operator 
private static boolean check_if_operator(char c)
{
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'|| c == 'r'
            || c == '(' || c == ')'|| c == 's' || c == 'c' || c == 't' || c == 'l';
}

// To return the final answer 
public double get_answer()
{
	return answer;
}



}