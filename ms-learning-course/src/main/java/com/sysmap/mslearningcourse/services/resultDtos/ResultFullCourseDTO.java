package com.sysmap.mslearningcourse.services.resultDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultFullCourseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID courseId;
    private String courseName;
    private boolean status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdOn;
}
