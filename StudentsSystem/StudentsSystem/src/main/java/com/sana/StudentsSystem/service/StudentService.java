package com.sana.StudentsSystem.service;

import com.sana.StudentsSystem.model.Student;

import java.util.List;

public interface StudentService
{
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Integer id);
    public void delete(Integer id );

}
