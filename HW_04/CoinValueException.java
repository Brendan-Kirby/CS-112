public class CoinValueException extends Exception {

	String defaultValueError = "\n\nCoin identity did not match coin value, try again.\n\n";

	public CoinValueException() {
		
		System.out.println(defaultValueError);
		
	}

	public CoinValueException(String valueError) {
	
		super(valueError);	
	
	}
}
