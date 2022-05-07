package com.example.btl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TranscriptLineDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("study_class")
    private StudyClassDTO studyClass;

    @JsonProperty("student")
    private StudentDTO student;

    @JsonProperty("transcript_item")
    private List<TranscriptItemDTO> transcriptItems;

}
