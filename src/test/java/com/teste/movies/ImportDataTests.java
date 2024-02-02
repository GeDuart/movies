package com.teste.movies;

import com.teste.movies.domain.entity.Movies;
import com.teste.movies.repository.MoviesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest()
public class ImportDataTests {

    @Autowired
    private MoviesRepository moviesRepository;
    @Test
    public void testImportDataH2() {
        List<Movies> moviesList = moviesRepository.findAll();

        assertThat(!moviesList.isEmpty()).isTrue();
        assertThat(moviesList.get(0).getTitle().equals("Can't Stop the Music")).isTrue();
    }

}
