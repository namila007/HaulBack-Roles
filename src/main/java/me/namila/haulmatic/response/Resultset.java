package me.namila.haulmatic.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import me.namila.haulmatic.exceptionHandler.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static me.namila.haulmatic.constants.statics.GlobalStatics.DATE_PATTERN;

@Data
public class Resultset<T>
{
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDateTime timestamp;
    private T data;

    private Resultset()
    {
        this.timestamp = LocalDateTime.now();
    }

    public Resultset( T o, HttpStatus status ) throws RuntimeException {
        this();
        if ( o == null || ( o instanceof List && ( ( List ) o ).isEmpty() ) )
            throw new ResourceNotFoundException( "No Content Found" );
        this.status = status;
        this.data = o;
    }

}