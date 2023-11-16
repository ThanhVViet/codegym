package com.codegym.webservice.controller;

import com.codegym.webservice.dto.StudentDto;
import com.codegym.webservice.model.Student;
import com.codegym.webservice.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class RestControllerStudent {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK); // 200
    }
    @GetMapping("/pages")
    public ResponseEntity<Page<Student>> getPage(@RequestParam(defaultValue = "0",required = false)int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Student> studentPage = studentService.findAll(pageable);
        if (studentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(studentPage, HttpStatus.OK); // 200
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) {
        // check validate
        if (studentDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);//201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
       Student student = studentService.findById(id);
       if (student==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       studentService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable int id, @RequestBody StudentDto studentDto) {
        Student student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
