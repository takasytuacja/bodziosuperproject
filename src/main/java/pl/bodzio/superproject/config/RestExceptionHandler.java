package pl.bodzio.superproject.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.bodzio.superproject.controller.book.BookIdMismatchException;
import pl.bodzio.superproject.controller.book.BookNotFoundException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	public RestExceptionHandler() {
		super();
	}


	@ExceptionHandler(BookNotFoundException.class)
	@ResponseBody
	protected ResponseEntity<ErrorData> handleNotFound(Exception ex, WebRequest request) {
		ErrorData errorData = new ErrorData(ex.getMessage());
		return new ResponseEntity(errorData, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({
			BookIdMismatchException.class,
			ConstraintViolationException.class,
			DataIntegrityViolationException.class
	})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected ResponseEntity<ErrorData> handleBadRequest(Exception ex, WebRequest request) {
		ErrorData errorData = new ErrorData(ex.getMessage());
		return new ResponseEntity(errorData, HttpStatus.BAD_REQUEST);
	}

}
