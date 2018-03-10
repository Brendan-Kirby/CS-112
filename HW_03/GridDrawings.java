public class GridDrawings {

	public static void main(String[] args) {
	
		//declaration & instantiation
		Grid xyPlane = new Grid(50, 20);
		Rectangle rect1 = new Rectangle(4, 16);
		Rectangle rect2 = new Rectangle(16, 4);
		Triangle tri1 = new Triangle(7, 7, 8);
		Triangle tri2 = new Triangle(12, 12, 13);
		
		//processing
		xyPlane.clearGrid();
		
		rect1.draw(xyPlane);
		
		rect1.center(xyPlane);
				
		//output
		xyPlane.printGrid();
		
		
	}

}
