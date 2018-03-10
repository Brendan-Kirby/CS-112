/* Bullseye.java – draws a bullseye pattern on the screen
   Author:   Brendan Kirby
   Module:   1
   Project:  Project 3
   Problem Statement: This class draws the rings of a bullseye
    				  pattern and fills them using alternating
					  colors. 
        
   Algorithm / Plan:
		 1.	 Define a circle of radius 256 with coordinates (73,75)
         2.  For every decrement the radius by 41, if the resulting
			 radius is even: set color to BLACK and if it is odd:
			 set color to GREEN
         3.  For every decrement of the radius, while the radius 
             remains greater than 10, draw a filled oval and 
             increment the x and y coordinates by 20 
*/

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Bullseye extends JFrame {
		
	public void paint(Graphics canvas) {
		
		int radius, xcoord, ycoord;
		
		radius = 256;
		xcoord = 73;
		ycoord = 75;

		for (radius = 256; radius > 10; radius -= 41) {
			
			if ((radius % 2) != 0) {
			
				canvas.setColor(Color.BLACK);
				
			}
			else {
				
				canvas.setColor(Color.GREEN);
				
			}	
			
			canvas.fillOval(xcoord, ycoord, radius, radius);
			xcoord += 20;
			ycoord += 20;	
		}	 
	}
	
	public static void main(String[] args) {
	
		JFrame drawing;
		drawing = new Bullseye();
		drawing.setSize(400, 400);
		drawing.setTitle("Bullseye");
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.setLocationRelativeTo(null);
		drawing.setVisible(true);
	}
}
