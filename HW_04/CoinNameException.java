public class CoinNameException extends Exception {

	private final String DEFAULT_MESSAGE = "\n\nInvalid coin name, try again. Valid coin names are : \n" +
										   "* Penny\n" +
										   "* Nickel\n" +
										   "* Dime\n" +
										   "* Quarter\n" +
										   "* Half-Dollar\n\n";
	
	public CoinNameException() {
	
		System.out.println(DEFAULT_MESSAGE);
			
	}
	
	public CoinNameException(String nameError) {
		
		super(nameError);
	}

}
