package com.example.reactivespring.Controllers;

import com.example.reactivespring.Models.Studio;
import com.example.reactivespring.Services.StudioService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/studios")
public class StudioController {

    private final StudioService service;

    public StudioController(StudioService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Studio> getAllStudios() {
        return service.getAllStudios();
    }

    @GetMapping("/{id}")
    public Mono<Studio> getStudioById(@PathVariable String id) {
        return service.getStudioById(id);
    }

    @PostMapping
    public Mono<Studio> createStudio(@RequestBody @Validated Studio studio) {
        return service.saveStudio(studio);
    }

    @PutMapping("/{id}")
    public Mono<? extends Studio> updateStudio(@PathVariable String id, @RequestBody @Validated Studio studio) {
        return service.updateStudioById(id, studio);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudio(@PathVariable String id) {
        return service.deleteStudioById(id);
    }
}
