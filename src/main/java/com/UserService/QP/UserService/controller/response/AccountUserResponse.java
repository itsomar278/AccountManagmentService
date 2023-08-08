package com.UserService.QP.UserService.controller.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccountUserResponse {
    private String firstName;
    private String lastName;
    private int account_Id;

    public AccountUserResponse(String firstName, String lastName, int Account_Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account_Id = Account_Id;
    }
}
