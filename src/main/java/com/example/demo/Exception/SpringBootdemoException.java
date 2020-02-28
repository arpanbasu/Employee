package com.example.demo.Exception;

public class SpringBootdemoException extends RuntimeException {
    public SpringBootdemoException(String message) {
        super(message);
    }

    public SpringBootdemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringBootdemoException(Throwable cause) {
        super(cause);
    }
}
