package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.domain.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {




}