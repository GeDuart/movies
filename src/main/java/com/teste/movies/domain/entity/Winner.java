package com.teste.movies.domain.entity;

import com.teste.movies.domain.dto.WinnerDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movies movies;

    @ManyToOne
    private Studios studios;

    @ManyToOne
    private Producer producer;

    private int yearWinner;

    public Winner(Movies movies, Studios studios, Producer producer,int yearWinner) {
        this.movies = movies;
        this.studios = studios;
        this.producer = producer;
        this.yearWinner = yearWinner;
    }

    public Winner() {

    }

}
