package woodProject;

public class UnavailableNodeException extends Exception {
		
	public String getMessage() {
		
		return "List is empty.";
	}
}
