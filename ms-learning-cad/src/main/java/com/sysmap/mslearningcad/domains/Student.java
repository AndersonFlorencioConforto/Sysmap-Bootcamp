package com.sysmap.mslearningcad.domains;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@Document(collection = "tb_student")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Indexed(unique = true)
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String document;
    private LocalDate birthDate;
    private UUID courseId;
    private boolean status;
    private LocalDateTime createdOn;
}
