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
public class StudentDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("student_code")
    private String studentCode;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("password")
    private String password;

}
