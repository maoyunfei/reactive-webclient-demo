package com.example.reactivewebclient;

import com.example.reactivewebclient.model.Employee;
import com.example.reactivewebclient.model.EmployeeEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveWebclientApplication {

    @Bean
    WebClient webClient() {
        return WebClient.create("http://127.0.0.1:8082/rest/employee");
    }

    @Bean
    CommandLineRunner commandLineRunner(WebClient webClient) {
        return args -> {
            webClient
                    .get()
                    .uri("/all")
                    .retrieve()
                    .bodyToFlux(Employee.class)
                    .filter(employee -> employee.getName().equals("Peter"))
                    .flatMap(employee -> {

                        return webClient
                                .get()
                                .uri("/{id}/events", employee.getId())
                                .retrieve()
                                .bodyToFlux(EmployeeEvent.class);
                    })
                    .subscribe(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebclientApplication.class, args);
    }
}
