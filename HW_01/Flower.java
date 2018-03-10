/* Flower.java – draws a flower on the screen
   Author:   Brendan Kirby
   Module:   1
   Project:  Project 3
   Problem Statement: This class draws the center and petals
					  of a flower and fills them using different
					  colors. 
        
   Algorithm / Plan:
		 1.	 Set color to GREEN
         2.  Draw and fill center of flower
         3.  Set color to MAGENTA
         4.  Draw and fill petals of flower at 3, 6, 9, and 12 
			 o'clock relative to the center drawn in step 2  
*/

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;


public class Flower extends JFrame {

	public void paint(Graphics canvas) {
	
	
		canvas.setColor(Color.GREEN);
		canvas.fillOval(190, 190, 25, 25);
		
		canvas.setColor(Color.MAGENTA);
		canvas.fillOval(215, 192, 144, 25);
		canvas.fillOval(191, 215, 25, 144);
		canvas.fillOval(190, 45, 25, 144);
		canvas.fillOval(45, 192, 144, 25);
	}
	
	public static void main(String[] args) {
	
		JFrame drawing;
		drawing = new Flower();
		drawing.setSize(400, 400);
		drawing.setTitle("Flower");
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.setLocationRelativeTo(null);
		drawing.setVisible(true);
	}
}
