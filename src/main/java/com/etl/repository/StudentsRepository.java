package com.etl.repository;

import com.etl.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student,Long> {

}
