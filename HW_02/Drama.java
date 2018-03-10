public class Drama extends Movie {

	public static final double LATE_FEE_DRAMA = 2.00;
	
	public Drama() {
	
		super(DEFAULT_TITLE, DEFAULT_ID_NUM, DEFAULT_RATING);
	}
	
	public Drama(String title, int idNum, String rating) {
		
		super(title, idNum, rating);
	}
	
	@Override
	public double calcLateFees(int daysLate) {
		
		double fee;
		
		if (daysLate > 0) {
			
			fee = daysLate * LATE_FEE_DRAMA;
		}
		else {
			fee = 0.00;
		}	
		
		return fee;
	}	
	
	public Drama copyFilm() {
			
		Drama copy;
		String tempTitle, tempRating;
		int tempIdNum;
		
		copy = new Drama();
		
		tempTitle = this.getTitle();
		tempRating = this.getRating();
		tempIdNum = this.getIdNum();
		
		copy.setTitle(tempTitle);
		copy.setIdNum(tempIdNum);
		copy.setRating(tempRating);
		
		return copy;
	}			
}
