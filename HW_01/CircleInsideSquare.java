/* CircleInsideSquare.java – draws a circle within a square on
							 the screen
   Author:   Brendan Kirby
   Module:   1
   Project:  Project 2
   Problem Statement: This class draws a square on the screen, then
					  draws a circle perfectly within the bounds of
					  the square.
        
   Algorithm / Plan:
		 1.	 Set color to BLUE
         2.  Draw a filled rectangle of equal length and height
         3.  Set color to YELLOW
         4.  Draw a filled oval with equal size major/minor axes
			 (making it a circle) and also having radius equal to
			 the length and height of the square drawn in step 2
*/

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class CircleInsideSquare extends JFrame {
		
	public void paint(Graphics canvas) {
			
		canvas.setColor(Color.BLUE);	
		canvas.fillRect(73, 75, 256, 256);
		
		canvas.setColor(Color.YELLOW);
		canvas.fillOval(73, 75, 256, 256);	
	}
	
	public static void main(String[] args) {
	
		JFrame drawing;
		drawing = new CircleInsideSquare();
		drawing.setSize(400, 400);
		drawing.setTitle("Circle Inside Square");
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.setLocationRelativeTo(null);
		drawing.setVisible(true);
	}
}
