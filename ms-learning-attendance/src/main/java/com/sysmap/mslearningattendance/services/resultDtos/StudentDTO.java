package com.sysmap.mslearningattendance.services.resultDtos;

import com.sysmap.mslearningattendance.domains.Attendance;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String courseName;
    private List<AttendanceDTO> attendances = new ArrayList<>();
}
