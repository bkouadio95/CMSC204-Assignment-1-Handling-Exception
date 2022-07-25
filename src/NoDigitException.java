
@SuppressWarnings("serial")
public class NoDigitException extends Exception {
	
	public NoDigitException() {
		
		
	}
	
	public NoDigitException (String error_message) {
		
		super (" The password must contain at least one digit");
	}

}
