package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.controllers.inputDtos.InputStudentDTO;
import com.sysmap.mslearningcad.domains.Student;
import com.sysmap.mslearningcad.services.resultDtos.KafkaEventStudentDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultFullStudentDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultStudentDTO;
import java.util.UUID;

public interface StudentService {

    ResultStudentDTO create(InputStudentDTO dto);
    ResultFullStudentDTO findByStudendId(UUID id);
    KafkaEventStudentDTO kafkaEvent(Student save);
}
