package com.khalil.vgms.services;

import com.khalil.vgms.entities.Genre;
import com.khalil.vgms.repos.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
