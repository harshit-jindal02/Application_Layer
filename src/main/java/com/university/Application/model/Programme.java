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
public class Programme implements Serializable {
    private Integer course_id;

    private String course_name;

    private Department department;

    private List<Semester> semesters;

}