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
public class Subject implements Serializable {
    private int subject_id;

    private String subject_name;

    private List<Faculty> faculties;

    private List<Semester> semesterList;

    private List<TeachingAssignment> teachingAssignment;
}
