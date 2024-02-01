package com.teste.movies.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Awards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movies movies;

    @ManyToOne
    private Studios studios;

    @ManyToOne
    private Producer producer;

    private int yearAward;

    public Awards(Movies movies, Studios studios, Producer producer, int yearAward) {
        this.movies = movies;
        this.studios = studios;
        this.producer = producer;
        this.yearAward = yearAward;
    }

    public Awards() {

    }

}
