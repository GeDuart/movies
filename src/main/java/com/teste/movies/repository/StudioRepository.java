package com.teste.movies.repository;

import com.teste.movies.domain.entity.Studios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studios,Long> {

    Studios findByStudioName(String studioName);

}
