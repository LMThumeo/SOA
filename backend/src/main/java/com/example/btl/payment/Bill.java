package com.example.btl.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bill {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private int studentId;
    private int semesterId;
    private int subjectId;
}
