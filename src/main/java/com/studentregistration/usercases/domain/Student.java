package com.studentregistration.usercases.domain;

import com.studentregistration.enums.Gender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private long id;

    private String firstName;

    private String lastName;

    private String registrationNo;

    private String gender;
}
