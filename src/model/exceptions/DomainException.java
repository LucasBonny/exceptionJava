package model.exceptions;

//RuntimeException não obriga a tratar
//Exception obriga a tratar
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public DomainException(String msg) {
		super(msg);
	}

}
