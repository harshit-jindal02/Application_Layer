package com.university.Application.Services;

import com.university.Application.model.Department;
import com.university.Application.model.Faculty;
import com.university.Application.model.Programme;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AppService {

    private Traverson traverson;


    AppService() {
        this.traverson = new Traverson(URI.create("http://localhost:9090"), MediaTypes.HAL_JSON);
    }

    /*
    public Department addDepartment(Department department) {
        return localApiClient
                .post()
                .uri("/departments")
                .body(BodyInserters.fromValue(department))
                .retrieve()
                .bodyToMono(Department.class).block();
    }
     */

    public List<Department> getALlDepartment() {
        CollectionModel<Department> departments = traverson
                .follow("departments")
                .toObject(new TypeReferences.CollectionModelType<Department>() {});


        assert departments != null;
        for (Department department : departments) {

            String departmentUrl = department.get_links().get("self").getHref();

            String id = extractResourceId(departmentUrl);
            department.setDepartmentId(Integer.valueOf(id));

            String facultyListUrl = department.get_links().get("facultyList").getHref();
            String programmeListUrl = department.get_links().get("programmeList").getHref();

            // Fetch facultyList and programmeList using the respective URLs
            List<Faculty> facultyList = fetchFacultyList(facultyListUrl);
            List<Programme> programmeList = fetchProgrammeList(programmeListUrl);

            // Update the department object with the retrieved data
            department.setFacultyList(facultyList);
            department.setProgrammeList(programmeList);
        }

        return departments.getContent().stream().toList();
    }

    private Department fetchDepartment(String url) {
        Traverson traverson = new Traverson(URI.create(url), MediaTypes.HAL_JSON);
        return traverson
                .follow()
                .toObject(Department.class);
    }

    private static String extractResourceId(String selfHref) {
        String pattern = ".*/(\\d+)$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(selfHref);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException("Invalid self HREF format");
        }
    }

    private List<Faculty> fetchFacultyList(String url) {
        Traverson traverson = new Traverson(URI.create(url), MediaTypes.HAL_JSON);
        CollectionModel<Faculty> facultyCollection = traverson
                .follow()
                .toObject(new TypeReferences.CollectionModelType<Faculty>() {});

        return facultyCollection.getContent().stream().toList();
    }

    private List<Programme> fetchProgrammeList(String url) {
        Traverson traverson = new Traverson(URI.create(url), MediaTypes.HAL_JSON);
        CollectionModel<Programme> facultyCollection = traverson
                .follow()
                .toObject(new TypeReferences.CollectionModelType<Programme>() {});

        return facultyCollection.getContent().stream().toList();
    }
}
