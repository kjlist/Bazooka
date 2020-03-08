package com.laoli.bazooka.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);



    @KafkaListener(id = "vitolisten0308", topics = "topic-demo1", groupId = "vitocon-group1")
    public void listen1(ConsumerRecord<?, ?> record) throws Exception {
        logger.info("vitolisten0308---topic = {}, partition = {} ,offset = {}, value = {} ", record.topic(),record.partition(), record.offset(), record.value());

    }
}
