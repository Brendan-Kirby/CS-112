public class Rectangle extends Figure {
	
	private final int DEFAULT_LENGTH = 2;
	private final int DEFAULT_WIDTH = 2;
	
	private int length, width;
	
	//default constructor
	public Rectangle() {
	
		setLength(DEFAULT_LENGTH);
		setWidth(DEFAULT_WIDTH);
	}	
	
	//full constructor
	public Rectangle(int length, int width) {
	
		setLength(length);
		setWidth(width);
	}	
	
	//setters
	public void setLength(int length) {
	
		if (length > 0) {
				
			this.length = length;
		}	
		else {
		
			System.out.println("Error: negative length!");
		}	
	}
	
	public void setWidth(int width) {
	
		if (width > 0) {
				
			this.width = width;
		}	
		else {
		
			System.out.println("Error: negative width!");
		}	
	}			
	
	//getters
	public int getLength() {
	
		return this.length;
	}		
	
	public int getWidth() {
	
		return this.width;
	}		
	
	//toString
	public String toString() {
	
		return "Length  : " + this.length +
			   "\nWidth : " + this.width;
	}
	
	//equals
	public boolean equals(Object anotherObject) {
		
		if (anotherObject == null || !(anotherObject instanceof Rectangle)) {
			
			return false;
		}	
		
		Rectangle anotherRectangle = new Rectangle();
		anotherObject = anotherRectangle;
		
		return (this.length == anotherRectangle.getLength() &&
				this.width == anotherRectangle.getWidth());
	}
	
	//draws the calling rectangle on a specified Grid object
	public void draw(Grid toDrawOn) {

		for (int j = 0; j < this.width; j++) {
			
			for (int i = 0; i < this.length; i++) {
				
				if (j > 0  			&&
					j < (this.width - 1)  &&
					i > 0			&&
					i < (this.length - 1)) {
				
					toDrawOn.getGridSpace()[i][j] = ' ';	
				}		
				else if (i <= this.length &&
						 j <= this.width)  {
					
					toDrawOn.getGridSpace()[i][j] = '*';
				}	
			}
		}			
	}		
	
	//erases the previous state of the calling rectangle from the specified Grid object
	public void erase(Grid toEraseOn) {
		
		for (int j = 0; j < this.width; j++) {
			
			for (int i = 0; i < this.length; i++) {
				
				if (j > 0  			      &&
					j < (this.width - 1)  &&
					i > 0			      &&
					i < (this.length - 1)) {
				
					toEraseOn.getGridSpace()[i][j] = ' ';	
				}		
				else if (i <= this.length &&
						 j <= this.width)  {
					
					toEraseOn.getGridSpace()[i][j] = ' ';
				}	
			}
		}			
		
	}	
	
	//erases the previous state of the calling rectangle from the specified Grid object, then draws the 
	//calling rectangle in the center of the specified Grid object
	public void center(Grid toCenterOn) {
	
		this.erase(toCenterOn);
		
		int planeCenterX = (toCenterOn.getGridSizeX() / 2);
		int planeCenterY = (toCenterOn.getGridSizeY() / 2);
		
		int length = this.getLength();
		int width = this.getWidth();
		/*
		for (int i = 0; i < length; i++) {
		
				toCenterOn.getGridSpace()[planeCenterX - (length / 2)][i + planeCenterY - (length / 2)] = '*';
		}
		
		for (int i = 0; i < width; i++) {
		
				toCenterOn.getGridSpace()[0 + planeCenterX - 1 - (width / 2)][i + planeCenterY - (width / 2)] = '*';
		}	
		*/
		for (int j = 0; j < this.width; j++) {
			
			for (int i = 0; i < this.length; i++) {
				
				if (j > 0  			      &&
					j < (this.width - 1)  &&
					i > 0			      &&
					i < (this.length - 1)) {
				
					toCenterOn.getGridSpace()[i + planeCenterX - (width / 2)][0 + planeCenterY - (length / 2)] = ' ';	
				}		
				else if (i <= this.length &&
						 j <= this.width)  {
							 
					toCenterOn.getGridSpace()[i + planeCenterX - (width / 2)][0 + planeCenterY - (length / 2)] = '*';
				}	
			}
		}			
	}					
}
