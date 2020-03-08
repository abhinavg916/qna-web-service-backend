package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.ZonedDateTime;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity createUser(UserEntity userEntity){
        entityManager.persist(userEntity);
        return userEntity;
    }

    @Transactional
    public UserEntity DeleteUser(UserEntity userEntity){
        entityManager.remove(userEntity);


        return userEntity;
    }
    @Transactional
    public UserAuthTokenEntity SignOut(UserAuthTokenEntity userAuthTokenEntity){
        userAuthTokenEntity.setLogoutAt(ZonedDateTime.now());


        return userAuthTokenEntity;
    }
    public UserEntity getUserName(final String Username){
        try
        {
           return entityManager.createNamedQuery("userByUserName",UserEntity.class).setParameter("userName",Username)
                   .getSingleResult();
        }
        catch (NoResultException ex){
            return null;
        }
    }

    public UserEntity getUserPassword(final String password){
        try
        {
            return entityManager.createNamedQuery("userByPassword",UserEntity.class).setParameter("userpassword",password)
                    .getSingleResult();
        }
        catch (NoResultException ex){
            return null;
        }
    }

    public UserEntity getUserByEmail(final String email) {
        try {
            return entityManager.createNamedQuery("userByEmail", UserEntity.class).setParameter("email", email).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public UserEntity getUserByUUID(final String UUID) {
        try {
            return entityManager.createNamedQuery("userByUUID", UserEntity.class).setParameter("UUID", UUID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public UserEntity getUserByID(final String ID) {
        try {
            return entityManager.createNamedQuery("userByID", UserEntity.class).setParameter("ID", ID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public UserAuthTokenEntity getUserAuthToken(final String accessToken) {
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class).setParameter("accessToken", accessToken).getSingleResult();
        } catch (NoResultException nre) {

            return null;
        }

    }
    public UserAuthTokenEntity createAuthToken(final UserAuthTokenEntity userAuthTokenEntity) {
        entityManager.persist(userAuthTokenEntity);
        return userAuthTokenEntity;
    }
    public void updateUser(final UserEntity updatedUserEntity) {
        entityManager.merge(updatedUserEntity);
    }

}
