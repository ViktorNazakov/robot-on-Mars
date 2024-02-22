package com.comsystem.homework.exception;

public class NumberOfDaysNotValidException extends RuntimeException{
    public NumberOfDaysNotValidException(String errorMessage) {
        super(errorMessage);
    }
}
