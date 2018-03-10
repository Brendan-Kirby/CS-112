public class Comedy extends Movie {

	public static final double LATE_FEE_COMEDY = 2.50;

	public Comedy() {
	
		super(DEFAULT_TITLE, DEFAULT_ID_NUM, DEFAULT_RATING);
	}
	
	public Comedy(String title, int idNum, String rating) {
		
		super(title, idNum, rating);
	}	
	
	@Override
	public double calcLateFees(int daysLate) {
		
		double fee;
		
		if (daysLate > 0) {
			
			fee = daysLate * LATE_FEE_COMEDY;
		}
		else {
			fee = 0.00;
		}	
		
		return fee;
	}	
	
	public Comedy copyFilm() {
			
		Comedy copy;
		String tempTitle, tempRating;
		int tempIdNum;
		
		copy = new Comedy();
		
		tempTitle = this.getTitle();
		tempRating = this.getRating();
		tempIdNum = this.getIdNum();
		
		copy.setTitle(tempTitle);
		copy.setIdNum(tempIdNum);
		copy.setRating(tempRating);
		
		return copy;
	}	
}
