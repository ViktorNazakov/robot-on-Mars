package com.comsystem.homework.exception.handler;

import com.comsystem.homework.dto.ApiErrorResponseDTO;
import com.comsystem.homework.exception.NumberOfDaysNotValidException;
import com.comsystem.homework.exception.NumberOfStonesNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RobotRestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Returns exception message with status code bad request
     *
     * @param e - the exception thrown.
     * @return - response, containing the exception message and appropriate status code.
     */
    @ExceptionHandler(NumberOfDaysNotValidException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleNumberOfDaysNotValid(NumberOfDaysNotValidException e) {
        String exceptionMessage = e.getLocalizedMessage();
        return new ResponseEntity<>(new ApiErrorResponseDTO(HttpStatus.BAD_REQUEST, exceptionMessage, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns exception message with status code bad request
     *
     * @param e - the exception thrown.
     * @return - response, containing the exception message and appropriate status code.
     */
    @ExceptionHandler(NumberOfStonesNotValidException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleNumberOfStonesNotValid(NumberOfStonesNotValidException e) {
        String exceptionMessage = e.getLocalizedMessage();
        return new ResponseEntity<>(new ApiErrorResponseDTO(HttpStatus.BAD_REQUEST, exceptionMessage, e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
