package com.sysmap.mslearningcad.repositories;

import com.sysmap.mslearningcad.domains.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findByStudentId(UUID id);
}
