package com.teste.movies.domain.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "title")
    private String title;

    @Column(name = "winner")
    private boolean winner;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Studios studios;

    public Movies(Integer year, String title, Boolean winner, Producer producer, Studios studios) {
        this.year = year;
        this.title = title;
        this.winner = winner;
        this.producer = producer;
        this.studios = studios;
    }

    public Movies() {

    }
}
