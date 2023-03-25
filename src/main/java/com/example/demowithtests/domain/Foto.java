package com.example.demowithtests.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fotos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String link;
    private Integer length;
    private Integer width;
    private Boolean isDeleted = Boolean.FALSE;
    private Boolean isShown = Boolean.TRUE;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Set<Foto> fotos = new HashSet<>();


}