public class Rental {
	
	public static final int DEFAULT_CUSTOMER_ID = 0000;
	public static final int DEFAULT_DAYS_LATE = 0;

	private Movie rented;
	private int customerID;
	private int daysLate;
	
	public Rental() {
	
		this.rented = new Movie();
		this.customerID = DEFAULT_CUSTOMER_ID;
		this.daysLate = DEFAULT_DAYS_LATE;
	}	
	
	public Rental(Movie toRent, int customerID, int daysLate) {
	
		this.rented = toRent.copyFilm(); //deep copy
		this.customerID = customerID;
		this.daysLate = daysLate;
	}
	
	public String toString() {
	
		return "Rental Movie: " + this.rented + "\nDays Late: " + this.getDaysLate() + "\nCustomer ID: " + this.customerID;
	}	
	
	public void setDaysLate(int daysLate) {
	
		this.daysLate = daysLate;
	}	
	
	public void setCustomerID(int customerID) {
	
		this.customerID = customerID;
	}	
	
	public void setMovie(Object rented) {
		
		Movie toRent = (Movie) rented;		
		
		this.rented = toRent;
	}	
	
	public int getDaysLate() {
	
		return this.daysLate;
	}		
	
	public int getCustomerID() {
	
		return this.customerID;
	}	
	
	public Movie getMovie() {
	
		return this.rented.copyFilm();
	}	
	
	public double calcRentalLateFee() {
	
		return this.getMovie().calcLateFees(this.getDaysLate());
		
	}	
	
	public static double lateFeesOwed(Rental[] toCalc) {
	
		double totalLateFee;
		
		totalLateFee = 0.00;
	
		for (int i = 0; i < toCalc.length; i++) {
			
			if (toCalc[i].getDaysLate() > 0) {
				
				totalLateFee = totalLateFee + toCalc[i].calcRentalLateFee();
				
			}
		}	
		
		return totalLateFee;
	}	

}
