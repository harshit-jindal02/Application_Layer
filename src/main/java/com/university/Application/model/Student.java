package com.university.Application.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student implements Serializable {
    private int enrollment_number;

    private String student_name;

    private String student_gender;

    private int student_dob;

    private int batch_year;

    private Section sections;

}