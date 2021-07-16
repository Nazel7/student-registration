package com.studentregistration.usercases.dtos.request;

import com.studentregistration.enums.Gender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    private String firstName;

    private String lastName;

    private String registrationNo;

    private Gender gender;
}
