package com.sysmap.mslearningcourse.controllers.inputDtos;

import com.sysmap.mslearningcourse.services.validation.CourseInsertValid;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@CourseInsertValid
@NoArgsConstructor
public class InputCourseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(min = 3, max = 60, message = "Deve conter entre 3 e 60 caracteres.")
    @NotBlank(message = "Campo requerido.")
    private String courseName;

}
