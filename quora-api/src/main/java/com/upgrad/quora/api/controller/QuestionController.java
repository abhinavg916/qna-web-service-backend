package com.upgrad.quora.api.controller;

import com.upgrad.quora.service.business.QuestionBusinessService;

import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upgrad.quora.api.model.QuestionResponse;
import com.upgrad.quora.api.model.QuestionRequest;
import com.upgrad.quora.api.model.QuestionEditRequest;
import com.upgrad.quora.api.model.QuestionEditResponse;
import com.upgrad.quora.api.model.QuestionDeleteResponse;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/")
public class QuestionController {

    @Autowired
    private QuestionBusinessService questionBusinessService;

    @RequestMapping(method = RequestMethod.POST, path = "/question/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionResponse> CreateQuestion(final QuestionRequest questionRequest,@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {


        String [] bearerToken = authorization.split("Bearer ");

        final QuestionEntity questionEntity = new QuestionEntity();

       questionEntity.setContent(questionRequest.getContent());
       questionEntity.setDate(ZonedDateTime.now());
       questionEntity.setUuid(UUID.randomUUID().toString());

        final QuestionEntity createdquestionEntity = questionBusinessService.CreateQuestion(questionEntity,bearerToken[0]);
        QuestionResponse questionResponse = new QuestionResponse().id(createdquestionEntity.getUuid()).status("QUESTION CREATED");

        return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/question/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getAllQuestion(@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException
    {
        String [] bearerToken = authorization.split("Bearer ");

        final List<QuestionEntity> questionEntity = questionBusinessService.getAllQuestion(bearerToken[0]);
        //final MultiValueMap<String, String> mMap = new LinkedMultiValueMap<>();

        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (QuestionEntity n : questionEntity) {
            JSONObject Entity = new JSONObject();
            Entity.put("uuid", n.getUuid());
            Entity.put("content", n.getContent());
            entities.add(Entity);
        }

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
        //return new ResponseEntity<List<QuestionRequest>>(mMap, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/question/edit/{questionId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionEditResponse> EditQuestion(final QuestionEditRequest questionEditRequest,@PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, InvalidQuestionException {

        String [] bearerToken = authorization.split("Bearer ");

        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setContent(questionEditRequest.getContent());

        final QuestionEntity editquestionEntity = questionBusinessService.EditQuestion(questionEntity,questionId,bearerToken[0]);

        QuestionEditResponse questionEditResponse = new QuestionEditResponse().id(editquestionEntity.getUuid()).status("QUESTION EDITED");

        return new ResponseEntity<QuestionEditResponse>(questionEditResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/question/delete/{questionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionDeleteResponse> DeleteQuestion(@PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, InvalidQuestionException
    {
        String [] bearerToken = authorization.split("Bearer ");
        final QuestionEntity questionEntity = questionBusinessService.DeleteQuestion(questionId,bearerToken[0]);

        QuestionDeleteResponse questionDeleteResponse = new QuestionDeleteResponse().id(questionEntity.getUuid()).status("QUESTION DELETED");

        return new ResponseEntity<QuestionDeleteResponse>(questionDeleteResponse, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "question/all/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> getAllQuestionByUser(@PathVariable("userId") final String userId,@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, UserNotFoundException
    {
        String [] bearerToken = authorization.split("Bearer ");

        final List<QuestionEntity> questionEntity = questionBusinessService.getAllQuestionByUser(userId,bearerToken[0]);

        List<JSONObject> entit = new ArrayList<JSONObject>();
        for (QuestionEntity n : questionEntity) {
            JSONObject Entitys = new JSONObject();
            Entitys.put("uuid", n.getUuid());
            Entitys.put("content", n.getContent());
            entit.add(Entitys);
        }

        return new ResponseEntity<Object>(entit, HttpStatus.OK);
    }
}
