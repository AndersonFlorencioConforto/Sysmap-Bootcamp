package com.sysmap.mslearningcad.services;

import com.google.gson.Gson;
import com.sysmap.mslearningcad.services.resultDtos.KafkaEventStudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void eventStudent(KafkaEventStudentDTO eventStudentDTO) {
        Gson gson = new Gson();
        kafkaTemplate.send("topic-student",gson.toJson(eventStudentDTO));
    }
}
