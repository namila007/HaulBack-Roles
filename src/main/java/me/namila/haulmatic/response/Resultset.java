package me.namila.haulmatic.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.namila.haulmatic.exceptionHandler.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static me.namila.haulmatic.constants.statics.Common.DATE_PATTERN;

@Data
@ApiModel
public class Resultset<T> {
    @ApiModelProperty(value = "Https Status Code", example = "OK")
    private HttpStatus status;

    @ApiModelProperty(value = "Date and Time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private LocalDateTime timestamp;
    @ApiModelProperty(value = "Data Object")
    private T data;

    private Resultset() {
        this.timestamp = LocalDateTime.now();
    }

    public Resultset(T o, HttpStatus status) throws RuntimeException {
        this();
        if ( o == null || ( o instanceof List && ( ( List ) o ).isEmpty() ) )
            throw new ResourceNotFoundException( "No Content Found" );
        this.status = status;
        this.data = o;
    }

}