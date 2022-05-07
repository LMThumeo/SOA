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
public class SubjectSemesterDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("semester")
    private SemesterDTO semester;

    @JsonProperty("subject")
    private SubjectDTO subject;
}
