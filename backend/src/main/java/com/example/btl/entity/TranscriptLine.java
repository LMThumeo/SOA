package com.example.btl.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "transcript_line")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscriptLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "study_class_id", referencedColumnName = "id")
    private StudyClass studyClass;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToMany(mappedBy = "transcriptLine", cascade = CascadeType.ALL)
    private List<TranscriptItem> transcriptItems;


}
