package com.sysmap.mslearningcourse.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.sysmap.mslearningcourse.controllers.exceptions.FieldMessage;
import com.sysmap.mslearningcourse.controllers.inputDtos.InputCourseDTO;
import com.sysmap.mslearningcourse.domains.Course;
import com.sysmap.mslearningcourse.repositories.CourseRepository;

public class CourseInsertValidator implements ConstraintValidator<CourseInsertValid, InputCourseDTO> {


    private final CourseRepository courseRepository;

    public CourseInsertValidator(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void initialize(CourseInsertValid ann) {
    }

    @Override
    public boolean isValid(InputCourseDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        Course byCourseName = courseRepository.findByCourseName(dto.getCourseName());
        if (byCourseName != null) {
            list.add(new FieldMessage("courseName","Curso já existente na base de dados"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}

