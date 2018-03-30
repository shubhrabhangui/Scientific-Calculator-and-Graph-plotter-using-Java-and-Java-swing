package calc_v0;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import calc_v0.Calculator;
import calc_v0.equation_handler;
import calc_v0.keyboard_handler;
import calc_v0.GraphPanel;


// This class just forms the basic GUI 

public class GUI extends JFrame {
	
	// GUI elements 
	protected static JFrame frmCalculator;
	
	// Equation Panel elements 
	protected static JPanel panel_equation = new JPanel();
	protected static JTextField enter_text;
	protected static JTextField textField;
	protected static JScrollPane scrollPane = new JScrollPane();
	protected static JList<String> list = new JList();
	protected static String[] colors =  {"Black ", "Red ", "Green ", " Blue"};
	protected static JComboBox color = new JComboBox(colors);
	protected static double answer;
	protected static JLabel equation_label1 = new JLabel("Equation :-");
	protected static JLabel equation_label2 = new JLabel("y=f(x)=");
	protected static JPanel panel_output= new JPanel();
	protected static JButton Add_Button= new JButton("PLOT");
	protected static JButton Delete_Button = new JButton("ERASE");
	protected static JLabel history_label = new JLabel("History :-");
	protected static JLabel Color_Label = new JLabel("Select Color :-");
	protected static JTextField xrange_text;
	protected static JTextField yrange_text;
	
	// Keyboard Panel elements 
	protected static JPanel keyboard_panel = new JPanel(new GridLayout(5,4));
	protected static JButton nine= new JButton("9");
	protected static JButton eight= new JButton("8");
	protected static JButton seven= new JButton("7");
	protected static JButton plus= new JButton("+");
	protected static JButton power= new JButton("^");
	protected static JButton sine= new JButton("Sin");
	protected static JButton six= new JButton("6");
	protected static JButton five= new JButton("5");
	protected static JButton four= new JButton("4");
	protected static JButton minus= new JButton("-");
	protected static JButton rootof= new JButton("√");
	protected static JButton cosine= new JButton("cos");
	protected static JButton three= new JButton("3");
	protected static JButton two= new JButton("2");
	protected static JButton one= new JButton("1");
	protected static JButton divide= new JButton("/");
	protected static JButton expo= new JButton("e");
	protected static JButton tan= new JButton("tan");
	protected static JButton dot= new JButton(".");
	protected static JButton zero= new JButton("0");
	protected static JButton clear= new JButton("C");
	protected static JButton multiply= new JButton("*");
	protected static JButton pi= new JButton("π");
	protected static JButton ln= new JButton("ln");
	// Panel_ans_enter : New panel for better display of keyboard 
	protected static JPanel panel_ans_enter = new JPanel();
	protected static JButton answer_button = new JButton("ANSWER");
	protected static JButton enter_button = new JButton("ENTER");
	protected static JButton open_bracket = new JButton("(");
	protected static JButton close_bracket = new JButton(")");
	
