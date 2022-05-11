package com.example.btl.service;

import com.example.btl.dto.SemesterDTO;
import com.example.btl.dto.StudyClassDTO;
import com.example.btl.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {

    StudyClassDTO getStudyClassBySubject(int studentID, int semesterId, int subjectId);

    List<SubjectDTO> getSubjectByStudentAndSemester(int studentID, int semesterId);

//    List<SemesterDTO> getSemester();

//    StudyClassDTO getStudyClassOfStudent(int studentID, List<StudyClassDTO> studyClassDTOs);
}
