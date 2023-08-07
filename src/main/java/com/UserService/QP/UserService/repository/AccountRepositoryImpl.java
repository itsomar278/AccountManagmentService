package com.UserService.QP.UserService.repository;

import com.UserService.QP.UserService.model.AccountEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IAccountRepository IAccountRepository;

    public AccountEntity findByEmail(String email) {
        String hql = "SELECT u FROM AccountEntity u WHERE u.email = :email";
        TypedQuery<AccountEntity> query = entityManager.createQuery(hql, AccountEntity.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}