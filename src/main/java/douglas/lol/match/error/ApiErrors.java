package douglas.lol.match.error;

import java.util.Arrays;
import java.util.List;


public class ApiErrors {

	private List<String> errors;
	
	public ApiErrors(String errorMessage) {
		this.errors = Arrays.asList(errorMessage);
	}
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
