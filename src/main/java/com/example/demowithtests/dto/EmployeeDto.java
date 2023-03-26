package com.example.demowithtests.dto;

import com.example.demowithtests.domain.Address;
import com.example.demowithtests.domain.Foto;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class EmployeeDto {

    @Schema(description = "Name of an employee.", example = "Billy", required = true)
    public String name;
    public String country;
    public String email;
    public Date creationTime = Date.from(Instant.now());
    public Boolean isDeleted = Boolean.FALSE;

    public Set<FotoDto> fotos = new HashSet<>();
    public Set<AddressDto> addresses = new HashSet<>();

}
