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
public class SemesterDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("year_start")
    private int yearStart;

    @JsonProperty("semester_num")
    private int semesterNum;

}
