package com.proadvisor.repository;

import com.proadvisor.model.entity.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepository {

    private static final String JPQL_GET_USER_BY_LOGIN = "SELECT usr FROM User usr WHERE login = :login";
    private static final String JPQL_GET_USER_COUNT_WITH_EMAIL = "SELECT count(usr) FROM User usr WHERE email = :email";
    private static final String JPQL_GET_USER_COUNT_WITH_LOGIN = "SELECT count(usr) FROM User usr WHERE login = :login";
    private static final String JPQL_GET_USER_COUNT_WITH_LOGIN_OR_EMAIL = "SELECT count(usr) FROM User usr WHERE login = :login or email = :email";

    @Autowired
    private EntityManager entityManager;

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login) {
        return entityManager.createQuery(JPQL_GET_USER_BY_LOGIN, User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public boolean hasUserWithLogin(String login) {
        return entityManager.createQuery(JPQL_GET_USER_COUNT_WITH_LOGIN, Long.class)
                .setParameter("login", login)
                .getSingleResult()
                != 0;
    }

    public boolean hasUserWithEmail(String email) {
        return entityManager.createQuery(JPQL_GET_USER_COUNT_WITH_EMAIL, Long.class)
                .setParameter("email", email)
                .getSingleResult()
                != 0;
    }

    public boolean hasUserWithLoginOrEmail(String email, String login) {
        return entityManager.createQuery(JPQL_GET_USER_COUNT_WITH_LOGIN_OR_EMAIL, Long.class)
                .setParameter("email", email)
                .setParameter("login", login)
                .getSingleResult()
                != 0;
    }


}
