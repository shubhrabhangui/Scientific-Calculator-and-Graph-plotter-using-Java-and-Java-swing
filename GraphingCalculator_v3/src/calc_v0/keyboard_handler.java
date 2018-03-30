package calc_v0;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import calc_v0.Keyboard_calculations;
import calc_v0.keyboard_hash;
/* This class handles any keyboard events */

public class keyboard_handler implements ActionListener{
	static double first=0,second=0,result=0;
	static int operator=0;
	JButton nine, eight, seven; 
	JButton plus, sine, six, five; 
	JButton four, minus, rootof, power;
	JButton cosine, three, two, one;
	JButton divide, expo, tan, dot, zero;
	JButton clear, multiply, pi, ln;
	JButton answer_button, enter_button;
	JButton open_bracket, close_bracket;
	JTextField textField;
	JTextField hash_text;
	static String value="";
	
	static String temp;
	
	/* Keyboard_handler constructor 
	Initialization done here*/
	keyboard_handler(JTextField textField,JButton nine, JButton eight, JButton seven, 
			JButton plus, JButton sine, JButton six, JButton five, 
			JButton four, JButton minus, JButton rootof,
			JButton cosine, JButton three, JButton two, JButton one, 
			JButton divide, JButton expo, JButton tan, JButton dot, JButton zero,
			JButton clear, JButton multiply, JButton pi, JButton ln, 
			JButton answer_button, JButton enter_button, 
			JButton open_bracket,JButton close_bracket, JButton power)
	{
		this.textField= textField;
		this.nine= nine;
		this.eight= eight;
		this.seven= seven;
		this.plus= plus;
		this.sine= sine;
		this. six= six;
		this.five= five;
		this.four= four;
		this.minus=minus;
		this.rootof= rootof;
		this.cosine= cosine;
		this.three= three;
		this.two= two;
		this.one =one;
		this.divide = divide;
		this.expo= expo; 
		this.tan= tan; 
		this.dot= dot;
		this.zero= zero;
		this.clear= clear;
		this.multiply= multiply;
		this.pi= pi;
		this.ln=ln;
		this.answer_button= answer_button;
		this.enter_button= enter_button;
		this.open_bracket= open_bracket;
		this.close_bracket= close_bracket;
		this.power= power;
		

		
	}
	
