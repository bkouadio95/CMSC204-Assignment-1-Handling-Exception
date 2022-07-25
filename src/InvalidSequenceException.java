
@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
	
	public InvalidSequenceException() {
		
	}
	
	public InvalidSequenceException (String error_message){
		
		super(error_message);
	}

}
