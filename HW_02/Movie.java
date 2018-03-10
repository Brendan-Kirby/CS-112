public class Movie {

	public static final int DEFAULT_ID_NUM = 00000;
	public static final String DEFAULT_RATING = "G";
	public static final String DEFAULT_TITLE = "no assigned title";
	public static final double LATE_FEE_DEFAULT = 2.00;

	private String rating, title;
	private int idNum;
	private double lateFee;
	
	public Movie() {
		
		this.setTitle(DEFAULT_TITLE);
		this.setRating(DEFAULT_RATING);
		this.setIdNum(DEFAULT_ID_NUM);
	}
	
	public Movie(String title, int idNum, String rating) {
		
		this.setTitle(title);
		this.setRating(rating);
		this.setIdNum(idNum);
	}		
	
	public void setRating(String rating) {
	
		this.rating = rating;
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	} 

	public void setIdNum(int idNum) {
	
		this.idNum = idNum;
	}
	
	public String getRating() {
	
		return this.rating;
	}
	
	public String getTitle() {
	
		return this.title;
	}

	public int getIdNum() {
	
		return this.idNum;
	}

	public String toString() {
	
		return "Title: " + this.title + "\nID Number: " + this.idNum + "\nRating: " + this.rating;
	}
	
	@Override
	public boolean equals(Object anotherObject) {
	
		if (!(this instanceof Movie) || 
			this.getClass() == null) {
		
			return false;		
		}	
		
		Movie anotherMovie = (Movie) anotherObject;
		
		return (this.getIdNum() == anotherMovie.getIdNum());
	}
	
	public double calcLateFees(int daysLate) {
		
		double fee;
		
		if (daysLate > 0) {
			
			fee = daysLate * LATE_FEE_DEFAULT;
		}
		else {
			fee = 0.00;
		}	
		
		return fee;
	}
	
	public Movie copyFilm() {
			
		Movie copy;
		String tempTitle, tempRating;
		int tempIdNum;
		
		copy = new Movie();
		
		tempTitle = this.getTitle();
		tempRating = this.getRating();
		tempIdNum = this.getIdNum();
		
		copy.setTitle(tempTitle);
		copy.setIdNum(tempIdNum);
		copy.setRating(tempRating);
		
		return copy;
	}			
}
