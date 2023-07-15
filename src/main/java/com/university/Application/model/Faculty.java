package com.university.Application.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Faculty implements Serializable {
    private int faculty_id;

    private String faculty_name;

    private String faculty_gender;

    private Department department;

    private List<TeachingAssignment> teachingAssignment;

}
