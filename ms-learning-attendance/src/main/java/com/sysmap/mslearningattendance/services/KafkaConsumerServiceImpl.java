package com.sysmap.mslearningattendance.services;

import com.google.gson.Gson;
import com.sysmap.mslearningattendance.domains.Student;
import com.sysmap.mslearningattendance.repositories.StudentRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerServiceImpl implements KafkaConsumeService {

    private final StudentRepository studentRepository;

    public KafkaConsumerServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @KafkaListener(topics = "topic-student",groupId = "group-1",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String,String> payload) {
        Gson gson = new Gson();
        var student = gson.fromJson(payload.value(), Student.class);
        Student entity = new Student();
        entity.setCourseId(student.getCourseId());
        entity.setStudentId(student.getStudentId());
        entity.setFullName(student.getFullName());
        studentRepository.save(entity);
    }
}
