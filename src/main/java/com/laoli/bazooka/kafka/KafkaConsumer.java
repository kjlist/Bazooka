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



    @KafkaListener(id = "listen1", topics = "topic-demo1", groupId = "con-group1")
    public void listen1(ConsumerRecord<?, ?> record) throws Exception {
        logger.info("1 topic = {}, partition = {} ,offset = {}, value = {} ", record.topic(),record.partition(), record.offset(), record.value());

    }
}
