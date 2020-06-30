package me.namila.haulmatic.exceptionHandler;

import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import me.namila.haulmatic.exceptionHandler.exceptions.ResourceNotFoundException;
import me.namila.haulmatic.exceptionHandler.exceptions.ValidationException;
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
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> resourceEntityNotFound(ResourceNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> validationExceptions(ValidationException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MongoWriteException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ApiError> handleMongoExceptions(MongoWriteException ex) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_ACCEPTABLE, "DUPLICATE NIC FOUND", ex), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MongoException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ApiError> handleMongoExceptions(MongoException ex) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_ACCEPTABLE, "MongoDB ERROR OCCURRED", ex), HttpStatus.NOT_ACCEPTABLE);
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ApiError> handleAllExceptions(Exception ex) {
//        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST,"ERROR OCCURRED", ex), HttpStatus.BAD_REQUEST);
//    }

}
