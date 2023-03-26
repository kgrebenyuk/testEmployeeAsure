package com.example.demowithtests.dto;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeReadDto {
    public String name;
    public String email;
    public Date creationTime = Date.from(Instant.now());
    public Set<FotoDto> fotos = new HashSet<>();
    public Set<AddressDto> addresses = new HashSet<>();

}
