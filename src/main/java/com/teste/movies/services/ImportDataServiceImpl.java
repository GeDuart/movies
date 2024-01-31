package com.teste.movies.services;

import com.teste.movies.domain.entity.Movies;
import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;
import com.teste.movies.domain.entity.Winner;
import com.teste.movies.repository.MoviesRepository;
import com.teste.movies.repository.ProducerRepository;
import com.teste.movies.repository.StudioRepository;
import com.teste.movies.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class ImportDataServiceImpl implements ImportDataService {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    StudioRepository studioRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    WinnerRepository winnerRepository;

    private static final int INDEX_YEAR = 0;
    private static final int INDEX_FILM_NAME = 1;
    private static final int INDEX_STUDIO = 2;
    private static final int INDEX_PRODUCER = 3;
    private static final int INDEX_WINNER = 4;

    @Override
    public void importDataH2() {
        Resource resource = new ClassPathResource("movielist.csv");
        try {
            InputStream inputStream = resource.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReader
                    .lines()
                    .skip(1)
                    .forEach(this::parseObject);

        }catch (IOException e) {
            throw new RuntimeException("Não foi possível encontrar o arquivo para importar os dados.");
        }
    }

    private void parseObject(String csvLine){
        String[] fields = csvLine.split(";");
        boolean winner = fields.length > 4 && fields[INDEX_WINNER].equals("yes");

        Studios studiosSave = getOrCreateStudio(fields[INDEX_STUDIO]);

        Producer producerSave = getOrCreateProducer(fields[INDEX_PRODUCER]);

        Movies movieSave = createMovie(new Movies(Integer.parseInt(fields[INDEX_YEAR]),fields[INDEX_FILM_NAME],winner, producerSave,studiosSave));

        if (winner)
            winnerRepository.save(new Winner(movieSave,studiosSave,producerSave,Integer.parseInt(fields[INDEX_YEAR])));
    }

    private Studios getOrCreateStudio(String studioName) {
        Studios studios = studioRepository.findByStudioName(studioName);
        return (studios != null) ? studios : studioRepository.save(new Studios(studioName));
    }

    private Producer getOrCreateProducer(String producerName) {
        Producer producer = producerRepository.findByProducerName(producerName);
        return (producer != null) ? producer : producerRepository.save(new Producer(producerName));
    }

    private Movies createMovie(Movies movies) {

        return moviesRepository.save(movies);
    }
}
