package com.sana.StudentsSystem.controller;

import com.sana.StudentsSystem.model.Student;
import com.sana.StudentsSystem.repository.StudentRepository;
import com.sana.StudentsSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController
{
    @Autowired
    private StudentService studentService ;

    @PostMapping("/add")
    public  String add(@RequestBody Student student)
    {
        studentService.saveStudent(student);
        return "New Student is added !!";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id){
        try{
            Student existingStuden=studentService.getStudentById(id);
            studentService.saveStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        studentService.delete(id);
        return "Deleted Student with id "+id;
    }
    
}
