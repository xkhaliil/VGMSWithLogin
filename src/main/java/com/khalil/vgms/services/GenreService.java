package com.khalil.vgms.services;

import com.khalil.vgms.entities.Genre;

import java.util.List;

public interface GenreService {
    Genre saveGenre(Genre genre);
    Genre updateGenre(Genre genre);
    void deleteGenre(Genre genre);
    void deleteGenreById(Long id);
    Genre getGenre(Long id);
    List<Genre> getAllGenres();
}
