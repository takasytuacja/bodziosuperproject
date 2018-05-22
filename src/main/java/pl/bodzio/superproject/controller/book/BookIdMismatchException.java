package pl.bodzio.superproject.controller.book;

public class BookIdMismatchException extends RuntimeException {

	BookIdMismatchException(){
		super("Book ids missmatch");
	}

}
