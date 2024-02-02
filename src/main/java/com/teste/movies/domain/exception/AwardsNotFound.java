package com.teste.movies.domain.exception;

public class AwardsNotFound extends RuntimeException{
    public AwardsNotFound(String message ){
        super(message);
    }
}
