package com.sysmap.mslearningcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MsLearningCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLearningCourseApplication.class, args);
    }

}
