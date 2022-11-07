package com.accenture.publishesbillingdata.controller;

import com.accenture.publishesbillingdata.service.TopicProducer;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class PublishKafkaController {
    private final TopicProducer topicProducer;
    @GetMapping(value = "/send")
    public void send(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody String data){
        topicProducer.send(data);
    }
}
