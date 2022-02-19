package com.sysmap.mslearningcad.services.resultDtos;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID studentId;
}
