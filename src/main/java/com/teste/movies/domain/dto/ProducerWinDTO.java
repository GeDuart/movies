package com.teste.movies.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProducerWinDTO {

    private String producer;

    private int interval;

    private int previousWin;

    private int followingWin;

}
