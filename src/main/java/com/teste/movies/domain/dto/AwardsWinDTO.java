package com.teste.movies.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AwardsWinDTO {

    private List<AwardsProducerDTO> min;

    private List<AwardsProducerDTO> max;

}
