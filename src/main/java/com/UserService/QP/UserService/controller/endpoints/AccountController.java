package com.UserService.QP.UserService.controller.endpoints;

import com.UserService.QP.UserService.Mapper.IAccountMapper;
import com.UserService.QP.UserService.controller.request.AccountPostRequest;
import com.UserService.QP.UserService.controller.request.AccountUpdateRequest;
import com.UserService.QP.UserService.controller.response.AccountResponse;
import com.UserService.QP.UserService.model.AccountEntity;
import com.UserService.QP.UserService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountEntityService;

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountEntity> accountEntityList = accountEntityService.findAll();
        return new ResponseEntity<>(IAccountMapper.INSTANCE.map(accountEntityList), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable int id) {
        AccountEntity accountEntity = accountEntityService.findById(id);
        AccountResponse accountResponse = IAccountMapper.INSTANCE.entityToResponse(accountEntity);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable int id) {
        accountEntityService.deleteById(id);
        return new ResponseEntity<>("Account with id: " + id + " was deleted", HttpStatus.OK);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<String> updateAccountById(@PathVariable int id, AccountUpdateRequest updateRequest) {
        {
            accountEntityService.Update(IAccountMapper.INSTANCE.updateRequestToEntity(updateRequest), id);
            return new ResponseEntity<>("account with id : " + id + "was updated successfully", HttpStatus.OK);
        }

    }

    @PostMapping("/accounts")
    public ResponseEntity<String> createAccount(AccountPostRequest accountEntity) {
        accountEntityService.save(IAccountMapper.INSTANCE.requestToEntity(accountEntity));
        return new ResponseEntity<>("account was created successfully", HttpStatus.CREATED);
    }



}