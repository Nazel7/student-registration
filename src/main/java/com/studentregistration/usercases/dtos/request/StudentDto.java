package com.studentregistration.usercases.dtos.request;

import com.studentregistration.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String firstName;

    private String lastName;

    private String registrationNo;

    private Gender gender;
}
