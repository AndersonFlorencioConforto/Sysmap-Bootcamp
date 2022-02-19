package com.sysmap.mslearningcad.controllers.exceptions;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
