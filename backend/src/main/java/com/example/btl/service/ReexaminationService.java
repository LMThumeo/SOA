package com.example.btl.service;

import com.example.btl.dto.ReexaminationDTO;

import java.util.List;

public interface ReexaminationService {

    List<ReexaminationDTO> getReexaminationByStudent(int studentId);

    ReexaminationDTO submitForm(int studentId, int semesterId, int subjetcId);

    List<ReexaminationDTO> getAllReexamination();

    ReexaminationDTO updatePointReexamination(ReexaminationDTO reexaminationDTO);
}
