package com.khalil.vgms;

import com.khalil.vgms.entities.Game;
import com.khalil.vgms.entities.Genre;
import com.khalil.vgms.repos.GameRepository;
import com.khalil.vgms.repos.GenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class VGMSApplicationTests {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GameRepository gameRepository;

    @Test
    void testCreateGenre() {
        Genre genre = new Genre("Genre 1", "Description 1");
        genreRepository.save(genre);
    }

    @Test
    void testFindGenre() {
        Genre genre = genreRepository.findById(1L).get();
        System.out.println(genre);
    }

    @Test
    void testUpdateGenre() {
        Genre genre = genreRepository.findById(1L).get();
        genre.setGenreName("Genre 1 Updated");
        genreRepository.save(genre);
    }

    @Test
    void testDeleteGenre() {
        genreRepository.deleteById(1L);
    }

    @Test
    void testCreateGame() {
        Game game = new Game("Game 1", "Artist 1", "Description 1", 10.0, new Date(), genreRepository.findById(2L).get());
        gameRepository.save(game);
    }

    @Test
    void testFindGame() {
        Game game = gameRepository.findById(1L).get();
        System.out.println(game);
    }

    @Test
    void testUpdateGame() {
        Game game = gameRepository.findById(1L).get();
        game.setGameName("Game 1 Updated");
        gameRepository.save(game);
    }

    @Test
    void testfindByNamePrice() {
        List<Game> games = gameRepository.findByNamePrice("Game 1", 10.0);
        for (Game a : games) {
            System.out.println(a);
        }
    }

    @Test
    void testfindByGenre() {
        Genre genre = new Genre();
        genre.setGenreId(1L);
        List<Game> games = gameRepository.findByGenre(genre);
        for (Game a : games) {
            System.out.println(a);
        }
    }

    @Test
    void testtrierGamesNomsPrix() {
        List<Game> games = gameRepository.trierGamesNomsPrix();
        for (Game a : games) {
            System.out.println(a);
        }
    }
}
