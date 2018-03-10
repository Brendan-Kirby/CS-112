public class Action extends Movie {

	public static final double LATE_FEE_ACTION = 3.00;
	
	public Action() {
	
		super(DEFAULT_TITLE, DEFAULT_ID_NUM, DEFAULT_RATING);
	}
	
	public Action(String title, int idNum, String rating) {
		
		super(title, idNum, rating);	
	}
	
	@Override
	public double calcLateFees(int daysLate) {
		
		double fee;
		
		if (daysLate > 0) {
			
			fee = daysLate * LATE_FEE_ACTION;
		}
		else {
			fee = 0.00;
		}	
		
		return fee;
	}	
	
	public Action copyFilm() {
			
		Action copy;
		String tempTitle, tempRating;
		int tempIdNum;
		
		copy = new Action();
		
		tempTitle = this.getTitle();
		tempRating = this.getRating();
		tempIdNum = this.getIdNum();
		
		copy.setTitle(tempTitle);
		copy.setIdNum(tempIdNum);
		copy.setRating(tempRating);
		
		return copy;
	}	
}
