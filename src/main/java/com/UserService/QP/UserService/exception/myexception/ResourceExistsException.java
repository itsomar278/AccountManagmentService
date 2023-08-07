package com.UserService.QP.UserService.exception.myexception;

public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException() {
        super("Account or User already exists");
    }

    public ResourceExistsException(String message) {
        super(message);
    }

}
