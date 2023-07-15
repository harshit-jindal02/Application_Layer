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
public class TeachingAssignment implements Serializable {
    private int id;

    private Section section;

    private Faculty faculty;

    private Subject subject;

    // Constructors, getters, and setters
}
