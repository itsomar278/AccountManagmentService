package com.UserService.QP.UserService.exception.myexception;

public class ResultNotFoundException extends RuntimeException{
    public ResultNotFoundException() {
        super("Account or User not found");
    }

    public ResultNotFoundException(String message) {
        super(message);
    }
}
