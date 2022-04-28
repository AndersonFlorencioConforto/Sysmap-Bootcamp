package com.sysmap.mslearningattendance.services;

import com.acme.avro.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumeService {

    void listen(ConsumerRecord<String, Student> payload);
}
