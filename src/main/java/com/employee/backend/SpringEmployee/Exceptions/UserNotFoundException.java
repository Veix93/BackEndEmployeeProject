package com.employee.backend.SpringEmployee.Exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }
}
