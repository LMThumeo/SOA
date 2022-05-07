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
public class SubjectPointDTO {

    @JsonProperty("id")
    private int id;

    @Column(name = "weight")
    private int weight;

    @JsonProperty("point")
    private PointDTO point;

    @JsonProperty("subject")
    private SubjectDTO subject;

//    @OneToMany(mappedBy = "subjectPoint")
//    private List<TranscriptItem> transcriptItems;

}
