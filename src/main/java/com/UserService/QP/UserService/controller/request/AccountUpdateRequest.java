package com.UserService.QP.UserService.controller.request;

import java.util.Date;

public class AccountUpdateRequest {
    public class AccountPostRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String country;
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

    }


}
