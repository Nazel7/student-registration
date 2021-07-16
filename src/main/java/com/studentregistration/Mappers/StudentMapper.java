package com.studentregistration.Mappers;

import com.studentregistration.entities.StudentModel;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static Student mapToDomain(StudentModel model){

        final Student student= Student.builder()
               .id(model.getId())
               .firstName(model.getFirstName())
               .lastName(model.getLastName())
               .gender(model.getGender())
               .registrationNo(model.getRegistrationNo())
               .build();

        return student;
    }

    public static List<Student> mapToListDomain(List<StudentModel> models){

       final List<Student> studentList= new ArrayList<>();

        for (StudentModel studentModel: models){

         final Student student= StudentMapper.mapToDomain(studentModel);
          studentList.add(student);
        }

        return studentList;
    }

    public static StudentModel mapToModel(Student student){

        final StudentModel studentModel= StudentModel.builder().id(student.getId())
                                      .firstName(student.getFirstName())
                                      .lastName(student.getLastName())
                                      .gender(student.getGender())
                                      .registrationNo(student.getRegistrationNo())
                                      .build();

        return studentModel;
    }

    public static StudentModel mapToModel(StudentDto studentDto){

        final StudentModel studentModel= StudentModel.builder()
                                                     .firstName(studentDto.getFirstName())
                                                     .lastName(studentDto.getLastName())
                                                     .gender(studentDto.getGender().name())
                                                     .registrationNo(studentDto.getRegistrationNo())
                                                     .build();

        return studentModel;
    }
}
