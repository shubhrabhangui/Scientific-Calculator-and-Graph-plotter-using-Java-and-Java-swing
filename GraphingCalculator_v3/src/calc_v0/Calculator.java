package calc_v0;

import java.awt.EventQueue;

import calc_v0.GUI;

// This class contains the main

public class Calculator {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Exception Handling 
				try {
					GUI window = new GUI();
					GUI.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
