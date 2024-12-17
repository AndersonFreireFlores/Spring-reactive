package com.example.reactivespring.Repositories;

import com.example.reactivespring.Models.Studio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends ReactiveMongoRepository<Studio, String> {
}
