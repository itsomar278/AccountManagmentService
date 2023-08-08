package com.UserService.QP.UserService.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class AccountPostRequest {
        private String firstName;
        private String lastName;
        private String email;
        private Date dateOfBirth;
        private String country;

    }

