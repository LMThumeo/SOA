package com.example.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "transcript_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscriptItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transcript_line_id", referencedColumnName = "id")
    private TranscriptLine transcriptLine;

    @ManyToOne
    @JoinColumn(name = "subject_point_id", referencedColumnName = "id")
    private SubjectPoint subjectPoint;

    @Column(name = "point")
    private float point;
}
