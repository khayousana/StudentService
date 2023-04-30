package com.sana.StudentsSystem.repository;

import com.sana.StudentsSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer>
{
}
