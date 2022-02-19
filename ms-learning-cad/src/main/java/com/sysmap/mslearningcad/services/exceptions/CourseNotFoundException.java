package com.sysmap.mslearningcad.services.exceptions;


public class CourseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(String msg) {
        super(msg);
    }


}
