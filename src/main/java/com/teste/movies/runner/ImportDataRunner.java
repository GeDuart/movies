package com.teste.movies.runner;

import com.teste.movies.services.ImportDataService;
import com.teste.movies.services.ImportDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ImportDataRunner implements ApplicationRunner {

    @Autowired
    ImportDataService importData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        importData.importDataH2();
    }
}
