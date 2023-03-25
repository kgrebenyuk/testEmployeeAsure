package com.example.demowithtests.dto;

public class EmployeeReadDto {
    public String name;
   // public String country;
    public String email;

    @Override
    public String toString() {
        return "EmployeeReadDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    //public Date creationTime = Date.from(Instant.now());
}
