package com.example.reactivespring.Services;

import com.example.reactivespring.Models.Studio;
import com.example.reactivespring.Repositories.StudioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudioService {

    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public Mono<Studio> saveStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    public Mono<Studio> getStudioById(String id) {
        return studioRepository.findById(id);
    }

    public Flux<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    public Mono<? extends Studio> updateStudioById(String id, Studio studio) {
        return studioRepository.findById(id)
                .map(existingStudio -> new Studio(existingStudio.getId(), studio.getName(), studio.getCountry()
                        , studio.getFounded(), studio.getGames()))
                .flatMap(studioRepository::save);
    }

    public Mono<Void> deleteStudioById(String id) {
        return studioRepository.deleteById(id);
    }
}