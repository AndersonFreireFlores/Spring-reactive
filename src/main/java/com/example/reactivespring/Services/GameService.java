package com.example.reactivespring.Services;

import com.example.reactivespring.Models.Game;
import com.example.reactivespring.Repositories.GameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Mono<Game> saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Mono<Game> getGameById(String id) {
        return gameRepository.findById(id);
    }

    public Flux<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Mono<Game> updateGameById(String id, Game game) {
        return gameRepository.findById(id)
                .map(existingGame -> new Game(existingGame.getId(), game.getName(), game.getGenre()
                        , game.getPlatform(), game.getStudio()))
                .flatMap(gameRepository::save);
    }

    public Mono<Void> deleteGameById(String id) {
        return gameRepository.deleteById(id);
    }
}
