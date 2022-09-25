package org.example.servers.errors;

public class GetProductFromDBException extends RuntimeException {

    private final String message;

    public GetProductFromDBException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
