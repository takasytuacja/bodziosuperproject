package pl.bodzio.superproject.service.validation;

public class ValidationException extends RuntimeException{

	ValidationException(String message){
		super("Validation exception: " +message);
	}
}
