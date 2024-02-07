package com.teste.movies.services;

import com.teste.movies.domain.entity.Movies;
import com.teste.movies.domain.entity.Producer;
import com.teste.movies.domain.entity.Studios;
import com.teste.movies.domain.entity.Awards;
import com.teste.movies.repository.MoviesRepository;
import com.teste.movies.repository.ProducerRepository;
import com.teste.movies.repository.StudioRepository;
import com.teste.movies.repository.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ImportDataServiceImpl implements ImportDataService {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    StudioRepository studioRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    AwardsRepository awardsRepository;

    private static final int INDEX_YEAR = 0;
    private static final int INDEX_FILM_NAME = 1;
    private static final int INDEX_STUDIO = 2;
    private static final int INDEX_PRODUCER = 3;
    private static final int INDEX_AWARDS = 4;

    @Override
    public void importDataH2() throws IOException {
        Resource resource = new ClassPathResource("movielist.csv");

        try {
            System.out.println("- Importando dados do CSV -");
            InputStream inputStream = resource.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReader
                    .lines()
                    .skip(1)
                    .forEach(this::parseObject);
            System.out.println("- Dados importados com sucesso -");
        }catch (IOException e) {
            throw new RuntimeException("Não foi possível encontrar o arquivo para importar os dados.");
        }
    }

    @Override
    public void parseObject(String csvLine){
        String[] fields = csvLine.split(";");
        if (fields.length >= 4 ) {

            boolean awards = fields.length > 4 && fields[INDEX_AWARDS].equals("yes");

            Studios studiosSave = getOrCreateStudio(fields[INDEX_STUDIO]);

            List<Producer> producerSave = getOrCreateProducer(fields[INDEX_PRODUCER]);

            Movies movieSave = createMovie(new Movies(Integer.parseInt(fields[INDEX_YEAR]),fields[INDEX_FILM_NAME],awards,studiosSave));

            if (awards)
                producerSave.forEach(producer ->
                    awardsRepository.save(new Awards(movieSave,studiosSave,producer,Integer.parseInt(fields[INDEX_YEAR])))
                );


        }else {
            System.out.println("Dados incompletos ou incorretos, ignorando esta linha: " + csvLine);
        }
    }

    @Override
    public Studios getOrCreateStudio(String studioName) {
        Studios studios = studioRepository.findByStudioName(studioName);
        return (studios != null) ? studios : studioRepository.save(new Studios(studioName));
    }
    @Override
    public List<Producer> getOrCreateProducer(String producerName) {
        String[] fields = producerName.split(",|and");
        List<Producer> producers = new ArrayList<Producer>();

        for (String field : fields) {
            Producer producer = producerRepository.findByProducerName(field.trim());
            producer = (producer != null) ? producer : producerRepository.save(new Producer(field.trim()));
            producers.add(producer);
        }
        return producers;
    }

    public Movies createMovie(Movies movies) {

        return moviesRepository.save(movies);
    }
}
