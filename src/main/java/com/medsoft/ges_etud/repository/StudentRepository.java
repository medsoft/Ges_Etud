package com.medsoft.ges_etud.repository;

import com.medsoft.ges_etud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByCode(String code);
    public List <Student> findByProgramId(String programId);
}
