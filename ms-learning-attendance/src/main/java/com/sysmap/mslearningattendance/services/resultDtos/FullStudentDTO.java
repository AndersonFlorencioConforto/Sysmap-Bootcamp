package com.sysmap.mslearningattendance.services.resultDtos;

import lombok.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String courseName;
}
