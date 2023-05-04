package com.khalil.vgms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GenreId;
    private String GenreName;
    private String GenreDescription;


    public Genre(String genreName, String genreDescription) {
        GenreName = genreName;
        GenreDescription = genreDescription;

    }

    public Genre() {
    }
}
