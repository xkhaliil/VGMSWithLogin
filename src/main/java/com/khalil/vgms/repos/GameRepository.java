package com.khalil.vgms.repos;

import com.khalil.vgms.entities.Game;
import com.khalil.vgms.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT a FROM Game a WHERE a.GameName LIKE %:GameName AND a.GamePrice > :GamePrice")
    List<Game> findByNamePrice(@Param("GameName") String GameName, @Param("GamePrice") Double GamePrice);

    @Query("SELECT a from Game  a where a.genre = ?1")
    List<Game> findByGenre(Genre genre);

    @Query("select a from Game a order by a.GameName ASC, a.GamePrice DESC ")
    List<Game> trierGamesNomsPrix();
}
