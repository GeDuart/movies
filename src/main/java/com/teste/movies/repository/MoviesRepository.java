package com.teste.movies.repository;

import com.teste.movies.domain.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {

}
