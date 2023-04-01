package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "passports")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final  UUID serialNumber = UUID.randomUUID();
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private Boolean isFree = Boolean.TRUE;

    @OneToOne(mappedBy = "passport")
    private Employee employee;


}
