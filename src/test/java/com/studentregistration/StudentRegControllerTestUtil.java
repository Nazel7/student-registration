package com.studentregistration;

import com.studentregistration.entities.StudentModel;
import com.studentregistration.enums.Gender;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

public class StudentRegControllerTestUtil {

    public static final String FIRST_NAME = "randomFirstName";
    public static final String LAST_NAME = "randomLastName";
    public static final String REG_NO = "randomRegNo";

    final static StudentDto studentDto = StudentDto
            .builder()
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .gender(Gender.MALE)
            .registrationNo(REG_NO)
            .build();

    final static StudentModel studentModel = StudentModel
            .builder()
            .id(1L)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .gender(Gender.FEMALE.name())
            .registrationNo(REG_NO)
            .build();

    final static Student student = Student
            .builder()
            .id(1L)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .gender(Gender.FEMALE.name())
            .registrationNo(REG_NO)
            .build();
}
