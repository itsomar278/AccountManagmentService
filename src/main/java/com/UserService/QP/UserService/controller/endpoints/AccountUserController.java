package com.UserService.QP.UserService.controller.endpoints;

import com.UserService.QP.UserService.Mapper.IAccountUserMapper;
import com.UserService.QP.UserService.controller.request.AccountUserPostRequest;
import com.UserService.QP.UserService.controller.request.AccountUserUpdateRequest;
import com.UserService.QP.UserService.controller.response.AccountUserResponse;
import com.UserService.QP.UserService.model.AccountUserEntity;
import com.UserService.QP.UserService.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountUserController {

    @Autowired
    private AccountUserService accountUserService;

    @GetMapping("accounts/{account_id}/users")
    public ResponseEntity<List<AccountUserResponse>> getAllUsers(@PathVariable int account_id) {
        List<AccountUserEntity> accountUserEntityList = accountUserService.findAll(account_id);
        return new ResponseEntity<>(IAccountUserMapper.INSTANCE.map(accountUserEntityList), HttpStatus.OK);
    }

    @GetMapping("accounts/{account_id}/users/{id}")
    public ResponseEntity<AccountUserResponse> getUserById(@PathVariable int account_id, @PathVariable int id) {
        AccountUserEntity accountUserEntity = accountUserService.findById(id, account_id);
        AccountUserResponse accountUserResponse = IAccountUserMapper.INSTANCE.entityToResponse(accountUserEntity);
        return new ResponseEntity<>(accountUserResponse, HttpStatus.OK);
    }

    @PostMapping("accounts/{account_id}/users")
    public ResponseEntity<String> createAccountUser(@RequestBody AccountUserPostRequest request , @PathVariable int account_id) {
        accountUserService.Save(IAccountUserMapper.INSTANCE.postRequestToEntity(request),account_id);
        return new ResponseEntity<>("account was created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("accounts/{account_id}/users/{id}")
    public ResponseEntity<String> deleteAccountUserById(@PathVariable int account_id,@PathVariable int id) {
        accountUserService.DeleteById(id , account_id);
        return new ResponseEntity<>("Account with id: " + id + " was deleted", HttpStatus.OK);
    }

    @PutMapping("accounts/{account_id}/users/{id}")
    public ResponseEntity<String> updateAccountUserById(@PathVariable int account_id ,@PathVariable int id, AccountUserUpdateRequest request) {
        accountUserService.Update(IAccountUserMapper.INSTANCE.updateRequestToEntity(request), id , account_id);
        return new ResponseEntity<>("account with id : " + id + "was updated successfully", HttpStatus.OK);
    }


}
