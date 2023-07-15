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
public class Section implements Serializable {
    private int id;

    private Semester semester_id;

    private int section_number;

    private List<TeachingAssignment> teachingAssignment;

    private List<Student> students;
}
