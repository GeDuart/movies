package com.teste.movies.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProducerWinnerDTO {

    private List<ProducerWinDTO> min;

    private List<ProducerWinDTO> max;

}
