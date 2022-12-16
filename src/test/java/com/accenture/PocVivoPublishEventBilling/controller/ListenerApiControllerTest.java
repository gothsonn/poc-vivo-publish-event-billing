package com.accenture.PocVivoPublishEventBilling.controller;

import com.accenture.PocVivoPublishEventBilling.model.EventSubscription;
import com.accenture.PocVivoPublishEventBilling.model.FinancialAccountCreateEvent;
import com.accenture.PocVivoPublishEventBilling.service.TopicProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.IOException;

@SpringBootTest
class ListenerApiControllerTest {
    public ListenerApiController listenerApiController;

    @Test
    void listenToFinancialAccountCreateEventHeaderErrorTest() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Accept", "text");

        //setup controller properties
        listenerApiController = new ListenerApiController(
                new ObjectMapper(), request, new TopicProducer(null, null)
        );

        FinancialAccountCreateEvent data = new FinancialAccountCreateEvent();
        ResponseEntity<EventSubscription> responseEntity = listenerApiController.listenToFinancialAccountCreateEvent(data);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
    }

    @Test
    void listenToFinancialAccountCreateEventEventTest() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Accept", "application/json");

        TopicProducer topicProducerMock = Mockito.mock(TopicProducer.class);

        //setup controller properties
        listenerApiController = new ListenerApiController(
                new ObjectMapper(), request, topicProducerMock
        );

        FinancialAccountCreateEvent data = new FinancialAccountCreateEvent();
        data.setEventId("VOXTROT");
        ResponseEntity<EventSubscription> responseEntity = listenerApiController.listenToFinancialAccountCreateEvent(data);

        Mockito.verify(topicProducerMock).send(data);

        Assertions.assertThat(responseEntity.getBody().getId()).isNotBlank();
        Assertions.assertThat(responseEntity.getBody().getCallback()).isEqualTo("Event Created");
        Assertions.assertThat(responseEntity.getBody().getQuery()).isEqualTo("id='VOXTROT'");
    }
}
