package com.sysmap.mslearningattendance.repositories;

import com.sysmap.mslearningattendance.domains.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {

}
