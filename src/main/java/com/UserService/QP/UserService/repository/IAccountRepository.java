package com.UserService.QP.UserService.repository;

import com.UserService.QP.UserService.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findByEmail(String email);
}
