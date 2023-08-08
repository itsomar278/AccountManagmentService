package com.UserService.QP.UserService.controller.response;

public class AccountUserResponse {
    private String firstName;
    private String lastName;
    private int account_Id;

    public AccountUserResponse(String firstName, String lastName, int Account_Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account_Id = Account_Id;
    }

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

    public int getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(int account_Id) {
        this.account_Id = account_Id;
    }
}
