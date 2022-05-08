package com.example.btl.service.impl;

import com.example.btl.converter.MappingHelper;
import com.example.btl.dto.SemesterDTO;
import com.example.btl.repository.SemesterRepository;
import com.example.btl.service.SemsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterServiceImpl implements SemsterService {

    final private SemesterRepository semesterRepository;
    final private MappingHelper mappingHelper;

    @Autowired
    public SemesterServiceImpl(SemesterRepository semesterRepository, MappingHelper mappingHelper) {
        this.semesterRepository = semesterRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public List<SemesterDTO> getAll() {
        return mappingHelper.mapList(semesterRepository.findAll(), SemesterDTO.class);
    }
}