    /* The actions to be performed on each button click */
	@Override
	public void actionPerformed(ActionEvent e) {
		//GUI c= new GUI();
		
		
		if(e.getSource()==nine)
		{
		 textField.setText(textField.getText().concat("9"));
		 value= value+'9';
		 
		}
		
		if(e.getSource()==eight)
		{
		 textField.setText(textField.getText().concat("8"));
		 value= value+'8';
		}
		
		if(e.getSource()==seven)
		{
		 textField.setText(textField.getText().concat("7"));
		 value= value+'7';
		}
		
		if(e.getSource()==six)
		{
		 textField.setText(textField.getText().concat("6"));
		 value= value+'6';
		}
		
		if(e.getSource()==five)
		{
		 textField.setText(textField.getText().concat("5"));
		 value= value+'5';
		}
		
		if(e.getSource()==four)
		{
		 textField.setText(textField.getText().concat("4"));
		 value= value+'4';
		}
		
		if(e.getSource()==three)
		{
		 textField.setText(textField.getText().concat("3"));
		 value= value+'3';
		}
		
		if(e.getSource()==two)
		{
		 textField.setText(textField.getText().concat("2"));
		 value= value+'2';
		}
		
		if(e.getSource()==one)
		{
		 textField.setText(textField.getText().concat("1"));
		 value= value+'1';
		}
		
		if(e.getSource()==zero)
		{
		 textField.setText(textField.getText().concat("0"));
		 value= value+'0';
		}
		
		if(e.getSource()==plus)
		{
		 textField.setText(textField.getText().concat("+"));
		 value= value+'+';
		}
		
		if(e.getSource()==minus)
		{
		 textField.setText(textField.getText().concat("-"));
		 value= value+'-';
		}
		
		if(e.getSource()==multiply)
		{
		 textField.setText(textField.getText().concat("*"));
		 value= value+'*';
		}
		
		if(e.getSource()==divide)
		{
		 textField.setText(textField.getText().concat("/"));
		 value= value+'/';
		}
		
		if(e.getSource()==sine)
		{
		 textField.setText(textField.getText().concat("Sin"));
		 value= value+'s';
		}
		
		if(e.getSource()==cosine)
		{
		 textField.setText(textField.getText().concat("Cos"));
		 value= value+'c';
		}
		
		if(e.getSource()==tan)
		{
		 textField.setText(textField.getText().concat("Tan"));
		 value= value+'t';
		}
		
		if(e.getSource()==rootof)
		{
		 textField.setText(textField.getText().concat("√"));
		 value= value+'r';
		}
		
		if(e.getSource()==expo)
		{
		 textField.setText(textField.getText().concat("e"));
		 // e= 2.71828
		 if(value.length()!=0)
		 {
		 char op= value.charAt(value.length()-1);
		 if(op == '+' || op == '-' || op == '*' || op == '/' || op == '^'|| op == 'r'|| op=='('
				 || op==')'||op=='s'||op=='c'|| op=='t'|| op=='l')
				 {
			       value= value+'2'+'.'+'7'+'1'+'8'+'2'+'8';
				 }
		 
		 
		 else 
		        {
			       value= value+'*'+'2'+'.'+'7'+'1'+'8'+'2'+'8';
		        }
		 }
		 
		 else {value= value+'2'+'.'+'7'+'1'+'8'+'2'+'8';}
		}
		
		if(e.getSource()==dot)
		{
		 textField.setText(textField.getText().concat("."));
		 value=value+'.';
		}
		
		if(e.getSource()==clear)
		{
		 textField.setText("");
		 value="";
		 
		 
		}
		
		if(e.getSource()==pi)
		{
             textField.setText(textField.getText().concat("π"));
             if(value.length()!=0)
             {
			 char op= value.charAt(value.length()-1);
			 if(op == '+' || op == '-' || op == '*' || op == '/' || op == '^'|| op == 'r'|| op=='s'||op=='c'||
					 op=='t'||op=='(')
					  {
				       /*value= value+'3'+'.'+'1'+'4';*/
				         value=value+'p';
					  }
			 else
			         {
				      // value= value+'*'+'3'+'.'+'1'+'4';
				       value=value+'*'+'p';
			         }
             }
             else 
             {
			       //value= value+'3'+'.'+'1'+'4';
            	         value= value+'p';
		     }

		}
		
		if(e.getSource()==ln)
		{
			textField.setText(textField.getText().concat("ln"));
			value= value+'l';
		}
		
		if(e.getSource()==close_bracket)
		{
			textField.setText(textField.getText().concat(")"));
			value= value+')';
		}
		
		if(e.getSource()==power)
		{
			textField.setText(textField.getText().concat("^"));
			value= value+'^';
		}
		
		if(e.getSource()==open_bracket)
		{
			textField.setText(textField.getText().concat("("));
			value= value+'(';
		}
		
		
		if (e.getSource()== enter_button)
		{   
			/* keyboard_hash class converts the string to postfix expression */
             keyboard_hash key1= new keyboard_hash(value);
			String postfix= key1.get_postfix();
			
			/* keyboard_calculation class finds the final answer using postfix expression*/
			Keyboard_calculations key= new Keyboard_calculations(postfix);
			GUI.answer= key.get_answer();
			textField.setText(Double.toString(GUI.answer));
			key1.value="";
			
		}
		
		if (e.getSource()== answer_button)
		{   
			
		    if (value=="")
			{
			textField.setText(Double.toString(GUI.answer));
			value= value+Double.toString(GUI.answer);
			}
			
		    else
		    {
		    	textField.setText(value+ Double.toString(GUI.answer));
		    	value= value+Double.toString(GUI.answer);
		    }
			
		}
		
	}

	

}
