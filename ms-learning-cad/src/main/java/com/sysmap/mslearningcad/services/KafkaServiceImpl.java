package com.sysmap.mslearningcad.services;

import com.acme.avro.Student;
import com.sysmap.mslearningcad.mapper.StudentMapper;
import com.sysmap.mslearningcad.services.resultDtos.KafkaEventStudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    @Value("${topic.name.producer}")
    private String value;

    private final KafkaTemplate<String, Student> kafkaTemplate;
    private final StudentMapper studentMapper;

    public KafkaServiceImpl(KafkaTemplate<String, Student> kafkaTemplate, StudentMapper studentMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.studentMapper = studentMapper;
    }


    @Override
    public void eventStudent(KafkaEventStudentDTO eventStudentDTO) {
        Student student = studentMapper.builderAvro(eventStudentDTO);
        kafkaTemplate.send(value, student);
        log.info("{}", student);
    }
}
