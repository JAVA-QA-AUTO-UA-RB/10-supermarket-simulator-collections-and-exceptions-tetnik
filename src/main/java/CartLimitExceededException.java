package main.java;

public class CartLimitExceededException extends RuntimeException {
    public CartLimitExceededException(String message) {
        super(message);
    }
}
