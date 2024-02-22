package com.comsystem.homework.dto;

import org.springframework.http.HttpStatus;

public class ApiErrorResponseDTO {
    public ApiErrorResponseDTO(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    private HttpStatus status;
    private String message;
    private String error;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}