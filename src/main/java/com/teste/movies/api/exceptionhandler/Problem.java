package com.teste.movies.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Problem {
    private LocalDateTime dataHora;
    private String message;
}
