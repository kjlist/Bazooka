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



    @KafkaListener(id = "vitolisten03081", topics = "topic-demo1", groupId = "likekecon-group1")
    public void listen03081(ConsumerRecord<?, ?> record) throws Exception {
        logger.info("log---listen03081---vitolisten03081");
        logger.info("log---listen03081---topic = {}, partition = {} ,offset = {}, value = {} ", record.topic(),record.partition(), record.offset(), record.value());
    }

    @KafkaListener(id = "vitolisten03081", topics = "topic-demo1", groupId = "likekecon-group1")
    public void listen03082(ConsumerRecord<?, ?> record) throws Exception {
        logger.info("log---listen03082---vitolisten03081");
        logger.info("log---listen03082---topic = {}, partition = {} ,offset = {}, value = {} ", record.topic(),record.partition(), record.offset(), record.value());
    }
}
