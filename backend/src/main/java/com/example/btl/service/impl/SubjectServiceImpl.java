package com.example.btl.service.impl;

import com.example.btl.converter.MappingHelper;
import com.example.btl.dto.SemesterDTO;
import com.example.btl.dto.StudyClassDTO;
import com.example.btl.dto.SubjectDTO;
import com.example.btl.entity.SubjectSemester;
import com.example.btl.entity.TranscriptLine;
import com.example.btl.repository.SemesterRepository;
import com.example.btl.repository.StudyClassRepository;
import com.example.btl.repository.SubjectSemesterRepository;
import com.example.btl.repository.TranscriptLineRepository;
import com.example.btl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    final private SubjectSemesterRepository subjectSemesterRepository;
    final private StudyClassRepository studyClassRepository;
    final private TranscriptLineRepository transcriptLineRepository;
    final private SemesterRepository semesterRepository;
    final private MappingHelper mappingHelper;

    @Autowired
    public SubjectServiceImpl(SubjectSemesterRepository subjectSemesterRepository, StudyClassRepository studyClassRepository, TranscriptLineRepository transcriptLineRepository, SemesterRepository semesterRepository, MappingHelper mappingHelper) {
        this.subjectSemesterRepository = subjectSemesterRepository;
        this.studyClassRepository = studyClassRepository;
        this.transcriptLineRepository = transcriptLineRepository;
        this.semesterRepository = semesterRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public StudyClassDTO getStudyClassBySubject(int studentId, int semesterId, int subjectId) {
        return mappingHelper.mapList(transcriptLineRepository.findByStudentId(studentId)
                .stream().map(tl -> tl.getStudyClass())
                .filter(studyClass -> studyClass.getSubjectSemester().getSubject().getId() == subjectId
                                        && studyClass.getSubjectSemester().getSemester().getId() == semesterId)
                .collect(Collectors.toList()),
                StudyClassDTO.class)
                .get(0);
    }

    @Override
    public List<SubjectDTO> getSubjectByStudentAndSemester(int studentID, int semesterId) {
        return mappingHelper.mapList(transcriptLineRepository.findByStudentId(studentID)
                .stream().map(transcriptLine -> transcriptLine.getStudyClass().getSubjectSemester())
                .filter(subjectSemester -> subjectSemester.getSemester().getId()==semesterId)
                .map(subjectSemester -> subjectSemester.getSubject())
                .collect(Collectors.toList()),
                SubjectDTO.class);
    }

    @Override
    public List<SemesterDTO> getSemester() {
        return mappingHelper.mapList(semesterRepository.findAll(), SemesterDTO.class);
    }


//    @Override
//    public StudyClassDTO getStudyClassOfStudent(int studentID, List<StudyClassDTO> studyClassDTOs) {
//        for (StudyClassDTO sc:studyClassDTOs) {
//            StudyClass studyClass = mappingHelper.map(sc, StudyClass.class);
//            for (TranscriptLine tl:studyClass.getTranscriptLines()) {
//                if (tl.getStudent().getId() == studentID) {
//                    return sc;
//                }
//            }
//        }
//        return null;
//    }
}
