package com.studentregistration.usercases.dtos.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExceptionMessage {

    private String Message;
    private String errorStatus;
    private String timeStamp;
}
