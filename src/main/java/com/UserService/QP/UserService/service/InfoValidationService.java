package com.UserService.QP.UserService.service;

import com.UserService.QP.UserService.exception.myexception.WrongInputException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InfoValidationService {

    public boolean validateDateBirth(Date DateOfBirth) {
        boolean trueDate = DateOfBirth.before(new Date());
        boolean olderThan18 = DateOfBirth.before(new Date(System.currentTimeMillis() - 18 * 31556952000L));

        if(trueDate&& olderThan18)
        {
            return true;
        }

        throw new WrongInputException("Wrong Date of Birth , check again and make sure you are older than 18");
    }

    public boolean validateFirstName(String firstName) {
        boolean match = firstName.matches("^[a-zA-Z]+$");
        if (match)
        {
            return true;
        }

        throw new WrongInputException("First Name can't include anything else of alphabetical characters");
    }
    public boolean validateLastName(String lastName) {
        boolean match = lastName.matches("^[a-zA-Z]+$");
        if (match)
        {
            return true;
        }

        throw new WrongInputException("Last Name can't include anything else of alphabetical characters");
    }
    public boolean validateEmail(String email) {
        boolean match = email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");

        if (match) {
            return true;
        }

        throw new WrongInputException("Wrong Email address please check it again ");

    }

}
