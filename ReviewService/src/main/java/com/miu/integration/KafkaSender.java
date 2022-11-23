package com.miu.integration;

import com.miu.service.dto.ReviewDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    private KafkaTemplate<String, ReviewDto> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String,ReviewDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic ,ReviewDto bookDto) {
        kafkaTemplate.send(topic,bookDto);

    }
}
