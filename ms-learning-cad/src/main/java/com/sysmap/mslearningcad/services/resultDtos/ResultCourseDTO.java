package com.sysmap.mslearningcad.services.resultDtos;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultCourseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID courseId;
    private String courseName;
}
