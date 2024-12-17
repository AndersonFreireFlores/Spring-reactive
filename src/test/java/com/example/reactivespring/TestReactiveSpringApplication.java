package com.example.reactivespring;

import org.springframework.boot.SpringApplication;

public class TestReactiveSpringApplication {

    public static void main(String[] args) {
        SpringApplication.from(ReactiveSpringApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
