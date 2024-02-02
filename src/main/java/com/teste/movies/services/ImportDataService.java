package com.teste.movies.services;

import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface ImportDataService {

    void importDataH2() throws IOException;

    void parseObject(String csvLine);

    Studios getOrCreateStudio(String studioName);

    Producer getOrCreateProducer(String producerName);

}
