package com.sysmap.mslearningattendance.controllers.inputDtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class InputAttendanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean attendanceStatus;
}
