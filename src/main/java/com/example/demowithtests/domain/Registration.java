package com.example.demowithtests.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String info;
    private Boolean isActive = Boolean.TRUE;
    public Date creationTime = Date.from(Instant.now());

}