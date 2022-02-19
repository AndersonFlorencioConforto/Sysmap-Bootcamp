package com.sysmap.mslearningcourse.controllers;

import com.sysmap.mslearningcourse.controllers.inputDtos.InputCourseDTO;
import com.sysmap.mslearningcourse.services.CourseService;
import com.sysmap.mslearningcourse.services.resultDtos.ResultCourseDTO;
import com.sysmap.mslearningcourse.services.resultDtos.ResultFullCourseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "API REST COURSES")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/course")
    @ApiOperation(value = "Método responsável por criar um curso")
    public ResponseEntity<ResultCourseDTO> create(@Valid @RequestBody InputCourseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(dto));
    }

    @GetMapping(value = "/courses")//produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Método responsável por retornar um curso com Id específico ou uma lista de cursos caso id não for passado")
    public ResponseEntity<Page<ResultFullCourseDTO>> findByIdOrList(Pageable pageable, @RequestParam(required = false, name = "id") UUID id) {
        if (id != null) {
            return ResponseEntity.ok().body(courseService.findById(id, pageable));
        }
            return ResponseEntity.ok().body(courseService.findByPaged(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResultFullCourseDTO> findByCourseId(@PathVariable UUID id){
        return ResponseEntity.ok().body(courseService.findByCourseId(id));
    }
}
