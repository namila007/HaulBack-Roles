package me.namila.haulmatic.exceptionHandler.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static me.namila.haulmatic.constants.statics.Common.DATE_PATTERN;

@Data
@AllArgsConstructor
public class ApiError
{

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public ApiError()
    {
        timestamp = LocalDateTime.now();
    }

    public ApiError( HttpStatus status )
    {
        this();
        this.status = status;
    }

    public ApiError( HttpStatus status, Throwable ex )
    {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError( HttpStatus status, String message, Throwable ex )
    {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getMessage();
    }
}