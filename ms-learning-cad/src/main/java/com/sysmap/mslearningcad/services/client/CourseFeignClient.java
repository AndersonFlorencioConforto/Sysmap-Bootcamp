package com.sysmap.mslearningcad.services.client;

import com.sysmap.mslearningcad.services.resultDtos.ResultCourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.UUID;
@FeignClient(value = "ms-learning-cad",url = "${course-url}")
public interface CourseFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<ResultCourseDTO> findByCourse(@PathVariable UUID id);
}
