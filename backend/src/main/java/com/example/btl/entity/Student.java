package com.example.btl.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "student_transcript",
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "transcript_id", referencedColumnName = "id"))
//    private Set<TranscriptLine> transcriptLine;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "student_transcript_his",
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "transcript_his_id", referencedColumnName = "id"))
//    private Set<TranscriptLineHis> transcriptLineHis;


}
