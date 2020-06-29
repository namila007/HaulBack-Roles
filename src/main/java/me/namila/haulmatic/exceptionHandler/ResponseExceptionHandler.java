package me.namila.haulmatic.exceptionHandler;

import me.namila.haulmatic.exceptionHandler.exceptions.ResourceNotFoundException;
import me.namila.haulmatic.exceptionHandler.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> resourceEntityNotFound(ResourceNotFoundException ex )
    {
        ApiError apiError = new ApiError( HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),  ex );
        return new ResponseEntity<>( apiError, HttpStatus.BAD_REQUEST );
    }

}
