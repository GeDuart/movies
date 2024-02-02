package com.teste.movies.services;

import com.teste.movies.domain.dto.AwardsDTO;
import com.teste.movies.domain.entity.Awards;

import java.util.List;

public interface AwardsService {

    List<AwardsDTO> convertToDTOList(List<Awards> awardsList);

    AwardsDTO convertToDTO(Awards awards);
}
