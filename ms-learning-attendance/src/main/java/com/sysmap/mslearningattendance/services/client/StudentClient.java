package com.sysmap.mslearningattendance.services.client;

import com.sysmap.mslearningattendance.services.resultDtos.FullStudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "ms-learning-attendance", url = "${student-url}")
public interface StudentClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<FullStudentDTO> findByStudentId(@PathVariable UUID id);
}
