package calc_v0;

/* This class is to check if the entered expression is valid or invalid 
 * Takes the expression staring as input 
 *  */


public class validate_equation {
	
	String equation_check;
	protected static String error_or_not="";
	protected boolean expression_check;

	public validate_equation(String equation_check) {
		// Constructor 
		this.equation_check=equation_check;
		expression_check=check_equation(equation_check);
	}
	
	
	private static  boolean check_equation(String equation_check) {
		try {
			error_or_not="";
			//static String error_or_not="";
			char ch= equation_check.charAt(0);
			
			//System.out.println(" First character is : "+ch);
			
			// Check if the equation is trigonometric function 
			if(ch=='S'||ch=='s'|| ch=='C'||ch=='c'||ch=='t'||ch=='T')
				
			{   
				
				check_trignometry(equation_check,ch);
		
				
				
				
			} // check if trigonometric function over 
			
			else 
				{
				
				check_expression(equation_check);
				//System.out.println("Checking equation");
				}
			
			}catch(Exception e)
			{
				return false;
			}
			
			if(error_or_not=="ERROR")
			{
				 // Error found
				return false;
			                          }
			else { 
				//Expression successful
			      return true;}
			
		}

		private static void check_trignometry(String equation_check, char ch) 
		{
			// TODO Auto-generated method stub
			String sin= ""+ch;
			// Check if Sin 
			if(ch=='s'|| ch=='S')
			{  try {
				for(int i=1;i<=3;i++)
				{
					 sin=sin+equation_check.charAt(i);
					// System.out.println("sin check "+sin);
				}
				
				//System.out.println("Sine funtion or not "+ sin);
				
				if (sin.equals("SIN(" )|| sin.equals("sin(") || sin.equals("Sin("))
				{   
					
					if(equation_check.charAt(equation_check.length()-1)!=')') {
						
						error_or_not="ERROR";
					}
					else if(equation_check.contains("+")||equation_check.contains("-")||equation_check.contains("/"))
					{
						error_or_not="ERROR";
					}
					else 
					{   int i=4;
					    String expression= "";
						while(equation_check.charAt(i)!=')')
						{
							expression= expression+ equation_check.charAt(i);
							if((i+1)!=equation_check.length()) {i++;}
							//System.out.println("Forming equation"+ expression);
							
						}
						//System.out.println("The equation to be checked is: "+expression);
						check_expression(expression);
							
					}
				}
				else {//System.out.println("Error " + sin);
				      error_or_not= "ERROR";
				      }
			} catch(Exception e) {error_or_not= "ERROR";}
			
		}
			
			            // Check if Cos
			        String cos= ""+ch;
					if(ch=='c'|| ch=='C')
			{  
				try {
				for(int i=1;i<=3;i++)
				{
					 cos=cos+equation_check.charAt(i);
					
				}
				
				//System.out.println("Cos funtion or not "+ cos);
				
				if (cos.equals("COS(" )|| cos.equals("cos(") || cos.equals("Cos("))
				{   
					//System.out.println("It is Cos function");
					//System.out.println("equation_check.charAt(equation_check.length())!=')' "+ equation_check.charAt(equation_check.length()-1));
					if(equation_check.charAt(equation_check.length()-1)!=')') {
						//System.out.println("Error cos");
						error_or_not="ERROR";
					}
					else if(equation_check.contains("+")||equation_check.contains("-")||equation_check.contains("/"))
					{
						error_or_not="ERROR";
					}
					else
					{   int i=4;
					    String expression= "";
						while(equation_check.charAt(i)!=')')
						{
							expression= expression+ equation_check.charAt(i);
							if((i+1)!=equation_check.length()) {i++;}
							//System.out.println("Forming equation"+ expression);
							
						}
						//System.out.println("The equation to be checked is: "+expression);
						check_expression(expression);
						//System.out.println(" ERROR or not"+error_or_not);
							
					}
				}
				else {//System.out.println("Error " + cos);
				      error_or_not= "ERROR";
				      }
				}catch(Exception e)	{error_or_not= "ERROR";}	
			
		}
			
						// Check if Tan 
					String tan= ""+ch;
					// Check if Sin 
					if(ch=='t'|| ch=='T')
					{   
						try {
						for(int i=1;i<=3;i++)
						{
							 tan=tan+equation_check.charAt(i);
							// System.out.println("tan check "+tan);
						}
						
						//System.out.println("tan funtion or not "+ tan);
						
						if (tan.equals("TAN(" )|| tan.equals("tan(") || tan.equals("Tan("))
						{   
							//System.out.println("It is Tan function");
							//System.out.println("equation_check.charAt(equation_check.length())!=')' "+ equation_check.charAt(equation_check.length()-1));
							if(equation_check.charAt(equation_check.length()-1)!=')') {
								//System.out.println("Error tan");
								error_or_not="ERROR";
							}
							else if(equation_check.contains("+")||equation_check.contains("-")||equation_check.contains("/"))
							{
								error_or_not="ERROR";
							}
							else
							{   int i=4;
							    String expression= "";
								while(equation_check.charAt(i)!=')')
								{
									expression= expression+ equation_check.charAt(i);
									if((i+1)!=equation_check.length()) {i++;}
									//System.out.println("Forming equation"+ expression);
									
								}
								//System.out.println("The equation to be checked is: "+expression);
								check_expression(expression);
									
							}
						}
						else {//System.out.println("Error " + tan);
						      error_or_not= "ERROR";
						      }
						}catch(Exception e)	{error_or_not= "ERROR";}	
					
				}
		}

