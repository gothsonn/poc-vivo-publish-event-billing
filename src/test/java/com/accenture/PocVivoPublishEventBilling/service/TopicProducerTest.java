package com.accenture.PocVivoPublishEventBilling.service;

import com.accenture.PocVivoPublishEventBilling.model.FinancialAccountCreateEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class TopicProducerTest {
    private final KafkaTemplate kafkaTemplate = Mockito.mock(KafkaTemplate.class);

    @Test
    public void sendTest(){
        TopicProducer topicProducer = new TopicProducer(
                new ObjectMapper(), kafkaTemplate
        );

        FinancialAccountCreateEvent message = new FinancialAccountCreateEvent();
        topicProducer.send(message);
        String expectedMessage = "{\"id\":null,\"href\":null,\"eventId\":null,\"eventTime\":null,\"eventType\":null,\"correlationId\":null,\"domain\":null,\"title\":null,\"description\":null,\"priority\":null,\"timeOcurred\":null,\"payload\":null}";
        Mockito.verify(kafkaTemplate).send(Mockito.isNull(String.class), Mockito.eq(expectedMessage));
    }

    @Test
    public void sendJsonProcessingExceptionErrorTest() throws JsonProcessingException {
        ObjectMapper objectMapper = Mockito.mock(ObjectMapper.class);

        TopicProducer topicProducer = new TopicProducer(
                objectMapper, kafkaTemplate
        );

        Mockito.when(objectMapper.writeValueAsString(Mockito.any())).thenThrow(
                new JsonProcessingException("FOO"){}
        );

        RuntimeException ex = Assertions.assertThrows(
                RuntimeException.class,
                () -> {
                    topicProducer.send(new FinancialAccountCreateEvent());
                },
                "Expected topicProducer.send to throw RuntimeException, but it didn't"
        );
        Assertions.assertEquals("com.accenture.PocVivoPublishEventBilling.service.TopicProducerTest$1: FOO", ex.getMessage());
    }
}
