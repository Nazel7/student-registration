package com.studentregistration.entities;





import com.studentregistration.enums.Gender;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;


@Entity
@Table(name = "student_reg")
@Data
@Builder
@Access(AccessType.FIELD)
@AllArgsConstructor
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String registrationNo;

    private String gender;

    @Tolerate
    public StudentModel (){

    }

}
