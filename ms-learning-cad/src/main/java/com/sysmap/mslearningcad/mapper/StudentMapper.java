package com.sysmap.mslearningcad.mapper;

import com.sysmap.mslearningcad.controllers.inputDtos.InputStudentDTO;
import com.sysmap.mslearningcad.domains.Student;
import com.sysmap.mslearningcad.services.client.CourseFeignClient;
import com.sysmap.mslearningcad.services.exceptions.CourseNotFoundException;
import com.sysmap.mslearningcad.services.resultDtos.ResultCourseDTO;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class StudentMapper {

    private final CourseFeignClient feignClient;

    public StudentMapper(CourseFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public Student mapper(InputStudentDTO dto) {
        ResponseEntity<ResultCourseDTO> result = callBack(dto.getCourseId());
        return Student.builder()
                .birthDate(dto.getBirthDate())
                .studentId(UUID.randomUUID())
                .createdOn(LocalDateTime.now())
                .status(true)
                .courseId(result.getBody().getCourseId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .document(dto.getDocument()).build();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResultCourseDTO> callBack(UUID id) {
        try {
            return feignClient.findByCourse(id);
        } catch (FeignException e) {
            throw new CourseNotFoundException("Curso não encontrado");
        }
    }
}
