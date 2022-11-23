package com.miu.integration;

import com.miu.service.dto.BookDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private KafkaTemplate<String, BookDto> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String,BookDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic ,BookDto bookDto) {


            kafkaTemplate.send(topic,bookDto);

    }
}
