package br.com.zup.services.common.connector.error;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = -5818768812443556783L;

	public BadRequestException(String message) {
        super(message);
    }
}
