package com.sysmap.mslearningattendance.services;

import com.sysmap.mslearningattendance.domains.Attendance;
import com.sysmap.mslearningattendance.repositories.AttendanceRepository;
import com.sysmap.mslearningattendance.services.client.StudentClient;
import com.sysmap.mslearningattendance.services.exceptions.ResourceNotFoundException;
import com.sysmap.mslearningattendance.services.resultDtos.AttendanceDTO;
import com.sysmap.mslearningattendance.services.resultDtos.FullStudentDTO;
import com.sysmap.mslearningattendance.services.resultDtos.StudentDTO;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentClient studentClient;
    private final AttendanceRepository attendanceRepository;

    public StudentServiceImpl(ModelMapper modelMapper, StudentClient studentClient, AttendanceRepository attendanceRepository) {
        this.modelMapper = modelMapper;
        this.studentClient = studentClient;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    @Transactional
    public StudentDTO findAttendancesByStudent(UUID studentId) {
        ResponseEntity<FullStudentDTO> student = callBack(studentId);
        StudentDTO studentDTO = new StudentDTO();
        List<Attendance> attendance = attendanceRepository.findAllByStudentId(studentId);
        studentDTO.setFullName(student.getBody().getFullName());
        studentDTO.setCourseName(student.getBody().getCourseName());
        for (Attendance att: attendance) {
            AttendanceDTO map = modelMapper.map(att, AttendanceDTO.class);
            studentDTO.getAttendances().add(map);
        }
        return studentDTO;
    }

    private ResponseEntity<FullStudentDTO> callBack(UUID studentId) {
        try {
            return studentClient.findByStudentId(studentId);
        } catch (FeignException e) {
            throw new ResourceNotFoundException("Student not found");
        }
    }

}
