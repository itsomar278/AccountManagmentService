package com.UserService.QP.UserService.exception.myexception;

public class EmptyResultException extends RuntimeException
{

    public EmptyResultException()
    {
        super("No accounts or users found");
    }

    public EmptyResultException(String message)
    {
        super(message);
    }

}
