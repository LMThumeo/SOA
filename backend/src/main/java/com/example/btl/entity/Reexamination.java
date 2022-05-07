package com.example.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reexamination")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reexamination implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "point")
    private String point;

    @OneToOne
    @JoinColumn(name = "transcript_line_id", referencedColumnName = "id")
    private TranscriptLine transcriptLine;
}
