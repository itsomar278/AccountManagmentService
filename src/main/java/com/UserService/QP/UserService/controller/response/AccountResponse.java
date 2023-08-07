package com.UserService.QP.UserService.controller.response;

import java.util.Date;

public class AccountResponse {
        private String firstName;
        private String lastName;
        private String email;
        private int numberOfUsers ;
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

        public int getNumberOfUsers() {
            return numberOfUsers;
        }

        public void setNumberOfUsers(int numberOfUsers) {
            this.numberOfUsers = numberOfUsers;
        }

    }
