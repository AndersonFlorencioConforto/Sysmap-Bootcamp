package com.sysmap.mslearningcad.controllers;

import com.sysmap.mslearningcad.controllers.inputDtos.InputStudentDTO;
import com.sysmap.mslearningcad.services.StudentService;
import com.sysmap.mslearningcad.services.resultDtos.ResultFullStudentDTO;
import com.sysmap.mslearningcad.services.resultDtos.ResultStudentDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/student")
    @ApiOperation(value = "Método responsável por criar um estudante")
    public ResponseEntity<ResultStudentDTO> create(@Valid @RequestBody InputStudentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(dto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResultFullStudentDTO> findByStudentId(@PathVariable UUID id) {
       return ResponseEntity.ok().body(studentService.findByStudendId(id));
    }
}
