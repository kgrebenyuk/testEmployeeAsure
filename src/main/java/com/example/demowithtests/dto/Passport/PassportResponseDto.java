package com.example.demowithtests.dto.Passport;

import com.example.demowithtests.dto.Employee.AddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ToString
//@Getter
//@Setter
public class PassportResponseDto {
    public Integer id;
    public final UUID serialNumber = UUID.randomUUID();
    public String firstName;
    public String secondName;
    public LocalDate birthDate;

    public Set<RegistrationDto> registrations = new HashSet<>();
}
