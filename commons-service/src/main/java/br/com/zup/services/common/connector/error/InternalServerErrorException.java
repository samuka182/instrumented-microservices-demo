package br.com.zup.services.common.connector.error;

public class InternalServerErrorException extends Exception {

	private static final long serialVersionUID = 5719093913455555297L;

	public InternalServerErrorException(String message) {
        super(message);
    }
}
