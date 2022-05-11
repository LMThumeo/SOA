package com.example.btl.repository;

import com.example.btl.entity.Reexamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReexaminationRepository extends JpaRepository<Reexamination, Integer> {

    Reexamination findByTranscriptLineId(int transcriptLineId);
}
