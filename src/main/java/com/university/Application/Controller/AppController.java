package com.university.Application.Controller;

import com.university.Application.Services.AppService;
import com.university.Application.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    AppService service;

    @PostMapping(path="/departments", consumes = MediaType.APPLICATION_JSON_VALUE)
    private Department addDepartments(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @GetMapping(path="/departments/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private Mono<Department> getDepartments(@PathVariable String departmentId) {
        return service.getDepartment(departmentId);
    }

}
