package com.example.btl.repository;

import com.example.btl.entity.StudyClass;
import com.example.btl.entity.SubjectSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyClassRepository extends JpaRepository<StudyClass, Integer> {

    List<StudyClass> getStudyClassBySubjectSemester(SubjectSemester subjectSemester);
}
