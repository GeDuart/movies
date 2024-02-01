package com.teste.movies.services;

import com.teste.movies.domain.dto.AwardsDTO;
import com.teste.movies.domain.entity.Awards;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwardsService {

    public List<AwardsDTO> convertToDTOList(List<Awards> awardsList) {
        return awardsList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AwardsDTO convertToDTO(Awards awards) {
        return new AwardsDTO(awards);
    }

}
