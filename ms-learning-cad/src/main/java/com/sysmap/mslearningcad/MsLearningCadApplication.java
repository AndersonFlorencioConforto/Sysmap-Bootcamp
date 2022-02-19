package com.sysmap.mslearningcad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsLearningCadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLearningCadApplication.class, args);
    }

}
