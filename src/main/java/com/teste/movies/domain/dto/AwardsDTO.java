package com.teste.movies.domain.dto;

import com.teste.movies.domain.entity.Movies;
import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;
import com.teste.movies.domain.entity.Awards;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardsDTO {

    private Long id;
    private Movies movies;
    private Studios studios;
    private Producer producer;
    private int yearAwards;
    private int interval;
    private int previousWin;
    private int followingWin;

    public AwardsDTO(Awards awards) {
        this.id = awards.getId();
        this.movies = awards.getMovies();
        this.studios = awards.getStudios();
        this.producer = awards.getProducer();
        this.yearAwards = awards.getYearAward();
    }
}

