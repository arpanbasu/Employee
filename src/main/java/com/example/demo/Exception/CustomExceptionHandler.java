package com.example.demo.Exception;

import com.example.demo.bean.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

public class CustomExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Response> handleInvalidRequest(InvalidRequestException ex) {
        return new ResponseEntity<>(
                new Response(true, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler({SpringBootdemoException.class, IOException.class})
    public ResponseEntity<Response> handleInvalidRequest(Exception ex) {

        String message;
        if (ex instanceof IOException)
            message = "Unable to process your request , Please try again later";
        else
            message = ex.getMessage();
        return new ResponseEntity<>(
                new Response(true, message),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
