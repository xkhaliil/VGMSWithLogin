package com.khalil.vgms.services;

import com.khalil.vgms.entities.Game;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameService {
    Game saveGame(Game game);
    Game updateGame(Game game);
    void deleteGame(Game game);
    void deleteGameById(Long id);
    Game getGame(Long id);
    List<Game> getAllGames();
    Page<Game> getAllGamesByPage(int page, int size);
}
