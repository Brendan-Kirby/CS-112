public class DivideByZeroException extends Exception {

	private final String DEFAULT_MESSAGE = "Error - Attempted division by zero"; 

	public DivideByZeroException() {
	
		System.out.println(DEFAULT_MESSAGE);
	}
	
	public DivideByZeroException(String message) {
	
		super(message);
	}
}
