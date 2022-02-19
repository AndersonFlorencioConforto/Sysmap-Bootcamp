package com.sysmap.mslearningattendance.controllers;

import com.sysmap.mslearningattendance.services.StudentService;
import com.sysmap.mslearningattendance.services.StudentServiceImpl;
import com.sysmap.mslearningattendance.services.resultDtos.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1")
public class StudentAttendanceController {

    private final StudentService studentService;

    public StudentAttendanceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/student/{studentId}/attendances")
    public ResponseEntity<StudentDTO> findAttendancesByStudent (@PathVariable UUID studentId) {
        return ResponseEntity.ok().body(studentService.findAttendancesByStudent(studentId));
    }
}
