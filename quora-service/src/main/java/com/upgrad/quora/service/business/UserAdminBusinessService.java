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
import java.util.UUID;

@Service
public class UserAdminBusinessService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordCryptographyProvider CryptographyProvider;

    public UserEntity DeleteUser(final String userid, final String authorizationToken) throws AuthorizationFailedException, UserNotFoundException {
        UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out");
            }

            UserEntity userEntity = userDao.getUserByUUID(userid);
            if (userEntity == null){
                throw new UserNotFoundException("USR-001", "User with entered uuid to be deleted does not exist");
            }
            else
            {
                String RoleName = userEntity.getRole();
                if (!RoleName.equals("admin")){
                    throw new AuthorizationFailedException("ATHR-003", "Unauthorized Access,Entered user is not an admin");
                }

            }

            return userDao.DeleteUser(userEntity);
        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity authenticate(final String username, final String password) throws AuthenticationFailedException {
        UserEntity userEntity = userDao.getUserName(username);
        if (userEntity == null) {
            throw new AuthenticationFailedException("ATH-001", "This username does not exist");
        }

        //final String encryptedPassword = CryptographyProvider.encrypt(password, userEntity.getSalt());
        if (password.equals(userEntity.getPassword())) {
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(password);
            UserAuthTokenEntity userAuthTokenEntity = new UserAuthTokenEntity();
            userAuthTokenEntity.setUser(userEntity);
            final ZonedDateTime now = ZonedDateTime.now();
            final ZonedDateTime expiresAt = now.plusHours(8);

            userAuthTokenEntity.setAccessToken(jwtTokenProvider.generateToken(userEntity.getUuid(), now, expiresAt));

            userAuthTokenEntity.setLoginAt(now);
            userAuthTokenEntity.setExpiresAt(expiresAt);
            userAuthTokenEntity.setUuid(UUID.randomUUID().toString());
            userDao.createAuthToken(userAuthTokenEntity);

            userDao.updateUser(userEntity);
             return userAuthTokenEntity;
        } else {
            throw new AuthenticationFailedException("ATH-002", "Password failed");
        }
    }



}
