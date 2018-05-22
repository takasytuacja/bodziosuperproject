package pl.bodzio.superproject.controller.book;

public class BookNotFoundException extends RuntimeException {

	BookNotFoundException(){
		super("Book Not Found");
	}
}
