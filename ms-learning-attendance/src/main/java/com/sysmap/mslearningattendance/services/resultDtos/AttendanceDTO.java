package com.sysmap.mslearningattendance.services.resultDtos;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AttendanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID courseId;
    private LocalDateTime classDate;
    private boolean attendanceStatus;
}
