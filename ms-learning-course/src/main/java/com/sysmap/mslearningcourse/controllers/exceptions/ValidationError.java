package com.sysmap.mslearningcourse.controllers.exceptions;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldName,String message) {
        errors.add(new FieldMessage(fieldName,message));
    }
}
