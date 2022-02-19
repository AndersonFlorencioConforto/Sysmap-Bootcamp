package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.controllers.inputDtos.InputStudentDTO;
import com.sysmap.mslearningcad.domains.Student;
import com.sysmap.mslearningcad.mapper.StudentMapper;
import com.sysmap.mslearningcad.repositories.StudentRepository;
import com.sysmap.mslearningcad.services.exceptions.CourseNotFoundException;
import com.sysmap.mslearningcad.services.resultDtos.KafkaEventStudentDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultCourseDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultFullStudentDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultStudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final KafkaService kafkaService;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper, KafkaService kafkaService, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.kafkaService = kafkaService;
        this.studentMapper = studentMapper;
    }

    @Transactional
    @Override
    public ResultStudentDTO create(InputStudentDTO dto) {
        Student student = studentMapper.mapper(dto);
        studentRepository.save(student);
        kafkaService.eventStudent(kafkaEvent(student));
        return modelMapper.map(student, ResultStudentDTO.class);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultFullStudentDTO findByStudendId(UUID id) {
        log.info("Buscando Student");
        Optional<Student> byStudentId = studentRepository.findByStudentId(id);
        Student student = byStudentId.orElseThrow(() -> new CourseNotFoundException("Estudante não encontrado"));
        ResultFullStudentDTO map = modelMapper.map(student, ResultFullStudentDTO.class);
        ResponseEntity<ResultCourseDTO> callBack = studentMapper.callBack(student.getCourseId());
        map.setCourseName(callBack.getBody().getCourseName());
        map.setFullName(student.getFirstName() + " " + student.getLastName());
        return map;
    }

    @Override
    public KafkaEventStudentDTO kafkaEvent(Student save) {
        KafkaEventStudentDTO eventStudentDTO = new KafkaEventStudentDTO();
        eventStudentDTO.setStudentId(save.getStudentId());
        eventStudentDTO.setFullName(save.getFirstName() + " " + save.getLastName());
        eventStudentDTO.setCourseId(save.getCourseId());
        return eventStudentDTO;
    }
}
