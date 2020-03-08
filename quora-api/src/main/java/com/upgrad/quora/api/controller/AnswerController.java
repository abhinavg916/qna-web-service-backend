package com.upgrad.quora.api.controller;

import com.upgrad.quora.api.model.AnswerRequest;
import com.upgrad.quora.api.model.AnswerResponse;
import com.upgrad.quora.api.model.QuestionRequest;
import com.upgrad.quora.api.model.QuestionResponse;
import com.upgrad.quora.service.business.AnswerBusinessService;
import com.upgrad.quora.service.business.QuestionBusinessService;
import com.upgrad.quora.service.entity.AnswerEntity;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.exception.AnswerNotFoundException;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/")
public class AnswerController {
    @Autowired
    private AnswerBusinessService answerBusinessService;

    @RequestMapping(method = RequestMethod.POST, path = "/question/{questionId}/answer/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AnswerResponse> CreateAnswer(final AnswerRequest answerRequest, @PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException , InvalidQuestionException {


        String [] bearerToken = authorization.split("Bearer ");

        final AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setContent(answerRequest.getAnswer());
        answerEntity.setDate(ZonedDateTime.now());
        answerEntity.setUuid(UUID.randomUUID().toString());

        final AnswerEntity answerEntity1 = answerBusinessService.CreateAnswer( answerEntity,questionId,bearerToken[0]);
        AnswerResponse answerResponse = new AnswerResponse().id(answerEntity1.getUuid()).status("ANSWER CREATED");

        return new ResponseEntity<AnswerResponse>(answerResponse, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/answer/edit/{answerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AnswerResponse> editAnswerContent (final AnswerRequest answerRequest, @PathVariable("answerId") final String answerId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException , AnswerNotFoundException {


        String [] bearerToken = authorization.split("Bearer ");

        final AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setContent(answerRequest.getAnswer());


        final AnswerEntity answerEntity1 = answerBusinessService.editAnswer( answerEntity,answerId,bearerToken[0]);
        AnswerResponse answerResponse = new AnswerResponse().id(answerEntity1.getUuid()).status("ANSWER EDITED");

        return new ResponseEntity<AnswerResponse>(answerResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/answer/delete/{answerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AnswerResponse> deleteAnswer  ( @PathVariable("answerId") final String answerId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException , AnswerNotFoundException {


        String [] bearerToken = authorization.split("Bearer ");



        final boolean checkdelete = answerBusinessService.deleteAnswer( answerId,bearerToken[0]);
        AnswerResponse answerResponse = new AnswerResponse().id(answerId).status("ANSWER DELETED");

        return new ResponseEntity<AnswerResponse>(answerResponse, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/answer/all/{questionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getAllAnswersToQuestion   ( @PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException , InvalidQuestionException {


        String [] bearerToken = authorization.split("Bearer ");


        List<AnswerEntity> allQuestionAnswer = answerBusinessService.getAllQuestionAnswer(questionId, bearerToken[0]);
         List<JSONObject> entities = new ArrayList<JSONObject>();
        for (AnswerEntity n : allQuestionAnswer) {
            JSONObject Entity = new JSONObject();
            Entity.put("uuid", n.getUuid());
            Entity.put("content", n.getContent());
            entities.add(Entity);
        }

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }
}
