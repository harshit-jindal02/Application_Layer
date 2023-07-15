package com.university.Application.Services;


import com.university.Application.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class AppService {
    private final WebClient localApiClient;

    @Autowired
    public AppService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public Department addDepartment(Department department) {
        return localApiClient
                .post()
                .uri("/departments")
                .body(BodyInserters.fromValue(department))
                .retrieve()
                .bodyToMono(Department.class).block();
    }

    public Mono<List<Department>> getALlDepartment() {
        return localApiClient.get()
                .uri("/departments")
                .retrieve()
                .bodyToFlux(Department.class)
                .collectList();
    }
}
