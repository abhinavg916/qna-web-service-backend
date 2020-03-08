package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public QuestionEntity createquestion(QuestionEntity questionEntity){
        entityManager.persist(questionEntity);
        return questionEntity;
    }

    @Transactional
    public QuestionEntity editquestion(QuestionEntity questionEntity){
        entityManager.merge(questionEntity);
        return questionEntity;
    }
    @Transactional
    public QuestionEntity DeleteQuestion(QuestionEntity questionEntity){
        entityManager.remove(questionEntity);

        return questionEntity;
    }
    public UserAuthTokenEntity getUserAuthToken(final String accessToken) {
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class).setParameter("accessToken", accessToken).getSingleResult();
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

    public List<QuestionEntity> getAllQuestion() {

        try {
            return entityManager.createNamedQuery("getAllQuestion", QuestionEntity.class).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<QuestionEntity> getAllQuestionByUser(final Integer UserId) {

        try {
            return entityManager.createNamedQuery("getAllQuestionByUser", QuestionEntity.class).setParameter("UserID", UserId).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public QuestionEntity getQuestionById(final String UUID) {
        try {
            return entityManager.createNamedQuery("questionByUUID", QuestionEntity.class).setParameter("UUID", UUID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
