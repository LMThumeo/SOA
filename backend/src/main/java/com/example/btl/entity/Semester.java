package com.example.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="semester")
public class Semester implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year_start")
    private int yearStart;

    @Column(name = "semester_num")
    private int semesterNum;

}
