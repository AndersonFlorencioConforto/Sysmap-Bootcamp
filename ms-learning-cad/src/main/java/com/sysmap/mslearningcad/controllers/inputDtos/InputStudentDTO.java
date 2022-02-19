package com.sysmap.mslearningcad.controllers.inputDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputStudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String document;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private UUID courseId;
}
