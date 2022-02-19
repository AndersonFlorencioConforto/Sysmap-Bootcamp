package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.services.resultDtos.KafkaEventStudentDTO;

public interface KafkaService {

    void eventStudent(KafkaEventStudentDTO eventStudentDTO);
}
