package com.elvis.spacey.www.Springwithamigos.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getListOfStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }


    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name ,
                              @RequestParam(required = false) String email){
        studentService.updateStudentDetails(studentId,name,email);

    }

}
