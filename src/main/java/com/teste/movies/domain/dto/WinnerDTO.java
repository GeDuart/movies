package com.teste.movies.domain.dto;

import com.teste.movies.domain.entity.Movies;
import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;
import com.teste.movies.domain.entity.Winner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinnerDTO {

    private Long id;
    private Movies movies;
    private Studios studios;
    private Producer producer;
    private int yearWinner;
    private int interval;
    private int previousWin;
    private int followingWin;

    public WinnerDTO(Winner winner) {
        this.id = winner.getId();
        this.movies = winner.getMovies();
        this.studios = winner.getStudios();
        this.producer = winner.getProducer();
        this.yearWinner = winner.getYearWinner();
    }
}

