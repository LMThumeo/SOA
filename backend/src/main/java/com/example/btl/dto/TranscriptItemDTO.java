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
public class TranscriptItemDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("subjectPoint")
    private SubjectPointDTO subjectPoint;

    @JsonProperty("point")
    private float point;
}
