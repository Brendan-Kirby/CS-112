public class UnknownOperatorException extends Exception {

	private final String DEFAULT_MESSAGE = "Error - Unknown Operator";

	public UnknownOperatorException() {
	
		System.out.println(DEFAULT_MESSAGE);
	}
	
	public UnknownOperatorException(String message) {
	
		super(message);
	}
}
