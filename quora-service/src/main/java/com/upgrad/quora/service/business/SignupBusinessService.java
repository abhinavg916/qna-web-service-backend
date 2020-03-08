package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(final UserEntity userentity) throws SignUpRestrictedException {
        UserEntity userEntity =  userDao.getUserName(userentity.getUserName());

        if (userEntity != null) {
            throw new SignUpRestrictedException("SGR-001", "Try any other Username, this Username has already been taken");
        }

        UserEntity userEntitys =  userDao.getUserByEmail(userentity.getEmail());
        if (userEntitys != null) {
            throw new SignUpRestrictedException("SGR-002", "This user has already been registered, try with any other emailId");
        }

        String password = userentity.getPassword();
        if (password == null) {

        }

        String[] encryptedText = cryptographyProvider.encrypt(userentity.getPassword());
        userentity.setSalt(encryptedText[0]);
        userentity.setPassword(encryptedText[1]);
        return userDao.createUser(userentity);

    }
}
