package com.sysmap.mslearningattendance.controllers;

import com.sysmap.mslearningattendance.controllers.inputDtos.InputAttendanceDTO;
import com.sysmap.mslearningattendance.services.AttendanceService;
import com.sysmap.mslearningattendance.services.AttendanceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping(value = "/course/{courseId}/student/{studentId}/attendance")
    public ResponseEntity<InputAttendanceDTO> create(@RequestBody InputAttendanceDTO dto, @PathVariable UUID courseId, @PathVariable UUID studentId){
        return ResponseEntity.ok().body(attendanceService.create(dto,courseId,studentId));
    }

}
