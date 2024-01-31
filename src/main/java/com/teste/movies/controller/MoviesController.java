package com.teste.movies.controller;

import com.teste.movies.domain.dto.ProducerWinnerDTO;
import com.teste.movies.services.ProducerWinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class MoviesController {

    @Autowired
    ProducerWinnerService producerWinnerService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ProducerWinnerDTO producerWinnerDTO() {

        return producerWinnerService.getFasterWinnerAndMaxInterval();
    }

}
