package com.zup.xyinc.service;

import com.zup.xyinc.model.PointInterest;
import com.zup.xyinc.repository.PointInterestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static java.util.Arrays.asList;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PointInterestServiceTest {
    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private PointInterestRepository pointInterestRepository;

    @InjectMocks
    private PointInterestService pointInterestService;

    @Test
    void returnAllpointInterests() {
        PointInterest pointInterest = PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build();
        PointInterest pointInterest1 = PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build();

        doReturn(asList(pointInterest)).when(pointInterestRepository).findAll();

        List<PointInterest> pointInterestList = pointInterestService.getAllPointsInterest();
        assertThat(pointInterestList).isNotEmpty();
        assertThat(pointInterestList).contains(pointInterest);
        assertThat(pointInterestList).doesNotContain(pointInterest1);
    }

    @Test
    void returnAllpointInterestsMatchCoordinates() {
        PointInterest pointInterest = PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build();
        PointInterest pointInterest1 = PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build();

        doReturn(asList(pointInterest)).when(pointInterestRepository).findAllByCoordinate(20L, 10L, 10.0);

        List<PointInterest> pointInterestList = pointInterestService.getPointsByProximity(20L, 10L, 10L);
        assertThat(pointInterestList).isNotEmpty();
        assertThat(pointInterestList).contains(pointInterest);
        assertThat(pointInterestList).doesNotContain(pointInterest1);
    }
}