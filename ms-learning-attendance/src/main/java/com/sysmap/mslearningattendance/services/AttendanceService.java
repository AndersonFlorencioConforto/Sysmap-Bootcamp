package com.sysmap.mslearningattendance.services;

import com.sysmap.mslearningattendance.controllers.inputDtos.InputAttendanceDTO;
import java.util.UUID;

public interface AttendanceService {

    InputAttendanceDTO create(InputAttendanceDTO dto, UUID courseId, UUID studentId);
}
