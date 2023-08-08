package com.UserService.QP.UserService.service;

import com.UserService.QP.UserService.Mapper.IAccountUserMapper;
import com.UserService.QP.UserService.exception.myexception.EmptyResultException;
import com.UserService.QP.UserService.exception.myexception.ResultNotFoundException;
import com.UserService.QP.UserService.model.AccountEntity;
import com.UserService.QP.UserService.model.AccountUserEntity;
import com.UserService.QP.UserService.repository.IAccountRepository;
import com.UserService.QP.UserService.repository.IAccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountUserService  {

    @Autowired
    private IAccountUserRepository accountUserRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private InfoValidationService infoValidationService;


    public List<AccountUserEntity> findAll(int accountId) {
        List<AccountUserEntity> result =  accountUserRepository.findAll().
                stream()
                .filter(accountUserEntity -> accountUserEntity.getAccount().getId() == accountId)
                .collect(Collectors.toList());

        if(result.isEmpty())
        {
            throw new EmptyResultException("This account didn't register any users");
        }
        else
        {
            return result;
        }
    }


    public AccountUserEntity findById(int id , int account_id) {
        // ACCOUNT ID IS NOT USED SINCE NO AUTHNTICATION YET
        if (accountRepository.existsById(account_id) == false) {
            throw new ResultNotFoundException("There is no account with such id");
        }
        else if(accountUserRepository.existsById(id) == false)
        {
            throw new ResultNotFoundException("There is no account user with such id");
        }
        else
        {
            AccountUserEntity result = accountUserRepository.findById(id).orElse(null);
            return result;
        }
    }

    public void DeleteById(int id , int account_id){
        if (accountRepository.existsById(account_id) == false) {
            throw new ResultNotFoundException("There is no account with such id");
        }
        else if(accountUserRepository.existsById(id) == false)
        {
            throw new ResultNotFoundException("There is no account user with such id");
        }
        else
        {
            accountUserRepository.deleteById(id);
        }
    }

    public void Save(AccountUserEntity accountUserEntity , int account_id)
    {
        if (accountRepository.existsById(account_id) == false) {
            throw new ResultNotFoundException("There is no account with such id");
        }
        validateAccountUser(accountUserEntity);

        AccountEntity account = accountRepository.findById(account_id).get();

        accountUserEntity.setAccount(account);
        account.getAccountUserEntityList().add(accountUserEntity);

        accountRepository.save(account);
        accountUserRepository.save(accountUserEntity);
    }

    public void Update(AccountUserEntity accountUserEntity , int id , int account_id)
    {
        if (accountRepository.existsById(account_id) == false) {
            throw new ResultNotFoundException("There is no account with such id");
        }
        if(accountUserRepository.existsById(id) == false)
        {
            throw new ResultNotFoundException("There is no account user with such id");
        }
        else
        {
            validateAccountUser(accountUserEntity);
            AccountUserEntity oldaccountUserEntity = accountUserRepository.findById(id).orElse(null);
            IAccountUserMapper.INSTANCE.entityToEntity(accountUserEntity , oldaccountUserEntity);
            accountUserRepository.save(oldaccountUserEntity);
        }
    }

    public boolean validateAccountUser(AccountUserEntity accountUserEntity)
    {
        return infoValidationService.validateLastName(accountUserEntity.getLastName())
                && infoValidationService.validateFirstName(accountUserEntity.getFirstName())
                && infoValidationService.validateDateBirth(accountUserEntity.getDateOfBirth());
    }

}
