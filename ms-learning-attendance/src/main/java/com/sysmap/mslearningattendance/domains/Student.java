package com.sysmap.mslearningattendance.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}
