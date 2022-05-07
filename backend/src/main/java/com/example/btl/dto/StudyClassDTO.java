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
public class StudyClassDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("room")
    private String room;

    @JsonProperty("shift")
    private int shift;

    @JsonProperty("subject_semester")
    private SubjectSemesterDTO subjectSemester;


//    @ManyToOne
//    @JoinColumn(name = "subject_semester_id", referencedColumnName = "id")
//    private SubjectSemester subjectSemester;

//    @ManyToOne
//    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    private Teacher teacher;
}
