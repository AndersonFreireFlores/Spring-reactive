package com.example.reactivespring.Controllers;

import com.example.reactivespring.Models.Game;
import com.example.reactivespring.Services.GameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public Flux<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Mono<Game> getGameById(@PathVariable String id) {
        return gameService.getGameById(id);
    }

    @PostMapping
    public Mono<Game> saveGame(@RequestBody @Validated Game game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public Mono<Game> updateGameById(@PathVariable String id, @RequestBody @Validated Game game) {
        return gameService.updateGameById(id, game);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteGameById(@PathVariable String id) {
        return gameService.deleteGameById(id);
    }
}
