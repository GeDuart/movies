package com.teste.movies;

import com.teste.movies.domain.dto.AwardsWinDTO;
import com.teste.movies.domain.exception.AwardsNotFound;
import com.teste.movies.repository.AwardsRepository;
import com.teste.movies.services.ProducerAwardsService;
import com.teste.movies.services.ProducerAwardsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class AwardsIntegrationTests {

	@Autowired
	ProducerAwardsService producerAwardsService;
	@Mock
	private AwardsRepository awardsRepository;
	@InjectMocks
	private ProducerAwardsServiceImpl producerAwardsServiceMock;
	@Test
	void testFasterAwards() {

		AwardsWinDTO awardsWinDTO = producerAwardsService.getFasterAwardsAndMaxInterval();

		assertThat(awardsWinDTO.getMax().get(0).getProducer().equals("Matthew Vaughn")).isTrue();
	}

	@Test
	void testGetFasterAwardsAndMaxIntervalWithNoAwards() {
		when(awardsRepository.findAwardsWithMoreThanTwoOccurrences()).thenReturn(Collections.emptyList());
		assertThrows(AwardsNotFound.class, () -> producerAwardsServiceMock.getFasterAwardsAndMaxInterval());
	}
}
