public class Grid {

	private final int DEFAULT_X = 50;
	private final int DEFAULT_Y = 20;

	private char[][] gridSpace;
	private int gridSizeX, gridSizeY;
	
	//default constructor
	public Grid() {
	
		this.gridSizeX = DEFAULT_X;
		this.gridSizeY = DEFAULT_Y;
		gridSpace = new char[gridSizeX][gridSizeY];
	}	
	
	//full constructor
	public Grid(int gridSizeX, int gridSizeY) {
	
		this.gridSizeX = gridSizeX;
		this.gridSizeY = gridSizeY;
		gridSpace = new char[gridSizeX][gridSizeY];
	}														
	
	//setters
	public void setGridSpace(char[][] gridSpace) {
		
		if (gridSpace != null) {
			
			this.gridSpace = gridSpace;
		}
		else {
			
			System.out.println("GridSpace set to null array error");
		}		
	}	
	
	public void setGridSizeX(int gridSizeX) {
	
		if (gridSizeX > 0) {
		
			this.gridSizeX = gridSizeX;
		}	
		else {
		
			System.out.println("Negative grid size error");
		}	
	}
	
	public void setGridSizeY(int gridSizeY) {
	
		if (gridSizeY > 0) {
		
			this.gridSizeY = gridSizeY;
		}	
		else {
		
			System.out.println("Negative grid size error");
		}	
	}
	
	//getters	
	public char[][] getGridSpace() {
	
		return this.gridSpace;
	}
	
	public int getGridSizeX() {
	
		return this.gridSizeX;
	}		
	
	public int getGridSizeY() {
	
		return this.gridSizeY;
	}		

	//clears the grid, setting every location on the grid equal to ' '
	public void clearGrid() {
	
		for (int j = 0; j < this.gridSizeY; j++) { //moving along y-axis
			
			for (int i = 0; i < this.gridSizeX; i++) { //moving along x-axis
				
				this.gridSpace[i][j] = ' '; //setting each coordinate equal to ' '
			}
		}		
	}			
	
	//prints the grid in its current state to the console
	public void printGrid() {		
	
		System.out.print("Y = " + this.gridSizeY + " +"); //y-max label, top left corner
	
		for (int i = 0; i < this.gridSizeX; i++) { //top border
		
			System.out.print("-");
		}	
	
		System.out.println("+"); //top right corner
	
		for (int j = 0; j < this.gridSizeY; j++) { //moving along y-axis
		
			System.out.print("       |"); //leftmost border		
			
			for (int i = 0; i < this.gridSizeX; i++) { //moving along x-axis
				
				System.out.print(this.gridSpace[i][j]); //prints whatever is contained in each coordinate
			}
			
			System.out.println("|"); //rightmost border	
		}
		
		System.out.print("Y = 0  +"); //y-min label, bottom left corner
		
		for (int i = 0; i < this.gridSizeX; i++) { //moving along x-axis
			
			System.out.print("-"); //bottom border
		}			
		
		System.out.println("+"); //bottom right corner
		
		System.out.print("       X = 0"); //x-min label
		
		for (int i = 0; i < this.gridSizeX; i++) { //moving along x-axis
		
			if (i > (this.gridSizeX - 5)) { //reserving space for x-max label
			
				System.out.print("X = " + this.gridSizeX); //x-max label
				break;
			}	
			else { //space between x-min label and x-max label
			
				System.out.print(" "); //empty space
			}	
		}				
	}	
}
