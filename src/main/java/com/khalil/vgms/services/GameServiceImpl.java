package com.khalil.vgms.services;

import com.khalil.vgms.entities.Game;
import com.khalil.vgms.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Game game) {
        gameRepository.delete(game);
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Page<Game> getAllGamesByPage(int page, int size) {
        return gameRepository.findAll(PageRequest.of(page, size));
    }
}
