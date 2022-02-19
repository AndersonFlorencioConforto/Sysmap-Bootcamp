package com.sysmap.mslearningattendance.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumeService {

    void listen(ConsumerRecord<String,String> payload);
}
