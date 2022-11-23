package com.miu.integration;


import com.miu.service.dto.CustomerDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private KafkaTemplate<String, CustomerDto> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String,CustomerDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic ,CustomerDto customerDto) {


            kafkaTemplate.send(topic,customerDto);

    }
}
