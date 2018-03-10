public class Triangle extends Figure {

	private final int DEFAULT_SIDE_A = 7;
	private final int DEFAULT_SIDE_B = 7;
	private final int DEFAULT_SIDE_C = 8;

	private int sideA, sideB, sideC;

	//default constructor
	public Triangle() {
		
		setSideA(DEFAULT_SIDE_A);
		setSideB(DEFAULT_SIDE_B);
		setSideC(DEFAULT_SIDE_C);
	}
	
	//full constructor
	public Triangle(int sideA, int sideB, int sideC) {
	
		setSideA(sideA);
		setSideB(sideB);
		setSideC(sideC);
	}		
		
	//setters
	public void setSideA(int sideA) {
	
		if (sideA > 0) {
		
			this.sideA = sideA;
		}
		else {
		
			System.out.println("Negative side length error");
		}						
	}		
	
	public void setSideB(int sideB) {
	
		if (sideB > 0) {
		
			this.sideB = sideB;
		}	
		else {
		
			System.out.println("Negative side length error");
		}				
	}
	
	public void setSideC(int sideC) {
	
		if (sideC > 0) {
		
			this.sideC = sideC;
		}	
		else {
		
			System.out.println("Negative side length error");
		}				
	}				
	
	//getters
	public int getSideA() {
		
		return this.sideA;
	}
	
	public int getSideB() {
	
		return this.sideB;
	}			

	public int getSideC() {
	
		return this.sideC;
	}		

	//toString
	public String toString() {
	
		return "Side A : " + this.sideA +
			   "Side B : " + this.sideB +
			   "Side C : " + this.sideC;
	}
	
	//equals
	public boolean equals(Object anotherObject) {
		
		if (anotherObject == null || !(anotherObject instanceof Triangle)) {
			
			return false;
		}	
		
		Triangle anotherTriangle = new Triangle();
		anotherObject = anotherTriangle;
		
		return (this.sideA == anotherTriangle.getSideA() &&
				this.sideB == anotherTriangle.getSideB() &&
				this.sideC == anotherTriangle.getSideC());
	}		

	//draws the calling Triangle on a specified Grid object
	public void draw(Grid toDrawOn) {
		
		int sideA = this.getSideA();
		int sideB = this.getSideB();
		int sideC = this.getSideC();
		int tracker = 0;
		
		for (int i = 0; i < sideC; i++) {
		
				toDrawOn.getGridSpace()[tracker][i] = '*';
				tracker++;	
		}
		
		tracker = 0;
		
		for (int i = 0; i < sideB; i++) {
		
				toDrawOn.getGridSpace()[0][i] = '*';
				tracker = i;
		}	
		
		for (int i = 0; i < sideA; i++) {
			
				toDrawOn.getGridSpace()[i][tracker + 1] = '*';	
		}
	}	
	
	//erases the previous state of the calling rectangle from the specified Grid object
	public void erase(Grid toEraseOn) {
		
		int sideA = this.getSideA();
		int sideB = this.getSideB();
		int sideC = this.getSideC();
		int tracker = 0;		
		
		for (int i = 0; i < sideC; i++) {
		
				toEraseOn.getGridSpace()[tracker][i] = ' ';
				tracker++;	
		}
		
		tracker = 0;
		
		for (int i = 0; i < sideB; i++) {
		
				toEraseOn.getGridSpace()[0][i] = ' ';
				tracker = i;
		}	
		
		for (int i = 0; i < sideA; i++) {
			
				toEraseOn.getGridSpace()[i][tracker + 1] = ' ';	
		}	
		
		tracker = 0;
		
		int planeCenterX = (toEraseOn.getGridSizeX() / 2);
		int planeCenterY = (toEraseOn.getGridSizeY() / 2);
		
		for (int i = 0; i < sideC; i++) {
		
				toEraseOn.getGridSpace()[tracker + planeCenterX - (this.getSideC() / 2)][i + planeCenterY - (this.getSideC() / 2)] = ' ';
				tracker++;	
		}
		
		tracker = 0;
		
		for (int i = 0; i < sideB; i++) {
		
				toEraseOn.getGridSpace()[0 + planeCenterX - 1 - (this.getSideB() / 2)][i + planeCenterY - (this.getSideB() / 2)] = ' ';
				tracker = i;
		}	
		
		for (int i = 0; i < sideA; i++) {
			
				toEraseOn.getGridSpace()[i + planeCenterX - 1 - (this.getSideA() / 2)][tracker + planeCenterY - (this.getSideA() / 2)] = ' ';	
		}				
	}	
	
	//erases the previous state of the calling Triangle from the specified Grid object, then draws the 
	//calling Triangle in the center of the specified Grid object
	public void center(Grid toCenterOn) {
		
		this.erase(toCenterOn);
		
		int planeCenterX = (toCenterOn.getGridSizeX() / 2);
		int planeCenterY = (toCenterOn.getGridSizeY() / 2);
		
		int sideA = this.getSideA();
		int sideB = this.getSideB();
		int sideC = this.getSideC();
		int shift = 0;
		int tracker = 0;
		
		for (int i = 0; i < sideC; i++) {
		
				toCenterOn.getGridSpace()[tracker + planeCenterX - (this.getSideC() / 2)][i + planeCenterY - (this.getSideC() / 2)] = '*';
				tracker++;	
		}
		
		tracker = 0;
		
		for (int i = 0; i < sideB; i++) {
		
				toCenterOn.getGridSpace()[0 + planeCenterX - 1 - (this.getSideB() / 2)][i + planeCenterY - (this.getSideB() / 2)] = '*';
				tracker = i;
		}	
		
		for (int i = 0; i < sideA; i++) {
			
				toCenterOn.getGridSpace()[i + planeCenterX - 1 - (this.getSideA() / 2)][tracker + planeCenterY - (this.getSideA() / 2)] = '*';	
		}		
	}		

}
