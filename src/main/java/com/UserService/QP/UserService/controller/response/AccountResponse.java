package com.UserService.QP.UserService.controller.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccountResponse {
        private String firstName;
        private String lastName;
        private String email;
        private int numberOfUsers ;
        public String getFirstName() {
            return firstName;
        }

    }
