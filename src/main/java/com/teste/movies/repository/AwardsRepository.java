package com.teste.movies.repository;

import com.teste.movies.domain.entity.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AwardsRepository extends JpaRepository<Awards,Long> {

    @Query(value = "SELECT * FROM Awards WHERE producer_id IN " +
                   "(SELECT producer_id FROM Awards GROUP BY producer_id HAVING COUNT(producer_id) >= 2)",nativeQuery = true)

    List<Awards> findAwardsWithMoreThanTwoOccurrences();

}
