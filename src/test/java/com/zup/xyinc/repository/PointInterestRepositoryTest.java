package com.zup.xyinc.repository;

import com.zup.xyinc.model.PointInterest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PointInterestRepositoryTest {
    @Autowired
    private PointInterestRepository pointInterestRepository;

    @BeforeEach
    void clear() {
        pointInterestRepository.deleteAll();
    }

    @Test
    void saveNewpointInterestReturnGeneratedId() {
        PointInterest pointInterest = PointInterest.builder()
                .name("Lanchonete")
                .coordinateX(27L)
                .coordinateY(12L)
                .build();

        PointInterest pointInterestResponse = pointInterestRepository.save(pointInterest);
        assertThat(pointInterestResponse).isNotNull();
        assertThat(pointInterestResponse.getName()).isEqualTo(pointInterest.getName());
        assertThat(pointInterestResponse.getCoordinateX()).isEqualTo(pointInterest.getCoordinateX());
        assertThat(pointInterestResponse.getCoordinateY()).isEqualTo(pointInterest.getCoordinateY());
    }

    @Test
    void returnAllpointInterestsDatabase() {
        pointInterestRepository.save(PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build());
        pointInterestRepository.save(PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build());

        List<PointInterest> pointInterestList = pointInterestRepository.findAll();

        assertThat(pointInterestList).isNotEmpty();
        assertThat(pointInterestList).hasSize(2);
    }

    @Test
    void returnpointInterestByCoordenate() {
        pointInterestRepository.save(PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build());
        pointInterestRepository.save(PointInterest.builder().name("Churrascaria").coordinateX(28L).coordinateY(2L).build());
        pointInterestRepository.save(PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build());

        List<PointInterest> pointInterestList = pointInterestRepository.findAllByCoordinate(20L, 10L, 10.0);

        assertThat(pointInterestList).isNotEmpty();
        assertThat(pointInterestList).hasSize(1);
    }
}