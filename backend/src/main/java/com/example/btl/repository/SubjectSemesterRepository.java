package com.example.btl.repository;

import com.example.btl.entity.SubjectSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectSemesterRepository extends JpaRepository<SubjectSemester, Integer> {

    SubjectSemester getSubjectSemesterBySemesterIdAndSubjectId(int semesterId, int subjectId);
}
