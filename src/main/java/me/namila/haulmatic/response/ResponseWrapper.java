package me.namila.haulmatic.response;

import org.springframework.http.HttpStatus;


public class ResponseWrapper<T> {
    public Resultset<T> body;

    public ResponseWrapper(T t, HttpStatus status) throws Exception {
        this.body = new Resultset<>(t, status);
    }
}
