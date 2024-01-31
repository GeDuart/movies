package com.teste.movies.services;

import com.teste.movies.domain.dto.ProducerWinDTO;
import com.teste.movies.domain.dto.ProducerWinnerDTO;
import com.teste.movies.domain.dto.WinnerDTO;
import com.teste.movies.domain.entity.Winner;
import com.teste.movies.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class ProducerWinnerService {

    @Autowired
    WinnerRepository winnerRepository;

    @Autowired
    WinnerService winnerService;

    public ProducerWinnerDTO getFasterWinnerAndMaxInterval(){

        List<Winner> winnerFaster = winnerRepository.findWinnersWithMoreThanTwoOccurrences();

        List<WinnerDTO> listWinnerDTO = winnerService.convertToDTOList(winnerFaster);

        List<WinnerDTO> calculateElapsedTime =
                listWinnerDTO
                        .stream()
                        .collect(Collectors.groupingBy(
                                WinnerDTO::getProducer,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            list.sort(Comparator.comparingInt(WinnerDTO::getYearWinner));
                                            int interval = 0;
                                            for (int i = 0; i < list.size(); i++) {
                                                WinnerDTO current = list.get(i);
                                                int followingIndex = i + 1;

                                                if (followingIndex < list.size()) {
                                                    WinnerDTO next = list.get(followingIndex);
                                                    interval = next.getYearWinner() - current.getYearWinner();

                                                    current.setFollowingWin(next.getYearWinner());
                                                    current.setInterval(interval);
                                                }

                                                if (i > 0) {
                                                    WinnerDTO previous = list.get(i - 1);
                                                    current.setPreviousWin(previous.getYearWinner());
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
                        .sorted(Comparator.comparing(WinnerDTO::getInterval))
                        .toList();

        List<WinnerDTO> registryMinorInterval = getMinorInterval(calculateElapsedTime);
        List<ProducerWinDTO> minorIntervalWinner = getIntervalWinner(registryMinorInterval);

        List<WinnerDTO> registryMaxInterval = getMaxInterval(calculateElapsedTime);
        List<ProducerWinDTO> biggerIntervalWinner = getIntervalWinner(registryMaxInterval);

        return new ProducerWinnerDTO(minorIntervalWinner,biggerIntervalWinner);
    }

    private List<WinnerDTO> getMinorInterval(List<WinnerDTO> calculateElapsedTime){
        Optional<Integer> minorInterval = calculateElapsedTime
                .stream()
                .map(WinnerDTO::getInterval)
                .min(Integer::compareTo);

        return minorInterval.map(interval ->
                        calculateElapsedTime.stream()
                                .filter(winnerDTO -> winnerDTO.getInterval() == interval)
                                .collect(Collectors.toList()))
                .orElse(List.of());
    }

    private List<WinnerDTO> getMaxInterval(List<WinnerDTO> calculateElapsedTime){
        Optional<Integer> maxInterval = calculateElapsedTime
                .stream()
                .map(WinnerDTO::getInterval)
                .max(Integer::compareTo);

        return maxInterval.map(interval ->
                        calculateElapsedTime.stream()
                                .filter(winnerDTO -> winnerDTO.getInterval() == interval)
                                .collect(Collectors.toList()))
                .orElse(List.of());
    }

    private List<ProducerWinDTO> getIntervalWinner(List<WinnerDTO> registryInterval ){
        List<ProducerWinDTO> intervalWinner = new ArrayList<>();
        registryInterval.forEach( r -> {
            ProducerWinDTO producerWinnerDTO = new ProducerWinDTO(r.getProducer().getProducerName(), r.getInterval(),  r.getYearWinner(), r.getFollowingWin());
            if (r.getPreviousWin() > 0 && r.getFollowingWin() == 0) {
                producerWinnerDTO = new ProducerWinDTO(r.getProducer().getProducerName(),r.getInterval(),r.getPreviousWin(),r.getYearWinner());
            }else if ( r.getPreviousWin() == 0 && r.getFollowingWin() > 0)
                producerWinnerDTO = new ProducerWinDTO(r.getProducer().getProducerName(),r.getInterval(),r.getYearWinner(),r.getFollowingWin());

            intervalWinner.add(producerWinnerDTO);
        });
        return intervalWinner;
    }
}
