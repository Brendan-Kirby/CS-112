/* CrescentMoon.java – draws a lit crescent moon
   Author:   Brendan Kirby
   Module:   1
   Project:  Project 3
   Problem Statement:  This class draws and fills a picture of a
					   crescent moon with one side lit, and the 
					   rest dark.
        
   Algorithm / Plan:
		 1.	 Draw a filled oval using  color ORANGE
         2.  Draw another filled oval using color DARK_GREY such 
             that it is offset rightward from the initial oval, 
             giving the impression of three dimensions 
*/


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;


public class CrescentMoon extends JFrame {

	public void paint(Graphics canvas) {

		canvas.setColor(Color.ORANGE);
		canvas.fillOval(105, 90, 225, 225);
	
		canvas.setColor(Color.DARK_GRAY);
		canvas.fillOval(90, 90, 225, 225);
	}
	
	public static void main(String[] args) {
	
		JFrame drawing;
		drawing = new CrescentMoon();
		drawing.setSize(400, 400);
		drawing.setTitle("Crescent Moon");
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.setLocationRelativeTo(null);
		drawing.setVisible(true);
	}
}
