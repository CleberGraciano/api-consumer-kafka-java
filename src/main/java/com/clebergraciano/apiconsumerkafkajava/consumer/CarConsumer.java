package com.clebergraciano.apiconsumerkafkajava.consumer;

import com.clebergraciano.apiconsumerkafkajava.dto.CarDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CarConsumer {

    private static final Logger log = LoggerFactory.getLogger(CarConsumer.class);

    @Value("${topic.name}")
    private String topic;

    @Value("${spring.kafka.group-id}")
    private String group;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, CarDto> record){
        log.info("Received Partition: "+record.partition());
        log.info("Received Message: "+record.value());
    }



}