		private static void check_expression(String expression) {
			
			char ch= expression.charAt(0);
			
			String str="";
			
			// check if 1st character is a number 
			//char ch= expression.charAt(0);
			
			if(expression.charAt(expression.length()-1)=='+'|| expression.charAt(expression.length()-1)=='*'||expression.charAt(expression.length()-1)=='^'||expression.charAt(expression.length()-1)=='.')
			{
				error_or_not="ERROR";
				//System.out.println("Error in expression");
				
			}
			
			else if(ch=='x'|| number(ch)) 
			{   
				//System.out.println("Expression length"+expression.length());
				try {
				for(int i=1;i<=expression.length()-1;i++)
				{
					char temp= expression.charAt(i);
					/*System.out.println("i="+i);
					System.out.println("ch="+ch);
					System.out.println("temp="+temp);*/
					if(ch=='.'&& number(temp))
					{
						ch=temp;
						continue;
					}
					
					else if(ch=='x'&&(temp=='^'|| temp=='+'))
					{
						
						ch=temp;
						continue;
					}
					else if(ch=='+'&&(temp=='x'||number(temp)))
					{
						ch=temp;
						continue;
					}
					else if(number(ch)&&(temp=='*'||temp=='+'|| isPoint(temp)||number(temp)))
					{
						ch=temp;
						continue;
						
						
					}
					
					else if (ch=='^' && number(temp))
					{
						ch= temp;
						continue;
					} 
					
					else if ( ch=='*'&& (temp=='x'))
					{
						ch= temp;
						continue;
					}
					else if ( ch=='*'&&(temp=='s'||temp=='S'||temp=='c'||temp=='C'||temp=='t'||temp=='T'))
					{   
						i++;
						while (expression.charAt(i)!= ')')
						{
							str= str+ expression.charAt(i);
							i++;
						}
						check_trignometry(str,ch);
					}
					
					else { 
						  error_or_not="ERROR";
						 // System.out.println("Not an expression");
						  }
					
				}
				}catch(Exception e)	{error_or_not= "ERROR";}	
			} else { 
				     error_or_not="ERROR";
				    // System.out.println("Error in expression");
				     }
			
		}

		private static boolean number(char ch) {
			// Check if number
			if(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9'||ch=='0')
			{
				return true;
			}
			return false;
		}
		
		private static boolean isPoint(char ch) {
			// Check if point
			if(ch=='.')
			{
				return true;
			}
			return false;
		}

     public boolean getExpression_check()
     {
    	  return expression_check;
     }

}
