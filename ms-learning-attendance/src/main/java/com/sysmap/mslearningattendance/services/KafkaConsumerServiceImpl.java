package com.sysmap.mslearningattendance.services;

import com.google.gson.Gson;
import com.sysmap.mslearningattendance.domains.Student;
import com.sysmap.mslearningattendance.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumeService {

    private final StudentRepository studentRepository;

    public KafkaConsumerServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @KafkaListener(topics = "topic-student",groupId = "group-1",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, com.acme.avro.Student> payload) {
        com.acme.avro.Student student = payload.value();
        Student entity = new Student();
        entity.setCourseId(UUID.fromString(student.getCourseId()));
        entity.setStudentId(UUID.fromString(student.getStudentId()));
        entity.setFullName(student.getFullName());
        studentRepository.save(entity);
        log.info("{}",student);
    }
}