	// Graph Panel 
	protected static JPanel panel_graph = new GraphPanel();
	
	
    // Constructor 
	public GUI() {
		// Calls the function which creates GUI
		CreateGUI();
		}

    
	// Function creating GUI 
	private void CreateGUI() {
		// Equation GUI creation 
				frmCalculator = new JFrame();
				frmCalculator.setResizable(false);
				frmCalculator.setTitle("Calculator");
				frmCalculator.setBounds(100, 100, 1400, 850);
				frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmCalculator.getContentPane().setLayout(null);
				
				
				panel_equation.setBounds(25, 31, 481, 450);
				frmCalculator.getContentPane().add(panel_equation);
				panel_equation.setLayout(null);
				
				
				equation_label1.setBounds(183, 16, 138, 39);
				panel_equation.add(equation_label1);
				
				
				equation_label2.setBounds(22, 42, 68, 39);
				panel_equation.add(equation_label2);
				
				enter_text = new JTextField();
				enter_text.setText("Enter f(x) here");
				enter_text.setBounds(124, 48, 254, 26);
				panel_equation.add(enter_text);
				enter_text.setColumns(10);
				
				
				Add_Button.setBounds(95, 166, 128, 29);
				panel_equation.add(Add_Button);
				
				
				Delete_Button.setBounds(262, 166, 117, 29);
				panel_equation.add(Delete_Button);
				
				
				history_label.setBounds(94, 274, 61, 16);
				panel_equation.add(history_label);

				
				//To scroll: Just in case the history panel has too many stored results 
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(92, 305, 306, 83);
				scrollPane.setViewportView(list);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				panel_equation.add(scrollPane);
				
				
				Color_Label.setBounds(96, 207, 110, 16);
				panel_equation.add(Color_Label);
				
				color.setEditable(true);
				color.setBounds(96, 235, 117, 27);
				panel_equation.add(color);
				
				JButton load_button = new JButton("LOAD");
				load_button.setBounds(92, 400, 117, 29);
				panel_equation.add(load_button);
				
				JLabel x_label = new JLabel("X axis range");
				x_label.setBounds(15, 91, 97, 16);
				panel_equation.add(x_label);
				
				xrange_text = new JTextField();
				xrange_text.setBounds(124, 86, 254, 25);
				panel_equation.add(xrange_text);
				xrange_text.setColumns(20);
				xrange_text.setText("[-10,10]");
				
				JLabel y_label = new JLabel("Y axis range");
				y_label.setBounds(15, 128, 97, 16);
				panel_equation.add(y_label);
				
				yrange_text = new JTextField();
				yrange_text.setBounds(124, 123, 254, 26);
				yrange_text.setText("[-10,10]");
				panel_equation.add(yrange_text);
				yrange_text.setColumns(20);
				
				
				// Calculator keyboard related GUI 
				
				panel_output.setBounds(24, 505, 482, 39);
				frmCalculator.getContentPane().add(panel_output);
				panel_output.setLayout(null);
				
				textField = new JTextField();
				textField.setText("");
				textField.setEditable(false);
				textField.setHorizontalAlignment(SwingConstants.LEFT);
				textField.setBounds(6, 6, 470, 27);
				panel_output.add(textField);
				textField.setColumns(25);
				
				
				keyboard_panel.setBounds(25, 568, 481, 185);
				frmCalculator.getContentPane().add(keyboard_panel);
				
				keyboard_panel.setLayout(null);
				keyboard_panel.add(nine);
				keyboard_panel.add(eight);
			    keyboard_panel.add(seven);
			    keyboard_panel.add(plus);
			    keyboard_panel.add(power);
			    keyboard_panel.add(sine);
			    keyboard_panel.add(six);
			    keyboard_panel.add(five);
			    keyboard_panel.add(four);
			    keyboard_panel.add(minus);
			    keyboard_panel.add(rootof);
			    keyboard_panel.add(cosine);
			    keyboard_panel.add(three);
			    keyboard_panel.add(two);
			    keyboard_panel.add(one);
			    keyboard_panel.add(divide);
			    keyboard_panel.add(expo);
			    keyboard_panel.add(tan);
			    keyboard_panel.add(dot);
			    keyboard_panel.add(zero);
			    keyboard_panel.add(clear);
			    keyboard_panel.add(multiply);
			    keyboard_panel.add(pi);
			    keyboard_panel.add(ln);
			    keyboard_panel.setLayout(new GridLayout(4,6,4,4));
			    
			   
			    panel_ans_enter.setBounds(25, 765, 481, 38);
				frmCalculator.getContentPane().add(panel_ans_enter);
				panel_ans_enter.setLayout(null);
				
				
				panel_ans_enter.add(answer_button);
				
				
				panel_ans_enter.add(enter_button);
				
				
				panel_ans_enter.add(open_bracket);
				
				
				panel_ans_enter.add(close_bracket);
				
				panel_ans_enter.setLayout(new GridLayout(1,4,4,4));
				
				// Panel Graph related GUI 
				
				panel_graph.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_graph.setBounds(533, 15, 800, 800);
				//panel_graph.setBackground(Color.LIGHT_GRAY);
				frmCalculator.getContentPane().add(panel_graph);
				
				// Equation handler 
				// Handles the equation panel actions
				equation_handler handler = new equation_handler(panel_graph); 
				
				// Equation/ Graph event Handlers 
				Add_Button.addActionListener(handler);
			    Delete_Button.addActionListener(handler);
				load_button.addActionListener(handler);
				color.addActionListener(handler);
				
			
				
				// Keyboard Handler
				// Handles Keyboard panel actions
				keyboard_handler keyboard_handler= new keyboard_handler(textField,nine, eight, seven, 
						                                                plus, sine, six, five, four, 
						                                                minus, rootof,cosine, three, 
						                                                two, one, divide, expo, tan, dot, 
						                                                zero,clear, multiply, pi, ln, 
						                                                answer_button, enter_button, 
						                                                open_bracket, close_bracket,power);
			    
			    
				// Calculator keyboard event handlers 
			    nine.addActionListener(keyboard_handler);
			    eight.addActionListener(keyboard_handler);
			    seven.addActionListener(keyboard_handler);
			    plus.addActionListener(keyboard_handler);
			    sine.addActionListener(keyboard_handler);
			    six.addActionListener(keyboard_handler);
			    five.addActionListener(keyboard_handler);
			    four.addActionListener(keyboard_handler);
			    minus.addActionListener(keyboard_handler);
			    rootof.addActionListener(keyboard_handler);
			    cosine.addActionListener(keyboard_handler);
			    three.addActionListener(keyboard_handler);
			    two.addActionListener(keyboard_handler);
			    one.addActionListener(keyboard_handler);
			    divide.addActionListener(keyboard_handler);
			    expo.addActionListener(keyboard_handler);
			    tan.addActionListener(keyboard_handler);
			    dot.addActionListener(keyboard_handler);
			    zero.addActionListener(keyboard_handler);	
			    clear.addActionListener(keyboard_handler);	
			    multiply.addActionListener(keyboard_handler);	    
			    pi.addActionListener(keyboard_handler);	
			    ln.addActionListener(keyboard_handler);  
			    answer_button.addActionListener(keyboard_handler); 
			    enter_button.addActionListener(keyboard_handler); 
			    open_bracket.addActionListener(keyboard_handler);
			    close_bracket.addActionListener(keyboard_handler);
			    power.addActionListener(keyboard_handler);
				
		
	}
	
}

