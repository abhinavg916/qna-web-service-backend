package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.AnswerDao;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.AnswerEntity;

import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.AnswerNotFoundException;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AnswerBusinessService {
    @Autowired
    private AnswerDao answerDao;


    public AnswerEntity CreateAnswer(final AnswerEntity answerEntity,final String questionId, final String authorizationToken) throws AuthorizationFailedException,InvalidQuestionException {

        UserAuthTokenEntity userAuthTokenEntity = answerDao.getUserAuthToken(authorizationToken);

        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to post an answer");
            }
                QuestionEntity questionEntity1 = answerDao.getQuestionById(questionId);
            if(questionEntity1 != null){
                answerEntity.setQuestion(questionEntity1);
                UserEntity userEntity = answerDao.getUserByUUID(userAuthTokenEntity.getUuid());
                if(userEntity != null){
                    answerEntity.setUser(userEntity);
                    return answerDao.createAnswer(answerEntity);
                }
            }else{
                throw new InvalidQuestionException("QUES-001", "The question entered is invalid");

            }

        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }

    public AnswerEntity editAnswer(final AnswerEntity answerEntity,final String answerid, final String authorizationToken) throws AuthorizationFailedException ,AnswerNotFoundException{


        UserAuthTokenEntity userAuthTokenEntity = answerDao.getUserAuthToken(authorizationToken);

        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to edit an answer");
            }
            AnswerEntity answerEntity1 = answerDao.getAnswerById(answerid);
            if(answerEntity1 != null){
                 UserEntity userEntity = answerDao.getUserByUUID(userAuthTokenEntity.getUuid());
                if(answerEntity1.getUser().getId().equals(userEntity.getId()) ){
                    answerEntity1.setContent(answerEntity.getContent());
                     return answerDao.editAnswer(answerEntity1);
                }else{
                    throw new AnswerNotFoundException("ANS-001", "Entered answer uuid does not exist");

                }
            }else{
                throw new AuthorizationFailedException("ATHR-003", "Only the answer owner can edit the answer");

            }

        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }

    public boolean deleteAnswer( final String answerid, final String authorizationToken) throws AuthorizationFailedException ,AnswerNotFoundException{


        UserAuthTokenEntity userAuthTokenEntity = answerDao.getUserAuthToken(authorizationToken);

        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to delete an answer");
            }
            AnswerEntity answerEntity1 = answerDao.getAnswerById(answerid);
            if(answerEntity1 != null){
                UserEntity userEntity = answerDao.getUserByUUID(userAuthTokenEntity.getUuid());
                if (answerEntity1.getUser() == userAuthTokenEntity.getUser() || userEntity.getRole().equals("admin"))
                {
                    return answerDao.deleteAnswer(answerEntity1);
                }else{
                    throw new AnswerNotFoundException("ANS-001", "Entered answer uuid does not exist");
                }
            }else{
                throw new AuthorizationFailedException("ATHR-003", "Only the answer owner or admin can delete the answer");

            }

        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }
    public  List<AnswerEntity> getAllQuestionAnswer( final String questionId, final String authorizationToken) throws AuthorizationFailedException ,InvalidQuestionException{


        UserAuthTokenEntity userAuthTokenEntity = answerDao.getUserAuthToken(authorizationToken);

        if(userAuthTokenEntity != null){
            ZonedDateTime logout = userAuthTokenEntity.getLogoutAt();
            if (logout != null) {
                throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to get the answers");
            }
            QuestionEntity questionById = answerDao.getQuestionById(questionId);
                if(questionById != null){
                     List<AnswerEntity> allAnswer = answerDao.getAllAnswer(questionById.getUuid());
                    return allAnswer;
                }else{
                    throw new InvalidQuestionException("QUES-001", "The question with entered uuid whose details are to be seen does not exist");

                }
        }

        throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
    }

}
