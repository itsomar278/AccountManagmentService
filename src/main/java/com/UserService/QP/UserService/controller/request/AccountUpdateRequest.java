package com.UserService.QP.UserService.controller.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountUpdateRequest {
    public class AccountPostRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String country;

    }


}
