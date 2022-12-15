package com.accenture.PocVivoPublishEventBilling.controller;

import com.accenture.PocVivoPublishEventBilling.model.*;
import com.accenture.PocVivoPublishEventBilling.service.TopicProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T21:16:01.493Z")

@Controller
public class ListenerApiController implements ListenerApi {

    private static final Logger log = LoggerFactory.getLogger(ListenerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final TopicProducer topicProducer;

    @org.springframework.beans.factory.annotation.Autowired
    public ListenerApiController(ObjectMapper objectMapper, HttpServletRequest request, TopicProducer topicProducer) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.topicProducer = topicProducer;
    }

    public ResponseEntity<EventSubscription> listenToFinancialAccountCreateEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountCreateEvent data) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            topicProducer.send(data);
            EventSubscription eventSubscription = objectMapper.convertValue(data, EventSubscription.class);
            eventSubscription.setId(UUID.randomUUID().toString());
            eventSubscription.setCallback("Event Created");
            eventSubscription.setQuery("id='"+data.getEventId()+"'");
            return new ResponseEntity<EventSubscription>(eventSubscription, HttpStatus.CREATED);
        }
        return new ResponseEntity<EventSubscription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EventSubscription> listenToFinancialAccountDeleteEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountDeleteEvent data) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EventSubscription>(objectMapper.readValue("{\"empty\": false}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EventSubscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EventSubscription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EventSubscription> listenToFinancialAccountStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountStateChangeEvent data) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EventSubscription>(objectMapper.readValue("{\"empty\": false}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EventSubscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EventSubscription>(HttpStatus.NOT_IMPLEMENTED);
    }
}
