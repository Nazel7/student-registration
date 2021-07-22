package com.studentregistration.respositories;

import com.studentregistration.entities.StudentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRegistrationRepo extends JpaRepository<StudentModel, Long> {

    StudentModel findStudentModelByRegistrationNo(String regNo);
}
