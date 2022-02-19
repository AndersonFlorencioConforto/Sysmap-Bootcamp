package com.sysmap.mslearningcad.services.resultDtos;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KafkaEventStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID studentId;
    private String fullName;
    private UUID courseId;

}
