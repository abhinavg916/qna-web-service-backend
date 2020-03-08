package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.AnswerEntity;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AnswerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public AnswerEntity createAnswer(AnswerEntity answerEntity){
        entityManager.persist(answerEntity);
        return answerEntity;
    }
    @Transactional
    public AnswerEntity editAnswer(AnswerEntity answerEntity){
        entityManager.merge(answerEntity);
        return answerEntity;
    }
    @Transactional
    public boolean deleteAnswer(AnswerEntity answerEntity){
        entityManager.remove(answerEntity);
        return true;
    }
    public UserEntity getUserByUUID(final String UUID) {
        try {
            return entityManager.createNamedQuery("userByUUID", UserEntity.class).setParameter("UUID", UUID).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public QuestionEntity getQuestionById(final String id) {
        try {
            return entityManager.createNamedQuery("questionByUUID", QuestionEntity.class).setParameter("UUID", id).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    public AnswerEntity getAnswerById(final String UUID) {
        try {
            return entityManager.createNamedQuery("answerByUUID", AnswerEntity.class).setParameter("UUID", UUID).getSingleResult();
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

    public List<AnswerEntity> getAllAnswer(String id) {

        try {
            return entityManager.createNamedQuery("getAllAnswerByQuestion", AnswerEntity.class).setParameter("QUESTIONID", id).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
