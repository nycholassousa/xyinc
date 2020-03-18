package com.zup.xyinc.repository;

import com.zup.xyinc.model.PointInterest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointInterestRepositoryTest {
    @Autowired
    private PointInterestRepository pointInterestRepository;

    @BeforeEach
    public void clear() {
        pointInterestRepository.deleteAll();
    }

    @Test
    public void saveNewPlaceReturnGeneratedId() {
        PointInterest pointInterest = PointInterest.builder()
                .name("Lanchonete")
                .coordinateX(27L)
                .coordinateY(12L)
                .build();

        PointInterest placeResponse = pointInterestRepository.save(pointInterest);
        assertThat(placeResponse).isNotNull();
        assertThat(placeResponse.getName()).isEqualTo(pointInterest.getName());
        assertThat(placeResponse.getCoordinateX()).isEqualTo(pointInterest.getCoordinateX());
        assertThat(placeResponse.getCoordinateY()).isEqualTo(pointInterest.getCoordinateY());
    }

    @Test
    public void returnAllPlacesDatabase() {
        pointInterestRepository.save(PointInterest.builder().name("Lanchonete").coordinateX(27L).coordinateY(12L).build());
        pointInterestRepository.save(PointInterest.builder().name("Posto").coordinateX(31L).coordinateY(18L).build());

        List<PointInterest> placeList = pointInterestRepository.findAll();

        assertThat(placeList).isNotEmpty();
        assertThat(placeList).hasSize(2);
    }
}