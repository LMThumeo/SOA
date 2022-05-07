package com.example.btl.repository;

import com.example.btl.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByStudentCodeAndPassword(String code, String pass);
}
