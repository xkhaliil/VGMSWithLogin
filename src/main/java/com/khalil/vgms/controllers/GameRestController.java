package com.khalil.vgms.controllers;

import com.khalil.vgms.entities.Game;
import com.khalil.vgms.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin("*")
public class GameRestController {
    @Autowired
    GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{GameId}")
    public Game getGameById(@PathVariable("GameId") Long id) {
        return gameService.getGame(id);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public Game saveGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Game updateGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{GameId}")
    public void deleteGame(@PathVariable("GameId") Long id) {
        gameService.deleteGameById(id);
    }
}
