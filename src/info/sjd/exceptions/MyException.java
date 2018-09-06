package info.sjd.exceptions;

public class MyException extends RuntimeException{

	public MyException(Exception e) {
		super(e);
	}
	
	public MyException(String message) {
		super(message);
	}
	
}
