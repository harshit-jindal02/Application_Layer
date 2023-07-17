package com.university.Application.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.Link;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Department implements Serializable {

    private Integer departmentId;
    private String departmentName;
    private List<Programme> programmeList;
    private List<Faculty> facultyList;

    private Map<String, Link> _links;
}
