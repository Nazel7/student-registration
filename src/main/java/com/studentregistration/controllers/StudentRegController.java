package com.studentregistration.controllers;

import com.studentregistration.Mappers.StudentMapper;
import com.studentregistration.entities.StudentModel;
import com.studentregistration.exceptions.StudentNotFoundException;
import com.studentregistration.services.StudentRegistrationService;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.NotActiveException;
import java.net.URI;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentRegController {
    private final StudentRegistrationService mStudentRegistrationService;

    @CrossOrigin
    @GetMapping("/test")
    public ResponseEntity<String> getTest() {

        return  new ResponseEntity<>("::: Welcome to Student registration service :::", HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(" ")
    public ResponseEntity<Student> registerStudent(@RequestBody StudentDto studentDto){

        final Student regStudent= mStudentRegistrationService.saveStudent(studentDto);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(regStudent.getId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public EntityModel<Student> getRegisteredStudent(@PathVariable("id") long id)
            throws NotActiveException, StudentNotFoundException {

        final Student retrievedStudent= mStudentRegistrationService.getById(id);
        final EntityModel<Student> entityModel= EntityModel.of(retrievedStudent);

        WebMvcLinkBuilder linkToStudents= linkTo(methodOn(this.getClass()).getAllRegisteredStudent());
        entityModel.add(linkToStudents.withRel("all_students"));

        return  entityModel;
    }

    @CrossOrigin
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllRegisteredStudent()
            throws NotActiveException, StudentNotFoundException {

        final List<Student> retrievedStudent= mStudentRegistrationService.fetchAllStudents();

        return  new ResponseEntity<>(retrievedStudent, HttpStatus.OK);
    }

}
