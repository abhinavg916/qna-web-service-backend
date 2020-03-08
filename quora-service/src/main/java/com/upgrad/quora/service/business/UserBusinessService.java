package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.AuthenticationFailedException;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.SignOutRestrictedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class UserBusinessService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUser(final String userUuid, final String authorizationToken) throws AuthorizationFailedException,UserNotFoundException{
        UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to get user details");
            }

            UserEntity userEntity = userDao.getUserByUUID(userUuid);
            if (userEntity == null){
                throw new UserNotFoundException("USR-001", "User with entered uuid does not exist");
            }
            return userEntity;
        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity signOut(final String authorizationToken) throws AuthenticationFailedException, SignOutRestrictedException {
        UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
        if(userAuthTokenEntity != null){
            return userDao.SignOut(userAuthTokenEntity);
        }else{
            throw new SignOutRestrictedException("SGR-001", "User is not Signed in");

        }


    }
}
