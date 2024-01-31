package com.teste.movies.repository;

import com.teste.movies.domain.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WinnerRepository extends JpaRepository<Winner,Long> {

    @Query(value = "SELECT * FROM Winner WHERE producer_id IN " +
                   "(SELECT producer_id FROM Winner GROUP BY producer_id HAVING COUNT(producer_id) >= 2)",nativeQuery = true)

    List<Winner> findWinnersWithMoreThanTwoOccurrences();

}
