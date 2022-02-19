package com.sysmap.mslearningcourse.domains;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tb_course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Indexed(unique = true)
    private UUID courseId;
    private String courseName;
    private boolean status;
    private LocalDateTime createdOn;

    public Course() {
        this.status = true;
        this.createdOn = LocalDateTime.now();
        this.courseId = UUID.randomUUID();
    }


}
