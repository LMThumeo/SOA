package com.example.btl.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "study_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "room")
    private String room;

    @Column(name = "shift")
    private int shift;

    @Column(name = "reexamination_deadline")
    private Date reexaminationDeadline;

    @ManyToOne
    @JoinColumn(name = "subject_semester_id", referencedColumnName = "id")
    private SubjectSemester subjectSemester;

    @OneToMany(mappedBy = "studyClass")
    private List<TranscriptLine> transcriptLines;

//    @ManyToOne
//    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    private Teacher teacher;
}
