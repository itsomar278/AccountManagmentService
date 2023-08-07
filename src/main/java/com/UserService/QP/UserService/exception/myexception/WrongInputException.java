package com.UserService.QP.UserService.exception.myexception;

public class WrongInputException extends RuntimeException{

    public WrongInputException(String message )
    {
        super(message);
    }
    public WrongInputException()
    {
        super("Wrong input data");
    }


}
