package com.sysmap.mslearningcourse.services;

import com.sysmap.mslearningcourse.controllers.inputDtos.InputCourseDTO;
import com.sysmap.mslearningcourse.services.resultDtos.ResultCourseDTO;
import com.sysmap.mslearningcourse.services.resultDtos.ResultFullCourseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface CourseService {

    ResultFullCourseDTO findByCourseId(UUID id);
    ResultCourseDTO create(InputCourseDTO dto);
    Page<ResultFullCourseDTO> findById(UUID id, Pageable pageable);
    Page<ResultFullCourseDTO> findByPaged(Pageable pageable);
}
