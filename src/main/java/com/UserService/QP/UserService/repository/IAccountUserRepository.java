package com.UserService.QP.UserService.repository;

import com.UserService.QP.UserService.model.AccountEntity;
import com.UserService.QP.UserService.model.AccountUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IAccountUserRepository extends JpaRepository<AccountUserEntity, Integer> {
}
