package com.UserService.QP.UserService.service;

import com.UserService.QP.UserService.Mapper.IAccountMapper;
import com.UserService.QP.UserService.exception.myexception.ResourceExistsException;
import com.UserService.QP.UserService.exception.myexception.ResultNotFoundException;
import com.UserService.QP.UserService.exception.myexception.WrongInputException;
import com.UserService.QP.UserService.repository.IAccountRepository;
import com.UserService.QP.UserService.exception.myexception.EmptyResultException;
import com.UserService.QP.UserService.model.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private InfoValidationService infoValidationService;

    public AccountService() {
        super();
    }

    public List<AccountEntity> findAll() {
        List<AccountEntity> result = accountRepository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException("No Accounts are registered in the system");
        }
        else {
            return result;
        }
    }

    public AccountEntity findById(int id) {
        AccountEntity result = accountRepository.findById(id).orElse(null);

        if (result == null) {
            throw new ResultNotFoundException("No Account with such id");
        }
        else {
            return result;
        }
    }

    public AccountEntity save(AccountEntity account) {
        AccountEntity result = accountRepository.findByEmail(account.getEmail());

        if(result != null) {
            throw new ResourceExistsException("Account with such email already exists");
        }

        else {
            validateAccount(account);
            return accountRepository.save(account);
        }
    }

    public void deleteById(int id)
    {
        if(!doesUserExist(id))
        {
            throw new ResultNotFoundException("No Account with such id");
        }
        else
        {
            accountRepository.deleteById(id);
        }
    }

    public void Update (AccountEntity account , int id) {
        if(!doesUserExist(id))
        {
            throw new ResultNotFoundException("No Account with such id");
        }
        else
        {
            AccountEntity oldAccount = accountRepository.findById(id).orElse(null);
            if(!oldAccount.getEmail().equals(account.getEmail())&&doesUserExist(account.getEmail()))
            {
                    throw new WrongInputException("Account with such email already exists");
            }
            else
            {
                IAccountMapper.INSTANCE.entityToEntity(account,oldAccount);
                accountRepository.save(oldAccount);
            }
        }

    }

    public boolean validateAccount(AccountEntity user) {
        return infoValidationService.validateEmail(user.getEmail())&&
                infoValidationService.validateDateBirth(user.getDateOfBirth())&&
                infoValidationService.validateFirstName(user.getFirstName())&&
                infoValidationService.validateLastName(user.getLastName());
    }

    public boolean doesUserExist(int id) {
        boolean exists = accountRepository.existsById(id);
        return exists;
    }

    public boolean doesUserExist(String email) {
        AccountEntity account = accountRepository.findByEmail(email);

        if(account == null) {
            return false;
        }
        else {
            return true;
        }
    }

}
