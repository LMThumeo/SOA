package com.example.btl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReexaminationDTO{

    @JsonProperty("id")
    private int id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("point")
    private float point;

    @JsonProperty("submit_time")
    private Date submitTime;

    @JsonProperty("transcriptLine")
    private TranscriptLineDTO transcriptLine;
}
