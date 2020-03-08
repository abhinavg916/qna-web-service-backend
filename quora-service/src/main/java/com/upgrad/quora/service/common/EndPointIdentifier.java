package com.upgrad.quora.service.common;

/**
 * @author Manish Rout (https://github.com/mnshrt)
 * Description - Interface for constant used for identifying checkpoints
 */
public interface EndPointIdentifier {
    String USER_ENDPOINT="User is signed out.Sign in first to get user details";
    String ADMIN_ENDPOINT="User is signed out";
    String QUESTION_ENDPOINT="User is signed out.Sign in first to post a question";
    String ANSWER_ENDPOINT="User is signed out.Sign in first to edit an answer";
    String GET_ALL_QUESTIONS="User is signed out.Sign in first to get all questions";
    String CHECK_QUESTION="User is signed out.Sign in first to edit the question";
    String DELETE_QUESTION="User is signed out.Sign in first to delete the question";
    String GET_QUESTION_BY_USER="User is signed out.Sign in first to get all questions posted by a specific user";
    String CHECK_ANSWER = "User is signed out.Sign in first to edit the answer";
    String DELETE_ANSWER = "User is signed out.Sign in first to delete the answer";
    String GET_ALL_ANSWERS = "User is signed out.Sign in first to get the answers";
}
