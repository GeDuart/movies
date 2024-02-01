package com.teste.movies.controller;

import com.teste.movies.domain.dto.AwardsWinDTO;
import com.teste.movies.services.ProducerAwardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awards")
@Tag(name = "Premios")
public class AwardsController {

    @Autowired
    ProducerAwardsService producerAwardsService;

    @GetMapping("/range")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Obter o produtor com maior intervalo entre dois prêmios consecutivos e o que obteve dois prêmios mais rápido")
    public AwardsWinDTO producerWinnerDTO() {

        return producerAwardsService.getFasterAwardsAndMaxInterval();
    }

}
