package com.studentregistration.interfaces;

import com.studentregistration.entities.StudentModel;
import com.studentregistration.exceptions.StudentNotFoundException;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

import java.io.NotActiveException;
import java.util.List;

public interface IStudentRegistationService {

    Student saveStudent(StudentDto studentDto);

    Student getById(long id) throws NotActiveException, StudentNotFoundException;

    void deleteByID(StudentModel studentModel);

    List<Student> fetchAllStudents() throws StudentNotFoundException;

}
