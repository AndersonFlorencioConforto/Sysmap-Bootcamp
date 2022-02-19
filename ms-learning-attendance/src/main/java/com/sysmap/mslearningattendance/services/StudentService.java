package com.sysmap.mslearningattendance.services;

import com.sysmap.mslearningattendance.services.resultDtos.StudentDTO;
import java.util.UUID;

public interface StudentService {

    StudentDTO findAttendancesByStudent(UUID studentId);
}
