package com.sysmap.mslearningattendance.services;

import com.sysmap.mslearningattendance.controllers.inputDtos.InputAttendanceDTO;
import com.sysmap.mslearningattendance.domains.Attendance;
import com.sysmap.mslearningattendance.domains.Student;
import com.sysmap.mslearningattendance.repositories.AttendanceRepository;
import com.sysmap.mslearningattendance.repositories.StudentRepository;
import com.sysmap.mslearningattendance.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    private final AttendanceRepository attendanceRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, ModelMapper modelMapper, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    @Transactional
    @Override
    public InputAttendanceDTO create(InputAttendanceDTO dto,UUID courseId, UUID studentId){
        Optional<Student> byId = studentRepository.findById(studentId);
        if(byId.isPresent()) {
            Attendance save = attendanceRepository.save(student(dto, courseId, studentId));
            return modelMapper.map(save,InputAttendanceDTO.class);
        }else {
            throw new ResourceNotFoundException("Estudante não encontrado na base de dados");
        }
    }

    private Attendance student(InputAttendanceDTO dto,UUID courseId,UUID studentId) {
        Attendance attendance = new Attendance();
        attendance.setCourseId(courseId);
        attendance.setStudentId(studentId);
        attendance.setClassDate(LocalDateTime.now());
        attendance.setAttendanceId(UUID.randomUUID());
        attendance.setAttendanceStatus(dto.isAttendanceStatus());
        return attendance;
    }
}
