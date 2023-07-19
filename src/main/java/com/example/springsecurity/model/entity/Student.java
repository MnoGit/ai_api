package com.example.springsecurity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private int studentId;
    private String  name;
    private Date dob;
    private String sex;
    private String religion;
    private String email;
    private String phone;
    private String address;
    private Integer classesId;
    private Integer sectionId;
    private Integer roll;
    private String bloodGroup;
    private String country;
    private String registerNo;
    private String state;
//    private String liberary;
}
