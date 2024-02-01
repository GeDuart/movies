package com.teste.movies.services;

import com.teste.movies.domain.dto.AwardsProducerDTO;
import com.teste.movies.domain.dto.AwardsWinDTO;
import com.teste.movies.domain.dto.AwardsDTO;
import com.teste.movies.domain.entity.Awards;
import com.teste.movies.repository.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class ProducerAwardsService {

    @Autowired
    AwardsRepository awardsRepository;

    @Autowired
    AwardsService awardsService;

    public AwardsWinDTO getFasterAwardsAndMaxInterval(){

        List<Awards> awardsFaster = awardsRepository.findAwardsWithMoreThanTwoOccurrences();

        List<AwardsDTO> listAwardsDTO = awardsService.convertToDTOList(awardsFaster);

        List<AwardsDTO> calculateElapsedTime =
                listAwardsDTO
                        .stream()
                        .collect(Collectors.groupingBy(
                                AwardsDTO::getProducer,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            list.sort(Comparator.comparingInt(AwardsDTO::getYearAwards));
                                            int interval = 0;
                                            for (int i = 0; i < list.size(); i++) {
                                                AwardsDTO current = list.get(i);
                                                int followingIndex = i + 1;

                                                if (followingIndex < list.size()) {
                                                    AwardsDTO next = list.get(followingIndex);
                                                    interval = next.getYearAwards() - current.getYearAwards();

                                                    current.setFollowingWin(next.getYearAwards());
                                                    current.setInterval(interval);
                                                }

                                                if (i > 0) {
                                                    AwardsDTO previous = list.get(i - 1);
                                                    current.setPreviousWin(previous.getYearAwards());
                                                    current.setInterval(interval);
                                                }
                                            }
                                            return list;
                                        }
                                )
                        ))
                        .values()
                        .stream()
                        .flatMap(List::stream)
                        .sorted(Comparator.comparing(AwardsDTO::getInterval))
                        .toList();

        List<AwardsDTO> registryMinorInterval = getMinorInterval(calculateElapsedTime);
        List<AwardsProducerDTO> minorIntervalAwards = getIntervalAwards(registryMinorInterval);

        List<AwardsDTO> registryMaxInterval = getMaxInterval(calculateElapsedTime);
        List<AwardsProducerDTO> biggerIntervalAwards = getIntervalAwards(registryMaxInterval);

        return new AwardsWinDTO(minorIntervalAwards,biggerIntervalAwards);
    }

    private List<AwardsDTO> getMinorInterval(List<AwardsDTO> calculateElapsedTime){
        Optional<Integer> minorInterval = calculateElapsedTime
                .stream()
                .map(AwardsDTO::getInterval)
                .min(Integer::compareTo);

        return minorInterval.map(interval ->
                        calculateElapsedTime.stream()
                                .filter(awardsDTO -> awardsDTO.getInterval() == interval)
                                .collect(Collectors.toList()))
                .orElse(List.of());
    }

    private List<AwardsDTO> getMaxInterval(List<AwardsDTO> calculateElapsedTime){
        Optional<Integer> maxInterval = calculateElapsedTime
                .stream()
                .map(AwardsDTO::getInterval)
                .max(Integer::compareTo);

        return maxInterval.map(interval ->
                        calculateElapsedTime.stream()
                                .filter(awardsDTO -> awardsDTO.getInterval() == interval)
                                .collect(Collectors.toList()))
                .orElse(List.of());
    }

    private List<AwardsProducerDTO> getIntervalAwards(List<AwardsDTO> registryInterval ){
        List<AwardsProducerDTO> intervalAwards = new ArrayList<>();
        registryInterval.forEach( r -> {
            AwardsProducerDTO producerAwardsDTO = new AwardsProducerDTO(r.getProducer().getProducerName(), r.getInterval(),  r.getYearAwards(), r.getFollowingWin());
            if (r.getPreviousWin() > 0 && r.getFollowingWin() == 0) {
                producerAwardsDTO = new AwardsProducerDTO(r.getProducer().getProducerName(),r.getInterval(),r.getPreviousWin(),r.getYearAwards());
            }else if ( r.getPreviousWin() == 0 && r.getFollowingWin() > 0)
                producerAwardsDTO = new AwardsProducerDTO(r.getProducer().getProducerName(),r.getInterval(),r.getYearAwards(),r.getFollowingWin());

            intervalAwards.add(producerAwardsDTO);
        });
        return intervalAwards;
    }
}
