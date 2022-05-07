package com.example.btl.repository;

import com.example.btl.entity.TranscriptItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptItemRepository extends JpaRepository<TranscriptItem, Integer> {
    void deleteAllByTranscriptLineId(Integer lineId);
}
