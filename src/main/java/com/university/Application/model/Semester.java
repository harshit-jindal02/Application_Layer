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
public class Semester implements Serializable {
    private int semester_id;

    private Programme programmes;

    private int semester_number;

    private List<Subject> subjects;

    private List<Section> sectionList;
}