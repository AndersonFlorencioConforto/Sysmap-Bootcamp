package com.sysmap.mslearningcourse.services;

import com.sysmap.mslearningcourse.controllers.inputDtos.InputCourseDTO;
import com.sysmap.mslearningcourse.domains.Course;
import com.sysmap.mslearningcourse.repositories.CourseRepository;
import com.sysmap.mslearningcourse.services.exceptions.ResourceNotFoundException;
import com.sysmap.mslearningcourse.services.resultDtos.ResultCourseDTO;
import com.sysmap.mslearningcourse.services.resultDtos.ResultFullCourseDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ResultFullCourseDTO findByCourseId(UUID id) {
        log.info("Buscando curso");
        Optional<Course> byCourseId = courseRepository.findByCourseId(id);
        Course entity = byCourseId.orElseThrow(() -> new ResourceNotFoundException("id não encontrado: " +id));
        log.info("Buscando curso {}",entity);
        return modelMapper.map(entity,ResultFullCourseDTO.class);
    }

    @Transactional
    @Override
    public ResultCourseDTO create(InputCourseDTO dto) {
        log.info("Criando um novo curso...");
        Course save = courseRepository.save(modelMapper.map(dto, Course.class));
        log.info("Curso criado {}",save);
        return modelMapper.map(save, ResultCourseDTO.class);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ResultFullCourseDTO> findById(UUID id, Pageable pageable)  {
        log.info("Buscando cursos");
        var findByCourseId = courseRepository.findByCourseId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado"));
        Page<Course> coursePage = new PageImpl<>(Arrays.asList(findByCourseId),pageable, pageable.getPageSize());
        return coursePage.map(course -> modelMapper.map(course,ResultFullCourseDTO.class));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ResultFullCourseDTO> findByPaged(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);
        return page.map(course -> modelMapper.map(course, ResultFullCourseDTO.class));
    }

}
