package com.teste.movies.services;

import com.teste.movies.domain.dto.WinnerDTO;
import com.teste.movies.domain.entity.Winner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WinnerService {

    public List<WinnerDTO> convertToDTOList(List<Winner> winnerList) {
        return winnerList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WinnerDTO convertToDTO(Winner winner) {
        return new WinnerDTO(winner);
    }

}
