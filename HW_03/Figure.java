public abstract class Figure {

	//to be overridden in derived classes
	public abstract void draw(Grid toDrawOn);
	
	public abstract void erase(Grid toEraseFrom);
	
	public abstract void center(Grid toCenterOn);
	
	public abstract boolean equals(Object anotherObject);
	
	public abstract String toString();

}
