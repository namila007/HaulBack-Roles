package me.namila.haulmatic.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseWrapper<T> extends ResponseEntity<T>
{
    public ResponseWrapper( T t, HttpStatus status ) throws Exception {
        super( ( T ) new Resultset<>( t, status ), status );
    }
}
