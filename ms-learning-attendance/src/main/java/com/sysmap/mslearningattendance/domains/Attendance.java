package com.sysmap.mslearningattendance.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RedisHash("Attendance")
public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID attendanceId;
    @Indexed
    private UUID studentId;
    private UUID courseId;
    private LocalDateTime classDate;
    private boolean attendanceStatus;
    //teste
}
