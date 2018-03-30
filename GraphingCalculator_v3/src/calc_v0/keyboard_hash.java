package calc_v0;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
/*
 * In this class the input string is converted into postfix expression which 
 * is easier to evaluate and checks precedence of operators 
 * */

public class keyboard_hash {
	/*
	 * 1) int loop is used to keep track of the number 
	 * 2) To check if it is the new number or part of ongoing number 
	 * 3) value is the string expression which contains the input text 
	 * 4) s is each character of the input string 
	 * 5) temp is the string which finally becomes postfix expression 
	 * 6) Stack is used to check the precedence of operators 
	 * */
    int loop = 0;
	String value;
	public char s;
    String temp = "";
    int i = 0;
	Stack<Character> stack = new Stack<Character>();
	
	  keyboard_hash(String value){  
		  
		  do {
			  
			  s= value.charAt(i);
			 
			  
			      // To check if the character is pi 
			      if(s=='p')
			      {
			    	  loop=0;
			    	  temp= temp+s;
			      }
			      
			      /*To check if the character is a number 
			       * The numbers in postfix expression begin with # so as for easier parsing 
			       * This helps in getting numbers in keyboard_calculation class.
			      */
			      else if (!check_if_operator(s) ) {
			      
			      if (loop == 0) {
				      if (temp == null)
				          temp = "#";
				      else
				     	  temp = (temp +"#");
				  }
		        	  temp = temp + s;
		          loop++;
		       } // if its number loop closed
			      
		       //if it is operator-- put into stack 
		       else if (check_if_operator(s)) {
			     
			     loop = 0;
		         if (stack.isEmpty()) {
			         stack.push(s);
			         
			     }
		         else {
		        	     // precedence of operator not low 
		             if (!check_precedence_low(s, stack.peek())) {
		        	          /*System.out.println("The precedence of operator is not low");
		        	          System.out.println("The value of s is " + s + " The value of top of stack is"+ stack.peek());*/
		        	          
		            	 if (s != ')')
		                  {
		        	    	          //System.out.println(" Top of stack is not right paranthesis");
			                  stack.push(s);
			              }// character ) loop closed 
		                  else {
		            	        while (!stack.empty() && stack.peek() != '(')
		        	            {
			        	             temp = temp + stack.pop();
		        	            }
		            	        
		            	        if (!stack.empty())
		        	              stack.pop();
		                  }
		              }
		              else 
		              {  
			        	     //System.out.println("The precedence of operator is low");
			    	         while (!stack.empty() && check_precedence_low(s, stack.peek()))
			    	         { 
			    	        	   //System.out.println("The value of s is "+ s + " The value of top of stack is " + stack.peek());
			    	    	       temp = temp + stack.pop();
			    	    	     }
			    	         stack.push(s);
		    	          }
		  }
	  }
      ++i;
      //System.out.println("temp= " +temp);
	}   while (i < value.length());
		while (!stack.empty())
            temp= temp+ stack.pop();
		
	/*System.out.println(" Popping the extra items in stack");
	System.out.println("temp is "+temp);*/
		
	for (int j=0;j<stack.size();j++)
	{
		//if not paranthesis then do this else ignore
		temp= temp + stack.pop();
	}
	//System.out.println("temp is "+temp);
}
	// To check if operator 
	private static boolean check_if_operator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'|| c == 'r'
                || c == '(' || c == ')'|| c == 's' || c == 'c' || c == 't' || c == 'l';
    }
	
	// To check for precedence 
	
	private static boolean check_precedence_low(char c, char top)
    {  
		if( ((c==')')||(c=='('))&& ((top=='*') || (top=='/') || (top=='^')|| (top=='r')|| 
        		(top=='s')|| (top=='c')|| (top=='t')|| (top=='+')||(top=='-') || (top=='*')|| (top=='/')||(top=='l')))
        		{
        	       return false; 
        		}
		else if ((c=='+') && ((top=='*') || (top=='/') || (top=='^')|| (top=='r')|| (top=='s')|| (top=='c')|| (top=='t')))
   		{
        	  return true;
        	}
        else if((c=='-') && ((top=='*')||(top=='/') || (top=='^')|| (top=='r')|| (top=='s')|| (top=='c')|| (top=='t')))
		{
  	      return true;
  		}
        else if(c=='*' && top=='^' || (top=='r')|| (top=='s')|| (top=='c')|| (top=='t'))
        {
        	 return true;
        }
        else if(c=='/' && top=='^'|| (top=='r')|| (top=='s')|| (top=='c')|| (top=='t'))
        {
        	 return true;
        }
        
       
        
        else  return false;
    }
	
	
	// To return the postfix string back 
	public String get_postfix()
	{
		return temp;
	}
	
	
	
}


