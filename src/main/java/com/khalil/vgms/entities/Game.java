package com.khalil.vgms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GameId;
    @NotEmpty(message = "The name is required")
    @Size(min = 3, max = 35)
    private String GameName;
    @NotEmpty(message = "The publisher is required.")
    private String GamePublisher;
    @NotEmpty(message = "The Rating is required.")
    private String GameRating;
    @Min(value = 10)
    @Max(value = 1500)
    @NotNull(message = "The price is required.")
    private Double GamePrice;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date GameReleaseDate;
    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genre;

    public Game(String gameName, String gamePublisher, String gameRating, Double gamePrice, Date gameReleaseDate, Genre genre) {
        GameName = gameName;
        GamePublisher = gamePublisher;
        GameRating = gameRating;
        GamePrice = gamePrice;
        GameReleaseDate = gameReleaseDate;
        this.genre = genre;
    }

    public Game() {
    }
}
