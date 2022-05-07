package com.example.btl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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

    @JsonProperty("transcriptItem")
    private TranscriptItemDTO transcriptItem;
}
