package com.comsystem.homework.exception;

public class NumberOfStonesNotValidException extends RuntimeException{
    public NumberOfStonesNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
