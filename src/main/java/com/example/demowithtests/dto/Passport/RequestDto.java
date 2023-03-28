package com.example.demowithtests.dto.Passport;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class RequestDto {

    public String firstName;
    public String secondName;
    public LocalDate birthDate;
}
