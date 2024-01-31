package com.teste.movies.repository;

import com.teste.movies.domain.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {

    Producer findByProducerName(String producerName);

}
