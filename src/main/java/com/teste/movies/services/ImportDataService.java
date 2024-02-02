package com.teste.movies.services;

import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;

import java.io.IOException;

public interface ImportDataService {

    void importDataH2() throws IOException;

    void parseObject(String csvLine);

    Studios getOrCreateStudio(String studioName);

    Producer getOrCreateProducer(String producerName);

}
