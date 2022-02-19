package com.sysmap.mslearningcourse.repositories;

import com.sysmap.mslearningcourse.domains.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {

    Optional<Course> findByCourseId(UUID id);
    Page findByCourseId(Pageable page,UUID id);
    Course findByCourseName(String name);
}
