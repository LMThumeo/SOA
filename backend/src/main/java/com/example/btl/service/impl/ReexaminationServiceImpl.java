package com.example.btl.service.impl;

import com.example.btl.converter.MappingHelper;
import com.example.btl.dto.ReexaminationDTO;
import com.example.btl.entity.Reexamination;
import com.example.btl.entity.SubjectSemester;
import com.example.btl.entity.TranscriptLine;
import com.example.btl.repository.ReexaminationRepository;
import com.example.btl.repository.TranscriptLineRepository;
import com.example.btl.service.ReexaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReexaminationServiceImpl implements ReexaminationService {

    final private ReexaminationRepository reexaminationRepository;
    final private TranscriptLineRepository transcriptLineRepository;
    final private MappingHelper mappingHelper;

    @Autowired
    public ReexaminationServiceImpl(ReexaminationRepository reexaminationRepository, TranscriptLineRepository transcriptLineRepository, MappingHelper mappingHelper) {
        this.reexaminationRepository = reexaminationRepository;
        this.transcriptLineRepository = transcriptLineRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public List<ReexaminationDTO> getReexaminationByStudent(int studentId) {
        return mappingHelper.mapList(reexaminationRepository.findAll(Sort.by(Sort.Direction.DESC, "submitTime"))
                .stream().filter(reexamination -> reexamination.getTranscriptLine().getStudent().getId() == studentId)
                .collect(Collectors.toList()),
                ReexaminationDTO.class);
    }

    @Override
    public ReexaminationDTO submitForm(int studentId, int semesterId, int subjectId) {
        TranscriptLine transcriptLine = transcriptLineRepository.findByStudentId(studentId)
                .stream().filter(tl -> {
                    SubjectSemester subjectSemester = tl.getStudyClass().getSubjectSemester();
                    return subjectSemester.getSemester().getId() == semesterId
                            && subjectSemester.getSubject().getId() == subjectId;
                })
                .collect(Collectors.toList()).get(0);
        Reexamination reexamination = Reexamination.builder()
                .status("ACCEPT")
                .transcriptLine(transcriptLine)
                .submitTime(new Date(new java.util.Date().getTime()))
                .build();
        return mappingHelper.map(reexaminationRepository.save(reexamination), ReexaminationDTO.class);
    }
}
