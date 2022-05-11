package com.example.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reexamination")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reexamination implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "point")
    private Float point;

    @Column(name = "submit_time")
    private Date submitTime;

    @OneToOne
    @JoinColumn(name = "transcript_line_id", referencedColumnName = "id")
    private TranscriptLine transcriptLine;
}
