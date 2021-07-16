package com.studentregistration.respositories;

import com.studentregistration.entities.StudentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegistrationRepo extends JpaRepository<StudentModel, Long> {
}
