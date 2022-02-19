package com.sysmap.mslearningcad.services.resultDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultFullStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String document;
    private LocalDate birthDate;
    private String courseName;
    private boolean status;
}
